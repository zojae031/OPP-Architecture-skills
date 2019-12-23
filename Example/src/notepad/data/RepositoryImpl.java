package notepad.data;

import notepad.data.datasource.LocalDataSource;

public class RepositoryImpl implements Repository {
    private LocalDataSource localDataSource;

    public RepositoryImpl(LocalDataSource localDataSource) {
        this.localDataSource = localDataSource;
    }

    @Override
    public void save(String text) {
        localDataSource.saveText(text);
    }

    @Override
    public String load() {
        return localDataSource.getText();
    }
}
