package data;

import data.dao.AddressDataModel;

public interface DataSource {
    void insert(AddressDataModel model);
    void delete(int index);
}
