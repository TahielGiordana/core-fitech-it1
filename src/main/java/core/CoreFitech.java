package core;

import interfaces.Observable;
import interfaces.Observer;
import interfaces.Validator;
import services.ValidationTask;
import services.ValidatorFactory;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CoreFitech  implements Observable, Observer{
    private final ValidationTask validationTask;
    private final Set<Observer> observers = new HashSet<>();
    private Map<String,Boolean> validationResult;

    public CoreFitech(String path, String machineCode) throws FileNotFoundException {
        this.validationResult = new HashMap<>();
        System.out.println("\u001B[31mCuando se inicia el Core isValid es: "+validationResult+"\u001B[0m");
        this.validationTask = new ValidatorFactory().create(path);
        for(Validator validator : validationTask.getValidators()){
            if(Observable.class.isAssignableFrom(validator.getClass())){
                validator.addObserver(this);
            }
        }
        this.validationTask.setMachineCode(machineCode);
    }

    public void processRequest(String userName){
        validationResult = new HashMap<>();
        validationTask.validate(userName);
    }

    public Map<String,Boolean> getResult(){
        return this.validationResult;
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

    public Set<Validator> getValidators(){
        return validationTask.getValidators();
    }

    @Override
    public void update() {
        Set<Validator> validators = validationTask.getValidators();
        Map<String,Boolean> result = new HashMap<>();
        for(Validator validator : validators){
            if(!validator.getResult()){
                System.out.println("Falló el " + validator.getClass().getName());
            }else{
                System.out.println("Pasó el " + validator.getClass().getName());
            }
            result.put(validator.getClass().getName(),validator.getResult());
        }
        System.out.println("\u001B[31mEl resultado de Core era "+ validationResult + "y ahora es "+ result +"\u001B[0m");

        if(validationResult.isEmpty() || !validationResult.equals(result)){
            validationResult = result;
            System.out.println("\u001B[31mAsi que notifico a la UI\u001B[0m");
            notifyObservers();
        }
    }
}