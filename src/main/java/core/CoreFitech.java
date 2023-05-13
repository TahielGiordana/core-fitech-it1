package core;

import interfaces.Observable;
import interfaces.Observer;
import services.ValidationTask;
import services.ValidatorFactory;

import java.util.HashSet;
import java.util.Set;

public class CoreFitech  implements Observable{
    private ValidationTask validationTask;
    private final Set<Observer> observers = new HashSet<>();
    private String machineCode;

    private boolean isValid = true;

    public CoreFitech(String path, String machineCode){
        this.validationTask = new ValidatorFactory().create(path);
        this.machineCode = machineCode;
    }

    public void postValidationRequest(String userName){
        this.isValid = validationTask.validate(userName, this.machineCode);
        notifyObservers();
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
}