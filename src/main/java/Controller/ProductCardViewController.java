package Controller;

import Exceptions.StorifyExceptions;

import Models.Producto.Producto;
import Models.Storify;
import Utils.ModelFactoryController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class ProductCardViewController {

    ModelFactoryController modelFactoryController;

    @FXML
    private ImageView image;

    @FXML
    private VBox contentImage;

    @FXML
    private Text nombreProducto;

    @FXML
    private Text descripcion;

    @FXML
    private Text precio;


    @FXML
    private Text codProducto;


    @FXML
    private HBox idProducto;

    @FXML
    private Button btnFavoritos;

    Storify storify = ModelFactoryController.getInstance().getStorify();

    @FXML
    void initialize() throws IOException, StorifyExceptions {
        modelFactoryController = ModelFactoryController.getInstance();
        idProducto.setId(""+modelFactoryController.getCurrentProduct().getCodproducto());
//        if (modelFactoryController.isArtist.getValue()) {
//            setArtist();
//        } else {
//            setSong();
//        }
        setProducto();
    }

//    private void setArtist() {
//        Artist artist = modelFactoryController.getCurrentArtist();
//        nameSong.setText("Nombre: " + artist.getName());
//        image.setImage(new Image("file:" + "src/main/resources/imagenes/icono.png"));
//        nameAlbum.setText("Nacionalidad: " + artist.getNationality());
//        if (artist.isGroup()) {
//            genre.setText("El artista pertenece a un grupo.");
//        } else {
//            genre.setText("El artista no pertenece a un grupo.");
//        }
//        anio.setOpacity(0);
//        duration.setOpacity(0);
//    }

    private void setProducto() {
        Producto product = modelFactoryController.getCurrentProduct();
        nombreProducto.setText(product.getNombre());
        String path = "file:" + "src/main/resources/imagenes/caratulas/producto.png";
        Image image1 = new Image(path);
        image.setImage(image1);
        descripcion.setText("Codigo: " + product.getDescripcion());
        precio.setText("Precio: " + product.getPrecio() + "");
        codProducto.setText("Codigo del producto: " + product.getCodproducto() + "");
//
//        if(modelFactoryController.sectionCurrent.equals("Favoritos")) {
//            btnFavoritos.setText("Eliminar");
//        }
    }

    public void playSong() throws Exception {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("videoPage-view.fxml"));
//        Parent root = loader.load();
//        VideoPageController controller = loader.getController();
//
//        for (Song song : storify.getSongs()) {
//            songsUserList.add(song);
//        }
//
//        String url = songsUserList.searchVideo(idSong.getId());
//        searchArtistByIdSong(idSong.getId());
//
//        controller.initializeWithUrl(url);
//        Scene scene = new Scene(root);
//        getStage.stage.setScene(scene);
//        getStage.stage.show();
    }

    @FXML
    public void addFavorites() throws Exception {
//        for (Song song : storify.getSongs()) {
//            songsUserList.add(song);
//        }
//        ObservableList<Song> songs = modelFactoryController.getFavoriteSongs();
//        if(btnFavoritos.getText().equals("Eliminar")) {
//            deleteFavorite(songs);
//            Parent hboxParent = idSong.getParent();
//            while (hboxParent != null && !(hboxParent instanceof Pane)) {
//                hboxParent = hboxParent.getParent();
//            }
//            if (hboxParent instanceof Pane) {
//                ((Pane) hboxParent).getChildren().remove(idSong);
//            }
//        } else {
//            addFavorite(songs);
//        }
    }

//    private void deleteFavorite(ObservableList<Song> songs ) throws UserExceptions, IOException {
//        for (Song songCurrent : songs) {
//            if(songCurrent.getId().equals(songsUserList.searchSong(idSong.getId()).getId())) {
//                for (int i = 0; i < modelFactoryController.getFavoriteSongs().size(); i ++) {
//                    if(modelFactoryController.getFavoriteSongs().get(i).getName().
//                            equals(songsUserList.searchSong(idSong.getId()).getName())) {
//                        modelFactoryController.getFavoriteSongs().remove(i);
//                        songsUserList.remove(songsUserList.searchSong(idSong.getId()));
//                    }
//                }
//                Persistence.saveSongUser(modelFactoryController.getFavoriteSongs());
//                CustomAlert.showMessage("¡Notificación!", "¡Hecho!",
//                        "La canción ya no pertenece a tu lista de favoritos.", Alert.AlertType.INFORMATION);
//                break;
//            }
//        }
//    }

//    private void addFavorite( ObservableList<Song> songs ) throws UserExceptions, IOException {
//        boolean isValid = true;
//        for (Song song : songs) {
//            if(song.getId().equals(songsUserList.searchSong(idSong.getId()).getId())) {
//                isValid = false;
//                CustomAlert.showMessage("¡Notificación!", "La canción ya pertenece a tu lista de favoritos.",
//                        "Por favor elije otra canción.", Alert.AlertType.WARNING);
//                break;
//            }
//        }
//        if(isValid) {
//            songs.add(songsUserList.searchSong(idSong.getId()));
//            Persistence.saveSongUser(songs);
//            CustomAlert.showMessage("¡Notificación!", "¡Hecho!",
//                    "La canción se ha añadido a tu lista de favoritos.", Alert.AlertType.INFORMATION);
//        }
//    }

//    public void searchArtistByIdSong(String id) throws UserExceptions, IOException {
//
//        modelFactoryController = ModelFactoryController.getInstance();
//
//        ArrayList<Artist> artists = modelFactoryController.getStorify().getArtists();
//
//        SongsUserList songsUserList = new SongsUserList();
//        String nameOfArtist = songsUserList.searchNameArtist(id);
//
//        if ( nameOfArtist != null ) {
//            for ( Artist artist : artists ) {
//                if ( artist.getName().equals(nameOfArtist) ) {
//                    artist.setCounter(artist.getCounter() + 1);
//                }
//            }
//            System.out.println("Se ha sumado un contador al artista: " + nameOfArtist + " con id: " + id );
//        }
//
//        Persistence.saveArtists(storify.getArtists());
//    }

}
