package my.design.pattern.demo.decorator;

import cn.hutool.core.io.FileUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.InputStream;

/**
 * @Author: Fang Jinxu
 * @Description:
 * @Date: 2024-06-26 20:43
 */
@Slf4j
public class FileDataSource implements DataSource{

    private final File file;

    public FileDataSource(File file) {
        this.file = file;
    }

    @Override
    public void write(InputStream data) {
        log.info("write into file data source");
        FileUtil.writeFromStream(data, file);
    }

    @Override
    public InputStream read() {
        if (!file.exists()) {
            log.error("file [{}] not exist", file.getName());
        }
        log.info("read from file data source");
        return FileUtil.getInputStream(file);
    }
}
