import java.util.regex.Pattern;

public class PruebaRegex {
    public static void main(String[] args) {

        // CUIL
        String regex = "[0-9]{10,11}";
        System.out.println("41190418135201 cumple: " + "41190418135201".matches(regex));
        System.out.println("27252692555 cumple: " + "27252692555".matches(regex));

        Pattern pat = Pattern.compile("[0-9]{10,11}");






    }
}
