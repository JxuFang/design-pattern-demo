package my.design.pattren.demo.decorator;

import java.io.InputStream;

/**
 * @Author: Fang Jinxu
 * @Description:
 * @Date: 2024-06-26 20:39
 */
public interface DataSource {

    /**
     * write data
     * @param data
     */
    void write(InputStream data);

    /**
     * read data
     * @return T
     */
    InputStream read();
}
