package proceso;

import modelo.Estudiante;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcesadorArchivoCsv {

    private String nombreArchivo;
//    private String regex;
    String regex = "[0-9]+,[a-zA-Z ().-]+,[a-zA-Z]*,[a-zA-Z0-9 |()-]*,[a-zA-Z ]+,[a-zA-Z ()/-]*,[a-zA-Z ()|-]*";

    public ProcesadorArchivoCsv(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public ArrayList<Estudiante> procesarArchivo(){
        // Creo la lista que contendrá los resultados
        ArrayList<Estudiante> lista = new ArrayList<>();
        // Armo un path al archivo en disco pero no se accede todavía
        Path f = Paths.get(nombreArchivo);

        // Controlando que el archivo existe
        if (Files.exists(f) && Files.isReadable(f)) {

            // Abro y podría provocar una excepción por eso el try-catch
            try (Scanner miEscaner = new Scanner(f, "UTF-8")) {

                int contadorLineas = 1;

                // Recorrer el archivo línea por línea
                while (miEscaner.hasNextLine()) {
                    // Leo del archivo una línea
                    String linea = miEscaner.nextLine();
                    // Saltea la primera línea de encabezados
                    if (contadorLineas > 1) {
                        // Separar los tokens de cadena en la línea
                        String[] datos = separarLinea(linea);
//                        System.out.println("Procesando línea: " + contadorLineas);
                        // Valido que realmente esta línea corresponde a un estudiante
                        if (datos[3].contains("Student")){
//                          if (datos[3].equals("Student")){
                            Estudiante e = Estudiante.parseStringArray(datos);
                            lista.add(e);
                        }
                    }
                    contadorLineas++;
                }
            }
            catch(IOException ex) {
                ex.printStackTrace();
                System.exit(-1);
            }

        }
        else {
            System.out.println("Error: El archivo no existe.");
        }
        return lista;

    }

    public ArrayList<Estudiante> procesarArchivoConValidacion(){
        ArrayList<Estudiante> lista = new ArrayList<>();
        Path f = Paths.get(nombreArchivo);
        Pattern pattern = Pattern.compile(regex);

        if (Files.exists(f) && Files.isReadable(f)) {

            try (Scanner miEscaner = new Scanner(f, "UTF-8")) {
                int contadorLineasInvalidas = 0;
                int contadorLineas = 1;

                while (miEscaner.hasNextLine()) {
                    String linea = miEscaner.nextLine();
                    Matcher matcher = pattern.matcher(linea);
//                    if (linea.matches(regex)) {
                    if (matcher.matches()) {
                        String[] datos = separarLinea(linea);
//                        System.out.println("Procesando línea: " + contadorLineas);
                        if (datos[3].contains("Student")){
                            Estudiante e = Estudiante.parseStringArray(datos);
                            lista.add(e);
                        }
                    }
                    else {
//                        System.out.println("Línea inválida: " + contadorLineas + " | " + linea);
                        contadorLineasInvalidas++;
                    }
                    contadorLineas ++;
                }
                if (contadorLineasInvalidas > 0){
                    System.err.println("Líneas inválidas encontradas: " + contadorLineasInvalidas );
                }

            }
            catch(IOException ex) {
                ex.printStackTrace();
                System.exit(-1);
            }

        }
        else {
            System.out.println("Error: El archivo no existe.");
        }
        return lista;

    }


    private String[] separarLinea(String linea) {
        if (!linea.equals("") && !linea.equals("\n")) {
            // la coma está siendo vista como una expresión regular y por eso las barras de escape tanto de regex como
            // de java
            return linea.split(",");
            // retorna un vector con un elemento por cada columna separada por coma de la línea de datos

        }


        return new String[0];

    }
}
