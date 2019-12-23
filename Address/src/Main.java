import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Address");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        AddressPanel primary = new AddressPanel();
        frame.getContentPane().add(primary);

        frame.pack();
        frame.setVisible(true);
    }
}
