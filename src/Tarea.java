public class Tarea {

    private static int contador = 1;

    private String descripcion;
    private boolean completada;
    private int id;
    private String prioridad;

    public Tarea(String descripcion, boolean completada, String prioridad) {
        this.descripcion = descripcion;
        this.completada = completada;
        this.prioridad = prioridad;
        this.id = contador;
        contador++;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public int getID() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    public void marcarCompletada() {
        this.completada = true;
    }

    @Override
    public String toString() {
        String completadaCadena = completada ? "[x]" : "[ ]";
        return "Tarea{" +
                "ID=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", completada=" + completadaCadena +
                ", prioridad='" + prioridad + '\'' +
                '}';
    }

}
