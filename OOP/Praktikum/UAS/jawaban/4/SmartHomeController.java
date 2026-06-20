import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class SmartHomeController {

    // Kelas ini tidak boleh dapat diinstansiasi dari luar kelas
    // karena hanya berisi operasi statis.
    private SmartHomeController() {
    }

    static void printStatus(Object device) {
        Class<?> clazz = device.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(device);
                System.out.println(field.getName() + " = " + value);
            } catch (IllegalAccessException e) {
                System.out.println("FIELD_ACCESS_ERROR");
            }
        }
    }

    static void printCommands(Object device) {
        Class<?> clazz = device.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        Arrays.sort(methods, Comparator.comparing(Method::getName));

        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }

    static void execute(Object device, String command) {
        Class<?> clazz = device.getClass();
        Method target = null;

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getName().equals(command) && method.getParameterCount() == 0) {
                target = method;
                break;
            }
        }

        if (target == null) {
            System.out.println("COMMAND_NOT_FOUND");
            return;
        }

        try {
            target.setAccessible(true);
            target.invoke(device);
        } catch (Exception e) {
            System.out.println("COMMAND_EXECUTION_ERROR");
        }
    }
}