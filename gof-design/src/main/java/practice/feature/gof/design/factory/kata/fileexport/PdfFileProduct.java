package practice.feature.gof.design.factory.kata.fileexport;

public class PdfFileProduct implements FileProduct {

    @Override
    public void create(String fileName) {
        System.out.println("Exporting " + fileName + " to PDF");
    }
}
