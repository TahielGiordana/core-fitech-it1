package services;

import interfaces.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

public class ValidatorStorage {

    private Logger log = LogManager.getLogger("ValidatorStorage");
    private Set<Validator> validators;

    public ValidatorStorage(Set<Validator> validators) {
        this.validators = validators;
    }
    public ValidatorStorage(String path) {
        log.info("se crea ValidatorStorage");
        ValidatorFinder validatorFinder = new ValidatorFinder();
        this.validators = validatorFinder.findValidators(path);
    }

    public Set<Validator> getValidators() {
        return validators;
    }

}
