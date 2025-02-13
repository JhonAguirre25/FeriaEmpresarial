public class Comentario {
    private String nombre;
    private String fecha;
    private int calificacion;
    
    public Comentario(String nombre,String fecha,int calificacion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.calificacion = calificacion; 
    }
    
    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setFecha (String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }
    public void setCalificacion (int calificacion) {
        this.calificacion = calificacion;
    }

    public int getCalificacion() {
        return calificacion;
    }



}
