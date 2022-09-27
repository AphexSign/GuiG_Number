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
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class SettingsController {

    private Difficulty difficulty=Difficulty.EASY;
    private Range range= com.example.guig_number.mechanics.Range.TEN;
    public static Mode mode;
    public static Tasker tasker;

    public static Party party;

    public Mode getMode(){
        return this.mode;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ToggleGroup Range;

    @FXML
    private Button beginPartyButton;

    @FXML
    private Button buttonCancel;

    @FXML
    private ToggleGroup difficult;

    @FXML
    private RadioButton rButton1, rButton2, rButton3, rButton4, rButton5, rButton6, rButton7, rButton8;

    @FXML
    void beginPartyButtonOnClick(ActionEvent event) {
        System.out.println("Begin new party");
            this.mode=new Mode(this.range,this.difficulty);
            GlobalVar.Mode=new Mode(this.range,this.difficulty);

            this.tasker=new Tasker(this.mode);
            GlobalVar.tasker=new Tasker(GlobalVar.Mode);

            party=new Party(0,0,this.getMode().getTryCount(),false);


        System.out.println(party);
       // System.out.println(GlobalVar.Mode);

        final Node source = (Node) event.getSource();
        final Stage stage2 = (Stage) source.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("GameMenu.fxml"));
        Parent root1= null;
        try {
            root1 = (Parent) fxmlLoader.load();
            Stage stage=new Stage();
            stage.setTitle("Угадайка v0.01");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

    @FXML
    void cancelButtonOnClick(ActionEvent event) {
        System.out.println("Cancel");

        final Node source = (Node) event.getSource();
        final Stage stage2 = (Stage) source.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        Parent root1= null;
        try {
            root1 = (Parent) fxmlLoader.load();
            Stage stage=new Stage();
            stage.setTitle("Угадайка v0.01");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @FXML
    void getDifficulty(ActionEvent event) {
        if(rButton1.isSelected()){
            this.difficulty=Difficulty.EASY;
        }
        if(rButton2.isSelected()){
            this.difficulty=Difficulty.MEDIUM;
        }
        if(rButton3.isSelected()){
            this.difficulty=Difficulty.HARD;
        }
        if(rButton4.isSelected()){
            this.difficulty=Difficulty.IMPOSSIBLE;
        }
    }

    @FXML
    void getRange(ActionEvent event) {

        if(rButton5.isSelected()){
            this.range= com.example.guig_number.mechanics.Range.TEN;
        }
        if(rButton6.isSelected()){
            this.range= com.example.guig_number.mechanics.Range.HUNDRED;
        }
        if(rButton7.isSelected()){
            this.range= com.example.guig_number.mechanics.Range.THOUSAND;
        }
        if(rButton8.isSelected()){
            this.range= com.example.guig_number.mechanics.Range.TENTHOUSAND;
        }


    }

    @FXML
    void initialize() {
//        assert Range != null : "fx:id=\"Range\" was not injected: check your FXML file 'SettingsMenu.fxml'.";
//        assert beginPartyButton != null : "fx:id=\"beginPartyButton\" was not injected: check your FXML file 'SettingsMenu.fxml'.";
//        assert buttonCancel != null : "fx:id=\"buttonCancel\" was not injected: check your FXML file 'SettingsMenu.fxml'.";
//        assert difficult != null : "fx:id=\"difficult\" was not injected: check your FXML file 'SettingsMenu.fxml'.";
//        assert rButton1 != null : "fx:id=\"rButton1\" was not injected: check your FXML file 'SettingsMenu.fxml'.";
//        assert rButton2 != null : "fx:id=\"rButton2\" was not injected: check your FXML file 'SettingsMenu.fxml'.";
//        assert rButton3 != null : "fx:id=\"rButton3\" was not injected: check your FXML file 'SettingsMenu.fxml'.";
//        assert rButton4 != null : "fx:id=\"rButton4\" was not injected: check your FXML file 'SettingsMenu.fxml'.";
//        assert rButton5 != null : "fx:id=\"rButton5\" was not injected: check your FXML file 'SettingsMenu.fxml'.";
//        assert rButton6 != null : "fx:id=\"rButton6\" was not injected: check your FXML file 'SettingsMenu.fxml'.";
//        assert rButton7 != null : "fx:id=\"rButton7\" was not injected: check your FXML file 'SettingsMenu.fxml'.";
//        assert rButton8 != null : "fx:id=\"rButton8\" was not injected: check your FXML file 'SettingsMenu.fxml'.";

    }

}