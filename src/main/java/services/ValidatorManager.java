package services;

import interfaces.Observable;
import interfaces.Observer;

import java.util.HashSet;
import java.util.Set;

public class ValidatorManager implements Observable {
    private Set<Observer> observers;
    private boolean validationResult;
    private String actualUserName;
    private String actualMachineCode;
    private ValidatorClasses validatorClasses;

    public ValidatorManager(ValidatorClasses validatorClasses) {
        this.observers = new HashSet<>();
        this.validatorClasses = validatorClasses;
        this.validationResult = false;
        this.actualUserName = "";
        this.actualMachineCode = "";
    }

    public void validate(String userName, String machineCode){
        System.out.println("inicio con datos: "+ userName + "- maquina - " + machineCode);
        this.actualUserName = userName;
        this.actualMachineCode = machineCode;
        this.validationResult = this.validatorClasses.validate(userName, machineCode);
        notifyObservers();
    }

    public boolean getValidationResult(){
        return this.validationResult;
    }

    public String getActualUserName(){
        return this.actualUserName;
    }

    public String getActualMachineCode(){
        return this.actualMachineCode;
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
