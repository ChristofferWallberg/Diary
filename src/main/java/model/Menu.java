package model;

import java.util.*;

public class Menu {
    private static Map<Integer, List<String>> MENUS = new HashMap<>();

    /**
     * Create menu for logged off state.
     */
    public static void menu1() {
        ArrayList options = new ArrayList<>();
        options.add("Välj användare");
        options.add("Skapa ny användare");
        options.add(options.size(), "Avsluta");
        MENUS.put(1, options);

    }

    /**
     * Create menu for logged in state.
     */
    public static void menu2() {
        ArrayList options = new ArrayList<>();
        options.add("Läs inlägg");
        options.add("Skriv inlägg");
        options.add("Logga av");
        options.add(options.size(), "Avsluta");
        MENUS.put(2, options);
    }

    /**
     * Depending on which menu you are in, present that menus options.
     * @param x
     */
    public static void getMenu(int x) {
        int i = 1;
        System.out.println("Var god och ange en siffra för menyval: ");
        for (String options : MENUS.get(x)) {
            System.out.println("\t" + i + ") " + options);
            i++;
        }
    }

    public static Map<Integer, List<String>> getMENUS() {
        return MENUS;
    }
}
