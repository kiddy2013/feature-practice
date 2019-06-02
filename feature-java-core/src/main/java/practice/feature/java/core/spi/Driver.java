package practice.feature.java.core.spi;

/**
 * 模拟Driver接口
 *
 * @author jack
 */
public interface Driver {

    /**
     * 链接数据库
     *
     * @param url
     * @return
     */
    String connect(String url);
}
