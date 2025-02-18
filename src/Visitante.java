import java.util.ArrayList;

public class Visitante {

    private String nombre;
    private int identicacion;
    private String correo;
    private ArrayList<String> stands = new ArrayList<String>(); 


    public Visitante (String nombre, int identificacion, String correo){

        this.nombre = nombre;
        this.identicacion = identificacion;
        this.correo = correo;
    }

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public void setIdenticacion (int identicacion) {
        this.identicacion = identicacion;
    }

    public int getIdenticacion() {
        return identicacion;
    }
    public void setCorreo (String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }
    public void setStands (String nombre) {
        stands.add(nombre);
    }

    public void getStands() {
        String saveStands = "";
        for (String nombre : stands) {
             saveStands += " " + nombre;
        }
        System.out.println(saveStands);
    }

}
