package practice.feature.java.core.time;

import java.util.Date;
import java.util.HashMap;

public class TestMain {

    public static void main(String[] args) {
        //Date date=new Date();
        //System.out.println(date);
        //System.out.println(date.getTime());
        //// 5年  1000*60*60*24*(365*5+1)
        //long dddd=date.getTime()+1000*60*60*24*(365*5+1);
        //Date date1=new Date(dddd);
        //
        //System.out.println(date1);
        //System.out.println(date1.getTime());
        //
        //Date date2=new Date();
        //date2.setYear(125);
        //HashMap
        //System.out.println(date2);
        //System.out.println(date2.getTime());
        //
        //System.out.println("***************************");
        //System.out.println(1000L*60*60*24*(365*5+1));
        //System.out.println(date2.getTime()-dddd);
        //System.out.println(System.currentTimeMillis());
        HashMap a=new HashMap<>(1);
        a.put("a","a");
        System.out.println("");
        System.out.println(tableSizeFor(1000));

    }
    static final int MAXIMUM_CAPACITY = 1 << 30;
    /**
     * Returns a power of two size for the given target capacity.
     */
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}

