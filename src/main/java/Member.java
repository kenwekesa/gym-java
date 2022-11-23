import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Member implements java.io.Serializable{
   public transient Scanner input = new Scanner(System.in);
    private int id;
    private String name, address, city, email,plan;

    public Member() {
    }

    public Member(int id, String name, String address, String city, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.email = email;

    }
    //Setters


    public void setPlan(String plan) {
        this.plan = plan;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPlan() {
        return plan;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    //

    public void signupMember()
    {
       System.out.println("--------------------------SIGN UP PAGE -----------------------------------\n");
        ArrayList<Member> list = deserializeMember();
        ArrayList<Integer> id_list = new ArrayList<Integer>();
        for(Member memb: list)
        {
            id_list.add(memb.getId());
        }
        int id;
        String name, address, city, email,plan;


        System.out.println("Enter the member ID: ");
        id = input.nextInt();
        if(id_list.contains(id))
        {
            System.out.println("Member with that ID already exists.");
            signupMember();
            System.exit(0);
        }
        System.out.println(("Enter the member name: "));
        name = input.next();

        System.out.println("Enter the member address");
        address = input.next();

        System.out.println("Enter the member Email address: ");
        email = input.next();

        System.out.println("Enter the member city: ");
        city = input.next();
        if(id==0|name.equals("") | email.equals("")|address.equals("")|city.equals(""))
        {
            System.out.println("Some fields are empty, fill out all fieds");
            signupMember();
            System.exit(0);
        }
        Member member = new Member(id,name,address,city,email);
        saveMember(member);
    }


    public static void serializeMember(Member member)
    {
        ArrayList<Member> members_list;

        members_list = deserializeMember();

        try {
            members_list.add(member);
            FileOutputStream fileOut =
                    new FileOutputStream("members.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(members_list);
            out.close();
            fileOut.close();
            System.out.printf("Saved successfully!");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static ArrayList<Member> deserializeMember()
    {
        ArrayList<Member> member_list= new ArrayList();
        try {
            FileInputStream fileIn = new FileInputStream("members.ser");
            ObjectInputStream object_input = new ObjectInputStream(fileIn);
            member_list =  (ArrayList<Member>) object_input.readObject();
            object_input.close();
            fileIn.close();
        } catch (IOException i) {
            //i.printStackTrace();
            System.out.println("No records found, none might might have been created before.");
            return member_list;
        } catch (ClassNotFoundException c) {
            System.out.println("Membere class not found");
            c.printStackTrace();
            return member_list;
        }

        System.out.println("Deserialized members...");


        return member_list;
    }



    /*
    *---------------------------------Enrollment----------------------------------------
     */







    public void enrolMember()
    {
        ArrayList<Member> members_list = deserializeMember();
        ArrayList<Integer> id_list = new ArrayList<Integer>();
        for(Member member: members_list)
        {
            id_list.add(member.getId());
        }
        int id;
        String member_name, city, class_type,plann;

        System.out.println("Please enter the member ID");
        id = input.nextInt();

        if(!id_list.contains(id))
        {
            System.out.println("The user with that ID is not signed up yet, so cannot be enrolled, sign them up to proceed");
            signupMember();
            enrolMember();
            System.exit(0);
        }


        System.out.println("Choose plan: ");
        System.out.println("Plans available is as follows: \n" +
                "[1] Basic plan - $9.99/month \n" +
                "\t->Equipments \n" +
                "\t->Guests - $10 per session - only equipments\n" +
                "[2] Fox Plan - 19.99/month\n" +
                "\t->Equipments\n" +
                "\t->Guest Priviledges\n" +
                "\t->Free group fitness classes");
        plann = choosePlan();
        System.out.println("Choose the class: ");
        System.out.println("Plans available is as follows: \n" +
                "[1] Yoga \n" +

                "[2] Zumba\n" +
                "[3] Cardio\n");



        /*
           *Getting user details based on Id provided
         */

        member_name = members_list.get(id_list.indexOf(id)).getName();
        class_type = chooseClass();
        //Handling saving the

        Enrol enrol = new Enrol(id,member_name,plann,class_type);

        saveEnrol(enrol);



    }

    public  String choosePlan()
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
    public  String chooseClass()
    {
        System.out.println("Choose Class: ");
        int choice = input.nextInt();

        switch (choice)
        {
            case 1:
                return "Yoga";

            case 2:
                return "Zumba";
            case 3:
                return "Cardio";
            default:
                System.out.println("Wrong choice, kindly choose from available choices");
                chooseClass();
        }
        return null;
    }

    public void viewMembers()
    {
        ArrayList<Member> member_objects_list = new ArrayList();

        member_objects_list = deserializeMember();

        for(Member member: member_objects_list)
        {
            System.out.println("Membername: "+member.getName()+"\nEmail Address: "+member.getEmail()+"\n");
        }

    }
    public void saveMember(Member member) {

        System.out.println("Press 1 to save and 2 to Cancel the operation:\n[1] SAVE \n[2] CANCEL");
        int action = input.nextInt();

        switch (action) {
            case 1:
                //SAve
                serializeMember(member);
                //deserializeMember();
                break;
            case 2:
                //cancel
                System.out.println("Cancelled");
                break;
            default:
                System.out.println("Please select from the provided options!\n\n");
                saveMember(member);
                break;
        }
    }
        public void saveEnrol(Enrol enrol)
        {

            Enrol en = new Enrol();
            System.out.println("Press 1 to save and 2 to Cancel the operation:\n[1] CONFIRM ENROLMENT \n[2] CANCEL");
            int action= input.nextInt();

            switch (action){
                case 1:
                    //SAve
                    en.serializeEnrolment(enrol);
                    //deserializeMember();
                    break;
                case 2:
                    //cancel
                    System.out.println("Cancelled");
                    break;
                default:
                    System.out.println("Please select from the provided options!\n\n");
                    saveEnrol(enrol);
                    break;
            }
    }

    public void switchPlan()
    {
        System.out.println("--------------------------SWITCHING PLAN -----------------------------------\n");
        Enrol en = new Enrol();
        ArrayList<Enrol> list = en.deserializeEnrolment();

        ArrayList<Integer> id_list = new ArrayList<Integer>();
        for(Enrol enl: list)
        {
            id_list.add(enl.getMember_id_id());
        }
        int id;
        String name, address, city, email,plan;


        System.out.println("Enter the member ID: ");
        id = input.nextInt();
        if(!id_list.contains(id))
        {
            System.out.println("Member with that ID not enrolled in any plan, proceed to enrolment.");
            enrolMember();
            System.exit(0);
        }
        Enrol object_to_update = list.get(id_list.indexOf(id));
      System.out.println("You are currently enrolle on "+list.get(id_list.indexOf(id)).getPlan()+"plan" +
              " \n" +
              "[1] Basic \n" +
              "[2] Fox");
        String plan_choosen = choosePlan();
        Enrol updated_enrol = new Enrol(id,object_to_update.getName(),plan_choosen,object_to_update.getClass_type());

        list.remove(object_to_update);
        list.add(updated_enrol);

        en.serializeEnrolmentUpdate(list);
    }

    public void cancelPlan()
    {
        System.out.println("--------------------------Canceling PLAN -----------------------------------\n");
        Enrol en = new Enrol();
        ArrayList<Enrol> list = en.deserializeEnrolment();

        ArrayList<Integer> id_list = new ArrayList<Integer>();
        for(Enrol enl: list)
        {
            id_list.add(enl.getMember_id_id());
        }
        int id;
        String name, address, city, email,plan;


        System.out.println("Enter the member ID: ");
        id = input.nextInt();
        if(!id_list.contains(id))
        {
            System.out.println("Member with that ID not enrolled in any plan, proceed to enrolment.");
            enrolMember();
            System.exit(0);
        }
        Enrol object_to_update = list.get(id_list.indexOf(id));
        System.out.println("You are currently enrolle on -"+list.get(id_list.indexOf(id)).getPlan()+"- plan" +
                " \nAre you sure you want to cancel your plan? This will log you out until you enrol again.\n" +
                "[1] Confirm \n" +
                "[2] Cancel");
        int confirm_choice = input.nextInt();

        if(confirm_choice==1)
        {
            list.remove(object_to_update);
            en.serializeEnrolmentUpdate(list);
        }
        else if(confirm_choice==2)
        {
            System.out.println("You cancelled your action, thank you.");
            System.exit(0);
        }
        else {
            System.out.println("Choose from available options: ");
            cancelPlan();
        }




    }
}
