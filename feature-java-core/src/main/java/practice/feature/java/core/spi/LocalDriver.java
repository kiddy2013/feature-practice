package practice.feature.java.core.spi;

/**
 * @author jack
 */
public class LocalDriver implements Driver {

    @Override
    public String connect(String url) {
        return "connect local success ！" + url;
    }
}
