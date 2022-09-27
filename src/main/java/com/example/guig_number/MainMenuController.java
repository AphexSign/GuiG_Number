package com.example.guig_number;

import com.example.guig_number.mechanics.GlobalVar;
import com.example.guig_number.mechanics.Party;
import com.example.guig_number.mechanics.Player;
import javafx.application.Platform;
import javafx.beans.value.ObservableStringValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    public Player player;

    @FXML
    private Label labelExcep;

    @FXML
    private Label welcomeText;

    @FXML
    private ListView<String> listView;

    @FXML
    private TextField textField;

    @FXML
    protected void gameButtonAction(ActionEvent ev) {
        int selectedId = listView.getSelectionModel().getSelectedIndex();

        if (selectedId < 0 && listView.getItems().size() > 0) {
            //Динамическая подмена lable
            Platform.runLater(() -> labelExcep.setText("Выберите из списка игрока!"));
        }

        if (listView.getItems().size() > 0 && selectedId >= 0) {

            try {
                GlobalVar.selectedPlayerID=selectedId;
                player = GlobalVar.playerList.get(selectedId);

                System.out.println("Игрок с именем: " + player.getName());

                //Закрыть старое окно
                final Node source = (Node) ev.getSource();
                final Stage stage2 = (Stage) source.getScene().getWindow();
                stage2.close();

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SettingsMenu.fxml"));
                Parent root1 = null;
                root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Settings Menu");
                stage.setScene(new Scene(root1));
                stage.show();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            labelExcep.setText("Добавьте игрока");
        }

    }

    public void onHofButtonClick(ActionEvent actionEvent) {
        System.out.println("Зал славы");
    }



    public void onMyProgButtonClick(ActionEvent actionEvent) {

        int selectedId = listView.getSelectionModel().getSelectedIndex();

        if (selectedId < 0 && listView.getItems().size() > 0) {
            //Динамическая подмена lable
            Platform.runLater(() -> labelExcep.setText("Выберите из списка игрока!"));
        }

        if (listView.getItems().size() > 0 && selectedId >= 0) {

            try {
                GlobalVar.selectedPlayerID=selectedId;
                player = GlobalVar.playerList.get(selectedId);

                System.out.println("Игрок с именем: " + player.getName());

                //Закрыть старое окно
                final Node source = (Node) actionEvent.getSource();
                final Stage stage2 = (Stage) source.getScene().getWindow();
                stage2.close();

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MyProgress.fxml"));
                Parent root1 = null;
                root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Settings Menu");
                stage.setScene(new Scene(root1));
                stage.show();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            labelExcep.setText("Добавьте игрока");
        }


    }

    public void onQuitButtonClick(ActionEvent actionEvent) {
        System.exit(0);
    }

    @FXML
    void addPlayerButtonClick(ActionEvent event) {
        Player player = new Player();
        player.setName(textField.getText());
        listView.getItems().add(player.getName());
        //Запись в глобальную коллекцию
        GlobalVar.playerList.add(player);

    }

    @FXML
    void removePlayerButtonClick(ActionEvent event) {
        int selectedId = listView.getSelectionModel().getSelectedIndex();
        listView.getItems().remove(selectedId);
        GlobalVar.playerList.remove(selectedId);
    }

    @FXML
    void initialize() {
        //Если у нас есть что-то в коллекции, то выводим в список
        for (Player player : GlobalVar.playerList) {
            listView.getItems().add(player.getName());
        }

    }


}