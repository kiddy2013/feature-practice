package practice.feature.java.core.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class MainEnter {

    public static void main(String[] args) throws IOException {

        File target = new File(MainEnter.class.getClassLoader().getResource("target.txt").getPath());
        BufferedReader targetReader = new BufferedReader(new FileReader(target));
        Set<String> tagetSet = new HashSet<>();
        String str = null;
        while ((str = targetReader.readLine()) != null) {
            tagetSet.add(str);
        }

        File local = new File(MainEnter.class.getClassLoader().getResource("local.txt").getPath());
        BufferedReader reader = new BufferedReader(new FileReader(local));
        Set<String> localSet = new HashSet<>();
        Set<String> localSet1 = new HashSet<>();
        String aaaa = null;
        while ((aaaa = reader.readLine()) != null) {
            if(!localSet.add(aaaa)){
                System.out.println(aaaa);
            }
            localSet1.add(aaaa);
        }
        for (String localid : localSet) {
            if (tagetSet.contains(localid)) {
                localSet1.remove(localid);
                tagetSet.remove(localid);
            }
        }

        System.out.println("asdasd");
    }
}
