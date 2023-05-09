package core;

import interfaces.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.ValidatorClasses;
import services.ValidatorFinder;
import services.ValidationEngine;
import services.ValidatorStorage;

import java.util.Set;

public class Core  {
    private Logger log = LogManager.getLogger("Core");
    private ValidationEngine validationEngine;

    public Core(String path) {
        log.info("SE CREA EL CORE - path: {}", path);
        ValidatorFinder validatorFinder = new ValidatorFinder();
        Set<Validator> validators = validatorFinder.findValidators(path);
        ValidatorStorage validatorStorage = new ValidatorStorage(validators);
        ValidatorClasses validatorClasses = new ValidatorClasses(validatorStorage);
        this.validationEngine = new ValidationEngine(validatorClasses);
        log.info("FIN INICIALIZACION DEL CORE");
    }

    public ValidationEngine getValidatorManager() {
        return validationEngine;
    }
}