package waits;

public class Waits {
    public Waits() {
    }

    public static Implicit implicitlyWait() {
        return new Implicit();
    }

    public static Explicit explicitlyWait() {
        return new Explicit();
    }

    public static Fluent fluentlyWait() {
        return new Fluent();
    }
}