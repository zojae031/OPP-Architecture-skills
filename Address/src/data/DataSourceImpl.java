package data;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import data.dao.AddressDataModel;

import java.io.*;
import java.util.ArrayList;


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
    private ArrayList<AddressDataModel> listData;
    private BufferedWriter bw;
    private BufferedReader br;

    private DataSourceImpl() {
        listData = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(fname));
            String strline = "";
            while ((strline = br.readLine()) != null) {
                AddressDataModel model = new Gson().fromJson(strline, AddressDataModel.class);
                listData.add(model);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(int index) {
        System.out.println("Delete");
        listData.remove(index);
        try {
            bw = new BufferedWriter(new FileWriter(fname, false));
            for(AddressDataModel model : listData) {
                bw.write(new Gson().toJson(model));
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(AddressDataModel model) {
        listData.add(model);

        String json = new Gson().toJson(model);
        try {
            bw = new BufferedWriter(new FileWriter(fname, true));
            bw.write(json);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<AddressDataModel> getListData() {
        return listData;
    }

    @Override
    public String select() {
       System.out.println(listData.toString());

        return "";
    }

    public static DataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataSourceImpl();
        }
        return INSTANCE;
    }
}
