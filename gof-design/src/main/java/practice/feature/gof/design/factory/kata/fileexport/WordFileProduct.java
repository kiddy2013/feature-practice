package practice.feature.gof.design.factory.kata.fileexport;

public class WordFileProduct implements FileProduct {
    @Override
    public void create(String fileName) {
        System.out.println("Exporting " + fileName + " to Word");
    }
}
