package elements.gesture_actions;

import elements.touch_actions.TouchActions;

public class GestureActions {
    public GestureActions() {
    }

    public static TouchActions touchActions() {
        return new TouchActions();
    }
    public IOSGestures iosGestures() {
        return new IOSGestures();
    }

    public AndroidGestures androidGestures() {
        return new AndroidGestures();
    }
}