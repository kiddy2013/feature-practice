package practice.feature.third.jar.jakson;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import practice.feature.third.jar.jakson.javabean.Order;

/**
 * 程序主要入口
 *
 * @author jack
 */
public class MainEnter {

    public static void main(String[] args) throws Exception {
        Order order = new Order();
        order.setId(123L);
        JsonFactory jsonFactory = new JsonFactory();
        jsonFactory.enable(JsonParser.Feature.ALLOW_COMMENTS);
        JsonGenerator jsonGenerator = jsonFactory.createGenerator(System.out, JsonEncoding.UTF8);
        jsonGenerator.writeObject(order);
    }
}
