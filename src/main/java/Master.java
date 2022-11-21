import java.io.*;
import java.util.ArrayList;
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
                onlineUsers();
                break;
            case 3:
                System.exit(0);

            default:
                System.out.println("Wrong choice, kindly choose from existing options");
                getUserChoice();


        }

    }

    public static void onlineUsers()
    {
        System.out.println("-------------Online Users------------------\n[1] Enrol \n[2] View all users");
        int choice = input.nextInt();

        switch (choice)
        {
            case 1:
                enrolUser();
                break;
            case 2:
                viewUsers();
                break;
            default:
                System.out.println("Wrong choice, choose acording to available ooptions");
                onlineUsers();
                break;
        }
    }

    public static void viewUsers()
    {
        ArrayList<User> user_objects_list = new ArrayList();

        user_objects_list = deserializeUser();

        for(User user: user_objects_list)
        {
            System.out.println("Username: "+user.getName()+"\nEmail Address: "+user.getEmail()+"\n");
        }

    }
    public static void enrolUser()
    {
        ArrayList<User> list = deserializeUser();
        ArrayList<Integer> id_list = new ArrayList<Integer>();
        for(User user: list)
        {
            id_list.add(user.getId());
        }
        int id;
        String name, address, city, email,plan;


        System.out.println("Enter the user ID: ");
        id = input.nextInt();
        if(id_list.contains(id))
        {
            System.out.println("User with that ID already exists.");
            enrolUser();
            System.exit(0);
        }
        System.out.println(("Enter the user name: "));
        name = input.next();

        System.out.println("Enter the user address");
        address = input.next();

        System.out.println("Enter the user Email address: ");
        email = input.next();

        System.out.println("Enter the user city: ");
        city = input.next();

        System.out.println("Choose plan: ");
        System.out.println("Plans available is as follows: \n" +
                "[1] Basic plan - $9.99/month \n" +
                "\t->Equipments \n" +
                "\t->Guests - $10 per session - only equipments\n" +
                "[2] Fox Plan - 19.99/month\n" +
                "\t->Equipments\n" +
                "\t->Guest Priviledges\n" +
                "\t->Free group fitness classes");
        plan = choosePlan();
        //Handling saving the
        User user = new User(id,name,address,city,email,plan);
        saveUser(user);

    }

    public static void saveUser(User user)
    {

        System.out.println("Press 1 to save and 2 to Cancel the operation:\n[1] SAVE \n[2] CANCEL");
        int action= input.nextInt();

        switch (action){
            case 1:
                //SAve
               serializeUser(user);
                //deserializeUser();
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
        ArrayList<User> users_list = new ArrayList();

        users_list = deserializeUser();

        try {
            users_list.add(user);
            FileOutputStream fileOut =
                    new FileOutputStream("users.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(users_list);
            out.close();
            fileOut.close();
            System.out.printf("Saved successfully!");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static ArrayList<User> deserializeUser()
    {
        ArrayList<User> user_list= new ArrayList();
        try {
            FileInputStream fileIn = new FileInputStream("users.ser");
            ObjectInputStream object_input = new ObjectInputStream(fileIn);
            user_list =  (ArrayList<User>) object_input.readObject();
            object_input.close();
            fileIn.close();
        } catch (IOException i) {
            //i.printStackTrace();
            System.out.println("No records found, none might might have been created before.");
            return user_list;
        } catch (ClassNotFoundException c) {
            System.out.println("Usere class not found");
            c.printStackTrace();
            return user_list;
        }

        System.out.println("Deserialized users...");


        return user_list;
    }

    public static String choosePlan()
    {
      System.out.println("Choose plan: ");
        int choice = input.nextInt();

        switch (choice)
        {
            case 1:
                return "Basic";

            case 2:
                return "Fox";
            default:
                System.out.println("Wrong choice, kindly choose from available choices");
                choosePlan();
        }
        return null;
    }
}
