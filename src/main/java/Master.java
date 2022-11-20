import java.io.*;
import java.util.Scanner;
public class Master {

    static Scanner input = new Scanner(System.in);

    public static void main(String [] args)
    {


        System.out.println("-------------RFFC GYMN-----------------" +
                "\n\nSelect one from the optionss below: \n" +
                "[1] GYNM STAFFR\n" +
                "[2] ONLINE USERS\n" +
                "[3] CLOSE");

        getUserChoice();


    }
    public static void getUserChoice()
    {
        //for keybaord input
        Scanner keyboard = new Scanner(System.in);
        int choice = keyboard.nextInt();


        switch (choice)
        {
            case 1:
                System.out.println("gym worker");
                break;
            case 2:
                System.out.println("Online user");
                enrolUser();
                break;
            case 3:
                System.exit(0);

            default:
                System.out.println("Wrong choice, kindly choose from existing options");
                getUserChoice();


        }

    }

    public static void enrolUser()
    {
        int id;
        String name, address, city, email;


        System.out.println("Enter the user ID: ");
        id = input.nextInt();

        System.out.println(("Enter the user name: "));
        name = input.next();

        System.out.println("Enter the user address");
        address = input.next();

        System.out.println("Enter the user Email address: ");
        email = input.next();

        System.out.println("Enter the user city: ");
        city = input.next();

        //Handling saving the
        User user = new User(id,name,address,city,email);
        saveUser(user);

    }

    public static void saveUser(User user)
    {

        System.out.println("Press 1 to save and 2 to Cancel the operation:\n[1] SAVE \n[2] CANCEL");
        int action= input.nextInt();

        switch (action){
            case 1:
                //SAve
                //serializeUser(user);
                deserializeUser();
                break;
            case 2:
                //cancel
                System.out.println("Cancelled"+user);
                break;
            default:
                System.out.println("Please select from the provided options!\n\n");
                saveUser(user);
                break;
        }
    }

    public static void serializeUser(User user)
    {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("users.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(user);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void deserializeUser()
    {
        User user;
        try {
            FileInputStream fileIn = new FileInputStream("users.ser");
            ObjectInputStream object_input = new ObjectInputStream(fileIn);
            user =  (User) object_input.readObject();
            object_input.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }

        System.out.println("Deserialized Employee...");
        System.out.println("Name: " + user.getName());
    }
}
