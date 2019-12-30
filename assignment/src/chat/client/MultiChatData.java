package chat.client;

import javax.swing.*;

public class MultiChatData {

    private JTextArea msgOut;

    public void addObj(JComponent component) {
        msgOut= (JTextArea) component;
    }

    public void refreshData(String msg) {
        msgOut.append(msg);
    }
}
