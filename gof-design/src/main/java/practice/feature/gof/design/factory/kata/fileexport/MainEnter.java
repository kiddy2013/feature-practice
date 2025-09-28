package practice.feature.gof.design.factory.kata.fileexport;

public class MainEnter {

    /**
     * 💡 场景：
     * 你需要支持生成 PDF 和 Excel 报告。
     *
     * 🎯 要求：
     * 使用工厂方法模式实现以下结构：
     *
     * Report 接口：void generate()
     * PdfReport, ExcelReport 实现类
     * ReportCreator 抽象类：声明 createReport() 工厂方法
     * PdfReportCreator, ExcelReportCreator 具体工厂
     * ✅ 功能：
     * 调用 creator.createAndGenerate() 应该输出对应类型的报告。
     *
     * @param args
     */
    public static void main(String[] args) {

        ReportCreator pdfFactory = new PdfReportCreator();
        pdfFactory.createAndGenerate();

        ReportCreator wordFactory = new ExcelReportCreator();
        wordFactory.createAndGenerate();

        ReportCreator restrictedPdfFactory = new RestrictedPdfReportCreator();
        restrictedPdfFactory.createAndGenerate();
    }
}
