package notepad.view;

import java.awt.event.ActionListener;
import java.io.File;

public interface View {
    void initView();

    void setItemActionListener(ActionListener listener);

    File showSaveFileChooser();

    File showOpenFileChoose();

    String getEditText();

    void setEditText(String text);

}
