package practice.feature.java.core;

public class TestMain {

    public static void main(String[] args) {
        long minPkid = 1;
        long maxPkid = 1234567;
        int cursor = 0;
        int recordNum = 100000;
        long updateCnt = 0;
        long startTimeTotal = System.currentTimeMillis();
        while (minPkid + recordNum * cursor < maxPkid) {
            long firstPkid = minPkid + recordNum * cursor;
            long lastPkid = minPkid + recordNum * (cursor + 1);
            StringBuilder sb = new StringBuilder();
            sb.append("where ft.pkid >= ");
            sb.append(firstPkid);
            sb.append(" and ft.pkid < ");
            if (lastPkid > maxPkid) {
                lastPkid = maxPkid;
            }
            sb.append(lastPkid);
            System.out.println(sb.toString());
            cursor++;
        }
    }
}

