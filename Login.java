import java.util.HashMap;
import java.util.Map;

public class Login{
    private Map<String, String> usuarios;

    public Login(){
        usuarios = new HashMap<>();
        usuarios.put("Equipo2","videojuegos");
    }
    public boolean autenticar(String usuario, String contraseña){
        return usuarios.containsKey(usuario) && usuarios.get(usuario).equals(contraseña);
    }
}