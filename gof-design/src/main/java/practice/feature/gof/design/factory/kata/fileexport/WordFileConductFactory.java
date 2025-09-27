package practice.feature.gof.design.factory.kata.fileexport;

public class WordFileConductFactory implements FileProductFactory {
    public FileProduct create() {
        return new WordFileProduct();
    }
}
