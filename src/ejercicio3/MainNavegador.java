package ejercicio3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainNavegador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HistorialNavegacion historial = new HistorialNavegacion();
        int opcion;

        System.out.println("\nHISTORIAL DE NAVEGACIÓN\n");

        do {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarPagina(scanner, historial);
                    break;
                case 2:
                    historial.navegarAtras();
                    break;
                case 3:
                    historial.navegarAdelante();
                    break;
                case 4:
                    historial.mostrarHistorial();
                    break;
                case 5:
                    buscarEnHistorial(scanner, historial);
                    break;
                case 6:
                    historial.limpiarHistorial();
                    break;
                case 0:
                    System.out.println("\n¡Adiós!\n");
                    break;
                default:
                    System.out.println("\nOpción inválida.\n");
            }

            if (opcion != 0) {
                System.out.println("\nPresiona Enter para continuar");
                scanner.nextLine();
            }

        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n       MENÚ PRINCIPAL           ");
        System.out.println(" 1. Agregar página visitada      ");
        System.out.println(" 2. Navegar hacia atrás          ");
        System.out.println(" 3. Navegar hacia adelante       ");
        System.out.println(" 4. Mostrar historial completo   ");
        System.out.println(" 5. Buscar página en historial   ");
        System.out.println(" 6. Limpiar historial            ");
        System.out.println(" 0. Salir                        ");
    }

    private static void agregarPagina(Scanner scanner, HistorialNavegacion historial) {
        System.out.println("\nAGREGAR PÁGINA");
        System.out.print("URL: ");
        String url = scanner.nextLine();

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        String fechaVisita = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

        historial.agregarPagina(url, titulo, fechaVisita);
    }

    private static void buscarEnHistorial(Scanner scanner, HistorialNavegacion historial) {
        System.out.print("\nIngresa término de búsqueda: ");
        String termino = scanner.nextLine();
        historial.buscarPagina(termino);
    }
}
