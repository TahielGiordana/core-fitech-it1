package services;

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

    public Set<Validator> getValidators() {
        return validators;
    }
}
