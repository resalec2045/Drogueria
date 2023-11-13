package Utils;

import Controller.LoginController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class NavBar {

    Scene scene = null;

    public void navigateToAddSong() {

        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("addSong-view.fxml"));
        try {
            scene = new Scene(fxmlLoader.load(), 1280, 705);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        getStage.stage.setScene(scene);
        getStage.stage.centerOnScreen();
        getStage.stage.show();

    }
    public void navigateToAddArtist() {

        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("addArtist-view.fxml"));
        try {
            scene = new Scene(fxmlLoader.load(), 1280, 705);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        getStage.stage.setScene(scene);
        getStage.stage.centerOnScreen();
        getStage.stage.show();

    }

    public void navigateToCategoriesFavorites() {

        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("categoriesFavorites-view.fxml"));
        try {
            scene = new Scene(fxmlLoader.load(), 1280, 705);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        getStage.stage.setScene(scene);
        getStage.stage.centerOnScreen();
        getStage.stage.show();

    }

    public void navigateToHomePage() {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("homePage-view.fxml"));
        try {
            scene = new Scene(fxmlLoader.load(), 1280, 705);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        getStage.stage.setScene(scene);
        getStage.stage.centerOnScreen();
        getStage.stage.show();
    }

    public void navigateToLogin() {

        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("login-view.fxml"));
        try {
            scene = new Scene(fxmlLoader.load(), 620, 500);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        getStage.stage.setScene(scene);
        getStage.stage.centerOnScreen();
        getStage.stage.show();

    }

}
