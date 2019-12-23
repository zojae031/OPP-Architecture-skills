package notepad.data.datasource;

public interface LocalDataSource {
    void saveText(String text);

    String getText();
}
