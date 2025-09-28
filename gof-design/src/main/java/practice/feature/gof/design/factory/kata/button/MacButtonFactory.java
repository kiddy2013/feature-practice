package practice.feature.gof.design.factory.kata.button;

public class MacButtonFactory extends ButtonFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }
}
