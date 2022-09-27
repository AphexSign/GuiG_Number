package com.example.guig_number;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.guig_number.mechanics.GlobalVar;
import com.example.guig_number.mechanics.Party;
import com.example.guig_number.mechanics.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class MyProgressController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea textArea;


    @FXML
    private Button buttonExit;

    @FXML
    void buttonExitClick(ActionEvent event) {

        final Node source = (Node) event.getSource();
        final Stage stage2 = (Stage) source.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Угадайка v0.01");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }



    @FXML
    void initialize() {

        String str="Игрок "+ GlobalVar.playerList.get(GlobalVar.selectedPlayerID).getName()
                +". Его партии:";

        String str2="";
        for(Party party:GlobalVar.playerList.get(GlobalVar.selectedPlayerID).getPartyList()){
            str2=str2+"\n"+party.toString();
        }
        str+=str2;

    textArea.setText(str);


    }

}
