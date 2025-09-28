package practice.feature.gof.design.factory.kata.fileexport;

public class PdfReport implements Report {

    @Override
    public void generate() {
        System.out.println("PDF 创建器应生成 PDF 报告");
    }
}
