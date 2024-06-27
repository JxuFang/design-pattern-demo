package my.design.pattern.demo.decorator;

import cn.hutool.core.util.ZipUtil;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @Author: Fang Jinxu
 * @Description:
 * @Date: 2024-06-27 21:18
 */
public class CompressionDecorator extends DataSourceDecorator {

    public CompressionDecorator(DataSource wrapper) {
        super(wrapper);
    }

    @Override
    public void write(InputStream data) {
        byte[] gzip = ZipUtil.gzip(data);
        super.write(new ByteArrayInputStream(gzip));
    }

    @Override
    public InputStream read() {
        byte[] bytes = ZipUtil.unGzip(super.read());
        return new ByteArrayInputStream(bytes);
    }
}