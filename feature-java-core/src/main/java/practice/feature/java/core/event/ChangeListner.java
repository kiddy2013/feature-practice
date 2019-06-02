package practice.feature.java.core.event;

import java.util.EventListener;

public interface ChangeListner extends EventListener {

    void handleEvent(ChangeEvent changeEvent);
}
