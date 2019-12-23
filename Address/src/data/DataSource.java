package data;

import data.dao.AddressDataModel;

public interface DataSource {
    void insert(AddressDataModel model);


    String select();


    void delete(int index);

}
