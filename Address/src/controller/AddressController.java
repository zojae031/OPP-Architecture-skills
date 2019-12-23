package controller;

import com.google.gson.Gson;
import data.DataSource;
import data.DataSourceImpl;
import data.dao.AddressDataModel;
import ui.AddressPanel;
import util.AddressConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class AddressController implements ActionListener, KeyListener {
    private AddressPanel pnl;
    private final DataSource dataSource = DataSourceImpl.getInstance();

    public AddressController(AddressPanel panel) {
        pnl = panel;
        pnl.attachActionListenser(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == pnl.getBtnAddInfo()) {
            insert();
        }//Add Info

        if (obj == pnl.getBtnDelete()) {
            delete();
        }//Delete Info

        if (obj == pnl.getBtnSearch()) {
            select();
        }//Search Info
    }

    private void insert() {
        String name = pnl.getTxtAddName().getText();
        int age = Integer.parseInt(pnl.getTxtAddAge().getText());
        String phone = pnl.getTxtAddPhoneNumber().getText();

        AddressDataModel model = new AddressDataModel(age, name, phone);//TODO util class 분리 가능

        dataSource.insert(model);
    }


    private void select() {
        String text = pnl.getTxtSearch().getText();
        if (text.equals("")) {//빈칸이면 모두 검색
            pnl.showSelectList((AddressDataModel) new Gson().fromJson(dataSource.select(), AddressDataModel.class));
        } else {//그렇지 않다면 선택 검색색

        }
    }

    private void delete(){
        int index = pnl.getJTableIndex();
        dataSource.delete(index);

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Object obj = e.getSource();
        if (obj == pnl.getTxtSearch()) {
            if (pnl.getComboBoxIndex() == AddressConstants.SearchToName) {

            }
            if (pnl.getComboBoxIndex() == AddressConstants.SearchToAge) {

            }
            if (pnl.getComboBoxIndex() == AddressConstants.SearchToPhoneNumber) {

            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


}
