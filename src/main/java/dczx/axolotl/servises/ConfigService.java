package dczx.axolotl.servises;

import dczx.axolotl.MainApplication;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigService {
    private static final Properties properties;
    private static final String filePath = MainApplication.path + "\\config.properties";

    static {
        properties = new Properties();
        // 加载配置文件
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static void setProperty(String key, String value) {
        properties.setProperty(key, value);
        saveConfig();
    }

    @SneakyThrows

    private static void saveConfig() {// 保存配置文件 因为输出流 没有文件会自动创建
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        properties.store(fileOutputStream, null);
        fileOutputStream.close();
    }

}