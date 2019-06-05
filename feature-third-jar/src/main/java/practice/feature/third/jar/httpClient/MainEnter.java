package practice.feature.third.jar.httpClient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHttpResponse;

/**
 * @author jack
 */
public class MainEnter {

    public static void main(String[] args) throws IOException, URISyntaxException {
        //1 new Client
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();

        URI uri = new URIBuilder()
            .setScheme("http")
            .setHost("www.google.com")
            .setPath("/search")
            .setParameter("q", "httpclient")
            .setParameter("btnG", "Google Search")
            .setParameter("aq", "f")
            .setParameter("oq", "")
            .build();
        HttpGet httpget = new HttpGet(uri);
        System.out.println(httpget.getURI());

        //2 new Request
        CloseableHttpResponse httpResponse=closeableHttpClient.execute(httpget);
        try {
            System.out.println("hello HttpClient!");
        }finally {
            httpResponse.close();
        }

        //3 new Response
        HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1,
            HttpStatus.SC_OK, "OK");

        System.out.println(response.getProtocolVersion());
        System.out.println(response.getStatusLine().getStatusCode());
        System.out.println(response.getStatusLine().getReasonPhrase());
        System.out.println(response.getStatusLine().toString());

        //4 edit header
        response.addHeader("Set-Cookie","c1=a; path=/; domain=localhost");
        response.addHeader("Set-Cookie","c2=b; path=\"/\", c3=c; domain=\"localhost\"");

        Header h1=response.getFirstHeader("Set-Cookie");
        System.out.println(h1);

        Header h2=response.getLastHeader("Set-Cookie");
        System.out.println(h2);

        Header[] hs=response.getHeaders("Set-Cookie");
        System.out.println(hs.length);

        response.headerIterator();

    }
}
