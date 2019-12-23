import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AddressController implements ActionListener, KeyListener {
    private AddressPanel pnl;

    public AddressController(AddressPanel panel){
        pnl = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == pnl.getBtnAddInfo()){

        }//Add Info

        if(obj == pnl.getBtnDelete()){

        }//Delete Info

        if(obj == pnl.getBtnSearch()){

        }//Search Info
    }


    @Override
    public void keyPressed(KeyEvent e) {
        Object obj = e.getSource();
        if(obj == pnl.getTxtSearch()){
            if(pnl.getComboBoxIndex() == AddressConstants.SearchToName){

            }
            if(pnl.getComboBoxIndex() == AddressConstants.SearchToAge){

            }
            if(pnl.getComboBoxIndex() == AddressConstants.SearchToPhoneNumber){

            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }
    @Override
    public void keyTyped(KeyEvent e) { }

}
