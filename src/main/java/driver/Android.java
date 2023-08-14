package driver;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.appium.java_client.android.AndroidDriver;

import java.util.Set;

public class Android {
    public Android() {
    }

    public AndroidDriver getDriverInstance() {
        return ((AndroidDriver) DriverManager.getDriverInstance());
    }

    public Set<String> getContextHandles() {
        return getDriverInstance().getContextHandles();
    }

    public String getCurrentContextHandle() {
        return getDriverInstance().getContext();
    }

    public void switchContext(@NotNull final String context) {
        getDriverInstance().context(context);
    }
}