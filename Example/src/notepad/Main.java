package notepad;

import notepad.controller.Controller;
import notepad.controller.MainController;
import notepad.data.RepositoryImpl;
import notepad.data.datasource.LocalDataSourceImpl;
import notepad.view.MainView;

public class Main {
    public static void main(String[] args) {
        Controller mainController = new MainController(new MainView(), new RepositoryImpl(new LocalDataSourceImpl()));
        mainController.init();
    }
}
