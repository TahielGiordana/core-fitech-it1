package services;

import interfaces.Observable;
import interfaces.Observer;
import interfaces.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

public class ValidationTask implements Observable, Observer {
    private final Logger log = LogManager.getLogger("ValidationTask");
    Set<Validator> validators;
    private String machineCode;
    private Boolean result;

    public ValidationTask(Set<Validator> validators, String machineCode){
        this.result = null;
        this.validators = validators;
        this.machineCode = machineCode;
        this.addAsObserver();
    }

    public void processRequest(String userName) {
        for (Validator validator : validators) {
            validator.validate(userName, this.machineCode);
        }
    }

    public void stopValidationTask(){
        this.result = null;
        for(Validator validator : validators){
            validator.stopValidation();
        }
    }

    private void addAsObserver() {
        for (Validator validator : this.validators) {
            validator.addObserver(this);
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {

    }

    @Override
    public void notifyObservers(Boolean result) {
        for (Observer observer : observers) {
            observer.update(result);
        }
    }

    @Override
    public void update() {
        boolean partialResult = true;
        for (Validator validator : this.validators) {
            //Verifico si existen validators que no finalizaron su validación
            //Si hay alguno en proceso de validación no realizo el update en la ui
            if(validator.getResult() == null){
                return;
            }
            //Si todos los validators tienen su resultado verifico si alguno falló
            else{
                if (!validator.getResult()) {
                    log.info("Falló el validador: {}", validator.getClass().getName());
                    partialResult = false;
                    break; // Detener la iteración si hay un fallo
                }
            log.info("Pasó el validador: {}", validator.getClass().getName());
            }
        }
        if(partialResult != result){
            result = partialResult;
            this.notifyObservers(result);
        }
        log.info("\u001B[31mResultado de la validación es: {}\u001B[0m", result);
    }

    @Override
    public void update(Boolean result) {
    }

    public Set<Validator> getValidators(){
        return this.validators;
    }
}
