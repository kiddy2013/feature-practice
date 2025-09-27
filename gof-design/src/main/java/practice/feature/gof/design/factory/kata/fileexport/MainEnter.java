package practice.feature.gof.design.factory.kata.fileexport;

public class MainEnter {

    /**
     * 🔧 Kata 1：最简单的例子 —— 不同类型的文档导出
     * 场景：
     * 你要支持导出 PDF、Excel、Word 文件。
     *
     * @param args
     */
    public static void main(String[] args) {

        FileProductFactory pdfFactory = new PdfFileConductFactory();
        FileProduct pdfProduct = pdfFactory.create();
        pdfProduct.create("test.pdf");

        FileProductFactory wordFactory = new WordFileConductFactory();
        FileProduct wordProduct = wordFactory.create();
        wordProduct.create("test.word");
    }
}
