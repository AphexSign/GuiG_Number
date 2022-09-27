package com.example.guig_number;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.guig_number.mechanics.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GameMenuController {


    // public static int taskNumber = SettingsController.tasker.showNumberTask();
    public static int taskNumber = GlobalVar.tasker.showNumberTask();
    public static Mode myMode = GlobalVar.Mode;
    private int tryCount = GlobalVar.Mode.getTryCount();
    private int totalTries = GlobalVar.Mode.getTryCount();
    private int myTries = 0;
    private int totalScores = 0;
    public static String msg1 = "";
    public static String msg2 = "";
    public static String msg3 = "";
    public static String msg9 = "";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Surrender;

    @FXML
    private Button buttonCheck;

    @FXML
    private Label labelCondition;

    @FXML
    private Label labelTry;

    @FXML
    private Label labelResult2;

    @FXML
    private Label labelAnswer;

    @FXML
    private TextField textField;

    @FXML
    void checkButtonAction(ActionEvent event) {




        try {
            int inputNumber = Integer.parseInt(textField.getText());

            //Подсчет очков здесь
            //(ВсегоПопыток-МоиПопытки)*Сложность(1-4)*Диапазон(10-10000)
            if ((inputNumber == taskNumber)&&tryCount>0) {
                this.myTries++;

                this.totalScores = (int) (((this.totalTries - this.myTries) * GlobalVar.Mode.getDifficult().getValue() * GlobalVar.Mode.getBound() + GlobalVar.Mode.getBound()) / totalTries);
                //Записать все в party
                //Передать все в список к игроку

                Party party = new Party(totalScores, myTries, totalTries, true, GlobalVar.Mode.getDifficult(), GlobalVar.Mode.getRange());
//                System.out.println("Кол-во игроков: "+GlobalVar.playerList.size());
//                System.out.println("Игрок - имя: "+GlobalVar.playerList.get(GlobalVar.selectedPlayerID).getName());
                GlobalVar.playerList.get(GlobalVar.selectedPlayerID).addParty(party);
//                System.out.println("Сколько партий: "+GlobalVar.playerList.get(GlobalVar.selectedPlayerID).getPartyList().size());


                //   System.out.println("Количество партий:"+MainMenuController.player.getPartyList().size());

                minusTry(event);
                System.out.println(this.totalScores);
                labelCondition.setText("Верно");
                labelResult2.setText("Молодец!");

                msg1 = "ВЫ ВЫИГРАЛИ!";
                msg2 = "Ваш игрок " + GlobalVar.playerList.get(GlobalVar.selectedPlayerID).getName() + " набрал " + this.totalScores + " очков!";
                msg3 = "Затратив при этом " + myTries + "/" + totalTries + " попыток.";

                resetGame();

                final Node source = (Node) event.getSource();
                final Stage stage2 = (Stage) source.getScene().getWindow();
                stage2.close();

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AnotherParty.fxml"));
                Parent root1 = null;
                root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Вы выиграли!");
                stage.setScene(new Scene(root1));
                stage.show();


            } else {
                labelCondition.setText("Не верно");
                //Но данное число или больше или меньше
                if (taskNumber > inputNumber) {
                    labelResult2.setText("Загаданное число больше, чем введенное!");

                } else {
                    labelResult2.setText("Загаданное число меньше, чем введенное!");
                }
                this.myTries++;
                minusTry(event);
            }

        } catch (Exception e) {
            labelCondition.setText("----");
            labelResult2.setText("Введите числовое значение!");
        }
    }

    @FXML
    void surrenderButtonAction(ActionEvent event) {

        labelAnswer.setText("Загаданное число: " + GlobalVar.tasker.showNumberTask());
        System.out.println("Глоб.текущий режим: " + GlobalVar.Mode);
    }

    private void minusTry(ActionEvent event) {

        //Подсчет очков здесь
        //(ВсегоПопыток-МоиПопытки)*Сложность(1-4)*Диапазон(10-10000)
        //  if (tryCount <= 1)
        int inputNumber = Integer.parseInt(textField.getText());
        if ((myTries>totalTries-1)&&(inputNumber != taskNumber)) {

            //Вызвать, что проиграл
            msg1 = "ВЫ ПРОИГРАЛИ!";
            msg2 = "Ваш игрок " + GlobalVar.playerList.get(GlobalVar.selectedPlayerID).getName() + " набрал " + this.totalScores + " очков!";
            msg3 = "Затратив при этом " + totalTries + "/" + totalTries + " попыток.";
            msg9 = "Число было: " + GlobalVar.tasker.showNumberTask();

            //Записать все в party
            //Передать все в список к игроку
            Party party = new Party(totalScores, myTries, totalTries, false, GlobalVar.Mode.getDifficult(), GlobalVar.Mode.getRange());
            GlobalVar.playerList.get(GlobalVar.selectedPlayerID).addParty(party);


            final Node source = (Node) event.getSource();
            final Stage stage2 = (Stage) source.getScene().getWindow();
            stage2.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AnotherParty.fxml"));
            Parent root1 = null;

            try {
                root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Вы выиграли!");
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        tryCount--;
        this.labelTry.setText(Integer.toString(tryCount));
    }


    public void resetGame() {

        //   this.tryCount = this.myMode.getTryCount();
        this.tryCount = GlobalVar.Mode.getTryCount();
        Tasker resetTasker = GlobalVar.tasker;

        this.myTries = 0;
        labelTry.setText(Integer.toString(this.myMode.getTryCount()));
        msg9 = "";
    }

    @FXML
    void initialize() {

        taskNumber = GlobalVar.tasker.showNumberTask();
        Mode myMode = GlobalVar.Mode;
        tryCount = GlobalVar.Mode.getTryCount();
        totalTries = GlobalVar.Mode.getTryCount();

        this.labelTry.setText(Integer.toString(tryCount));
        textField.setText("");

    }

}