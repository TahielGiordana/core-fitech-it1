package services;

import interfaces.Validator;

import java.io.FileNotFoundException;
import java.util.Set;

public class ValidatorFactory {

    private final String machineCode;
    private final ValidatorFinder validatorFinder;

    public ValidatorFactory(String path, String machineCode) {
        this.machineCode = machineCode;
        this.validatorFinder = new ValidatorFinder(path);
    }

    public ValidationTask buildValidationTask() throws FileNotFoundException {
        Set<Validator> validators = validatorFinder.findValidators();
        return new ValidationTask(validators, machineCode);

    }
}
