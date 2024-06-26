package my.design.pattren.demo.decorator;

import java.io.InputStream;

/**
 * @Author: Fang Jinxu
 * @Description:
 * @Date: 2024-06-26 21:43
 */
public abstract class DataSourceDecorator implements DataSource{

    private final DataSource wrapper;

    public DataSourceDecorator(DataSource wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public void write(InputStream data) {
        wrapper.write(data);
    }

    @Override
    public InputStream read() {
        return wrapper.read();
    }
}