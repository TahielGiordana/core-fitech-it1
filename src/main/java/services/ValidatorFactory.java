package services;

import interfaces.Validator;
import java.util.Set;

public class ValidatorFactory {

    public ValidationTask create(String path){
        Set<Validator> validators = new ValidatorFinder().findValidators(path);
        return new ValidationTask(validators);
    }
}
