package notepad.controller;

import notepad.data.Repository;
import notepad.view.View;

public class MainController implements Controller {
    View view;
    Repository repository;

    public MainController(View view, Repository repository) {
        super();
        this.view = view;
        this.repository = repository;
    }

    public void init() {
        view.initView();
    }
}
