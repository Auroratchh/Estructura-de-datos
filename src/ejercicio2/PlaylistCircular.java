package ejercicio2;

class PlaylistCircular {
    private NodoCancion punteroActual;
    private int tamanio;

    public PlaylistCircular() {
        this.punteroActual = null;
        this.tamanio = 0;
    }

    public void agregarCancion(String titulo, String artista) {
        Cancion nuevaCancion = new Cancion(titulo, artista);
        NodoCancion nuevoNodo = new NodoCancion(nuevaCancion);

        if (punteroActual == null) {
            punteroActual = nuevoNodo;
            nuevoNodo.siguiente = nuevoNodo;
        } else {

            NodoCancion ultimo = punteroActual;
            while (ultimo.siguiente != punteroActual) {
                ultimo = ultimo.siguiente;
            }
            ultimo.siguiente = nuevoNodo;
            nuevoNodo.siguiente = punteroActual;
        }
        tamanio++;
        System.out.println("Canción agregada: " + nuevaCancion);
    }

    public void reproducirSiguiente() {
        if (punteroActual == null) {
            System.out.println("La playlist está vacía");
            return;
        }
        punteroActual = punteroActual.siguiente;
        System.out.println("▶ Reproduciendo: " + punteroActual.cancion);
    }

    public void reproducirAnterior() {
        if (punteroActual == null) {
            System.out.println("La playlist está vacía");
            return;
        }

        NodoCancion anterior = punteroActual;
        while (anterior.siguiente != punteroActual) {
            anterior = anterior.siguiente;
        }
        punteroActual = anterior;
        System.out.println("◀ Reproduciendo: " + punteroActual.cancion);
    }

    public void eliminarCancionActual() {
        if (punteroActual == null) {
            System.out.println("La playlist está vacía");
            return;
        }

        if (tamanio == 1) {
            System.out.println("Canción eliminada: " + punteroActual.cancion);
            punteroActual = null;
            tamanio = 0;
            return;
        }

        NodoCancion anterior = punteroActual;
        while (anterior.siguiente != punteroActual) {
            anterior = anterior.siguiente;
        }

        System.out.println("Canción eliminada: " + punteroActual.cancion);
        anterior.siguiente = punteroActual.siguiente;
        punteroActual = punteroActual.siguiente;
        tamanio--;
    }

    public void mostrarCancionActual() {
        if (punteroActual == null) {
            System.out.println("La playlist está vacía");
            return;
        }
        System.out.println("Reproduciendo actualmente: " + punteroActual.cancion);
    }

    public void mostrarTodasLasCanciones() {
        if (punteroActual == null) {
            System.out.println("La playlist está vacía");
            return;
        }

        System.out.println("  PLAYLIST COMPLETA (" + tamanio + " canciones)");


        NodoCancion temp = punteroActual;
        int contador = 1;
        do {
            String marcador = (temp == punteroActual) ? " ▶" : "  ";
            System.out.println(marcador + contador + ". " + temp.cancion);
            temp = temp.siguiente;
            contador++;
        } while (temp != punteroActual);

    }

    // Modo aleatorio: reproduce canciones sin repetir hasta agotar todas
    public void modoAleatorio() {
        if (punteroActual == null) {
            System.out.println("La playlist está vacía");
            return;
        }

        System.out.println("\nMODO ALEATORIO ACTIVADO");


        java.util.ArrayList<Cancion> cancionesNoReproducidas = new java.util.ArrayList<>();
        NodoCancion temp = punteroActual;
        do {
            cancionesNoReproducidas.add(temp.cancion);
            temp = temp.siguiente;
        } while (temp != punteroActual);

        java.util.Random random = new java.util.Random();
        int numeroCancion = 1;

        while (!cancionesNoReproducidas.isEmpty()) {
            int indiceAleatorio = random.nextInt(cancionesNoReproducidas.size());
            Cancion cancionAleatoria = cancionesNoReproducidas.get(indiceAleatorio);
            System.out.println(numeroCancion + ". ▶ " + cancionAleatoria);
            cancionesNoReproducidas.remove(indiceAleatorio);
            numeroCancion++;
        }

        System.out.println("\nTodas las canciones reproducidas");
        System.out.println();
    }

    public int getTamanio() {
        return tamanio;
    }
}
