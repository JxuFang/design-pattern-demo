package my.design.pattern.demo.decorator;

import cn.hutool.core.util.ZipUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @Author: Fang Jinxu
 * @Description:
 * @Date: 2024-06-27 21:18
 */
@Slf4j
public class CompressionDecorator extends DataSourceDecorator {

    public CompressionDecorator(DataSource wrapper) {
        super(wrapper);
    }

    @Override
    public void write(InputStream data) {
        byte[] gzip = ZipUtil.gzip(data);
        log.info("gzip data source");
        super.write(new ByteArrayInputStream(gzip));
    }

    @Override
    public InputStream read() {
        byte[] bytes = ZipUtil.unGzip(super.read());
        log.info("ungzip data source");
        return new ByteArrayInputStream(bytes);
    }
}