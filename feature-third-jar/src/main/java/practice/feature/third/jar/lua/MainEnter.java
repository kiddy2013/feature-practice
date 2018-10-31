package practice.feature.third.jar.lua;

/**
 * 程序主要入口
 *
 * @author jack
 */
public class MainEnter {

    public static void main(String[] args) {
        System.out.println("程序主要入口");

        LuaProsessor luaProsessor = new LuaProsessor();
        luaProsessor.process();
    }

}
