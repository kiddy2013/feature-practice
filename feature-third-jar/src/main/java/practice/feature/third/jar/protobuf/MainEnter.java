package practice.feature.third.jar.protobuf;

/**
 * 程序主要入口
 * 安装protobuf插件，cd切换到bin目录,命令：
 * cd /usr/local/Cellar/protobuf@2.5/2.5.0/bin
 * 然后执行编译命令：
 * sudo ./protoc -I/usr/local/Cellar/protobuf@2.5/2.5.0/include/
 * --proto_path=/Users/jack/myCode/feature-practice/feature-third-jar/src/main/java/practice/feature/third/jar/protobuf
 * --java_out=/Users/jack/myCode/feature-practice/feature-third-jar/src/main/java
 * /Users/jack/myCode/feature-practice/feature-third-jar/src/main/java/practice/feature/third/jar/protobuf/*.proto
 * PersonModel 类是根据proto文件自动生成的
 *
 * @author jack
 */
public class MainEnter {
    public static void main(String[] args) {
        PersonModel.Person person = PersonModel.Person.newBuilder()
            .setId(1)
            .setEmail("1231231")
            .setName("asdasd").build();
        System.out.println(person);
    }
}
