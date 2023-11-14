package Controller;
import Exceptions.UserExceptions;
import Models.Artist.Artist;
import Models.Storify;
import Utils.CustomAlert;
import Utils.ModelFactoryController;
import Utils.NavBar;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class AddAritstController {
    @FXML
    private Button btnAddSong;
    @FXML
    private Button btnAddArtist;
    @FXML
    private TextField artistNameField;
    @FXML
    private TextField nationalityNameField;
    @FXML
    private ChoiceBox isGroupChoiceBox;

    Storify storify = ModelFactoryController.getInstance().getStorify();

    String pressedStyle = "-fx-border-color: purple;  -fx-border-width: 2px;  -fx-border-radius: 2px;";

    @FXML
    protected void initialize() {
        isGroupChoiceBox.getItems().add("Yes");
        isGroupChoiceBox.getItems().add("No");
        btnAddArtist.setStyle(pressedStyle);
    }

    @FXML
    public void sendArtist() throws UserExceptions, IOException {
//
//        boolean artistExist = false;
//
//
//        for (Artist artist : storify.getArtists()) {
//
//            if (artist.getName().equalsIgnoreCase(artistNameField.getText())) {
//                artistExist = true;
//                break;
//            }
//
//        }
//
//        if ((!artistNameField.getText().isEmpty() && !artistExist) && !nationalityNameField.getText().isEmpty() && isGroupChoiceBox.getValue() != null) {
//            storify.setArtist(new Artist(generateId(), artistNameField.getText(), nationalityNameField.getText(), isGroupChoiceBox.getValue().equals("Yes"), null));
//
//            Persistence.saveArtists(storify.getArtists());
//
//            cleanFields();
//
//            CustomAlert.showMessage("¡Notificación!", "Muy bien!",
//                    "Se ha guardado el artista. :D", javafx.scene.control.Alert.AlertType.INFORMATION);
//
//        }else if (artistExist){
//            CustomAlert.showMessage("¡Notificación!", "¡Error!",
//                    "El artista ya existe.", javafx.scene.control.Alert.AlertType.WARNING);
//        }
//        else {
//            CustomAlert.showMessage("¡Notificación!", "¡Error!",
//                        "No se ha llenado todos los campos.", javafx.scene.control.Alert.AlertType.WARNING);
//        }

    }
//    public String generateId() {
//        Random random = new Random();
//        Set<Integer> digits = new HashSet<>();
//        while (digits.size() < 3) {
//            digits.add(random.nextInt(10));
//        }
//        StringBuilder id = new StringBuilder();
//        for (Integer digit : digits) {
//            id.append(digit);
//        }
//        return id.toString();
//    }

    public void cleanFields() {
        artistNameField.setText("");
        nationalityNameField.setText("");
    }

    @FXML
    public void navToAddSongs() {
        NavBar navBar = new NavBar();
        navBar.navigateToAddSong();
    }

    @FXML
    public void navToAddArtist() {
        NavBar navBar = new NavBar();
        navBar.navigateToAddArtist();
    }

    @FXML
    public void navToCategoriesFavorites() {
        NavBar navBar = new NavBar();
        navBar.navigateToCategoriesFavorites();
    }

    @FXML
    public void navToLogin() {
        NavBar navBar = new NavBar();
        navBar.navigateToLogin();
    }

}
