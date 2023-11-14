package Controller;
import Exceptions.UserExceptions;
import Models.Storify;
import Utils.ModelFactoryController;
import Utils.NavBar;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class AddSongController {
    @FXML
    private Button btnAddSong;
    @FXML
    private ImageView imageView;
    @FXML
    private TextField imageNameField;
    @FXML
    private TextField namesSong;
    @FXML
    private TextField songNameField;
    @FXML
    private TextField songAnioField;
    @FXML
    private TextField songDurationField;
    @FXML
    private ChoiceBox songGenreField;
    @FXML
    private TextField songUrlField;
    @FXML
    private TextField nameArtist;
    private File selectedFile;

    private Stage stage;

    Storify storify = ModelFactoryController.getInstance().getStorify();

    String pressedStyle = "-fx-border-color: purple;  -fx-border-width: 2px;  -fx-border-radius: 2px;";

//    javafx.scene.image.Image notImage = new Image("file:" + "src/main/resources/imagenes/notImage.png");

    @FXML
    protected void initialize() {
//        ObservableList<Genre> genres = songGenreField.getItems();
//        genres.addAll(Genre.values());
//        btnAddSong.setStyle(pressedStyle);
//        imageView.setImage(notImage);
    }

    @FXML
    private void addImage() {
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.setTitle("Selecciona una imagen");
//        selectedFile = fileChooser.showOpenDialog(stage);
//
//        if (selectedFile != null) {
//            javafx.scene.image.Image image = new Image(selectedFile.toURI().toString());
//            imageView.setImage(image);
//        }
    }

   @FXML
    private void sendSong() throws UserExceptions, IOException {
//
//       confirmationNull();
//
//        if (selectedFile != null) {
//            FileChooser fileChooser = new FileChooser();
//            fileChooser.setTitle("Guardar imagen");
//            File initialDirectory = new File( System.getProperty("user.dir") + "/src/main/resources/imagenes/caratulas");
//            fileChooser.setInitialDirectory(initialDirectory);
//
//            File file = new File( "src/main/resources/imagenes/caratulas" + "/" + imageNameField.getText() + ".png");
//
//            ModelFactoryController modelFactoryController = ModelFactoryController.getInstance();
//            modelFactoryController.getStorify().setArtists(Persistence.loadArtist());
//
//            boolean isValid = false;
//            boolean existSong = false;
//
//            for (Artist artist : modelFactoryController.getStorify().getArtists()) {
//                if (artist.getName().equals(nameArtist.getText())) {
//                isValid = true;
//                    break;
//                } else {
//                    isValid = false;
//
//                }
//            }
//
//            for (Song song : modelFactoryController.getStorify().getSongs()) {
//                if (song.getName().equalsIgnoreCase(namesSong.getText())) {
//                    existSong = true;
//                    break;
//                }
//            }
//
//            if(!isValid) {
//                CustomAlert.showMessage("Notificación", "No existe el artista", null, Alert.AlertType.WARNING);
//            }else if (existSong){
//                CustomAlert.showMessage("¡Notificación!", "¡Error!",
//                        "Ya existe una canción con ese nombre.", Alert.AlertType.ERROR);
//            }
//            else {
//                isValid =  true;
//                storify.getSongs().add(new Song(
//                        generateId(),
//                        namesSong.getText(),
//                        songNameField.getText(),
//                        file,
//                        Integer.parseInt(String.valueOf(songAnioField.getText())),
//                        Double.parseDouble(String.valueOf(songDurationField.getText())),
//                        (Genre) songGenreField.getValue(),
//                        songUrlField.getText(),
//                        nameArtist.getText()
//                ));
//                Persistence.saveSongs(storify.getSongs());
//
//                cleanFields();
//
//                CustomAlert.showMessage("¡Notificación!", "Muy bien!",
//                        "Se ha guardado la canción. :D", Alert.AlertType.INFORMATION);
//
//                Files.copy(selectedFile.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
//
//            }
//
//        }
    }



//    public void cleanFields() {
//        namesSong.setText("");
//        songNameField.setText("");
//        imageNameField.setText("");
//        songAnioField.setText("");
//        songDurationField.setText("");
//        songUrlField.setText("");
//        nameArtist.setText("");
//        imageView.setImage(notImage);
//    }

    //metodo para generar un id aleatorio con 3 cifras
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

//    public void confirmationNull() {
//
//        if(namesSong.getText().isEmpty() || songNameField.getText().isEmpty() || imageNameField.getText().isEmpty() || songAnioField.getText().isEmpty() ||
//                songDurationField.getText().isEmpty() || songUrlField.getText().isEmpty() || nameArtist.getText().isEmpty()){
//            CustomAlert.showMessage("¡Notificación!", "¡Error!",
//                "No se ha llenado todos los campos.", javafx.scene.control.Alert.AlertType.ERROR);
//        }
//
//    }

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
