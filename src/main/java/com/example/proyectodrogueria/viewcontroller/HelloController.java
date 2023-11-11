package com.example.proyectodrogueria.viewcontroller;

import com.example.proyectodrogueria.controller.PersonaController;
import com.example.proyectodrogueria.factory.ConnectionFactory;
import com.example.proyectodrogueria.modelo.Persona;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.Connection;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {

        PersonaController personaController = new PersonaController();

        String txt = "";
        for(Persona p: personaController.listarPersonas()){
            txt += p.getNombre() + " " + p.getPrimerApellido() + " " + p.getSegundoApellido() + "\n";
        }

        welcomeText.setText(txt);
    }
}