package practice.feature.java.core.event;

import java.util.EventObject;

public class ChangeEvent extends EventObject {

    public ChangeEvent(Object source) {
        super(source);
    }

    public void say() {
        System.out.println("This is say method...");
    }
}
