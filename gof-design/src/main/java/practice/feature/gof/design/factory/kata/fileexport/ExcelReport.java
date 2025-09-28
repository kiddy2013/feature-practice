package practice.feature.gof.design.factory.kata.fileexport;

public class ExcelReport implements Report {
    @Override
    public void generate() {
        System.out.println("Excel 创建器应生成 Excel 报告");
    }
}
