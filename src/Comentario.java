public class Comentario {
    private String nombre;
    private String fecha;
    private int calificacion;
    private String comentario;
    
    public Comentario(String nombre,String fecha,int calificacion, String comentario) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.calificacion = calificacion; 
        this.comentario = comentario;
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

    public void setComentario (String comentario) {
        this.comentario = comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void imprimirComentario(){
        System.out.println(getNombre() + " " + getFecha() + " ");
        System.out.println("");
        System.out.println(getComentario());
        System.out.println("");
        System.out.println("Calificacion: " + getCalificacion() + " Estrellas.");
        System.out.println("-------");
        
    }

    
}
