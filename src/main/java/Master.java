import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Master {

    static Scanner input = new Scanner(System.in);

    public static void main(String [] args)
    {


        System.out.println("-------------RFFC GYMN-----------------" +
                "\n\nSelect one from the optionss below: \n" +
                "[1] GYNM STAFF\n" +
                "[2] ONLINE USER\n" +
                "[3] CLOSE");

        getMemberChoice();


    }
    public static void getMemberChoice()
    {
        //for keybaord input
        Scanner keyboard = new Scanner(System.in);
        int choice = keyboard.nextInt();


        switch (choice)
        {
            case 1:
                System.out.println("gym worker");
                GymClass g =  new GymClass();
                g.generateSchedule();
                g.displaySchedule();
                break;
            case 2:
                onlineMembers();
                break;
            case 3:
                System.exit(0);

            default:
                System.out.println("Wrong choice, kindly choose from existing options");
                getMemberChoice();


        }

    }

    public static void onlineMembers()
    {
        Member member = new Member();
        System.out.println("-------------Online Members------------------\n[1] Signup \n[2] Enrol for class" +
                "\n[3] Switch plan \n[4] Cancel plan \n[5] View schedules \n[6] Request for One to One class");
        int choice = input.nextInt();

        switch (choice)
        {
            case 1:
                member.signupMember();
                break;
            case 2:
                member.enrolMember();
                break;
            case 3:
                member.switchPlan();
                break;
            case 4:
                member.cancelPlan();
                break;
            default:
                System.out.println("Wrong choice, choose acording to available options");
                onlineMembers();
                break;
        }
    }










    public static void generateSchedules()
    {
        //Schedules be done her enah
    }

    public void manageSales()
    {

    }

    public void awardPoints()
    {
        //Award points
    }

    public void inventory()
    {
        //Manage inventory here
    }

    public void scheduleOnetoone()
    {

    }

}
