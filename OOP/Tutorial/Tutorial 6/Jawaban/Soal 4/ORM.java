import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ORM {

    public static void schema(Class<?> clazz) {
        TableName tableAnn = clazz.getAnnotation(TableName.class);
        String tableName = (tableAnn != null) ? tableAnn.value() : clazz.getSimpleName().toLowerCase();

        System.out.println("Table: " + tableName);
        System.out.println("Columns:");

        for (Field field : clazz.getDeclaredFields()) {
            ColumnName colAnn = field.getAnnotation(ColumnName.class);
            if (colAnn == null) continue;

            String colName = colAnn.value().isEmpty() ? field.getName() : colAnn.value();
            if (colAnn.primaryKey()) {
                System.out.println("  - " + colName + " [PRIMARY KEY]");
            } else {
                System.out.println("  - " + colName);
            }
        }
    }

    public static Object createInstance(Class<?> clazz, String[] values) throws Exception {
        Object obj = clazz.getDeclaredConstructor().newInstance();

        int idx = 0;
        for (Field field : clazz.getDeclaredFields()) {
            ColumnName colAnn = field.getAnnotation(ColumnName.class);
            if (colAnn == null) continue;

            field.setAccessible(true);
            String val = values[idx++];
            Class<?> type = field.getType();

            if (type == int.class || type == Integer.class) {
                field.set(obj, Integer.parseInt(val));
            } else if (type == double.class || type == Double.class) {
                field.set(obj, Double.parseDouble(val));
            } else {
                field.set(obj, val);
            }
        }

        for (Method method : clazz.getDeclaredMethods()) {
            Hook hook = method.getAnnotation(Hook.class);
            if (hook != null && hook.when() == Hook.When.POST_LOAD) {
                method.setAccessible(true);
                method.invoke(obj);
            }
        }

        return obj;
    }

    public static void insert(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();

        for (Method method : clazz.getDeclaredMethods()) {
            Hook hook = method.getAnnotation(Hook.class);
            if (hook != null && hook.when() == Hook.When.PRE_INSERT) {
                method.setAccessible(true);
                try {
                    method.invoke(obj);
                } catch (InvocationTargetException e) {
                    System.out.println("Gagal insert: " + e.getCause().getMessage());
                    return;
                }
            }
        }

        TableName tableAnn = clazz.getAnnotation(TableName.class);
        String tableName = (tableAnn != null) ? tableAnn.value() : clazz.getSimpleName().toLowerCase();

        StringBuilder cols = new StringBuilder();
        StringBuilder vals = new StringBuilder();

        for (Field field : clazz.getDeclaredFields()) {
            ColumnName colAnn = field.getAnnotation(ColumnName.class);
            if (colAnn == null) continue;

            field.setAccessible(true);
            String colName = colAnn.value().isEmpty() ? field.getName() : colAnn.value();
            Object value = field.get(obj);

            if (cols.length() > 0) {
                cols.append(", ");
                vals.append(", ");
            }
            cols.append(colName);

            if (value instanceof String) {
                vals.append("'").append(value).append("'");
            } else {
                vals.append(value);
            }
        }

        System.out.println("INSERT INTO " + tableName + " (" + cols + ") VALUES (" + vals + ")");
    }

    public static void delete(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();

        for (Method method : clazz.getDeclaredMethods()) {
            Hook hook = method.getAnnotation(Hook.class);
            if (hook != null && hook.when() == Hook.When.PRE_DELETE) {
                method.setAccessible(true);
                try {
                    method.invoke(obj);
                } catch (InvocationTargetException e) {
                    System.out.println("Gagal delete: " + e.getCause().getMessage());
                    return;
                }
            }
        }

        TableName tableAnn = clazz.getAnnotation(TableName.class);
        String tableName = (tableAnn != null) ? tableAnn.value() : clazz.getSimpleName().toLowerCase();

        for (Field field : clazz.getDeclaredFields()) {
            ColumnName colAnn = field.getAnnotation(ColumnName.class);
            if (colAnn == null || !colAnn.primaryKey()) continue;

            field.setAccessible(true);
            String colName = colAnn.value().isEmpty() ? field.getName() : colAnn.value();
            Object value = field.get(obj);

            String pkVal = (value instanceof String)
                    ? "'" + value + "'"
                    : String.valueOf(value);

            System.out.println("DELETE FROM " + tableName + " WHERE " + colName + " = " + pkVal);
            break;
        }
    }
}