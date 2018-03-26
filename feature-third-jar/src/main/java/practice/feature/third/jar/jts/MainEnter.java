package practice.feature.third.jar.jts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.Polygon;

/**
 * 程序主要入口
 * mesh.bnd
 *
 * @author jack
 */
public class MainEnter {

    public static void main(String[] args) throws Exception {
        Map<String, Polygon> meshMap = MeshUtils.getMeshMap();

        List<Polygon> list = new ArrayList<>();
        Polygon polygon = PolygonUtils.getPolygon();
        System.out.println("**********************************");
        for (Map.Entry<String, Polygon> entry : meshMap.entrySet()) {
            Polygon meshPolygon = entry.getValue();
            if (polygon.intersects(meshPolygon)) {
                list.add(meshPolygon);
                System.out.println(entry.getKey());
            }
        }
        Polygon[] polygons = new Polygon[list.size()];
        MultiPolygon multiPolygon = new GeometryFactory().createMultiPolygon(list.toArray(polygons));
        System.out.println("**********************************");
    }
}
