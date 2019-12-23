package notepad.data;

import java.io.File;

public interface Repository {
    void save(String text, File path);
    String load(File path);
}
