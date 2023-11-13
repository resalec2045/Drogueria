package Utils;

public class CustomAlert {
    public static void showMessage(String title, String header, String content, javafx.scene.control.Alert.AlertType alertType) {
        javafx.scene.control.Alert aler = new javafx.scene.control.Alert(alertType);
        aler.setTitle(title);
        aler.setHeaderText(header);
        aler.setContentText(content);
        aler.showAndWait();
    }

}
