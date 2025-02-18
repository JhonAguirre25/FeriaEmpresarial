import java.util.ArrayList;

public class Stand {
    private String id;
    private String ubicacion;
    private String tamaño;
    private String empresa;
    private ArrayList<Comentario> comentarios = new ArrayList<Comentario>(); 


    public Stand (String id, String ubicacion, String tamaño){
        this.id = id;
        this.ubicacion = ubicacion;
        this.tamaño = tamaño;
        this.empresa = "sin asignar";
    } 

    public void setId (String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    public void setUbicacion (String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }
    public void setTamaño (String tamaño) {
        this.tamaño = tamaño;
    }

    public String getTamaño() {
        return tamaño;
    }
    public void setEmpresa (String empresa) {
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setComentario (Comentario comentario) {
        comentarios.add(comentario);
    }
    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }
    public int getPromedio (){
        int calificacionTotal = 0;
        for (Comentario comentario : comentarios) {
            calificacionTotal += comentario.getCalificacion(); 
        } 
        calificacionTotal = calificacionTotal / comentarios.size();
            return calificacionTotal;
    }
    
}
