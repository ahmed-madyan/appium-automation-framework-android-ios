package driver;

import lombok.Getter;

@Getter
public enum BrowserStack {
    SIGN_IN_URL("https://www.browserstack.com/users/sign_in"),
    USERNAME("ahmed.madyan@vodafone.com"),
    PASSWORD("BrowserStack@1");

    private final String data;

    BrowserStack(String data) {
        this.data = data;
    }
    }