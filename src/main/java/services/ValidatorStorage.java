package services;

import interfaces.Validator;

import java.util.Set;

public class ValidatorStorage {
    private Set<Validator> validators;

    public ValidatorStorage(Set<Validator> validators) {
        this.validators = validators;
    }
    public ValidatorStorage(String path) {
        ValidatorFinder validatorFinder = new ValidatorFinder();
        this.validators = validatorFinder.findValidators(path);
    }

    public Set<Validator> getValidators() {
        return validators;
    }

}
