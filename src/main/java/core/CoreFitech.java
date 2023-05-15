package core;

import interfaces.Observable;
import interfaces.Observer;
import interfaces.Validator;
import services.ValidationTask;
import services.ValidatorFactory;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

public class CoreFitech  implements Observable, Observer{
    private final ValidationTask validationTask;
    private final Set<Observer> observers = new HashSet<>();
    private boolean isValid;

    public CoreFitech(String path, String machineCode) throws FileNotFoundException {
        this.validationTask = new ValidatorFactory().create(path);
        for(Validator validator : validationTask.getValidators()){
            if(Observable.class.isAssignableFrom(validator.getClass())){
                ((Observable) validator).addObserver(this);
            }
        }
        this.validationTask.setMachineCode(machineCode);
    }

    public void processRequest(String userName){
        validationTask.validate(userName);
    }

    public boolean getResult(){
        return this.isValid;
    }

    @Override
    public void addObserver(Observer observer){
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(){
        for(Observer observer : observers){
            observer.update();
        }
    }

    @Override
    public void update() {
        Set<Validator> validators = validationTask.getValidators();
        boolean result = true;
        for(Validator validator : validators){
            if(!validator.getResult()){
                result = false;
            }
        }
        if(isValid!= result){
            isValid = result;
            notifyObservers();
        }
    }
}