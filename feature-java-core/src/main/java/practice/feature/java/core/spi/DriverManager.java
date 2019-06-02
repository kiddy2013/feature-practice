package practice.feature.java.core.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Driver管理类
 *
 * @author jack
 */
public class DriverManager {

    public void connectDataBase() {
        ServiceLoader<Driver> loadedDrivers = ServiceLoader.load(Driver.class);
        Iterator<Driver> driversIterator = loadedDrivers.iterator();
        while (driversIterator.hasNext()) {
            System.out.println(driversIterator.next().connect("hello world"));
        }
    }

}
