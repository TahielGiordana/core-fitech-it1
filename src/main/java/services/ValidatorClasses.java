package services;

import interfaces.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

public class ValidatorClasses implements Validator {
    private Logger log = LogManager.getLogger("ValidatorClasses");
    private Set<Validator> validators;

    public ValidatorClasses(ValidatorStorage validatorStorage) {
        this.validators = validatorStorage.getValidators();
    }

    public boolean validate(String userName, String machineCode) {
        log.info("inicio metodo validate");
        for (Validator validator : validators) {
            if (!validator.validate(userName, machineCode)) {
                log.info("fin metodo validate - se retorna: false ");
                return false;
            }
        }
        log.info("fin metodo validate - se retorna: true ");
        return true;
    }
}
