import java.util.ArrayList;
import java.util.List;

class ListaTareas {
    private List<Tarea> tareas;

    public ListaTareas() {
        this.tareas = new ArrayList<>();
    }


    public void agregarTarea(Tarea tarea) {
        
        int posicion = 0;
        for (int i = 0; i < tareas.size(); i++) {
            if (tareas.get(i).getPrioridadNumerica() > tarea.getPrioridadNumerica()) {
                posicion = i;
                break;
            }
            posicion = i + 1;
        }
        tareas.add(posicion, tarea);
        System.out.println("Tarea agregada: " + tarea.getDescripcion());
    }


    public boolean marcarCompletada(String descripcion) {
        for (Tarea t : tareas) {
            if (t.getDescripcion().equalsIgnoreCase(descripcion)) {
                t.marcarCompletada();
                System.out.println("Tarea completada: " + descripcion);
                return true;
            }
        }
        System.out.println("No se encontró la tarea: " + descripcion);
        return false;
    }

    public void mostrarPendientes() {
        System.out.println("\n=== TAREAS PENDIENTES ===");
        boolean hayPendientes = false;
        for (Tarea t : tareas) {
            if (!t.isCompletada()) {
                System.out.println(t);
                hayPendientes = true;
            }
        }
        if (!hayPendientes) {
            System.out.println("No hay tareas pendientes.");
        }

    }


    public List<Tarea> buscarPorDescripcion(String descripcion) {
        List<Tarea> resultados = new ArrayList<>();
        System.out.println("\n=== BÚSQUEDA: \"" + descripcion + "\" ===");
        for (Tarea t : tareas) {
            if (t.getDescripcion().toLowerCase().contains(descripcion.toLowerCase())) {
                resultados.add(t);
                System.out.println(t);
            }
        }
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron tareas.");
        }

        return resultados;
    }


    public void mostrarAltaPrioridad() {
        System.out.println("\nTAREAS DE ALTA PRIORIDAD");
        boolean hayAlta = false;
        for (Tarea t : tareas) {
            if (t.getPrioridad().equals("alta") && !t.isCompletada()) {
                System.out.println(t);
                hayAlta = true;
            }
        }
        if (!hayAlta) {
            System.out.println("No hay tareas de alta prioridad pendientes.");
        }

    }

    public void mostrarTodas() {
        System.out.println("\nTODAS LAS TAREAS");
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas registradas.");
        } else {
            for (Tarea t : tareas) {
                System.out.println(t);
            }
        }

    }
}