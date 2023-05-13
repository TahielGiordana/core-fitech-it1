package services;

//java
import java.util.HashSet;
import java.util.Set;

//custom imports
import interfaces.Observable;
import interfaces.Observer;
import interfaces.Validator;

public class ValidationObservable implements Observable {

    private final Set<Observer> observers;
    private boolean validationResult;
    private ValidationTask validationTask;

    private String machindeCode;

    public ValidationObservable(Set<Validator> validators, String machineCode) {
        this.observers = new HashSet<>();
        this.validationTask = new ValidationTask(validators);
        this.machindeCode = machineCode;
    }

    public void runValidationTask(String userName){
        boolean result = this.validationTask.validate(userName, this.machindeCode);
        this.validationResult = result;
        notifyObservers();
    }

    public boolean getValidationResult(){
        return this.validationResult;
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        for(Observer observer : observers){
            observer.update();
        }
    }
}
