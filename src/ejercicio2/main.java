package ejercicio2;

public class main {
    public static void main(String[] args) {
        PlaylistCircular playlist = new PlaylistCircular();
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("\nPLAYLIST MUSICAL CIRCULAR\n");
        playlist.agregarCancion("Good Luck, Babe!", "Chappell Roan");
        playlist.agregarCancion("Manchild", "Sabrina Carpenter");
        playlist.agregarCancion("My Man On Willpower", "Sabrina Carpenter");
        playlist.agregarCancion("Tarde", "Siddhartha");
        playlist.agregarCancion("Azul", "Zoé");

        boolean continuar = true;

        while (continuar) {

            System.out.println("   \nPLAYLIST MUSICAL CIRCULAR\n        ");
            System.out.println("1. Agregar canción");
            System.out.println("2. Reproducir siguiente");
            System.out.println("3. Reproducir anterior");
            System.out.println("4. Eliminar canción actual");
            System.out.println("5. Mostrar canción actual");
            System.out.println("6. Mostrar todas las canciones");
            System.out.println("7. Modo aleatorio");
            System.out.println("8. Salir");
            System.out.print("\nSelecciona una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Artista: ");
                    String artista = scanner.nextLine();
                    playlist.agregarCancion(titulo, artista);
                    break;
                case 2:
                    playlist.reproducirSiguiente();
                    break;
                case 3:
                    playlist.reproducirAnterior();
                    break;
                case 4:
                    playlist.eliminarCancionActual();
                    break;
                case 5:
                    playlist.mostrarCancionActual();
                    break;
                case 6:
                    playlist.mostrarTodasLasCanciones();
                    break;
                case 7:
                    playlist.modoAleatorio();
                    break;
                case 8:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

        scanner.close();
    }
}
