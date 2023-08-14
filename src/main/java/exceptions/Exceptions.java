package exceptions;

public class Exceptions {
    public static void handle(Exception exception) {
        System.out.println(exception.getMessage() + "\n" + exception.getCause() + "\n");
        exception.printStackTrace();
    }
}