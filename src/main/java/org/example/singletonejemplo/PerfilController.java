package org.example.singletonejemplo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PerfilController {
    @FXML private Label lblUsername;
    @FXML private Label lblRol;

    @FXML
    public void initialize() {
        Usuario user = Usuario.getInstance();

        lblUsername.setText("Bienvenido: " + user.username);
        lblRol.setText("Tu rol es: " + user.rol);
    }
}
