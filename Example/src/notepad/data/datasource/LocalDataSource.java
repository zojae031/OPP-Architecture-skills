package notepad.data.datasource;

import java.io.File;

public interface LocalDataSource {
    void saveText(String text, File path);

    String getText(File path);
}
