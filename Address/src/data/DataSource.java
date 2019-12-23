package data;

import com.google.gson.JsonArray;
import data.dao.AddressDataModel;

public interface DataSource {
    void insert(AddressDataModel model);


    String select();


    void delete(int index);

    public JsonArray getListData();
}
