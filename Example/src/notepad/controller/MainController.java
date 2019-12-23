package notepad.controller;

import notepad.data.Repository;
import notepad.view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                view.changeLabel(commend);
                break;
            case "저장":
                String text = view.getEditText();

                repository.save(text);
                break;
            case "열기":
                String loadData = repository.load();
                System.out.println(loadData);
                view.setEditText(loadData);
                break;
            default:
                view.changeLabel(commend);
                break;
        }

    }
}
