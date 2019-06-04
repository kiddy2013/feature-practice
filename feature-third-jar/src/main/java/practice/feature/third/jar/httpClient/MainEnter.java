package practice.feature.third.jar.httpClient;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * @author jack
 */
public class MainEnter {

    public static void main(String[] args) {
        System.out.println("hello HttpClient!");

        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();

    }
}
