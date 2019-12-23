package notepad.view;

import java.awt.event.ActionListener;

public interface View {
    void initView();

    void setItemActionListener(ActionListener listener);

    void changeLabel(String text);

}
