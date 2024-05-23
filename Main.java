import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Login login = new Login();
        Scanner scanner = new Scanner(System.in);

        boolean autenticado = false;

        while (!autenticado) {
            System.out.print("Usuario: ");
            String usuario = scanner.nextLine();
            System.out.print("Contraseña: ");
            String contrasena = scanner.nextLine();

            if (login.autenticar(usuario, contrasena)) {
                System.out.println("Bienvenido a tu aplicación Catálogo de Videojuegos");
                autenticado = true;
                try {
                    Thread.sleep(5000);
                    clearScreen();
                } catch (InterruptedException e) {
                    System.out.println("Error en la pausa: " + e.getMessage());
                }
            } else {
                System.out.println("Credenciales erróneas. Intente nuevamente.");
                try {
                    Thread.sleep(5000);
                    clearScreen();
                } catch (InterruptedException e) {
                    System.out.println("Error en la pausa: " + e.getMessage());
                }
            }
        }

        CatalogoVideojuegos catalogo = new CatalogoVideojuegos();
        boolean salir = false;

        do {
            System.out.println("\nMenú del Catálogo de Videojuegos:");
            System.out.println("1. Agregar Videojuego");
            System.out.println("2. Mostrar Videojuego");
            System.out.println("3. Actualizar Videojuego");
            System.out.println("4. Eliminar Videojuego");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = 0;
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Opción no válida. Por favor ingrese un número.");
                scanner.nextLine();
                continue;
            }

            try {
                switch (opcion) {
                    case 1:
                    try{
                        System.out.print("ID: ");
                        int ID = scanner.nextInt();
                        System.out.print("Título: ");
                        String titulo = scanner.next();
                        System.out.print("Clasificación: ");
                        String clasificacion = scanner.next();
                        System.out.print("Año de Lanzamiento: ");
                        int anoLanzamiento = scanner.nextInt();
                        System.out.print("Plataforma: ");
                        String plataforma = scanner.next();
                        System.out.print("Precio: ");
                        Double precio = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Seleccione el Género del Videojuego:");
                        System.out.println("1. Aventura");
                        System.out.println("2. Acción");
                        System.out.println("3. RPG");
                        System.out.println("4. Deportes");
                        System.out.println("5. Carreras");
                        System.out.println("6. Disparos");
                        System.out.println("7. Terror");
                        System.out.println("8. Lucha");
                        System.out.print("Seleccione una opción: ");
                        int generoOpcion = scanner.nextInt();
                        Videojuego videojuego;
                            switch (generoOpcion) {
                                case 1: videojuego = new Aventura(ID, titulo, clasificacion, anoLanzamiento, plataforma, precio); break;
                                case 2: videojuego = new Acción(ID, titulo, clasificacion, anoLanzamiento, plataforma, precio); break;
                                case 3: videojuego = new RPG(ID, titulo, clasificacion, anoLanzamiento, plataforma, precio); break;
                                case 4: videojuego = new Deportes(ID, titulo, clasificacion, anoLanzamiento, plataforma, precio); break;
                                case 5: videojuego = new Carreras(ID, titulo, clasificacion, anoLanzamiento, plataforma, precio); break;
                                case 6: videojuego = new Disparos(ID, titulo, clasificacion, anoLanzamiento, plataforma, precio); break;
                                case 7: videojuego = new Terror(ID, titulo, clasificacion, anoLanzamiento, plataforma, precio); break;
                                case 8: videojuego = new Lucha(ID, titulo, clasificacion, anoLanzamiento, plataforma, precio); break;
                                default: throw new IllegalArgumentException("Opción de género no válida.");
                            }
                        catalogo.agregarVideojuego(videojuego);
                        System.out.println("Videojuego agregado.");
                        } catch (IllegalArgumentException e){
                            System.out.println(e.getMessage());
                        } catch (Exception e){
                            System.out.println("Error al agregar videojuego");
                        }
                        scanner.nextLine();
                        break;
                    case 2:
                        System.out.print("Ingrese el título del videojuego a buscar: ");
                        String tituloBusqueda = scanner.nextLine();
                        Videojuego buscado = catalogo.buscarVideojuegoPorTitulo(tituloBusqueda);
                        if (buscado != null) {
                            System.out.println("Videojuego encontrado: " + buscado);
                        } else {
                            System.out.println("Videojuego no encontrado.");
                        }
                        break;
                    case 3:
                        System.out.print("Ingrese el título del videojuego a actualizar: ");
                        String tituloActualizar = scanner.nextLine();
                        Videojuego videojuegoActualizar = catalogo.buscarVideojuegoPorTitulo(tituloActualizar);
                        if (videojuegoActualizar != null) {
                            System.out.print("Nuevo ID: ");
                            int nuevoID = scanner.nextInt();
                            System.out.print("Nuevo Título: ");
                            String nuevoTitulo = scanner.next();
                            System.out.print("Nueva Clasificación: ");
                            String nuevaClasificacion = scanner.next();
                            System.out.print("Nuevo Año de Lanzamiento: ");
                            int nuevoAnoLanzamiento = scanner.nextInt();
                            System.out.print("Nueva Plataforma: ");
                            String nuevaPlataforma = scanner.next();
                            System.out.print("Nuevo Precio: ");
                            Double nuevoPrecio = scanner.nextDouble();
                            scanner.nextLine();
                            videojuegoActualizar.setID(nuevoID);
                            videojuegoActualizar.setTitulo(nuevoTitulo);
                            videojuegoActualizar.setClasificacion(nuevaClasificacion);
                            videojuegoActualizar.setAñoLanzamiento(nuevoAnoLanzamiento);
                            videojuegoActualizar.setPlataforma(nuevaPlataforma);
                            videojuegoActualizar.setPrecio(nuevoPrecio);
                            System.out.println("Videojuego actualizado.");
                        } else {
                            System.out.println("Videojuego no encontrado.");
                        }
                        break;
                    case 4:
                        System.out.print("Ingrese el título del videojuego a eliminar: ");
                        String tituloEliminar = scanner.nextLine();
                        catalogo.eliminarVideojuego(tituloEliminar);
                        System.out.println("Videojuego eliminado.");
                        break;
                    case 5:
                        salir = true;
                        System.out.println("Saliendo del sistema.");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); 
            }
        } while (!salir);

        scanner.close();
    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error al limpiar la pantalla: " + e.getMessage());
        }
    }
}

        
