import javax.swing.*;
import java.awt.*;

public class AddressPanel extends JPanel {
    private JPanel pnlSearch,pnlAddAddress;
    JComboBox comboBox;
    JTextField txtSearch,txtAddName,txtAddAge,txtAddPhoneNumber;
    JButton btnSearch,btnAddInfo;
    JList list;

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

        btnSearch = new JButton("Search");

        pnlSearch.add(comboBox);
        pnlSearch.add(txtSearch);
        pnlSearch.add(btnSearch);
    }

    private void setInitAddInfoPanel(){
        pnlAddAddress = new JPanel();
        add(pnlAddAddress,BorderLayout.SOUTH);


        txtAddName = new JTextField(4);
        txtAddName.setBorder(BorderFactory.createTitledBorder("Name"));

        txtAddAge = new JTextField(3);
        txtAddAge.setBorder(BorderFactory.createTitledBorder("Age"));

        txtAddPhoneNumber = new JTextField(13);
        txtAddPhoneNumber.setBorder(BorderFactory.createTitledBorder("Phone Number"));

        btnAddInfo = new JButton("Register");

        pnlAddAddress.add(txtAddName);
        pnlAddAddress.add(txtAddAge);
        pnlAddAddress.add(txtAddPhoneNumber);
        pnlAddAddress.add(btnAddInfo);
    }
}
