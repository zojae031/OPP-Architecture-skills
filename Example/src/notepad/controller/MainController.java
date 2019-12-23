package notepad.controller;

import notepad.data.Repository;
import notepad.view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainController implements Controller, ActionListener {
    View view;
    Repository repository;

    public MainController(View view, Repository repository) {
        super();
        this.view = view;
        this.repository = repository;
    }

    public void init() {
        view.initView();
        view.setItemActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String commend = e.getActionCommand();
        System.out.println(commend);
        switch (commend) {
            case "닫기":
                System.exit(0);
                break;
            case "새 문서":
                int result = view.newFile();
                if (result == 0) {
                    save();
                    clearState();
                }
                break;
            case "저장":
                save();
                break;
            case "열기":
                open();
                break;
            case "작게":
                view.setFontSize(-2);
                break;
            case "보통":
                view.setFontSize(0);
                break;
            case "크게":
                view.setFontSize(+2);
                break;
            default:

                break;
        }
    }

    private void save() {
        String text = view.getEditText();
        File savePath = view.showSaveFileChooser();
        repository.save(text, savePath);
    }

    private void open() {
        File openPath = view.showOpenFileChoose();
        String loadData = repository.load(openPath);
        System.out.println(loadData);
        view.setEditText(loadData);
    }

    private void clearState() {
        view.clearView();
        view.changeTitle("NotePad");
    }

}
