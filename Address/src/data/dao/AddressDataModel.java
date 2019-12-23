package data.dao;

public class AddressDataModel {
    public int age = 0;
    public String name = "NONE";
    public String PhoneNumber = "NONE";

    public AddressDataModel(final int age, final String name, final String phonenumber) {
        this.age = age;
        this.name = name;
        this.PhoneNumber = phonenumber;
    }
}
