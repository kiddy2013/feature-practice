package practice.feature.java.core.event;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 程序主要入口
 *
 * @author jack
 */
public class MainEnter {

    private final Set<ApplicationListener<?>> applicationListeners = new LinkedHashSet<>();

    public static void main(String[] args) {
        System.out.println("asdasd");
    }

    public void addApplicationListener(ApplicationListener<?> listener) {
        this.applicationListeners.add(listener);
    }

}
