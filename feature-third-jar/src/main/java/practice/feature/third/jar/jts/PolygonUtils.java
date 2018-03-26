package practice.feature.third.jar.jts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;

public class PolygonUtils {

    private static Polygon polygon = null;

    static {
        // 加载图幅列表
        BufferedReader bw = null;
        try {
            bw = new BufferedReader(
                new InputStreamReader(PolygonUtils.class.getResourceAsStream("/jts/chongqing.txt"), "UTF-8"));
            String line;
            GeometryFactory factory = new GeometryFactory();
            List<Coordinate> list = new ArrayList<>();

            line = bw.readLine();
            String[] ss = line.split(", ");
            for (String s : ss) {
                String[] pointStrs = s.split(" ");
                Coordinate coordinate = new Coordinate(Double.parseDouble(pointStrs[0]),
                    Double.parseDouble(pointStrs[1]));
                list.add(coordinate);
            }
            Coordinate[] coordinates = new Coordinate[list.size()];
            polygon = factory.createPolygon(list.toArray(coordinates));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static Polygon getPolygon() {
        return polygon;
    }
}
