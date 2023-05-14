package core;

import interfaces.Observable;
import interfaces.Observer;
import services.ValidationTask;
import services.ValidatorFactory;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

public class CoreFitech  implements Observable{
    private final ValidationTask validationTask;
    private final Set<Observer> observers = new HashSet<>();

    private boolean isValid;

    public CoreFitech(String path, String machineCode) throws FileNotFoundException {
        this.validationTask = new ValidatorFactory().create(path);
        this.validationTask.setMachineCode(machineCode);
    }

    public void processRequest(String userName, String opcion){
        this.isValid = validationTask.validationRequest(userName, opcion);
        notifyObservers();
    }

    public int sizeSetValidators(){
        return this.validationTask.size();
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