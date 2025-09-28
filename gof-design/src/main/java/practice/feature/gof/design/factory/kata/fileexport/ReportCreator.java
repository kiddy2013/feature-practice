package practice.feature.gof.design.factory.kata.fileexport;

public abstract class ReportCreator {

    public void createAndGenerate() {
        logAccess();
        if (checkPermission()) {
            System.out.println("有权限");
        }
        else {
            System.out.println("没有权限");
        }

        Report report = createReport();  // 工厂方法
        if (isExportAllowed()) {
            report.generate();
        }
        else {
            System.out.println("Preview mode: export disabled");
        }
        report.generate();
    }

    protected abstract boolean isExportAllowed();

    abstract Report createReport();

    private void logAccess() {
        System.out.println("记录访问");
    }

    private boolean checkPermission() {
        return true;
    }
}
