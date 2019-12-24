package data;

import com.google.gson.JsonArray;
import data.dao.AddressDataModel;

import java.util.ArrayList;

public interface DataSource {
    void insert(AddressDataModel model);


    String select();


    void delete(int index);

    public ArrayList<AddressDataModel> getListData();

}
