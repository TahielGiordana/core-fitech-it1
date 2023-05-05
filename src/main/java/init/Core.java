package init;

import interfaces.Observable;
import interfaces.Observer;
import interfaces.Validator;
import services.ValidatorFinder;
import services.ValidatorSequence;

import java.util.HashSet;
import java.util.Set;

public class Core implements Observable {

    private HashSet<Observer> observers;
    private final Validator validatorSequence;
    private boolean validationResult;

    public Core(String path){
        ValidatorFinder validatorFinder = new ValidatorFinder();
        Set<Validator> validators = validatorFinder.findValidators(path);
        this.validatorSequence = new ValidatorSequence(validators);
        this.validationResult = false;
    }

    public void validate(String userName, String machineCode){
        System.out.println("inicio con datos: "+ userName + "- maquina - " + machineCode);
        this.validationResult = this.validatorSequence.validate(userName, machineCode);
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