import java.util.ArrayList;
import java.util.Scanner;

public class main {

    static ArrayList<Empresa> listaEmpresas = new ArrayList<Empresa>();
    static ArrayList<Stand> listaStands = new ArrayList<Stand>();
    static ArrayList<Visitante> listaVisitantes = new ArrayList<Visitante>();

    public static void main(String[] args) {
        añadirDatos();
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
                        if (elemento.getId() == stand) {
                            elemento.setEmpresa(empresa);
                            break;
                        }
                    }
                    for (Empresa elemento : listaEmpresas) {
                        if (elemento.getNombre() == empresa) {
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
                menuEmpresas();
                option = scnr.nextLine();
                if (option.equals("1")) {
                    mostrarEmpresas();
                } else if (option.equals("2")) {
                    eliminarEmpresas(scnr);
                } else if (option.equals("3")) {
                    editarEmpresa(scnr);
                } else if (option.equals("4")) {
                    continue;
                }

            } else if (option.equals("4")) {
                menuVisitantes();
                option = scnr.nextLine();
                if (option.equals("1")) {
                    mostrarVisitantes();
                } else if (option.equals("2")) {
                    eliminarVisitantes(scnr);
                } else if (option.equals("3")) {
                    editarVisitantes(scnr);
                } else if (option.equals("4")) {
                    continue;
                }
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

    public static void menuEmpresas() {
        System.out.println("1. Listar empresas");
        System.out.println("2. Eliminar empresas");
        System.out.println("3. Editar empresas");
        System.out.println("4. Volver al menu principal");
    }

    public static void menuVisitantes() {
        System.out.println("1. Listar visitantes");
        System.out.println("2. Eliminar visitantes");
        System.out.println("3. Editar visitantes");
        System.out.println("4. Volver al menu principal");
    }

    public static void menuRegistro() {
        System.out.println("1. Registrar empresa");
        System.out.println("2. Registrar visitantes");
        System.out.println("3. Regresar al menu principal");
    }

    public static void menuStand() {
        System.out.println("1. Lista de Stand");
        System.out.println("2. Asignar Stand");
        System.out.println("3. Visitar Stand");
        System.out.println("4. Regresar al menu principal");
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
            System.out.println(empresa.getNombre() + " sector: " + empresa.getSector() + " correo electronico: " + empresa.getEmail());

        }
    }

    public static void mostrarVisitantes() {
        for (Visitante visitante : listaVisitantes) {
            System.out.println(visitante.getNombre() + " Identificacion: " + visitante.getIdenticacion());
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

    public static void eliminarEmpresas(Scanner scnr) {
        System.out.println("Escriba el nombre de la empresa a eliminar");
        String respuesta = scnr.nextLine();
        for (int i = 0; i < listaEmpresas.size(); i++) {
            if (listaEmpresas.get(i).getNombre().equals(respuesta)) {
                listaEmpresas.remove(i);
                System.out.println("empresa eliminada con exito");
                break;
            }
        }
    }

    public static void eliminarVisitantes(Scanner scnr) {
        System.out.println("Escriba el nombre del visitante a eliminar");
        String respuesta = scnr.nextLine();
        for (int i = 0; i < listaVisitantes.size(); i++) {
            if (listaVisitantes.get(i).getNombre().equals(respuesta)) {
                listaVisitantes.remove(i);
                System.out.println("Visitante eliminado con exito");
                break;
            }
        }
    }

    public static void editarEmpresa(Scanner scnr) {
        System.out.println("Que empresa desea editar?");
        String respuesta = scnr.nextLine();
        for (int i = 0; i < listaEmpresas.size(); i++) {
            if (listaEmpresas.get(i).getNombre().equals(respuesta)) {
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

                listaEmpresas.set(i, empresa1);
                System.out.println("Empresa editada con exito");
            }
        }
    }

    public static void editarVisitantes(Scanner scnr) {
        System.out.println("Que visitante desea editar?");
        String respuesta = scnr.nextLine();
        for (int i = 0; i < listaVisitantes.size(); i++) {
            if (listaVisitantes.get(i).getNombre().equals(respuesta)) {
                System.out.println("Escribe el nombre del visitante: ");
                String nombre = scnr.nextLine();
                System.out.println("Escribe la identificacion del visitante: ");
                int identificacion = scnr.nextInt();
                System.out.println("Escribe el correo del visitante: ");
                String correo = scnr.nextLine();

                Visitante visitante1 = new Visitante(nombre, identificacion, correo);
                listaVisitantes.set(i, visitante1);
                System.out.println("Editado exitoso");

            }
        }
    }

    public static void añadirDatos(){
        Empresa empresa1 = new Empresa("cocacola", "retail", "cocacola.com");
        Empresa empresa2 = new Empresa("Sprite", "retail", "Sprite.com");
        Empresa empresa3 = new Empresa("Fant", "retail", "Fanta.com");

        listaEmpresas.add(empresa3);
        listaEmpresas.add(empresa2);
        listaEmpresas.add(empresa1);

        Visitante visitante1 = new Visitante("Jean", 123123, "cocacolavis.com");
        Visitante visitante2 = new Visitante("Paola", 21332, "Spritevis.com");
        Visitante visitante3 = new Visitante("Jhon", 5353, "Fantavis.com");

        listaVisitantes.add(visitante1);
        listaVisitantes.add(visitante2);
        listaVisitantes.add(visitante3);

        Stand stand1 = new Stand("123", "pabellon A", "Grande");
        Stand stand2 = new Stand("456", "pabellon B", "Pequeño");
        Stand stand3 = new Stand("789", "pabellon C", "Mediano");

        listaStands.add(stand3);
        listaStands.add(stand2);
        listaStands.add(stand1);

    }



}
