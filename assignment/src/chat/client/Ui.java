package chat.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Ui extends JFrame {
    //login
    private JPanel loginPanel;
    protected JButton loginButton;
    private JLabel inLabel;
    protected JTextField idInput;

    //logout
    protected JLabel outLabel;
    private JPanel logoutPanel;
    protected JButton logoutButton;

    private JPanel msgPanel;
    protected JTextField msgInput;
    protected JButton exitButton;

    protected Container tab;
    protected CardLayout cardLayout;

    private JScrollPane jsp;
    protected JTextArea msgOut;

    public String id;

    public Ui() {
        super("::멀티챗::");
        this.setLayout(new BorderLayout());

        //upper
        setUpper();
        this.add(tab, BorderLayout.NORTH);

        //middle
        setMiddle();
        this.add(jsp, BorderLayout.CENTER);

        //bottom
        setInputText();
        this.add(msgPanel, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 300);
        this.setVisible(true);

    }

    private void setLogin() {
        loginPanel = new JPanel();
        loginPanel.setLayout(new BorderLayout());

        idInput = new JTextField(15);
        loginButton = new JButton("로그인");

        inLabel = new JLabel("대화명 ");
        loginPanel.add(inLabel, BorderLayout.WEST);
        loginPanel.add(idInput, BorderLayout.CENTER);
        loginPanel.add(loginButton, BorderLayout.EAST);

    }

    private void setLogout() {
        logoutPanel = new JPanel();
        logoutPanel.setLayout(new BorderLayout());

        outLabel = new JLabel();
        logoutButton = new JButton("로그아웃");

        logoutPanel.add(outLabel, BorderLayout.CENTER);
        logoutPanel.add(logoutButton, BorderLayout.EAST);

    }

    private void setUpper() {
        setLogin();
        setLogout();
        tab = new JPanel();
        cardLayout = new CardLayout();
        tab.setLayout(cardLayout);
        tab.add(loginPanel, "login");
        tab.add(logoutPanel, "logout");
        cardLayout.show(tab, "logint");//
    }

    private void setInputText() {
        msgPanel = new JPanel();
        msgInput = new JTextField(15);

        exitButton = new JButton("종료");
        msgPanel.add(msgInput, BorderLayout.CENTER);
        msgPanel.add(exitButton, BorderLayout.EAST);
    }

    private void setMiddle() {
        msgOut = new JTextArea("", 10, 30);
        msgOut.setEditable(false);
        jsp = new JScrollPane(msgOut, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }

    public void addButtonActionListener(ActionListener listener) {
        loginButton.addActionListener(listener);
        logoutButton.addActionListener(listener);
        exitButton.addActionListener(listener);
        msgInput.addActionListener(listener);
    }
}
