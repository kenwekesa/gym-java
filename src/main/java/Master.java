import java.util.Scanner;
public class Master {

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
                break;
            case 3:
                System.exit(0);

            default:
                System.out.println("Wrong choice, kindly choose from existing options");
                getUserChoice();


        }

    }
}
