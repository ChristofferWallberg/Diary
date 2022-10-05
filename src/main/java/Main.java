import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        Skapar upp meny 1 och 2.
        Menu.menu1();
        Menu.menu2();
        List<User> users = new ArrayList<>(List.of(JsonUtils.gsonReadUserFromFile()));
        List<Diary> diaries = new ArrayList<>(List.of(JsonUtils.gsonReadDiariesFromFile()));


//        Diary diary = new Diary();
//        DiaryEntry diaryEntry = new DiaryEntry(diary);
        System.out.println(users);

        //Scanner för att hantera menyval.
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        //Börja på meny 1 innan man skrivit in en giltig användare för att komma åt meny 2.
        int menu = 1;
//        Meny som visar:
//        1. Välj användare
//        2. Skapa ny användare
//        3. Avsluta
        System.out.println("Hej och välkommen till Dagboken!");
        do {
            if (menu == 1) {
                Menu.getMenu(menu);
                try {
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
                        // Create new user and a new Diary for the user. Add this Diary to the list of diaries.
                        case 2:
                            System.out.println("Ange användarnamn: ");
                            User newUser = new User(scanner.next());
                            users.add(newUser);
                            JsonUtils.gsonWriteUserToFile(users);
                            Diary newUserDiary = new Diary(newUser);
                            diaries.add(newUserDiary);
                            JsonUtils.gsonWriteDiaryToFile(diaries);
                            for (Diary diary : diaries) {
                                System.out.println("User of Diary: " + diary.getUser());
                            }
                            for (User user : users)
                                System.out.println(user.getUsername());
                            break;
                        case 3:
                            for (Diary diary : diaries) {
                                System.out.println("Users with Diary: " + diary.getUser());
                            }
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Du skrev något fel! Var god endast ange siffran för menyvalet.");
                    scanner.nextLine();
                }
            }
            // Menu for logged in user
            if (menu == 2) {
                System.out.println("Användare: " + User.getCurrentUser().getUsername());
                Menu.getMenu(menu);
                try {
                    choice = scanner.nextInt();
                    switch (choice) {
                        //Read entries for current user
                        case 1:
                            for (Diary diary : diaries) {
                                if (Objects.equals(User.getCurrentUser().getUsername(), diary.getUser().getUsername()) && !(diary.getDiary().isEmpty())) {
                                    for (Diary currentDiary : diaries) {
                                        currentDiary.printDiaryEntries();
                                    }
                                } else if (diary.getDiary().isEmpty()) {
                                    System.out.println("Du har inga inlägg! Skriv några inlägg vettja!");
                                    break;
                                }
                            }
                            break;
                        //Create a Diary entry and put it inside current users Diary.
                        case 2:
                            System.out.println("Skriv titel på dagboksinlägget: ");
                            scanner.nextLine();
                            String scannerTitle = scanner.nextLine();
                            System.out.println("Skriv texten till dagboksinlägget: ");
                            String scannerText = scanner.nextLine();

                            DiaryEntry diaryEntry = new DiaryEntry(User.getCurrentUser(), scannerTitle, scannerText);
                            for (Diary diary : diaries) {
                                if (Objects.equals(User.getCurrentUser().getUsername(), diary.getUser().getUsername())) {
                                    diary.getDiary().add(diaryEntry);
                                    JsonUtils.gsonWriteDiaryToFile(diaries);
                                } else {
                                    System.out.println("User have no diary to write in.");
                                }
                            }
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
                } catch (InputMismatchException e) {
                    System.out.println("Du skrev något fel! Var god endast ange siffran för menyvalet.");
                    scanner.nextLine();
                    choice = 0;
                }
            }
        } while (choice != Menu.getMenus().get(menu).size());
        System.out.println("Hej då! Välkommen åter!");
    }
}
