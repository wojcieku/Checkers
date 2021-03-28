import java.util.Hashtable;
import java.util.Scanner;
public class LogInData {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Hashtable <String, String> ht1 = new Hashtable<>();
        String user;
        String password;
        while(true) {
            System.out.println("What would you like to do?");
            String order = scanner.nextLine();
            if (order.equals("exit")){
                System.exit(0);
            }
            else if (order.equals("save")) {
                while(true) {
                    System.out.println("Enter username:");
                    user = scanner.nextLine();
                    if(user.equals("q")){
                        break;
                    }
                    else {
                        System.out.println("Enter password: ");
                        password = scanner.nextLine();
                        ht1.put(user, password);
                        System.out.println("Data saved");
                    }
                }
            }
            else if (order.equals("check password")){
                System.out.println("Enter username");
                user = scanner.nextLine();
                if(ht1.containsKey(user)) {
                    System.out.println(user + "'s password is: " + ht1.get(user));
                }
                else{
                    System.out.println("No user found");
                }
            }
        }
    }
}
