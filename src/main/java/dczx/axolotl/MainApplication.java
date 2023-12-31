package dczx.axolotl;

import dczx.axolotl.screen.LevelSystemScreen;
import dczx.axolotl.screen.SettingScreen;
import dczx.axolotl.util.ThemeUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;

@AllArgsConstructor
@Slf4j(topic = "com.axolotl.BasicLogger")
public class MainApplication {
    public static final String path = System.getProperty("user.dir");
    private JFrame frame;
    private LevelSystemMaster mainScreen;
    private LevelSystemScreen levelSystemScreen;
    private SettingScreen settingScreen;

    public static void main(String[] args) {
        log.info("Loading...");

        MainApplication mainApplication = new MainApplication(
                new JFrame("等级闯关系统(LevelSystem) (Powered by: AxolotlXM)"),//主窗体
                new LevelSystemMaster(),//主界面
                new LevelSystemScreen(),//控制台界面
                new SettingScreen()//设置界面
        );

        mainApplication.initFrame();
        mainApplication.initTheme();
        mainApplication.initTabbedPane();

        log.info("Loaded!");

    }

    /**
     * 主窗体创建
     */
    private void initFrame() {
        //窗体设置
        frame.setContentPane(mainScreen.getMainScreenPanel());//载入主界面
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();//自适应大小
        frame.setSize(1000, 720);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.requestFocus();//获取焦点
    }

    /**
     * 初始化主题
     */
    private void initTheme() {
        //主题下拉框
        JComboBox<String> themeComboBox = settingScreen.getThemeComboBox();
        themeComboBox.setMaximumRowCount(30);
        ThemeUtil.bind(themeComboBox);
        //组件添加
        ThemeUtil.addComponent(frame);
        ThemeUtil.addComponent(mainScreen.getMainScreenPanel());
        ThemeUtil.addComponent(levelSystemScreen.getMainScreenPanel());
        ThemeUtil.addComponent(settingScreen.getSettingPanel());
        ThemeUtil.reloadTheme();

    }


    /**
     * 初始化标签页
     */
    private void initTabbedPane() {
        //标签页添加
        JTabbedPane tabbedPane = mainScreen.getTabbedPane();
        tabbedPane.addTab("主界面", levelSystemScreen.getMainScreenPanel());
        tabbedPane.addTab("版本设置", new JPanel());
        tabbedPane.addTab("设置", settingScreen.getSettingPanel());

    }

}