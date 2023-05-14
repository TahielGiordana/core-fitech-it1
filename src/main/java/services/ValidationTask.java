package services;

import interfaces.Validator;

import java.util.Set;

public class ValidationTask implements Validator {
    Set<Validator> validators;

    public ValidationTask(Set<Validator> validators){
        this.validators = validators;
    }

    public boolean validate(String userName, String machineCode){
        for(Validator validator : validators){
            if(!validator.validate(userName,machineCode)){
                return false;
            };
        }
        return true;
    }

    public Set<Validator> getValidators() {
        return validators;
    }
}
