package dczx.axolotl.screen;

import lombok.Data;

import javax.swing.*;
@Data
public class SettingScreen {
    private JPanel settingPanel;
    private JComboBox<String> themeComboBox;

    private void createUIComponents() {
        // TODO
    }

    public SettingScreen() {
        createUIComponents();
    }
}
