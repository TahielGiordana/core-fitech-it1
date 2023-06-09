package services;

import interfaces.Observable;
import interfaces.Observer;
import interfaces.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ValidationTask implements Observable, Observer {
    private final Logger log = LogManager.getLogger("ValidationTask");
    private Map<Validator, Boolean> validators;
    private String machineCode;
    private Map<String,Boolean> result;

    public ValidationTask(Set<Validator> validators, String machineCode){
        this.result = new HashMap<>();
        this.validators = new HashMap<>();
        for(Validator validator: validators){
            this.validators.put(validator, true);
        };
        this.machineCode = machineCode;
        this.addAsObserver();
    }

    public void processRequest(String userName) {
        validators.forEach((validator, checked) -> {
            if(checked){
                validator.validate(userName, this.machineCode);
            }
        });
    }

    public void toggleValidatorCheck(String validatorName){
        validators.forEach((validator, checked) -> {
            if(validator.getClass().getName().equals(validatorName)){
                validators.put(validator, !checked);
            }
        });
    }

    public void stopValidationTask(){
        this.result = new HashMap<>();
        validators.forEach((validator, aBoolean) -> {
            validator.stopValidation();
        });
    }

    private void addAsObserver() {
        validators.forEach((validator, aBoolean) -> {
            validator.addObserver(this);
        });
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
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public void notifyObservers(Boolean result) {
        for (Observer observer : observers) {
            observer.update(result);
        }
    }

    @Override
    public void update() {
        Map<String,Boolean> partialResult = new HashMap<>();

        for (Validator validator : this.validators.keySet()) {
            //Verifico si existen validators que no finalizaron su validación
            //Si hay alguno en proceso de validación no realizo el update en la ui
            if(validators.get(validator)){
                if(validator.getResult() == null){
                    return;
                }
                //Si todos los validators tienen su resultado verifico si alguno falló
                else{
                    if (!validator.getResult()) {
                        log.info("Falló el validador: {}", validator.getClass().getName());
                    }else{
                        log.info("Pasó el validador: {}", validator.getClass().getName());
                    }
                    partialResult.put(validator.getClass().getName(), validator.getResult());
                }
            }
        }
        System.out.println("\u001B[31mEl resultado de Core era "+ result + "y ahora es "+ partialResult +"\u001B[0m");
        if(result.isEmpty() || !partialResult.equals(result)){
            result = partialResult;
            System.out.println("\u001B[31mAsi que notifico a la UI\u001B[0m");
            this.notifyObservers();
        }
    }

    @Override
    public void update(Boolean result) {
    }

    public Set<Validator> getValidators(){
        return this.validators.keySet();
    }

    public Map<String,Boolean> getResult(){
        return this.result;
    }
}
