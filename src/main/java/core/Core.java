package core;

import interfaces.Validator;
import services.ValidatorClasses;
import services.ValidatorFinder;
import services.ValidationEngine;
import services.ValidatorStorage;

import java.util.Set;

public class Core  {
    private ValidationEngine validationEngine;

    public Core(String path) {
        ValidatorFinder validatorFinder = new ValidatorFinder();
        Set<Validator> validators = validatorFinder.findValidators(path);
        ValidatorStorage validatorStorage = new ValidatorStorage(validators);
        ValidatorClasses validatorClasses = new ValidatorClasses(validatorStorage);
        this.validationEngine = new ValidationEngine(validatorClasses);
    }

    public ValidationEngine getValidatorManager() {
        return validationEngine;
    }

}