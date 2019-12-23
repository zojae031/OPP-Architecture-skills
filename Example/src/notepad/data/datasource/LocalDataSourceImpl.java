package notepad.data.datasource;

import java.io.*;

public class LocalDataSourceImpl implements LocalDataSource {
    final String path = "./sample.txt";
    File file = new File(path);


    @Override
    public void saveText(String text) {
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(text);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getText() {
        try {
            String str;
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((str = br.readLine()) != null) {
            }
            return str;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
