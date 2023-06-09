package services.score;

import java.util.Map;
import services.notification.NotificationTask;

public class ScoreTask {
    private String path;
    private ScoreReader scoreReader;
    private ScoreWriter scoreWriter;
    private NotificationTask notificationTask;
    public ScoreTask(String path){
        this.path = path;
        this.scoreReader = new ScoreReader();
        this.scoreWriter = new ScoreWriter();
        this.notificationTask = new NotificationTask();
    }

    public int getScore(String username){
        return scoreReader.readScoreFromUser(path,username);
    };

    public Map<String,Integer> getAllScores(){
        return scoreReader.readAll(path);
    }

    public void addScore(String username, int score){
        scoreWriter.writeScore(path,username,score);
        int updatedScore = getScore(username);
        notificationTask.start(username,updatedScore);
    }

}
