import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
//        Skapar upp meny 1 och 2.
        Menu.menu1();
        Menu.menu2();
        List<User> users = new ArrayList<>(List.of(JsonUtils.gsonReadUserFromFile()));
        System.out.println(users);
        User currentUser = new User(null);
        Diary diary = new Diary(null);
        List<DiaryEntry> diaryEntries = new ArrayList<>();
        List<Diary> diaries = new ArrayList<>();

        //Scanner för att hantera menyval.
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        //Börja på meny 1 innan man skrivit in en giltig användare för att komma åt meny 2.
        int menu = 1;
//        Meny som visar:
//        1. Välj användare
//        2. Skapa ny användare
//        3. Avsluta
//        Var kvar i loopen tills att du Valt en användare -> Gå till meny 2. Öka eller minska counter för att gå mellan
//        menyer?
        System.out.println(Menu.getMenus().get(1).size());

        do {
            if (menu == 1) {
                Menu.getMenu(menu);
                choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> {
                        for (User user : users) {
                            System.out.println(user.getUsername());
                        }
                        currentUser.setCurrentUser(scanner.next());
                        for (User user : users) {
                            if (user.getUsername().equalsIgnoreCase(currentUser.getCurrentUser())) {
                                menu = 2;
                                break;
                            }
                        }
                    }
                    case 2 -> {
                        System.out.println("Ange användarnamn: ");
                        User newUser = new User(scanner.next());
                        users.add(newUser);
                        JsonUtils.gsonWriteUserToFile(users);
                        for (User user : users)
                            System.out.println(user.getUsername());
                    }
                }
            }
            if (menu == 2) {

                System.out.println("Användare: " + currentUser.getCurrentUser());
                Menu.getMenu(menu);
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        for (DiaryEntry user : diaryEntries) {
                            if (user.getUsername().getCurrentUser().equalsIgnoreCase(currentUser.getCurrentUser())) {
                                System.out.println(diaryEntries.get(0).getText());
                            }
                            //TODO Varför hoppar loopen över den här if satsen nedan? Har provat debugga men vad än ovan if ger för resultat går den direkt till break i case 1...
                            if (!(user.getUsername().getCurrentUser().equalsIgnoreCase(currentUser.getCurrentUser()))) {
                                System.out.println("Du har inga inlägg.");
                            }
                        }
                        break;
                    case 2:
                        DiaryEntry diaryEntry = new DiaryEntry(currentUser, "Dag1", "text");
                        diaryEntries.add(diaryEntry);
                        diaries.add(diary);
                        System.out.println("Mocktext: " + diaryEntry.getText() +
                                "\nMocktitel: " + diaryEntry.getTitle());
                        break;
                }
            }
        } while (choice != Menu.getMenus().get(menu).size());
    }
}
