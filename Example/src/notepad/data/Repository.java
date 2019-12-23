package notepad.data;

public interface Repository {
    void save(String text);

    String load();
}
