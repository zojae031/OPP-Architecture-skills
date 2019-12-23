package notepad.view;

import notepad.data.dao.EditDao;
import notepad.data.dao.FileDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * 툴바 : 새로만들기, 열기, 저장, 다름이름으로 저장, 끝내기, 작게, 보통, 크게, 프로그램 정보
 */

public class MainView extends JFrame implements View {
    private JMenuBar menuBar = new JMenuBar();

    FileDao fileDao = new FileDao();
    EditDao editDao = new EditDao();

    private final JTextArea textArea = new JTextArea();

    JToolBar toolBar = new JToolBar();
    JButton item = new JButton("item");

    private static final int BASE_FONT_SIZE = 12;

    @Override
    public void initView() {
        defaultSetting();
        menuSetting();
        toolbarSetting();
        textAreaSetting();
        setSize(300, 200);
        setVisible(true);
    }

    @Override
    public File showOpenFileChoose() {
        JFileChooser fileChooser = new JFileChooser("./");
        File path = null;
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            path = fileChooser.getSelectedFile();
        }
        return path;
    }

    @Override
    public File showSaveFileChooser() {
        JFileChooser fileChooser = new JFileChooser("./");
        File path = null;
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            path = fileChooser.getSelectedFile();
        }
        return path;
    }

    private void defaultSetting() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("NotePad");
        setLayout(new BorderLayout());
    }

    private void toolbarSetting() {
        add(toolBar, BorderLayout.NORTH);
        toolBar.add(item);
    }

    private void textAreaSetting() {
        add(textArea, BorderLayout.CENTER);
    }

    private void menuSetting() {
        menuBar.add(fileDao.fileMenu);


        fileDao.fileMenu.add(fileDao.newItem);
        fileDao.fileMenu.add(fileDao.saveItem);
        fileDao.fileMenu.add(fileDao.openItem);
        fileDao.fileMenu.addSeparator();
        fileDao.fileMenu.add(fileDao.closeItem);

        menuBar.add(editDao.editMenu);
        editDao.editMenu.add(editDao.small);
        editDao.editMenu.add(editDao.normal);
        editDao.editMenu.add(editDao.larger);

        setJMenuBar(menuBar);
    }

    @Override
    public int newFile() {
        return JOptionPane.showConfirmDialog(this, "저장하시겠습니까?");
    }

    @Override
    public void setItemActionListener(ActionListener listener) {
        fileDao.newItem.addActionListener(listener);
        fileDao.openItem.addActionListener(listener);
        fileDao.saveItem.addActionListener(listener);
        fileDao.closeItem.addActionListener(listener);

        editDao.small.addActionListener(listener);
        editDao.normal.addActionListener(listener);
        editDao.larger.addActionListener(listener);
    }

    @Override
    public String getEditText() {
        return textArea.getText();
    }

    @Override
    public void setEditText(String text) {
        textArea.setText(text);
    }


    @Override
    public void clearView() {
        textArea.setText("");
    }

    @Override
    public void changeTitle(String text) {
        setTitle(text);
    }

    @Override
    public void setFontSize(int size) {
        Font font = size == 0 ? new Font("Arial", Font.BOLD, BASE_FONT_SIZE) : new Font("Arial", Font.BOLD, textArea.getFont().getSize() + size);
        textArea.setFont(font);
    }
}

