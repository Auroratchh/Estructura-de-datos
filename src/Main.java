import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaTareas lista = new ListaTareas();
        int opcion;

        System.out.println("\nLISTA DE TAREAS\n");

        do {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarTareaNueva(scanner, lista);
                    break;
                case 2:
                    marcarTareaCompletada(scanner, lista);
                    break;
                case 3:
                    lista.mostrarPendientes();
                    break;
                case 4:
                    buscarTarea(scanner, lista);
                    break;
                case 5:
                    lista.mostrarAltaPrioridad();
                    break;
                case 6:
                    lista.mostrarTodas();
                    break;
                case 0:
                    System.out.println("\n¡Adiós!\n");
                    break;
                default:
                    System.out.println("\nOpción inválida. Intenta de nuevo.\n");
            }

            if (opcion != 0) {
                System.out.println("\nPresiona Enter para continuar");
                scanner.nextLine();
            }

        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {

        System.out.println("           MENÚ PRINCIPAL            ");
        System.out.println(" 1. Agregar tarea nueva              ");
        System.out.println(" 2. Marcar tarea como completada     ");
        System.out.println(" 3. Mostrar tareas pendientes        ");
        System.out.println(" 4. Buscar tarea por descripción     ");
        System.out.println(" 5. Mostrar tareas de alta prioridad ");
        System.out.println(" 6. Mostrar todas las tareas         ");
        System.out.println(" 0. Salir                            ");
    }

    private static void agregarTareaNueva(Scanner scanner, ListaTareas lista) {
        System.out.println("\nAGREGAR NUEVA TAREA");
        System.out.print("Descripción de la tarea: ");
        String descripcion = scanner.nextLine();

        System.out.print("Prioridad (alta/media/baja): ");
        String prioridad = scanner.nextLine();

        Tarea nuevaTarea = new Tarea(descripcion, prioridad);
        lista.agregarTarea(nuevaTarea);
    }

    private static void marcarTareaCompletada(Scanner scanner, ListaTareas lista) {
        System.out.println("\nMARCAR TAREA COMO COMPLETADA");
        System.out.print("Descripción de la tarea a completar: ");
        String descripcion = scanner.nextLine();
        lista.marcarCompletada(descripcion);
    }

    private static void buscarTarea(Scanner scanner, ListaTareas lista) {
        System.out.print("\nIngresa término de búsqueda: ");
        String termino = scanner.nextLine();
        lista.buscarPorDescripcion(termino);
    }}