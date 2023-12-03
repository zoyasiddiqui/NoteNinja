package interface_adapter.retrieve;

import use_case.retrieve_usecase.RetrieveInputBoundary;

import java.io.IOException;
import java.util.ArrayList;

public class RetrieveController {
    private final RetrieveInputBoundary retrieveInteractor;
    public RetrieveController (RetrieveInputBoundary retrieveInteractor) {
        this.retrieveInteractor = retrieveInteractor;
    }
    public void execute() throws IOException {
        retrieveInteractor.execute();
    }
}
