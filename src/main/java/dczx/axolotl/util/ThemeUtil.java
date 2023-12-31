package dczx.axolotl.util;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.IntelliJTheme;
import dczx.axolotl.MainApplication;
import dczx.axolotl.servises.ConfigService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

@Slf4j(topic = "com.axolotl.BasicLogger")
public class ThemeUtil {
    private static final String path = MainApplication.path + "\\themes\\";
    private static final ArrayList<String> list = new ArrayList<>();
    private static JComboBox<String> comboBox;
    private static final ArrayList<Component> components = new ArrayList<>();

    static {
        // 扫描指定文件夹下的所有json文件
        File folder = new File(path);
        File[] files = folder.listFiles((file, fileName) -> fileName.endsWith(".json"));//筛选
        if (files != null) {
            for (File file : files) {
                list.add(file.getName());
            }
        }
    }

    @SneakyThrows
    public static void bind(JComboBox<String> comboBox) {
        ThemeUtil.comboBox = comboBox;
        initComboBox();

        //以下不要放静态代码块 因为frame没初始化 会空指针异常
        log.info("load theme...");
        UIManager.setLookAndFeel(new FlatLightLaf());//默认亮色主题
        String theme = ConfigService.getProperty("theme");
        if (theme != null) {
            loadTheme(theme);
            comboBox.setSelectedItem(theme.replace(".theme.json", ""));
        }
        reloadTheme();
    }


    public static void addComponent(Component component) {
        components.add(component);
    }

    /**
     * 初始化下拉框
     */
    public static void initComboBox() {
        comboBox.removeAllItems();
        for (String s : list) {
            comboBox.addItem(s.replace(".theme.json", ""));
        }

        comboBox.addActionListener(e -> {
            String theme = (String) comboBox.getSelectedItem();
            ConfigService.setProperty("theme", theme);
            loadTheme(theme);
        });
    }

    @SneakyThrows
    public static void loadTheme(String theme) {
        IntelliJTheme.install(new FileInputStream(path + theme + ".theme.json"));
        reloadTheme();
    }

    /**
     * 重载UI
     */
    @SneakyThrows
    public static void reloadTheme() {
        components.forEach(SwingUtilities::updateComponentTreeUI);
    }

}
