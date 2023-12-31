package dczx.axolotl.screen;

import lombok.Data;

import javax.swing.*;

@Data
public class LevelSystemScreen {
    private JPanel mainScreenPanel;
    private JScrollPane LevelPanel;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public LevelSystemScreen() {
        createUIComponents();
    }
}
