package services;

import interfaces.Validator;

import java.util.Set;

public class ValidatorSequence implements Validator {
    Set<Validator> validatorSet;

    public ValidatorSequence(Set<Validator> validatorSet) {
        this.validatorSet = validatorSet;
    }

    public boolean validate(String userName, String machineCode) {
        System.out.println("validadores disponibles: " + this.validatorSet.size());
        boolean success = this.validatorSet.size() > 0;
        for (Validator v : this.validatorSet) {
            System.out.println("se valida con: " + v.getClass().getName() + " con resultado: " + v.validate(userName, machineCode));
            success = success && v.validate(userName, machineCode);
        }
        return success;
    }

}
