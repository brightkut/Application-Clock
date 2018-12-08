package Controller;


import Model.Clock;
import Model.Exercise;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;


public class Controller implements Initializable{

    @FXML
    private Label nowTime;
    @FXML
    private Button timeWake;

    @FXML
    private Label timeState;
    @FXML
    private TextField hourWake;
    @FXML
    private TextField minuteWake;

    @FXML
    private Label t;
    @FXML
    private Label t2;
    @FXML
    private Label t3;
    @FXML
    private Label colon;
    @FXML
    private Label colon2;
    @FXML
    private Label colon3;
    @FXML
    private Label colon4;

    @FXML
    private Label ex1;
    @FXML
    private Label ex2;
    @FXML
    private Label ex3;
    @FXML
    private Label ex4;
    @FXML
    private Label ex5;
    @FXML
    private TextField ex6;
    @FXML
    private Button ex7;
    @FXML
    private Button ex8;
    MediaPlayer mediaPlayer;


    private Stage primaryStage;
    private boolean state ;
    //timeline
    private Timeline timeline;

    private int hour;
    private   int minute;
    private int second;


    private String h;
    private String m;
    private String s;
    private Exercise exercise;
    private Clock clock;
    private URL l ;
    private ResourceBundle resourceBundle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hideBefore();
        show();
        l = location;
        resourceBundle = resources;
        clock = null;
        clock = new Clock();

        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);

        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1),
                        new EventHandler<ActionEvent>() {
                            @Override public void handle(ActionEvent event) {
                                    setNowTime();

                            }
                        }));
        timeline.play();


    }

    public void hideBefore(){
        ex1.setVisible(false);
        ex2.setVisible(false);
        ex3.setVisible(false);
        ex4.setVisible(false);
        ex5.setVisible(false);
        ex6.setVisible(false);
        ex7.setVisible(false);
        ex8.setVisible(false);


    }


    public void hide(){
        t.setVisible(false);
        t2.setVisible(false);
        t3.setVisible(false);
        colon.setVisible(false);
        colon2.setVisible(false);
        colon3.setVisible(false);
        colon4.setVisible(false);
        timeState.setVisible(false);
        nowTime.setVisible(false);
        hourWake.setVisible(false);
        minuteWake.setVisible(false);
        timeWake.setVisible(false);

    }
    public void show(){
        t.setVisible(true);
        t2.setVisible(true);
        t3.setVisible(true);
        colon.setVisible(true);
        colon2.setVisible(true);
        colon3.setVisible(true);
        colon4.setVisible(true);
        timeState.setVisible(true);
        nowTime.setVisible(true);
        hourWake.setVisible(true);
        timeWake.setVisible(true);
        minuteWake.setVisible(true);

    }
    public void showAfter(){
        ex1.setVisible(true);
        ex2.setVisible(true);
        ex3.setVisible(true);
        ex4.setVisible(true);
        ex5.setVisible(true);
        ex6.setVisible(true);
        ex7.setVisible(true);
        ex8.setVisible(true);
        ex8.setDisable(true);

    }
    public void setExercise(){
        ex2.setText(Integer.toString(exercise.getValue1()));
        ex3.setText(exercise.getOperator());
        ex4.setText(Integer.toString(exercise.getValue2()));
    }










    public void setNowTime()  {
        Calendar currentTime = Calendar.getInstance();
        hour = currentTime.get(Calendar.HOUR_OF_DAY);
        minute= currentTime.get(Calendar.MINUTE);
        second = currentTime.get(Calendar.SECOND);
        h = Integer.toString(hour);
        m = Integer.toString(minute);
        s = Integer.toString(second);

        if (clock.getSetH()==hour && clock.getSetM()==minute){
            timeState.setText("ปลุก !!!");
            timeline.stop();
            hide();
            showAfter();
            exercise = null;
            exercise = new Exercise();
            setExercise();
            playMusic();
        }

        if (hour<10){
            h = "0"+hour;
        }if (minute<10){
            m = "0"+minute;
        }if (second<10){
            s = "0"+second;
        }
        nowTime.setText(h+":"+m+":"+s);
    }

    public void playMusic(){
        String musicFile = "clockAlarm.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
         mediaPlayer  = new MediaPlayer(sound);
        mediaPlayer.play();
    }


    @FXML
    public void sendAnswer(ActionEvent event){
        System.out.println("in");

        if (exercise.calculate(Double.parseDouble(ex6.getText()))){
            System.out.println("true");
            ex1.setText("Exercise: Correct Congratgulation :)");
            ex6.clear();
            ex8.setDisable(false);
            ex7.setDisable(true);
        }else {
            ex1.setText("Exercise: Incorrect Try Again :(");
            ex6.clear();
        }
    }

    @FXML
    public void stopMusic(ActionEvent event){
        mediaPlayer.stop();
        initialize(l,resourceBundle);
        timeState.setText("ยังไม่ได้มีการเเจ้งปลุก");

    }


    @FXML
    public void setTimeWake(ActionEvent e){
        String h1 =hourWake.getText();
        String m1 = minuteWake.getText();

        try {
            clock.setSetH(clock.changeStringToHour(h1));
            clock.setSetM(clock.changeStringToMinute(m1));

        }catch (IllegalArgumentException ex){
            System.out.println(ex);
        }
        timeState.setText("ตั้งนาฬิกาปลุกเวลา " + clock.getHourShow()+":"+clock.getMinuteShow());
        hourWake.clear();
        minuteWake.clear();

    }


}

