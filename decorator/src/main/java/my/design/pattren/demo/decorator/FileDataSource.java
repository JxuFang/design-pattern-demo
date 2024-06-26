package my.design.pattren.demo.decorator;

import cn.hutool.Hutool;
import cn.hutool.core.io.FileUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedInputStream;
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
        FileUtil.writeFromStream(data, file);
    }

    @Override
    public InputStream read() {
        if (!file.exists()) {
            log.error("file [{}] not exist", file.getName());
        }
        return FileUtil.getInputStream(file);
    }
}
