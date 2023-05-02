package services;

import interfaces.Validator;
import pojos.Machine;
import pojos.Person;

import java.util.Set;

public class ValidatorSequence {
    Set<Validator> validatorSet;

    public ValidatorSequence(Set<Validator> validatorSet) {
        this.validatorSet = validatorSet;
    }

    public boolean executeValidators(Person person, Machine machine) {
        System.out.println("validadores disponibles: " + this.validatorSet.size());
        boolean success = this.validatorSet.size() > 0;
        for (Validator v : this.validatorSet) {
            System.out.println("se valida con: " + v + " con resultado: " + v.validate(person.getUsername(), machine.getCode()));
            success = success && v.validate(person.getUsername(), machine.getCode());
        }
        return success;
    }

}
