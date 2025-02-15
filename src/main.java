import java.util.ArrayList;
import java.util.Scanner;

public class main {

    static ArrayList<Empresa> listaEmpresas = new ArrayList<Empresa>();
    static ArrayList<Stand> listaStands = new ArrayList<Stand>();
    static ArrayList<Visitante> listaVisitantes = new ArrayList<Visitante>();

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        String option = "";

        while (true) {
            menu();
            option = scnr.nextLine();
            if (option.equals("q")) {
                break;
            } else if (option.equals("1")) {

                menuRegistro();
                option = scnr.nextLine();
                if (option.equals("1")) {
                    registroEmpresa(scnr);
                } else if (option.equals("2")) {
                    registroVisitante(scnr);
                } else if (option.equals("3")) {
                    continue;
                }

            } else if (option.equals("2")) {
                menuStand();
                option = scnr.nextLine();
                if (option.equals("1")) {
                    mostrarStands();
                } else if (option.equals("2")) {
                    standDisponibles();
                    empresasDisponibles();
                    System.out.println("");
                    System.out.println("Elija un stand ");
                    String stand = scnr.nextLine(); 
                    System.out.println("Elije un empresa");
                    String empresa = scnr.nextLine();
                    for (Stand elemento : listaStands) {
                        if (elemento.getId() == stand)  {
                            elemento.setEmpresa(empresa);
                            break;
                        }
                    } for (Empresa elemento : listaEmpresas) {
                        if (elemento.getNombre() == empresa)  {
                            elemento.setStand(stand);
                            break;
                        }
                    }
                } else if (option.equals("3")) {
                    
                } else if (option.equals("4")) {
                    
                } else if (option.equals("5")) {
                    continue;
                }
            } else if (option.equals("3")) {
                mostrarEmpresas();

            } else if (option.equals("4")) {
                mostrarVisitantes();
            } else if (option.equals("5")) {
                mostrarCalificaciones();
            } else {
                System.out.println("selecciona alguna opcion");
            }

        }

    }

    public static void menu() {
        System.out.println("Elija una opcion");
        System.out.println("1. Registro");
        System.out.println("2. Stands");
        System.out.println("3. Empresas");
        System.out.println("4. visitantes");
        System.out.println("5. Calificaciones");
        System.out.println("q. salir");

    }

    public static void menuRegistro() {
        System.out.println("1. Registrar empresa");
        System.out.println("2. Registrar visitantes");
        System.out.println("3. Regresar al menu principal");
    }

    public static void menuStand() {
        System.out.println("1. Lista de Stand");
        System.out.println("2. Asignar Stand");
        System.out.println("3. Editar Stad");
        System.out.println("4. Eliminar Stand");
        System.out.println("5. Regresar al menu principal");
    }

    public static void registroEmpresa(Scanner scnr) {
        System.out.println("Escribe el nombre de la empresa: ");
        String nombre = scnr.nextLine();
        System.out.println("Escribe el sector de la empresa: ");
        String sector = scnr.nextLine();
        System.out.println("Escribe el correo de la empresa: ");
        String correo = scnr.nextLine();
        System.out.println("Quieres asignarle un stand? : S/N");
        String respuestaStand = scnr.nextLine();

        Empresa empresa1 = new Empresa(nombre, sector, correo);
        if (respuestaStand.equalsIgnoreCase("S")) {
            System.out.println("Que Stand deseas?");
            standDisponibles();
            String stand = scnr.nextLine();
            empresa1.setStand(stand);
        }

        listaEmpresas.add(empresa1);
        System.out.println("registro exitoso");
    }

    public static void registroVisitante(Scanner scnr) {
        System.out.println("Escribe el nombre del visitante: ");
        String nombre = scnr.nextLine();
        System.out.println("Escribe la identificacion del visitante: ");
        int identificacion = scnr.nextInt();
        System.out.println("Escribe el correo del visitante: ");
        String correo = scnr.nextLine();

        Visitante visitante1 = new Visitante(nombre, identificacion, correo);
        listaVisitantes.add(visitante1);
        System.out.println("registro exitoso");
    }

    public static void mostrarEmpresas() {
        for (Empresa empresa : listaEmpresas) {
            System.out.println(empresa.getNombre());
        }
    }

    public static void mostrarVisitantes() {
        for (Visitante visitante : listaVisitantes) {
            System.out.println(visitante.getNombre());
        }
    }

    public static void mostrarCalificaciones() {
        for (Stand stand : listaStands) {
            System.out.println("stand: " + stand.getId() + " Ubicacion: " + stand.getUbicacion()
                    + "Promedio de calificacion: " + stand.getPromedio());
        }
    }

    public static void empresasDisponibles() {
        for (Empresa empresa : listaEmpresas) {
            if (empresa.getStand() == null) {
                System.out.println("Empresa " + empresa.getNombre());                
            }
        }
    }

    public static void standDisponibles() {
        for (Stand stand : listaStands) {
            if (stand.getEmpresa() == null) {
                System.out.println("stand: " + stand.getId() + " " + stand.getUbicacion() + " " + stand.getTamaño());
            }
        }
    }

    public static void mostrarStands() {
        System.out.println("<Disponibles>");
        for (Stand stand : listaStands) {
            if (stand.getEmpresa() == null) {
                System.out.println("stand: " + stand.getId() + " " + stand.getUbicacion() + " " + stand.getTamaño());
            }
        }
        System.out.println("<Disponibles>");

        System.out.println("<Ocupados>");
        for (Stand stand : listaStands) {
            if (stand.getEmpresa() != null) {
                System.out.println("stand: " + stand.getId() + " " + stand.getUbicacion() + " " + stand.getTamaño());
            }
        }
        System.out.println("<Ocupados>");
    }

}
