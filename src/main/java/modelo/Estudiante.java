package modelo;

public class Estudiante {

    private int numero;
    private String nombre;
    private char genero;

    // Para la casa pongo un atributo para el nombre que traigo del archivo csv
    private String nombreCasa;
    // Y otro atribuo para el objeto casa que se asignará cuando lo agregue efectivamente a la casa
    //  que corresponda
    private Casa casa;

    private String especie;
    private String blodStatus;

    public Estudiante(int numero, String nombre, char genero, String especie, String blodStatus) {
        this.numero = numero;
        this.nombre = nombre;
        this.genero = genero;
        this.especie = especie;
        this.blodStatus = blodStatus;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public String getNombreCasa() {
        return nombreCasa;
    }

    public void setNombreCasa(String nombreCasa) {
        this.nombreCasa = nombreCasa;
    }

    public String getBlodStatus() {
        return blodStatus;
    }

    public void setBlodStatus(String blodStatus) {
        this.blodStatus = blodStatus;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public char getGenero() {
        return genero;
    }

    public String getEspecie() {
        return especie;
    }

    public String toString() {
//        return numero + ": " + nombre + " (" + especie + ")";
        return new StringBuffer()
                .append(numero)
                .append(": ")
                .append(nombre)
                .append(" (")
                .append(especie)
                .append(")")
                .toString();
    }

    public static Estudiante parseStringArray(String[] datos) {
        try {
            // Realizo las trasformaciones de cada porción de la línea de texto al dato que espera
            //  la clase Estudiante
            int numero = Integer.parseInt(datos[0]);
            String nombre = datos[1];
            char genero = (datos[2].equals("Female") || datos[2].equals("Male")) ? datos[2].charAt(0) : 'X';

//            if (datos[2].equals("Female") || datos[2].equals("Male"))
//                genero = datos[2].charAt(0);
//            else
//                genero = 'X';
//
            String nombreCasa = datos[4];
            String especie = datos[5].trim();
            String blodStatus = datos[6];

            Estudiante e = new Estudiante(numero, nombre, genero, especie, blodStatus);
            e.setNombreCasa(nombreCasa);
            return e;
        }
        catch (Exception ex)
        {
            throw new RuntimeException(ex);
        }

    }
}
