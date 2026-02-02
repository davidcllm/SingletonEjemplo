package org.example.singletonejemplo;

public class Usuario {
    public String username, rol, password;
    private static Usuario usuario;
    private Usuario () {
        this.password = "hola123";
    }

    public synchronized static Usuario getInstance() {
        if (usuario == null) {
            usuario = new Usuario();
        }
        return usuario;
    }
}
