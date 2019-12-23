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

                break;
            case "저장":
                String text = view.getEditText();
                File savePath = view.showSaveFileChooser();
                repository.save(text, savePath);
                break;
            case "열기":
                File openPath = view.showOpenFileChoose();
                String loadData = repository.load(openPath);
                System.out.println(loadData);
                view.setEditText(loadData);
                break;
            default:

                break;
        }

    }
}
