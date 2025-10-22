package ejercicio3;

import java.util.ArrayList;
import java.util.List;

class HistorialNavegacion {
    private List<PaginaWeb> historial;
    private int posicionActual;
    private int maxHistorial;

    public HistorialNavegacion() {
        this.historial = new ArrayList<>();
        this.posicionActual = -1;
        this.maxHistorial = 10;
    }

    public void agregarPagina(String url, String titulo, String fechaVisita) {

        if (posicionActual < historial.size() - 1) {
            historial.subList(posicionActual + 1, historial.size()).clear();
        }

        PaginaWeb pagina = new PaginaWeb(url, titulo, fechaVisita);
        historial.add(pagina);
        posicionActual++;

        if (historial.size() > maxHistorial) {
            historial.remove(0);
            posicionActual--;
        }

        System.out.println("Página agregada: " + titulo);
    }

    public void navegarAtras() {
        if (posicionActual > 0) {
            posicionActual--;
            System.out.println("Navegando a: " + historial.get(posicionActual));
        } else {
            System.out.println("No hay páginas anteriores.");
        }
    }

    public void navegarAdelante() {
        if (posicionActual < historial.size() - 1) {
            posicionActual++;
            System.out.println("Navegando a: " + historial.get(posicionActual));
        } else {
            System.out.println("No hay páginas siguientes.");
        }
    }

    public void mostrarHistorial() {
        System.out.println("\nHISTORIAL DE NAVEGACIÓN");
        if (historial.isEmpty()) {
            System.out.println("El historial está vacío.");
        } else {
            for (int i = 0; i < historial.size(); i++) {
                String marcador = (i == posicionActual) ? " > " : "   ";
                System.out.println(marcador + (i + 1) + ". " + historial.get(i));
            }
        }
    }

    public void buscarPagina(String termino) {
        System.out.println("\nBÚSQUEDA: \"" + termino + "\"");
        boolean encontrado = false;
        for (int i = 0; i < historial.size(); i++) {
            PaginaWeb pagina = historial.get(i);
            if (pagina.getTitulo().toLowerCase().contains(termino.toLowerCase()) ||
                    pagina.getUrl().toLowerCase().contains(termino.toLowerCase())) {
                System.out.println((i + 1) + ". " + pagina);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron resultados.");
        }
    }

    public void limpiarHistorial() {
        historial.clear();
        posicionActual = -1;
        System.out.println("Historial limpio.");
    }

    public PaginaWeb getPaginaActual() {
        if (posicionActual >= 0 && posicionActual < historial.size()) {
            return historial.get(posicionActual);
        }
        return null;
    }
}
