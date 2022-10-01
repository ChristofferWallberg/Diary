import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
//        Skapar upp meny 1 och 2.
        Menu.menu1();
        Menu.menu2();
        List<User> users = new ArrayList<>(List.of(JsonUtils.gsonReadUserToFile()));
        System.out.println(users);
        //Scanner för att hantera menyval.
        Scanner scanner = new Scanner(System.in);
        int choice;
        //Börja på meny 1 innan man skrivit in en giltig användare för att komma åt meny 2.
        int menu = 1;
//        Meny som visar:
//        1. Välj användare
//        2. Skapa ny användare
//        3. Avsluta
//        Var kvar i loopen tills att du Valt en användare -> Gå till meny 2. Öka eller minska counter för att gå mellan
//        menyer?

        do {
            Menu.getMenu(menu);
            choice = scanner.nextInt();
            if (menu == 1 && choice == 1) {
                for (User user : users)
                    System.out.println(user.getUsername());
            }
            if (menu == 1 && choice == 2) {
                System.out.println("Ange användarnamn: ");
                User newUser = new User(scanner.next());
                users.add(newUser);
                JsonUtils.gsonWriteUserToFile(users);
                for (User user : users)
                    System.out.println(user.getUsername());
            }
        } while (choice != 3);
    }
}
