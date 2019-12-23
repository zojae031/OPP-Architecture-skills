package notepad.view;

import javax.swing.*;
import java.awt.*;


public class MainView extends JFrame implements View {
    private JMenuBar menuBar = new JMenuBar();

    private final JMenu fileMenu = new JMenu("파일");
    private final JMenu editMenu = new JMenu("편집");

    private final JMenuItem newItem = new JMenuItem("새 문서");
    private final JMenuItem openItem = new JMenuItem("열기");
    private final JMenuItem closeItem = new JMenuItem("닫기");

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
        setLayout(new FlowLayout());
        add(label);
    }

    private void menuSetting() {
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        fileMenu.add(newItem);
        newItem.addActionListener(e -> {
            label.setText("[" + newItem.getText() + "] 를 선택했습니다.");
        });
        fileMenu.add(openItem);
        openItem.addActionListener(e -> {
            label.setText("[" + openItem.getText() + "] 를 선택했습니다.");
        });
        fileMenu.add(closeItem);
        closeItem.addActionListener(e -> {
            System.exit(0);
        });


        setJMenuBar(menuBar);


    }
}

