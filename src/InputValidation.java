import java.util.Scanner;

public class InputValidation {
    private final Scanner scanner;
    InputValidation(){
        this.scanner = new Scanner(System.in);
    }
    public int checkInt(){
        while(true){
            try{
                return Integer.parseInt(scanner.nextLine().trim());
            }
            catch(NumberFormatException e){
                System.out.print("Invalid Input, please try again: ");
            }
        }
    }
    public double checkDouble(){
        while(true){
            try{
                return Double.parseDouble(scanner.nextLine().trim());
            }
            catch(NumberFormatException e){
                System.out.print("Invalid Input, please try again: ");
            }
        }
    }
    public int checkRange(int min, int max){
        while(true){
            int value = checkInt();
            if(value >= min && value <= max){
                return value;
            }
            else{
                System.out.println("Invalid input");
                System.out.print("Please enter a number between " + min + " and " + max + ": ");
            }
        }
    }
}
