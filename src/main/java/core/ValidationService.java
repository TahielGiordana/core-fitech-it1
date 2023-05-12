package core;

import interfaces.Observer;
import services.ValidatorFinder;
import services.ObservableValidationEngine;

public class ValidationService {
    private ObservableValidationEngine observableValidationEngine;

    public ValidationService(String path) {
        ValidatorFinder validatorFinder = new ValidatorFinder();
        observableValidationEngine = new ObservableValidationEngine(validatorFinder.findValidators(path));
    }

    public void postValidationRequest(String userName, String machineCode){
        this.observableValidationEngine.runValidationTask(userName,machineCode);
    }

    public boolean getResult(){
        return this.observableValidationEngine.getValidationResult();
    }

    public void subscribe(Observer observer){
        this.observableValidationEngine.addObserver(observer);
    }
}