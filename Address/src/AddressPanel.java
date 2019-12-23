import javax.swing.*;
import java.awt.*;

public class AddressPanel extends JPanel {
    private JPanel pnlSearch, pnlAddNDeleteAddress;
    private JComboBox comboBox;
    private JTextField txtSearch,txtAddName,txtAddAge,txtAddPhoneNumber;
    private JButton btnSearch,btnAddInfo,btnDelete;
    private AddressControler LAddress;

    public AddressPanel(){
        setBackground(Color.white);
        setPreferredSize(new Dimension(500,500));
        setLayout(new BorderLayout());

        setInitSearchPanel();
        setInitAddInfoPanel();
    }

    private void setInitSearchPanel(){
        pnlSearch = new JPanel();
        add(pnlSearch,BorderLayout.NORTH);

        comboBox = new JComboBox(AddressConstants.SearchFILTER);

        txtSearch = new JTextField(15);

        btnSearch = new JButton("Seach");

        pnlSearch.add(comboBox);
        pnlSearch.add(txtSearch);
        pnlSearch.add(btnSearch);
    }

    private void setInitAddInfoPanel(){
        pnlAddNDeleteAddress = new JPanel();
        add(pnlAddNDeleteAddress,BorderLayout.SOUTH);


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

    //=============Getter And Setter===================
    public JPanel getPnlSearch() { return pnlSearch; }
    public JPanel getPnlAddandDeleteAddress() { return pnlAddNDeleteAddress; }
    public JComboBox getComboBox() { return comboBox; }
    public JTextField getTxtSearch() { return txtSearch; }
    public JTextField getTxtAddName() { return txtAddName; }
    public JTextField getTxtAddAge() { return txtAddAge; }
    public JTextField getTxtAddPhoneNumber() { return txtAddPhoneNumber; }
    public JButton getBtnSearch() { return btnSearch; }
    public JButton getBtnAddInfo() { return btnAddInfo; }
    public JButton getBtnDelete() { return btnDelete; }

    public void setBtnAddInfo(JButton btnAddInfo) { this.btnAddInfo = btnAddInfo; }
    public void setBtnDelete(JButton btnDelete) { this.btnDelete = btnDelete; }
    public void setBtnSearch(JButton btnSearch) { this.btnSearch = btnSearch; }
    public void setComboBox(JComboBox comboBox) { this.comboBox = comboBox; }
    public void setPnlAddNDeleteAddress(JPanel pnlAddandDeleteAddress) { this.pnlAddNDeleteAddress = pnlAddandDeleteAddress; }
    public void setPnlSearch(JPanel pnlSearch) { this.pnlSearch = pnlSearch; }
    public void setTxtAddAge(JTextField txtAddAge) { this.txtAddAge = txtAddAge; }
    public void setTxtAddName(JTextField txtAddName) { this.txtAddName = txtAddName; }
    public void setTxtAddPhoneNumber(JTextField txtAddPhoneNumber) { this.txtAddPhoneNumber = txtAddPhoneNumber; }
    public void setTxtSearch(JTextField txtSearch) { this.txtSearch = txtSearch; }
    //=============Getter And Setter===================

}
