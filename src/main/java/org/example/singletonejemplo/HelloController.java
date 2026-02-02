package org.example.singletonejemplo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML private TextField tfUsername;
    @FXML private TextField tfPassword;

    @FXML
    protected void onLogin () {
        String usernameValido = Usuario.getInstance().username;
        String username = tfUsername.getText();

        String passwordValido = Usuario.getInstance().password;
        String password = tfPassword.getText();

        if (!validaciones(usernameValido, username, passwordValido, password)) {
            return;
        }

        Usuario.getInstance().rol = "Admin";

        // Cambiar ventana
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("perfil-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage newStage = new Stage();
            newStage.setTitle("Perfil de: " + Usuario.getInstance().username);
            newStage.setScene(scene);

            newStage.show();
            
        } catch (IOException e) {
            alerta("Error", "No se pudo cargar la vista de perfil.");
            e.printStackTrace();
        }
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