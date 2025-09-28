package practice.feature.gof.design.factory.kata.fileexport;

public class ExcelReportCreator extends ReportCreator {

    @Override
    Report createReport() {
        return new ExcelReport();
    }

    @Override
    protected boolean isExportAllowed() {
        return true;
    }
}
