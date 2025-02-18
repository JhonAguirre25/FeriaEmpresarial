import javax.print.DocFlavor.STRING;

public class Empresa {

    private String nombre;
    private String sector;
    private String email;
    private String stand;

    public Empresa(String nombre, String sector, String email){
        this.nombre = nombre;
        this.sector = sector;
        this.email = email;
        this.stand = "sin asignar";
    }

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public void setSector(String sector)  {
        this.sector = sector;
    }
    public String getSector() {
        return sector;       
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setStand(String stand) {
        this.stand = stand;
    }
    public String getStand() {
        return stand;
    }
    

}


