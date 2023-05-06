package services;

import interfaces.Validator;

import java.util.Set;

public class ValidatorClasses implements Validator {
    private Set<Validator> validators;

    public ValidatorClasses(ValidatorStorage validatorStorage) {
        this.validators = validatorStorage.getValidators();
    }

    public boolean validate(String userName, String machineCode) {
        for (Validator validator : validators) {
            if (!validator.validate(userName, machineCode)) {
                return false;
            }
        }
        return true;
    }
}
