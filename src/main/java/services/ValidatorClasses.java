package services;

import interfaces.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ValidatorClasses {
    private Logger log = LogManager.getLogger("ValidatorClasses");
    private Set<Validator> validators;

    public ValidatorClasses(ValidatorStorage validatorStorage) {
        this.validators = validatorStorage.getValidators();
    }

    public Map<String,Boolean> validate(String userName, String machineCode) {
        log.info("inicio metodo validate");
        Map<String,Boolean> result = new HashMap<>();
        for (Validator validator : validators) {
            if (!validator.validate(userName, machineCode)) {
                log.info("fin metodo validate - se retorna: false ");
                result.put(validator.getClass().getName().toString(),false);
            }else{
                result.put(validator.getClass().getName().toString(),true);
            }
        }
        log.info("fin metodo validate - se retorna: true ");
        return result;
    }
}
