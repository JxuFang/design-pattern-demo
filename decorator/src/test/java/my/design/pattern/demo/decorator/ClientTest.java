package my.design.pattern.demo.decorator;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @Author: Fang Jinxu
 * @Description:
 * @Date: 2024-06-27 22:40
 */
@RunWith(JUnit4.class)
public class ClientTest {

    @Test
    public void testFileDataSource() {
        File file = new File("src/test/resources/test.txt");
        DataSource fileDataSource = new FileDataSource(file);
        fileDataSource.write(new ByteArrayInputStream("hello, world!".getBytes(StandardCharsets.UTF_8)));
        try (InputStream inputstream = fileDataSource.read()) {
            System.out.println(IoUtil.getUtf8Reader(inputstream).readLine());
        } catch (IOException e) {
            System.out.println("error");
        }
    }
}