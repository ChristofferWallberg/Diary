import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init menu1 and menu2.
        Menu.menu1();
        Menu.menu2();
        // Create lists for users and diaries from Json-files. If no files are present empty lists are created instead.
        List<User> users = new ArrayList<>(List.of(JsonUtils.gsonReadUserFromFile()));
        List<Diary> diaries = new ArrayList<>(List.of(JsonUtils.gsonReadDiariesFromFile()));

        //Scanner for inputs
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        //Begin at menu 1 before you have chosen a user.
        int menu = 1;
//        Menu that shows options:
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
                        //Choose user
                        case 1:
                            System.out.println("\t1) Fortsätt\n" +
                                    "\t2) Avbryt");
                            choice = scanner.nextInt();
                            if (choice == 2) {
                                break;
                            } else if (choice == 1) {
                                System.out.println("Skriv in någon av följande användare för att logga in: ");
                                User.printAllUsers(users);

                                System.out.println("Ange användarnamn: ");
                                String currentUser = scanner.next();
                                if(users.stream()
                                        .noneMatch(user -> user.getUsername().equalsIgnoreCase(currentUser))) {
                                    System.out.println("Användaren finns inte!");
                                }
                                for (User user : users) {
                                    if (user.getUsername().equalsIgnoreCase(currentUser)) {
                                        User.setCURRENTUSER(user);
                                        menu = 2;
                                        break;
                                    }
                                }
                                break;
                            }
                            System.out.println("Du angav inte ett giltigt val, försök igen.");
                            choice = 0;
                            break;
                        // Create new user and a new Diary for the user. Add this Diary to the list of diaries.
                        case 2:
                            System.out.println("\t1) Fortsätt\n" +
                                    "\t2) Avbryt");
                            choice = scanner.nextInt();
                            if (choice == 2) {
                                break;
                            } else if (choice == 1) {
                                System.out.println("Upptagna användarnamn: ");
                                User.printAllUsers(users);
                                choice = 2;
                                System.out.println("Ange användarnamn: ");
                                String addUser = scanner.next();
                                // Check if the username is already taken
                                boolean userExists;
                                userExists = User.checkIfUserExist(users, addUser);
                                User.createUser(userExists, users, diaries, addUser);
                                break;
                            }
                            System.out.println("Du angav inte ett giltigt val, försök igen.");
                            choice = 0;
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Du skrev något fel! Var god endast ange siffran för menyvalet.");
                    scanner.nextLine();
                }
            }
            // Menu for logged in user
            if (menu == 2) {
                User.getLoggedInUser();
                Menu.getMenu(menu);
                try {
                    choice = scanner.nextInt();
                    switch (choice) {
                        //Read entries for current users diary
                        case 1:
                            for (Diary currentDiary : diaries) {
                                currentDiary.printDiaryEntriesCurrentUser(currentDiary);
                            }
                            break;
                        //Create a Diary entry and put it inside current users Diary.
                        case 2:
                            System.out.println("\t1) Fortsätt\n" +
                                    "\t2) Avbryt");
                            choice = scanner.nextInt();
                            if (choice == 2) {
                                break;
                            } else if (choice == 1) {
                                System.out.println("Skriv titel på dagboksinlägget: ");
                                scanner.nextLine();
                                String scannerTitle = scanner.nextLine();
                                System.out.println("Skriv texten till dagboksinlägget: ");
                                String scannerText = scanner.nextLine();
                                // Create new diary entry for the current user and puts it in the users diary.
                                DiaryEntry diaryEntry = Diary.createNewDiaryEntry(diaries, scannerTitle, scannerText);
                                System.out.println("Inlägg skapat: " +
                                        "\nAnvändare: " + diaryEntry.getUSER() +
                                        "\nMocktitel: " + diaryEntry.getTITLE() +
                                        "\nMocktext: " + diaryEntry.getTEXT() +
                                        "\n----------------------------------------------");
                            } else {
                                System.out.println("Du angav inte ett giltigt val, försök igen.");
                                choice = 0;
                            }
                            break;
                        // Going back to menu 1 (log off)
                        case 3:
                            menu = 1;
                            choice = 0;
                            break;
                        // Break the loop and terminates the application as choice = 4 which is last index of the menu
                        case 4:
                            break;
                        default:
                            System.out.println("Ogiltigt val, skriv in siffra från menyvalet.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Du skrev något fel! Var god endast ange siffran för menyvalet.");
                    scanner.nextLine();
                }
            }
        } while (choice != Menu.getMENUS().get(menu).size());
        System.out.println("Hej då! Välkommen åter!");
    }
}
