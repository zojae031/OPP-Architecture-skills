package notepad.view;

import java.awt.event.ActionListener;
import java.io.File;

public interface View {
    void initView();

    void setItemActionListener(ActionListener listener);

    File showSaveFileChooser();

    File showOpenFileChoose();

    int newFile();

    String getEditText();

    void setEditText(String text);

    void clearView();

    void changeTitle(String text);

    void setFontSize(int size);

    void showDialog();
}
