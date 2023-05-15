package services;

import interfaces.Observer;
import interfaces.Validator;

import java.util.Set;

public class ValidationTask {
    Set<Validator> validators;
    private String machineCode;

    public ValidationTask(Set<Validator> validators){
        this.validators = validators;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }

    public boolean validate(String userName){
        for(Validator validator : validators){
            validator.validate(userName, machineCode);
        }
        return true;
    }

    public void uncheckValidator(String validatorName,Observer observer){
        for(Validator validator : validators){
            if(validator.getClass().getName().equals(validatorName)){
                validator.removeObserver(observer);
            }
        }
    }

    public void checkValidator(String validatorName,Observer observer){
        for(Validator validator : validators){
            if(validator.getClass().getName().equals(validatorName)){
                validator.addObserver(observer);
            }
        }
    }


    public Set<Validator> getValidators() {
        return validators;
    }
}
