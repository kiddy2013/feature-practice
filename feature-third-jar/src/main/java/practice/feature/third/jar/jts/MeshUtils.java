package practice.feature.third.jar.jts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Polygon;

public class MeshUtils {

    private static final Map<String, Polygon> meshMap = new HashMap<>(138000);

    static {
        // 加载图幅列表
        BufferedReader bw = null;
        try {
            bw = new BufferedReader(
                new InputStreamReader(MeshUtils.class.getResourceAsStream("/jts/mesh.bnd"), "UTF-8"));
            String line;
            GeometryFactory factory = new GeometryFactory();
            while ((line = bw.readLine()) != null) {
                String[] ss = line.split(",");
                String meshId = ss[0];
                Coordinate coordinate1 = new Coordinate(Double.parseDouble(ss[1]), Double.parseDouble(ss[2]));
                Coordinate coordinate2 = new Coordinate(Double.parseDouble(ss[3]), Double.parseDouble(ss[4]));
                Coordinate coordinate3 = new Coordinate(Double.parseDouble(ss[1]), Double.parseDouble(ss[4]));
                Coordinate coordinate4 = new Coordinate(Double.parseDouble(ss[3]), Double.parseDouble(ss[2]));

                meshMap.put(meshId, factory
                    .createPolygon(new Coordinate[] {coordinate1, coordinate3, coordinate2, coordinate4, coordinate1}));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, Polygon> getMeshMap() {
        return meshMap;
    }
}
