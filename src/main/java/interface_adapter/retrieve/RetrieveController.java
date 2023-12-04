package interface_adapter.retrieve;

import use_case.retrieve.RetrieveInputBoundary;

public class RetrieveController {
    final RetrieveInputBoundary retrieveInteractor;

    public RetrieveController(RetrieveInputBoundary retrieveInteractor) {
        this.retrieveInteractor = retrieveInteractor;
    }

    public void execute() {
        retrieveInteractor.execute();
    }
}
