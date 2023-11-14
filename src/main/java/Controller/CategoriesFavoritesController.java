package Controller;

import Models.Storify;
import Utils.ModelFactoryController;
import Utils.NavBar;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class CategoriesFavoritesController {

    ModelFactoryController modelFactoryController;

    @FXML
    private Button btnCategoriesFavorites;

    @FXML
    private Text genderPopularField;

    @FXML
    private Text artistPopularField;

    Storify storify = ModelFactoryController.getInstance().getStorify();

    String pressedStyle = "-fx-border-color: purple;  -fx-border-width: 2px;  -fx-border-radius: 2px;";

    @FXML
    protected void initialize() {
        btnCategoriesFavorites.setStyle(pressedStyle);
//        genderPopular();
//        artistPupular();
    }

    public void genderPopular() {

//        HashMap<String, Integer> generoRecuento = new HashMap<>();
//
//        for (Song song : storify.getSongs()) {
//            String genero = song.getGenre().name();
//
//            if (generoRecuento.containsKey(genero)) {
//                int recuento = generoRecuento.get(genero);
//                generoRecuento.put(genero, recuento + 1);
//            } else {
//                generoRecuento.put(genero, 1);
//            }
//        }
//
//        String generoMasFrecuente = "";
//        int maxRecuento = 0;
//
//        for (String genero : generoRecuento.keySet()) {
//            int recuento = generoRecuento.get(genero);
//
//            if (recuento > maxRecuento) {
//                generoMasFrecuente = genero;
//                maxRecuento = recuento;
//            }
//        }
//
//        genderPopularField.setText(generoMasFrecuente);
    }

    public void artistPupular() {

//        modelFactoryController = ModelFactoryController.getInstance();
//        ArrayList<Artist> artists = modelFactoryController.getStorify().getArtists();
//
//        Artist artistaConMayorContador = artists.get(0);
//
//        for (int i = 1; i < artists.size(); i++) {
//            Artist artistaActual = artists.get(i);
//            if (artistaActual.getCounter() > artistaConMayorContador.getCounter()) {
//                artistaConMayorContador = artistaActual;
//            }
//        }
//
//        artistPopularField.setText(artistaConMayorContador.getName());

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
