package core;

import interfaces.Observable;
import interfaces.Observer;
import interfaces.Validator;
import services.ValidationTask;
import services.ValidatorFactory;
import services.score.ScoreTask;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CoreFitech{
    private final ValidationTask validationTask;
    private final ScoreTask scoreTask;

    public CoreFitech(String validatorsPath, String machineCode, String scoresPath) throws FileNotFoundException {
        ValidatorFactory validatorFactory = new ValidatorFactory(validatorsPath, machineCode);
        this.validationTask = validatorFactory.buildValidationTask();
        this.scoreTask = new ScoreTask(scoresPath);
    }

    public ValidationTask getValidationTask() {
        return this.validationTask;
    }

    public ScoreTask getScoreTask(){
        return this.scoreTask;
    }
}