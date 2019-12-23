package notepad.data.datasource;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LocalDataSourceImpl implements LocalDataSource {

    @Override
    public void saveText(String text, File path) {
        try {
            FileWriter fw = new FileWriter(path);
            fw.write(text);
            System.out.println("저장된 데이터 : " + text);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getText(File path) {
        try {
            char[] charArray = new char[128];
            FileReader fr = new FileReader(path);
            while (fr.read(charArray) != -1) {

            }
            fr.close();
            return String.valueOf(charArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
