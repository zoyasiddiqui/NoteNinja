package interface_adapter.switch_to_search;

import use_case.switch_to_search.SwitchToSearchInteractor;

public class SwitchToSearchController {

    private final SwitchToSearchInteractor switchToSearchInteractor;

    public SwitchToSearchController(SwitchToSearchInteractor switchToSearchInteractor) {
        this.switchToSearchInteractor = switchToSearchInteractor;
    }

    public void execute() {
        this.switchToSearchInteractor.execute();
    }

}
