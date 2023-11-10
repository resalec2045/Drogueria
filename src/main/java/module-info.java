module com.example.proyectodrogueria {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.proyectodrogueria to javafx.fxml;
    exports com.example.proyectodrogueria;
}