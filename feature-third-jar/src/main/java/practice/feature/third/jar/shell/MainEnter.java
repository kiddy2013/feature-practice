package practice.feature.third.jar.shell;

import java.io.File;

import practice.feature.third.jar.shell.ShellUtils.ShellExecResult;

/**
 * 程序主要入口
 *
 * @author jack
 */
public class MainEnter {

    public static void main(String[] args) {
        File tileFile = new File("/Users/jack/code/tile/10");
        for (File xfile : tileFile.listFiles()) {
            if (!xfile.isDirectory() || xfile.getName().equals(".DS_Store")) {
                continue;
            }
            for (File yfile : xfile.listFiles()) {
                if (!yfile.isDirectory() || yfile.getName().equals(".DS_Store")) {
                    continue;
                }
                String dbName = xfile.getName() + "_" + yfile.getName() + ".db";
                String dbPath = "/Users/jack/code/tile/tile/" + dbName;
                String filePath = " /Users/jack/code/tile/10/" + xfile.getName() + "/" + yfile.getName() + "/";

                String cmd = "ogr2ogr -f SQLite " + dbPath + filePath;
                try {
                    ShellExecResult result = ShellUtils.exec(cmd);
                    if (result.exitCode == 0) {
                        System.out.println(xfile.getName() + "_" + yfile.getName() + " is done!");
                    } else {
                        System.out.println(result.stderr);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }
        System.out.println("***done***");
    }

}
