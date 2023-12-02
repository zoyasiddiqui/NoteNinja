package interface_adapter.back_menu;

import use_case.back_menu.BackMenuInputBoundary;
import use_case.back_menu.BackMenuInteractor;

public class BackMenuController {
    final BackMenuInputBoundary backMenuInteractor;

    public BackMenuController (BackMenuInputBoundary backMenuInteractor) {
        this.backMenuInteractor = backMenuInteractor;
    }

    public void execute() {
        this.backMenuInteractor.execute();
    }

}