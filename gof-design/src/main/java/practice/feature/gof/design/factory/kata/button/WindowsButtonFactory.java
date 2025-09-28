package practice.feature.gof.design.factory.kata.button;

public class WindowsButtonFactory extends ButtonFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

}
