package notepad.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * 툴바 : 새로만들기, 열기, 저장, 다름이름으로 저장, 끝내기, 작게, 보통, 크게, 프로그램 정보
 */

public class MainView extends JFrame implements View {
    private JMenuBar menuBar = new JMenuBar();

    private final JMenu fileMenu = new JMenu("파일");
    private final JMenu editMenu = new JMenu("편집");

    private final JMenuItem newItem = new JMenuItem("새 문서");
    private final JMenuItem saveItem = new JMenuItem("저장");
    private final JMenuItem openItem = new JMenuItem("열기");
    private final JMenuItem closeItem = new JMenuItem("닫기");

    private final JPanel panel = new JPanel();
    private final JTextArea textArea = new JTextArea();
    private final JTextField textField = new JTextField(100);
    private JLabel label = new JLabel("라벨");

    @Override
    public void initView() {
        defaultSetting();
        menuSetting();
        setSize(300, 200);
        setVisible(true);
    }

    private void defaultSetting() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("NotePad");
        setLayout(new BorderLayout());

        add(label, BorderLayout.NORTH);
        textArea.add(textField);
        add(textArea, BorderLayout.CENTER);

    }

    private void menuSetting() {
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        fileMenu.add(newItem);
        fileMenu.add(saveItem);
        fileMenu.add(openItem);
        fileMenu.addSeparator();
        fileMenu.add(closeItem);

        setJMenuBar(menuBar);
    }

    @Override
    public void changeLabel(String text) {
        label.setText("[" + text + "] 를 선택했습니다.");
    }

    @Override
    public void setItemActionListener(ActionListener listener) {
        newItem.addActionListener(listener);
        openItem.addActionListener(listener);
        saveItem.addActionListener(listener);
        closeItem.addActionListener(listener);
    }

    @Override
    public String getEditText() {
        return textArea.getText();
    }

    @Override
    public void setEditText(String text) {
        textArea.setText(text);
    }
}

