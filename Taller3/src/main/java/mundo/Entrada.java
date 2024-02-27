
package mundo;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class Entrada {

    ArrayList<Entrada> misEntradas = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    private int idEntrada;
    private String descripcion;
    private Date fecha;

    public Entrada(int idEntrada, String descripcion, Date fecha) {
        this.idEntrada = idEntrada;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Entrada() {

    }

    // creacion de getters and setters
    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void mostrarMenu() {

        boolean activo = true;

        do {

            System.out.println("--------------------------");
            System.out.println("-----DIARIO PERSONAL------");
            System.out.println("--------------------------");
            System.out.println("-----1. Agregar Entrada---");
            System.out.println("-----2. Consultar Entrada-");
            System.out.println("-----3. Modificar Entrada-");
            System.out.println("-----4. Eliminar Entrada--");
            System.out.println("-----5. Salir-------------");
            System.out.println("--------------------------");

            int opcion = sc.nextInt();
            switch (opcion) {

                case 1:
                    agregarEntrada();
                    break;
                case 2:
                    consultarEntrada();
                    break;
                case 3:
                    modificarEntrada();
                    break;
                case 4:
                    eliminarEntrada();
                    break;
                case 5:
                    activo = false;
                    System.out.println("Programa terminado");
                    break;
                default:
                    System.out.println("Opcion invalida");

            }
        } while (activo);
    }

    public void agregarEntrada() {
        int tamanioLista = misEntradas.size();
        int nuevoIdEntrada = 1; 

        if (tamanioLista > 0) {
            Entrada ultimaEntrada = misEntradas.get(tamanioLista - 1);
            nuevoIdEntrada = ultimaEntrada.getIdEntrada() + 1;
        }

        System.out.println("La id de la entrada ingresada es " + nuevoIdEntrada);

        System.out.println("Ingresa una descripción:");
        sc.nextLine(); 
        String descripcion = sc.nextLine();

        Date fecha = new Date();
        DateFormat formateadorFechaLarga = DateFormat.getDateInstance(DateFormat.LONG);
        System.out.println(formateadorFechaLarga.format(fecha));
      

        Entrada nuevaEntrada = new Entrada(nuevoIdEntrada, descripcion, fecha);
        misEntradas.add(nuevaEntrada);
        System.out.println("Entrada agregada ");
    }

    public void consultarEntrada() {
        System.out.println("Lista de entradas:");
        for (Entrada entrada : misEntradas) {
            System.out.println("Id: " + entrada.getIdEntrada());
            System.out.println("Descripción: " + entrada.getDescripcion());
            System.out.println("Fecha: " + entrada.getFecha());
            System.out.println("-----------------------------");
        }
    }

    public void eliminarEntrada() {
    System.out.println("Digite el id de la entrada que quiere eliminar");
    int id = sc.nextInt();
    Iterator<Entrada> it = misEntradas.iterator();
    boolean encontrado = false; 

    while (it.hasNext()) {
        Entrada e = it.next();
        if (e.getIdEntrada() == id) {
            it.remove();
            encontrado = true;
            System.out.println("Entrada con id " + id + " ha sido eliminada");
            break;
        }
    }

    if (!encontrado) {
        System.out.println("Id no encontrado");
    }
}

    public void modificarEntrada() {

        System.out.println("Digite el id de la entrada a modificar:");
        int id = sc.nextInt();
        sc.nextLine(); 

        for (Entrada entrada : misEntradas) {
            if (entrada.getIdEntrada() == id) {
                System.out.println("Ingresa la nueva descripcion:");
                String nuevaDescripcion = sc.nextLine();
                entrada.setDescripcion(nuevaDescripcion);
                System.out.println("Descripción actualizada");
                break;
            }
        }

        if (misEntradas.size() == 0) {
            System.out.println("Id no encontrado");
        }
    }
}