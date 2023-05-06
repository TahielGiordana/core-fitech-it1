package core;

import interfaces.Validator;
import services.ValidatorClasses;
import services.ValidatorFinder;
import services.ValidatorManager;
import services.ValidatorStorage;

import java.util.Set;

public class Core  {
    private ValidatorManager validatorManager;

    public Core(String path) {
        ValidatorFinder validatorFinder = new ValidatorFinder();
        Set<Validator> validators = validatorFinder.findValidators(path);
        ValidatorStorage validatorStorage = new ValidatorStorage(validators);
        ValidatorClasses validatorClasses = new ValidatorClasses(validatorStorage);
        this.validatorManager = new ValidatorManager(validatorClasses);
    }

    public ValidatorManager getValidatorManager() {
        return validatorManager;
    }

}