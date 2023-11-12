package com.example.proyectodrogueria.viewcontroller;
import com.example.proyectodrogueria.controller.PersonaController;
import com.example.proyectodrogueria.dao.PersonaDao;
import com.example.proyectodrogueria.modelo.Persona;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginViewController {

    @FXML
    private TextField fieldUserName;

    @FXML
    private TextField fieldPassword;

    PersonaController personaController = new PersonaController();

    @FXML
    protected void login() throws IOException {

        Persona persona = personaController.verificarLogin(fieldUserName.getText(), fieldPassword.getText());

        System.out.println(persona);
    }
}
