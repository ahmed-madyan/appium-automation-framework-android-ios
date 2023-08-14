package waits;

import driver.DriverManager;
import exceptions.Exceptions;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;

import java.time.Duration;

public class Implicit {
    public Implicit() {
    }

    public Implicit wait(@NotNull final Duration duration) {
        try {
            DriverManager.getDriverInstance().manage().timeouts().implicitlyWait(duration);
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }
}