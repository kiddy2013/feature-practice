package practice.feature.third.jar.zip;

import java.io.File;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class ZipUtil {

    /**
     * todo  zip解压缩
     * @param source 压缩文件全路径
     * @param target 要解压路径
     * @param targetName 解压文件夹名称
     */
    public static void unzip (String source,String target,String targetName) throws Exception{
        try {
            File file = new File(source);
            if(!file.exists() || file.isDirectory()){
                throw new Exception("将要解压文件不存在或路径填写不正确！");
            }

            file = new File(target+File.separator+targetName);
            if(!file.exists()){
                file.mkdirs();
                System.out.println("路劲不存在，创建路径");
            }
            ZipFile zipfile = new ZipFile(source);
            if (!zipfile.isValidZipFile()) {  
                throw new Exception("压缩文件不合法,可能被损坏.");  
            } 
            zipfile.setFileNameCharset("GBK");
            zipfile.extractAll(target+File.separator+targetName);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }


    }

    /**
     * todo  生成zip压缩
     * @param source 要压缩文件全路径
     * @param target 压缩文件存放路径
     * @param targetName 解压文件名称
     */
    public static void zip (String source,String target,String targetName) throws Exception{
        try {           
            File file = new File(target);
            if(!file.exists()){
                file.mkdirs();
                System.out.println("解压存储路劲不存在，创建路径");
            }
            file = new File(source);
            if(!file.exists()){
                throw new Exception("将要解压文件不存在或路径填写不正确！");
            }

            ZipFile zipfile = new ZipFile(target+File.separator+targetName);
            zipfile.setFileNameCharset("GBK");
            ZipParameters params = new ZipParameters();
            params.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);           // 压缩方式  
            params.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);    // 压缩级别  
            //zipfile.cr
            if(file.isFile()){
                zipfile.addFile(file, params);
            }else{
                zipfile.addFolder(source, params);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }


    }

    public static void main(String[] args) {
        try {
            unzip("/Users/jack/myCode/shp.zip","/Users/jack/myCode","shp1");
            //zip("/Users/jack/myCode/shp","/Users/jack/myCode","shp.zip");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}