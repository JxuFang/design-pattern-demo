package my.design.pattren.demo.decorator;

import cn.hutool.Hutool;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @Author: Fang Jinxu
 * @Description:
 * @Date: 2024-06-26 22:08
 */
public class EncryptionDecorator extends DataSourceDecorator{

    private final SymmetricCrypto aes;
    public EncryptionDecorator(DataSource wrapper) {
        super(wrapper);
        // 生成随机密钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        // 构建
        this.aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);
    }

    @Override
    public InputStream read() {
        InputStream encryptedData = super.read();
        byte[] decrypt = aes.decrypt(encryptedData);
        return new ByteArrayInputStream(decrypt);

    }

    @Override
    public void write(InputStream data) {
        byte[] encrypt = aes.encrypt(data);
        InputStream encryptedData = new ByteArrayInputStream(encrypt);
        super.write(encryptedData);
    }

}