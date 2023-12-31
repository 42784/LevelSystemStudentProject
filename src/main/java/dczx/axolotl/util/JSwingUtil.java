package dczx.axolotl.util;


import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

@Slf4j(topic = "com.axolotl.BasicLogger")
public class JSwingUtil {
    public static void focusListenerInit(JTextField jTextField, String tip, boolean reset) {
        jTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {// 处理焦点获得事件
                if (jTextField.getText().equals(tip))//清空文本框内容
                    jTextField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {// 处理焦点失去事件
                if (reset && jTextField.getText().equals(""))
                    jTextField.setText(tip);//空字串 刷新提示
            }
        });
    }

//    public static void bindTextFieldToSearch(JTextField textField, SearchRunnable searchRunnable) {
//        // 添加DocumentListener来监听文本内容的变化
//        textField.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {// 当有字符插入时触发
//                updateText();
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {// 当有字符删除时触发
//                updateText();
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {// 当文本属性发生变化时触发
//                updateText();
//            }
//
//            private void updateText() {
//                String text = textField.getText(); // 获取文本框的当前文本内容
//                searchRunnable.run(text);//调用搜索算法
//            }
//        });
//    }
}
