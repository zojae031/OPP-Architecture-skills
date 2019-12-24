package ui;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import controller.AddressController;
import data.DataSource;
import data.DataSourceImpl;
import data.dao.AddressDataModel;
import util.AddressConstants;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class AddressPanel extends JPanel implements View {
    private JPanel pnlSearch, pnlAddNDeleteAddress;
    private JComboBox comboBox;
    private JTextField txtSearch, txtAddName, txtAddAge, txtAddPhoneNumber;
    private JButton btnSearch, btnAddInfo, btnDelete;
    private AddressController LAddress;
    private JTable Table;
    private DefaultTableModel model;
    private TableRowSorter<DefaultTableModel> tableSorter;
    public AddressPanel() {
        setBackground(Color.white);
        setPreferredSize(new Dimension(500, 500));
        setLayout(new BorderLayout());
        setInitSearchPanel();
        setInitAddInfoPanel();
        LAddress = new AddressController(this);
        setInitJTable();
    }

    private void setInitSearchPanel() {
        pnlSearch = new JPanel();
        add(pnlSearch, BorderLayout.NORTH);

        comboBox = new JComboBox(AddressConstants.SearchFILTER);

        txtSearch = new JTextField(15);

        btnSearch = new JButton("Seach");

        pnlSearch.add(comboBox);
        pnlSearch.add(txtSearch);
        pnlSearch.add(btnSearch);
    }

    private void setInitAddInfoPanel() {
        pnlAddNDeleteAddress = new JPanel();
        add(pnlAddNDeleteAddress, BorderLayout.SOUTH);


        txtAddName = new JTextField(4);
        txtAddName.setBorder(BorderFactory.createTitledBorder("Name"));

        txtAddAge = new JTextField(3);
        txtAddAge.setBorder(BorderFactory.createTitledBorder("Age"));

        txtAddPhoneNumber = new JTextField(13);
        txtAddPhoneNumber.setBorder(BorderFactory.createTitledBorder("Phone Number"));

        btnAddInfo = new JButton("Register");

        btnDelete = new JButton("Delete");

        pnlAddNDeleteAddress.add(txtAddName);
        pnlAddNDeleteAddress.add(txtAddAge);
        pnlAddNDeleteAddress.add(txtAddPhoneNumber);
        pnlAddNDeleteAddress.add(btnAddInfo);
        pnlAddNDeleteAddress.add(new JLabel("||"));
        pnlAddNDeleteAddress.add(btnDelete);
    }

    private void setInitJTable(){
        ArrayList<AddressDataModel> datalist = DataSourceImpl.getInstance().getListData();
        Table = new JTable();

        model = new DefaultTableModel(AddressConstants.SearchFILTER,0);
        for(AddressDataModel data : datalist) {
            model.addRow(new Object[]{data.name,data.age,data.PhoneNumber});
            System.out.println(data.name);
        }
        Table.setBackground(Color.white);
        Table.setModel(model);
        add(Table,BorderLayout.CENTER);
        TableColumn column;
        column = Table.getColumnModel().getColumn(0);
        column.setPreferredWidth(100);
        column = Table.getColumnModel().getColumn(1);
        column.setPreferredWidth(100);
        column = Table.getColumnModel().getColumn(2);
        column.setPreferredWidth(300);
    }

    //================================================
    public void filter(){
        String text = txtSearch.getText();
        int criteria = comboBox.getSelectedIndex();
        if(text == null)
            tableSorter.setRowFilter(null); //검색 중이 아닌 경우 모든 항목을 표시
        else
            tableSorter.setRowFilter(RowFilter.regexFilter(text, criteria)); //실제 검색 실행하여 결과 표시
    }

    //=============Getter And Setter===================

    public DefaultTableModel getModel() {
        return model;
    }

    public JPanel getPnlSearch() {
        return pnlSearch;
    }

    public JPanel getPnlAddandDeleteAddress() {
        return pnlAddNDeleteAddress;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public JTextField getTxtSearch() {
        return txtSearch;
    }

    public JTextField getTxtAddName() {
        return txtAddName;
    }

    public JTextField getTxtAddAge() {
        return txtAddAge;
    }

    public JTextField getTxtAddPhoneNumber() {
        return txtAddPhoneNumber;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public JButton getBtnAddInfo() {
        return btnAddInfo;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnAddInfo(JButton btnAddInfo) {
        this.btnAddInfo = btnAddInfo;
    }

    public void setBtnDelete(JButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public void setBtnSearch(JButton btnSearch) {
        this.btnSearch = btnSearch;
    }

    public void setComboBox(JComboBox comboBox) {
        this.comboBox = comboBox;
    }

    public void setPnlAddNDeleteAddress(JPanel pnlAddandDeleteAddress) {
        this.pnlAddNDeleteAddress = pnlAddandDeleteAddress;
    }

    public void setPnlSearch(JPanel pnlSearch) {
        this.pnlSearch = pnlSearch;
    }

    public void setTxtAddAge(JTextField txtAddAge) {
        this.txtAddAge = txtAddAge;
    }

    public void setTxtAddName(JTextField txtAddName) {
        this.txtAddName = txtAddName;
    }

    public void setTxtAddPhoneNumber(JTextField txtAddPhoneNumber) {
        this.txtAddPhoneNumber = txtAddPhoneNumber;
    }

    public void setTxtSearch(JTextField txtSearch) {
        this.txtSearch = txtSearch;
    }

    public int getComboBoxIndex() {
        return comboBox.getSelectedIndex();
    }

    // TODO: 2019-12-24 Have to Fix return
    public int getJTableIndex(){return Table.getSelectedRow();}
    //=============Getter And Setter===================


    @Override
    public void attachActionListenser(ActionListener listener) {
        btnAddInfo.addActionListener(listener);
        btnDelete.addActionListener(listener);
        btnSearch.addActionListener(listener);
    }

    @Override
    public void attachKeyListener(KeyListener listener) {
        comboBox.addKeyListener(listener);
    }

    @Override
    public void showSelectList(AddressDataModel model) {
        System.out.println(model.name + " " + model.age + " " + model.PhoneNumber);
    }
}
