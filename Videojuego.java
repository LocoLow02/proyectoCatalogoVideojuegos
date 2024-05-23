public abstract class Videojuego {
    private static int IDCounter = 1;
    private int ID;
    private String titulo;
    private String clasificacion;
    private int añoLanzamiento;
    private String plataforma;
    private double precio;

    public Videojuego(int ID, String titulo, String clasificacion, int añoLanzamiento, String plataforma,
            double precio) {
        this.ID = IDCounter++;
        this.titulo = titulo;
        this.clasificacion = clasificacion;
        this.añoLanzamiento = añoLanzamiento;
        this.plataforma = plataforma;
        this.precio = precio;

    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public int getAñoLanzamiento() {
        return añoLanzamiento;
    }

    public void setAñoLanzamiento(int añoLanzamiento) {
        this.añoLanzamiento = añoLanzamiento;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Videojuego [ID=" + ID + ", titulo=" + titulo + ", clasificacion=" + clasificacion + ", añoLanzamiento="
                + añoLanzamiento + ", plataforma=" + plataforma + ", precio=" + precio + "]";
    }
}