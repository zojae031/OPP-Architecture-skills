package ui;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public interface View {
    void attachActionListenser(ActionListener listener);

    void attachKeyListener(KeyListener listener);
}
