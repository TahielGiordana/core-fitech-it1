package services;

//java
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//custom imports
import interfaces.Observable;
import interfaces.Observer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ValidationEngine implements Observable {

    private Logger log = LogManager.getLogger("ValidationEngine");
    private final Set<Observer> observers;
    private Map<String,Boolean> validationResult;
    private final ValidatorClasses validatorClasses;

    public ValidationEngine(ValidatorClasses validatorClasses) {
        this.observers = new HashSet<>();
        this.validatorClasses = validatorClasses;
        this.validationResult = new HashMap<>();
    }

    public void validate(String userName, String machineCode){
        log.info("init metodo validate con datos --> userName: {} - maquina: {}", userName, machineCode);
        Map<String,Boolean> result = this.validatorClasses.validate(userName, machineCode);
        if(result != validationResult){
            this.validationResult = result;
            notifyObservers();
        }
        log.info("Fin método validate");
    }

    public Map<String,Boolean> getValidationResult(){
        return this.validationResult;
    }

    public void addObserver(Observer observer){
        log.info("Se agrega un observer: {}", observer.toString());
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        log.info("notificando observers");
        for(Observer observer : observers){
            observer.update();
        }
    }
}
