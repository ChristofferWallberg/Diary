import java.lang.reflect.Array;
import java.util.*;

public class Menu {
    private static Map<Integer, List<String>> menus = new HashMap<>();

    public static void menu1() {
        ArrayList options = new ArrayList<>();
        options.add("Välj användare");
        options.add("Skapa ny användare");
        options.add("Visa dagböcker");
        options.add(options.size(),"Avsluta");
        menus.put(1, options);

    }

    public static void menu2() {
        ArrayList options = new ArrayList<>();
        options.add("Läs inlägg");
        options.add("Skriv inlägg");
        options.add("Logga av");
        options.add(options.size(),"Avsluta");
        menus.put(2, options);
    }

    // HashMap[1{"välj", "skapa"}, 2{"läs inlägg", "skriv"}] ->
    public static void getMenu(int x) {
        int i = 1;
        System.out.println("Var god och ange en siffra för menyval: ");
        for (String options : menus.get(x)) {
            System.out.println("\t" + i + ") " + options);
            i++;
        }
    }

    public static Map<Integer, List<String>> getMenus() {
        return menus;
    }
}
