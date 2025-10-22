package ejercicio3;

class PaginaWeb {
    private String url;
    private String titulo;
    private String fechaVisita;

    public PaginaWeb(String url, String titulo, String fechaVisita) {
        this.url = url;
        this.titulo = titulo;
        this.fechaVisita = fechaVisita;
    }

    public String getUrl() {
        return url;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFechaVisita() {
        return fechaVisita;
    }

    @Override
    public String toString() {
        return "[" + fechaVisita + "] " + titulo + " - " + url;
    }
}
