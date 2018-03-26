package practice.feature.java.core.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 程序主要入口
 *
 * @author jack
 */
public class MainEnter {

    public static void main(String[] args) {
        new ArrayList<String>().stream().collect(Collectors.toMap(str -> str, str -> str));
        MainEnter mainEnter = new MainEnter();
        mainEnter.add((x, y) -> {
            return x + y;
        });
    }

    public void add(AddMethod addMethod) {
        System.out.println(addMethod.add(1, 3));
    }

}
