import java.util.ArrayList;
import java.util.List;

public class CatalogoVideojuegos{
    private List<Videojuego>videojuegos;

    public CatalogoVideojuegos(){
        videojuegos = new ArrayList<>();
    }
    public void agregarVideojuego(Videojuego videojuego){
        videojuegos.add(videojuego);
    }
    public Videojuego buscarVideojuegoPorTitulo(String titulo){
        for (Videojuego videojuego : videojuegos){
            if(videojuego.getTitulo().equalsIgnoreCase(titulo)){

            }
            return videojuego;
        }
        return null;
    }
    public void eliminarVideojuego(String titulo){
        videojuegos.removeIf(videojuego->videojuego.getTitulo().equalsIgnoreCase(titulo));
    }
    public List<Videojuego>listarVideojuegos(){
        return new ArrayList<>(videojuegos);
    }
    public List<Videojuego>buscaVideojuegosPorGenero(Class<?>genero){
        List<Videojuego> resultado = new ArrayList<>();
        for (Videojuego videojuego : videojuegos){
            if(genero.isInstance(videojuego)){
                resultado.add(videojuego);
            }
        }
        return resultado;
    }
}