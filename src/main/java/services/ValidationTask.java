package services;

import interfaces.Validator;

import java.util.Set;

public class ValidationTask implements Validator {
    Set<Validator> validators;
    String machineCode;

    public ValidationTask(Set<Validator> validators, String machineCode){
        this.validators = validators;
        this.machineCode = machineCode;
    }

    public boolean isValid(String userName){
        return this.validate(userName, this.machineCode);
    }
    public boolean validate(String userName, String machineCode){
        for(Validator validator : validators){
            if(!validator.validate(userName,machineCode)){
                return false;
            };
        }
        return true;
    }
}
