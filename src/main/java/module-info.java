module com.example.proyectodrogueria {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    exports com.example.proyectodrogueria.viewcontroller;
    opens com.example.proyectodrogueria.viewcontroller to javafx.fxml;
}