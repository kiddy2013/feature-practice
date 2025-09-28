package practice.feature.gof.design.factory.kata.button;

public class WindowsButton implements Button {
    @Override
    public void display() {
        System.out.println("Windows Button");
    }
}
