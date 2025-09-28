package practice.feature.gof.design.factory.kata.button;


/**
 * 🔧 Kata 3：跨平台 UI 组件（经典例子）
 */
public class MainEnter {
    public static void main(String[] args) {
        ButtonFactory buttonFactory = new WindowsButtonFactory();
        Button button = buttonFactory.createButton();
        button.display();

        buttonFactory = new MacButtonFactory();
        button = buttonFactory.createButton();
        button.display();
    }
}
