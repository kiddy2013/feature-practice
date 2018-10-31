package practice.feature.third.jar.lua;

import java.io.File;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.jse.JsePlatform;

/**
 * @author jack
 */
public class LuaProsessor {

    private Globals globals = null;

    //public LuaProsessor() {
    //    //初始化lua运行时环境
    //    globals = JsePlatform.standardGlobals();
    //    LuaValue chunk = globals.loadfile("lua/main.lua");
    //    chunk.call();
    //    //获取入口函数
    //    LuaValue func = globals.get(LuaValue.valueOf("main"));
    //    String result = func.call().toString();
    //    System.out.println(result);
    //}

    public LuaProsessor() {
        //初始化lua运行时环境
        globals = JsePlatform.standardGlobals();
        //找到classPath下的lua脚本路径，这里是入口函数的路径
        File luaFile = new File("/lua/main.lua");
        String luaPath = luaFile.getAbsolutePath();

        globals.get("package").set("path", LuaValue.valueOf(luaFile.getParentFile().getPath()
            .concat(File.separator).concat("luapackage").concat(File.separator).concat("?.lua")));
        globals.get("dofile").call(LuaValue.valueOf(luaPath));
    }

    public int process() {
        LuaTable recordTable = new LuaTable();
        recordTable.set("test", "test");
        LuaValue pcall = globals.get("pcall");
        Varargs retvals = pcall.invoke(LuaValue.varargsOf(new LuaValue[] {globals.get("main"), recordTable}));
        boolean success = retvals.arg(1).checkboolean();
        if (!success) {
            String err = retvals.arg(2).tojstring();
            System.out.println(" lua_main exception, msg: " + err);
            return 0;
        }
        LuaTable luaTable = (LuaTable)retvals.arg(2);
        System.out.println(luaTable.get("test"));
        return 1;
    }
}
