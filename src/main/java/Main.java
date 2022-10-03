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
//        User currentUser = new User("currentUser");
//        currentUser.setCurrentUser();
//        Diary diary = new Diary(null);
//        List<DiaryEntry> diaryEntries = new ArrayList<>();
//        List<Diary> diaries = new ArrayList<>();

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
                    //Välj användare
                    case 1:
                        for (User user : users) {
                            System.out.println(user);
                        }
                        System.out.println("Ange användarnamn: ");
                        String currentUser = scanner.next();
                        for (User user : users) {
                            if (user.getUsername().equalsIgnoreCase(currentUser)) {
                                User.setCurrentUser(user);
                                menu = 2;
                                break;
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Ange användarnamn: ");
                        User newUser = new User(scanner.next());
                        users.add(newUser);
                        JsonUtils.gsonWriteUserToFile(users);
                        for (User user : users)
                            System.out.println(user.getUsername());
                    break;
                    case 3:
                        for (Diary diary1 : diaries) {
                            System.out.println(diary1.getDiaries().toString());
                        }
                        break;
                }
            }
            if (menu == 2) {
                System.out.println("Användare: " + User.getCurrentUser().getUsername());
                Menu.getMenu(menu);
                choice = scanner.nextInt();
                switch (choice) {
                    List<Diary> diaries = new ArrayList<>();
                    List<DiaryEntry> diaryEntries = new ArrayList<>();
                    diaryEntries = new ArrayList<>();

                    //Read entries for current user
                    case 1:
//                        for (DiaryEntry readDiaryEntry : diaryEntries) {
//                            //TODO Varför hoppar loopen över den här if satsen nedan? Har provat debugga men vad än ovan if ger för resultat går den direkt till break i case 1...
////                            if (!(diaryEntry.getUser().getCurrentUser().equals(User.getCurrentUser()))) {
////                                System.out.println("Du har inga inlägg.");
//                            }
                            Diary diary;
                            if (User.getCurrentUser().getUsername().equalsIgnoreCase(diary.getDiary().get(0).getUser().getUsername())) {
                                for (Diary currentDiary : diaries) {
                                    System.out.println(currentDiary);
                                }
                            }
                            break;
                            case 2:
                                DiaryEntry diaryEntry = new DiaryEntry(User.getCurrentUser(), "Dag1", "text");

                                diary = new Diary(diaryEntry.getUser(), diaryEntries);

                                diaries.add(diary);
//                        diaryEntries.add(diaryEntry);
//                        diary.setDiary(diaryEntries);
//                        diaries.add(diary);
                                System.out.println("Användare: " + diaryEntry.getUser() +
                                        "\nMocktext: " + diaryEntry.getText() +
                                        "\nMocktitel: " + diaryEntry.getTitle());
                                break;
                            case 3:
                                menu = 1;
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Ogiltigt val, skriv in siffra från menyvalet.");
                        }
                }
        } while (choice != Menu.getMenus().get(menu).size());
    }
}
