package dczx.axolotl;

import lombok.Data;

import javax.swing.*;

@Data
public class LevelSystemMaster {
    private JTabbedPane tabbedPane;
    private JPanel mainScreenPanel;
    private JButton button1;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public LevelSystemMaster() {
        createUIComponents();
    }
}
