import data.ProveedorConexionSqlite;
import modelo.Estudiante;
import proceso.Hogwarts;
import proceso.ProcesadorArchivoCsv;
import proceso.ProcesoAplicacion;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class app {
    public static void main(String[] args)throws Exception{
        ProcesoAplicacion proc = new ProcesoAplicacion();

//        try {
            proc.iniciarAplicacion();

//        }
//        catch (Exception ex) {
//            // No en la consola sino en algún archivo de log donde quede registrado
//            System.out.println(ex);
//        }

//        Scanner miEscanner = new Scanner(System.in);
//
//        // Solo interfaz de usuario
//        System.out.println("Cargador de Datos de Hogwards");
//        System.out.println("=============================");
//        System.out.println();
//
//        // Ingrese del nombre del archivo de datos csv a procesar
//        System.out.print("Ingrese el nombre del archivo de datos: ");
//        String nombreArchivo = miEscanner.nextLine();
//
//        System.out.println("\nProcesando archivo...");
//        // Procesar el archivo de texto
//        // 1 Abrir el archivo
//        // 2 Leer el archivo línea por línea
//        //      Para cada línea
//        //      2.1 Separar porciones separadas por coma
//        //      2.2 Validamos que la línea corresponda a un objeto a crear
//        //      2.3 Creamos el objeto transformando las cadenas de acuerdo con los atributos
//        //      2.4 Agregamos el objeto a la lista resultante.
//        ProcesadorArchivoCsv procArchivo = new ProcesadorArchivoCsv(nombreArchivo);
////        ArrayList<Estudiante> lista = procArchivo.procesarArchivo();
//        ArrayList<Estudiante> lista = procArchivo.procesarArchivoConValidacion();
//        // Mostrar al usuario que el archivo se procesó.
//        System.out.println("Proceso finalizado, " + lista.size() + " estudiantes leídos.");
//
////        System.out.println("\nLista de Estudiantes:");
////        for(Estudiante e : lista)
////            System.out.println(e);
//
//        Hogwarts hogwarts = new Hogwarts();
//        for(Estudiante e : lista){
//            hogwarts.agregarEstudiante(e);
//        }
//
//        System.out.println("Cantidad de Estudiantes por casa: ");
//        for (String casa : new String[] {"Gryffindor", "Slytherin", "Hufflepuff", "Ravenclaw"}){
//            System.out.println("Casa: " + casa + " ==> " + hogwarts.getCasa(casa).getCantidadEstudiantes() + " estudiantes");
//        }

    }
}
