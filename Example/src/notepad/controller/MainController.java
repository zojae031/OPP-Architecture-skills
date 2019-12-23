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
        view.setItemActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String commend = e.getActionCommand();
        if (commend.equals("닫기")) System.exit(0);
        else view.changeLabel(commend);

    }
}
