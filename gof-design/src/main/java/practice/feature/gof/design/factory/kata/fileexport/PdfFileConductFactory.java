package practice.feature.gof.design.factory.kata.fileexport;

public class PdfFileConductFactory implements FileProductFactory {


    public FileProduct create() {
        return new PdfFileProduct();
    }
}
