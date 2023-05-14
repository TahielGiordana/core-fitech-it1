package services;

import interfaces.Validator;

import java.io.FileNotFoundException;
import java.util.Set;

public class ValidatorFactory {

    public ValidationTask create(String path) throws FileNotFoundException {
        Set<Validator> validators = new ValidatorFinder().findValidators(path);
        return new ValidationTask(validators);
    }
}
