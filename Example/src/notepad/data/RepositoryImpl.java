package notepad.data;

import notepad.data.datasource.LocalDataSource;

import java.io.File;

public class RepositoryImpl implements Repository {
    private LocalDataSource localDataSource;

    public RepositoryImpl(LocalDataSource localDataSource) {
        this.localDataSource = localDataSource;
    }

    @Override
    public void save(String text, File path) {
        localDataSource.saveText(text, path);
    }

    @Override
    public String load(File path) {
        return localDataSource.getText(path);
    }
}
