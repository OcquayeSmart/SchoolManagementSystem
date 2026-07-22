import java.util.List;
import java.util.Scanner;

public class UserLogins {
    private final List<User> users;
    private final Scanner scanner;
    private final InputValidation inputValidation;

    public UserLogins(Scanner scanner, List<User> users, InputValidation inputValidation) {
        this.scanner = scanner;
        this.users = users;
        this.inputValidation = inputValidation;
    }
    public User login() {
        while(true){
            System.out.println("Welcome back! Please enter your credentials.");
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            System.out.print("\n\rStatus: Verifying Credentials...");
            try{
                Thread.sleep(900);
            }
            catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
            for(User user: users){
                if(user.getPassword().equals(password) && user.getUsername().equals(username)){
                    System.out.print("\rStatus: Access Granted!");
                    return user;
                }
            }
            System.out.print("\nInvalid Credentials. Try again\n");
        }
    }
}
