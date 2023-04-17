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

    public boolean executeValidators(Person person, Machine machine){
        return this.validatorSet.stream().allMatch(validator -> validator.validate(person, machine));
    }

}
