package services;

import interfaces.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Set;

public class ValidationTask {
    private final Logger log = LogManager.getLogger("ValidationTask");
    Set<Validator> validators;
    private String machineCode;

    public ValidationTask(Set<Validator> validators){
        this.validators = validators;
    }

    public boolean validationRequest(String userName, String opcion){
        if(opcion.equalsIgnoreCase("ALL")){
            log.info("se ejecutan todos los validadores disponibles");
            return validate(userName);
        }else{
            Validator validator = getValidatorByName(opcion);
            return validator != null && validator.validate(userName, machineCode);
        }
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }

    public int size(){
        return this.validators.size();
    }

    private Validator getValidatorByName(String name){
        log.info("se busca validador por nombre: {} ", name);
        for(Validator validator : validators){
            if(validator.getName().equalsIgnoreCase(name)){
                log.info("busqueda exitosa se retorna el validador {}", validator.getName());
                return validator;
            }
        }
        log.warn("no existe el validador de nombre: {}", name);
        return null;
    }

    private boolean validate(String userName){
        for(Validator validator : validators){
            if(!validator.validate(userName,machineCode)){
                return false;
            };
        }
        return true;
    }

    
}
