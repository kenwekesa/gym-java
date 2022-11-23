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
                staffMembers();
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
        GymClass gymClass = new GymClass();
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
            case 5:
                gymClass.displaySchedule();
                break;
            case 6:
                System.out.println("One on one requested successfully");
                break;
            default:
                System.out.println("Wrong choice, choose acording to available options");
                onlineMembers();
                break;
        }
    }

    public static void  staffMembers()
    {
        Member member = new Member();
        GymClass gymClass = new GymClass();
        System.out.println("-------------Staff Member------------------\n[1] Check member in \n[2] View list of all Members" +
                "\n[3] Manage Inventory \n[4] Generate Schedule \n[5] View schedules \n[6] ------");
        int choice = input.nextInt();

        switch (choice)
        {
            case 1:
                member.signupMember();
                break;
            case 2:
                member.viewMembers();
                break;
            case 3:
                manageInventory();
                break;
            case 4:
                manageInventory();
                break;
            case 5:
                gymClass.displaySchedule();
                break;
            default:
                System.out.println("Wrong choice, choose acording to available options");
                staffMembers();
                break;
        }
    }


    public static void generateSchedule()
    {
        GymClass gymClass = new GymClass();
        System.out.println("Confirm you want to generate a fresh schedule for this month. If you proceed and the was any schedule before, it will be created anew:\n" +
                "[1] Yes generate \n[0] Cancel ");
        int confirm_choice = input.nextInt();

        switch (confirm_choice)
        {
            case 0:
                System.exit(0);
                break;
            case 1:
                gymClass.generateSchedule();
                break;
            default:
                System.out.println("Wrong choice, try again");
                generateSchedule();

        }
    }

    public static void manageInventory()
    {
        GymClass gymClass = new GymClass();
        System.out.println("````````````````````````````````````\n" +
                "[1] Add products \n[2] Sell products \n[3] View inventory report");
        int confirm_choice = input.nextInt();

        switch (confirm_choice)
        {
            case 1:
                createProduct();
                break;
            case 2:
                System.out.println("Sell products to members");
                break;
            case 3:
                viewStockReport();
                break;

            default:
                System.out.println("Wrong choice, try again");
                generateSchedule();

        }
    }


    public static void viewStockReport()
    {
        Product pr = new Product();
        System.out.println("=============================STOCK REPORT==============================\n");

        ArrayList<Product> stock_list = pr.deserializeProducts();

        for(Product prod: stock_list)
        {
            System.out.println("\nProduct name: \t"+prod.getName()+"" +
                    "\nStock Quantity: "+prod.getStock_quantity()+"\n");
        }

        System.out.println("=============================================================================\n");
    }
    public static void createProduct()
    {
        int id;
        int qunatity;
        String name;
        Product pro_object = new Product();
        System.out.println("----------------ADD PRODUCT--------------\n" +
                "Enter the product name: ");
        name = input.next();
        System.out.println("Enter the quantity to be added: ");
        qunatity = input.nextInt();

        ArrayList<Product> prodlist = pro_object.deserializeProducts();
        ArrayList<String> prod_names = new ArrayList<>();

        for(Product p:prodlist)
        {
            prod_names.add(p.getName());
        }

        Product new_product;
        if(prod_names.contains(name)) {
            Product product_to_edit = prodlist.get(prod_names.indexOf(name));

            new_product = new Product(2, product_to_edit.getName(), product_to_edit.getStock_quantity() + qunatity);
            prodlist.remove(product_to_edit);
            prodlist.add(new_product);
        }
        else {
            new_product = new Product(2, name, qunatity);
            prodlist.add(new_product);

        }


        pro_object.serializeProduct(prodlist);

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
