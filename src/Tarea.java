class Tarea {
    private String descripcion;
    private String prioridad;
    private boolean completada;

    public Tarea(String descripcion, String prioridad) {
        this.descripcion = descripcion;
        this.prioridad = prioridad.toLowerCase();
        this.completada = false;
    }

    public void marcarCompletada() {
        this.completada = true;
    }

    public int getPrioridadNumerica() {
        switch (prioridad) {
            case "alta": return 1;
            case "media": return 2;
            case "baja": return 3;
            default: return 4;
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public boolean isCompletada() {
        return completada;
    }

    @Override
    public String toString() {
        String estado = completada ? "[✓]" : "[ ]";
        return estado + " " + descripcion + " (Prioridad: " + prioridad + ")";
    }
}