package notepad.view;

import javax.swing.*;
import java.awt.*;


public class MainView extends JFrame implements View {
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu = new JMenu("상위 메뉴");

    private final String[] menuList = new String[]{"파일", "편집"};
    private final String[] fileItem = new String[]{"새 문서", "열기", "닫기"};

    private final JMenu fileMenu = new JMenu("파일");
    private final JMenu editMenu = new JMenu("편집");


    @Override
    public void initView() {
        defaultSetting();
        menuSetting();
        menu.addActionListener(e -> {

        });
        setSize(300, 200);
        setVisible(true);
    }

    private void defaultSetting() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("NotePad");
        setLayout(new FlowLayout());
        JLabel label = new JLabel("라벨");
        add(label);


    }

    private void menuSetting() {
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        for (String item : fileItem) {
            fileMenu.add(new JMenuItem(item));
        }
        setJMenuBar(menuBar);
    }
}

