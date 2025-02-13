import java.util.ArrayList;
import java.util.Scanner;

public class main {

    ArrayList<Empresa> listaEmpresas = new ArrayList<Empresa>();

    public static void main(String[] args) {
        
        Scanner scnr = new Scanner(System.in);
        String option = "";

        while (true) {
            menu();
            option = scnr.nextLine();
            if (option.equals("q")) {
                break;                
            } else if (option.equals("1")) {
                System.out.println("por implementar");
            } else {
                System.out.println("selecciona alguna opcion");
            }
    }

    }
    public static void menu (){
        System.out.println("Elija una opcion");
        System.out.println("1. Registro");
        System.out.println("q. salir");

    }
}
