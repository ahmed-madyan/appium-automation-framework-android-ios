package elements;

import elements.element_actions.ElementActions;
import elements.element_actions.ElementState;
import elements.gesture_actions.GestureActions;
import elements.mobile_actions.MobileActions;
import elements.touch_actions.TouchActions;

public class Elements {
    public Elements() {
    }

    public static ElementActions elementActions() {
        return new ElementActions();
    }

    public static ElementState elementState() {
        return new ElementState();
    }

    public static GestureActions gestureActions() {
        return new GestureActions();
    }

    public static MobileActions mobileActions() {
        return new MobileActions();
    }

    public static TouchActions touchActions() {
        return new TouchActions();
    }
}