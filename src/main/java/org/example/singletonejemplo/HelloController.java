package org.example.singletonejemplo;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML private TextField tfUsername;
    @FXML private TextField tfPassword;

    @FXML
    protected void onLogin () {
        String usernameValido = Usuario.getInstance().username;
        String username = tfUsername.getText();

        String passwordValido = Usuario.getInstance().password;
        String password = tfPassword.getText();

        boolean valido = validaciones(usernameValido, username, passwordValido, password);
        if (valido == false) {
            return;
        }

        Usuario.getInstance().rol = "Admin";

        System.out.println(Usuario.getInstance().username);
        System.out.println(Usuario.getInstance().rol);
    }

    private boolean validaciones(String usernameValido, String username, String passwordValido, String password) {
        if (!usernameValido.equals(username)) {
            alerta("Error de validación", "El usuario no coincide.");
            return false;
        }

        if (!passwordValido.equals(password)) {
            alerta("Error de valcación", "La contraseña es incorrecta.");
            return false;
        }

        return true;
    }

    private void alerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}