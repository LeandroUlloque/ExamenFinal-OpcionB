package proceso;

import data.ProveedorConexionSqlite;
import data.RepositorioCasas;
import modelo.Casa;
import modelo.Estudiante;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class ProcesoAplicacion {
    Scanner miEscanner = new Scanner(System.in);
    ArrayList<Estudiante> lista;
    Hogwarts hogwarts;

    public ProcesoAplicacion() {
        hogwarts = new Hogwarts();

    }

    public void iniciarAplicacion() {
        // Interfaz de usuario
        encabezadoApp();

        String nombreArchivo = leerNombreArchivo();

        // Comienza proceso de archivo
        procesarArchvio(nombreArchivo);

        agregarEstudiantesHogwarts();
        cantidadEstudiantesPorCasa();
        listadoEstudiantesNoHumanos();

        // Persistencia de Datos
        persistirCasas();

    }

    private static void encabezadoApp() {
        System.out.println("Cargador de Datos de Hogwards");
        System.out.println("=============================");
        System.out.println();

    }

    private String leerNombreArchivo() {
        System.out.print("Ingrese el nombre del archivo de datos: ");
        String nombreArchivo = miEscanner.nextLine();
        return nombreArchivo;
    }

    private void procesarArchvio(String nombreArchivo) {
        System.out.println("\nProcesando archivo...");
        // Procesar el archivo de texto
        // 1 Abrir el archivo
        // 2 Leer el archivo línea por línea
        //      Para cada línea
        //      2.1 Separar porciones separadas por coma
        //      2.2 Validamos que la línea corresponda a un objeto a crear
        //      2.3 Creamos el objeto transformando las cadenas de acuerdo con los atributos
        //      2.4 Agregamos el objeto a la lista resultante.
        ProcesadorArchivoCsv procArchivo = new ProcesadorArchivoCsv(nombreArchivo);
//        lista = procArchivo.procesarArchivo();
        lista = procArchivo.procesarArchivoConValidacion();
        // Mostrar al usuario que el archivo se procesó.
        System.out.println("Proceso finalizado, " + lista.size() + " estudiantes leídos.");
//        System.out.println("\nLista de Estudiantes:");
//        for(Estudiante e : lista)
//            System.out.println(e);
    }

    private void agregarEstudiantesHogwarts() {
        for(Estudiante e : lista){
            hogwarts.agregarEstudiante(e);
        }


    }

    private void cantidadEstudiantesPorCasa() {
        System.out.println("Cantidad de Estudiantes por casa: ");
        for (String casa : new String[] {"Gryffindor", "Slytherin", "Hufflepuff", "Ravenclaw"}){
            System.out.println("Casa: " + casa + " ==> " + hogwarts.getCasa(casa).getCantidadEstudiantes() + " estudiantes");
        }
    }

    private void listadoEstudiantesNoHumanos() {
    }

    private void persistirCasas() {

        Connection miConexion = ProveedorConexionSqlite.conectar(".\\data\\baseDeDatos.sqlite");
        RepositorioCasas repositorio = new RepositorioCasas(miConexion);

        for (String nombreCasa : new String[] {"Gryffindor", "Slytherin", "Hufflepuff", "Ravenclaw"}){
            Casa casa = hogwarts.getCasa(nombreCasa);
            Casa casaGuardada = repositorio.getCasa(casa.getIdCasa());
            if (casaGuardada == null) {
                repositorio.agregarCasa(casa);
            }

        }
    }

}
