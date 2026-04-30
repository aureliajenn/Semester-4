public class APIResponse<U> {
    private int statusCode;
    private String message;
    private U data;

    public APIResponse(int statusCode, String message, U data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }
    
    public void printResponse() {
        System.out.println("Response " + this.statusCode + " - " + this.message + " | Data: " + this.data + " (Type: " + this.data.getClass().getSimpleName() + ")");
    }
}
