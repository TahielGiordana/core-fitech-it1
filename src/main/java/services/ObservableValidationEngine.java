package services;

//java
import java.util.HashSet;
import java.util.Set;

//custom imports
import interfaces.Observable;
import interfaces.Observer;
import interfaces.Validator;

public class ObservableValidationEngine implements Observable {

    private final Set<Observer> observers;
    private boolean validationResult;
    private ValidationTask validationTask;

    public ObservableValidationEngine(Set<Validator> validators) {
        this.observers = new HashSet<>();
        this.validationResult = true;
        this.validationTask = new ValidationTask(validators);
    }

    public void runValidationTask(String userName, String machineCode){
        boolean result = this.validationTask.validate(userName, machineCode);
        if(result != validationResult){
            this.validationResult = result;
            notifyObservers();
        }
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
