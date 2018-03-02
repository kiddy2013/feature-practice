package practice.feature.java.core.classloader;

/**
 * 程序主要入口
 *
 * @author jack
 */
public class MainEnter {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException,
        InstantiationException {

        ClassLoader classLoader1 = new DqClassLoader("");
        Class clazz1 = classLoader1.loadClass("practice.feature.java.core.classloader.User");
        clazz1.newInstance();

        System.out.println(clazz1.newInstance().getClass().getClassLoader());
        while (classLoader1 != null) {
            System.out.println(classLoader1);
            classLoader1 = classLoader1.getParent();
        }
        ClassLoader.getSystemClassLoader();
    }

}
