package practice.feature.third.jar.lua;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

/**
 * 程序主要入口
 *
 * @author jack
 */
public class Main {

    public static void main(String[] args) {
        //初始化lua运行时环境
        Globals globals = JsePlatform.standardGlobals();
        LuaValue chunk = globals.loadfile("lua/main11.lua");
        chunk.call();
        //获取入口函数
        LuaValue func = globals.get(LuaValue.valueOf("main"));
        String result = func.call().toString();
        System.out.println(result);
    }
}
