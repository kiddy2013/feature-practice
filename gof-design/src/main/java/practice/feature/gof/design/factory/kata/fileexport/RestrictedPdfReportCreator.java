package practice.feature.gof.design.factory.kata.fileexport;

public class RestrictedPdfReportCreator extends ReportCreator {

    @Override
    Report createReport() {
        return new PdfReport();
    }

    @Override
    protected boolean isExportAllowed() {
        return false;
    }
}
