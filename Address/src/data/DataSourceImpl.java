package data;

import com.google.gson.Gson;
import data.dao.AddressDataModel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * SingleTon Pattern을 적용한 DataSource (Model Class)
 *
 * @link {https://ko.wikipedia.org/wiki/%EC%8B%B1%EA%B8%80%ED%84%B4_%ED%8C%A8%ED%84%B4}
 * DataSource (Model) 은 SingleTon으로 유지해주는것이 여러 인스턴스 생성을 방지하여 메모리상 이득을 본다.
 * 왜나하면, 어차피 데이터를 가져오는것은 단일 비즈니스 로직일 경우가 많다 (아닐경우 싱글톤을 사용하지 않아도 무관)
 */
public class DataSourceImpl implements DataSource {
    private static DataSource INSTANCE = null;
    private final static String fname = "./juso.txt";

    private BufferedWriter bw;

    private DataSourceImpl() {
        try {
            bw = new BufferedWriter(new FileWriter(fname, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void insert(AddressDataModel model) {
        String json = new Gson().toJson(model);
        try {
            bw.write(json);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataSourceImpl();
        }
        return INSTANCE;
    }
}
