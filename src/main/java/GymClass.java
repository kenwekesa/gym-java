import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GymClass implements java.io.Serializable{

    private int id;
    private String class_name, tutor;

    public GymClass() {
    }

    public GymClass(int id, String class_name, String tutor) {
        this.id = id;
        this.class_name = class_name;
        this.tutor = tutor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }


    public void generateSchedule()
    {
        ArrayList<String> tutors = new ArrayList();
        ArrayList<String> classNames = new ArrayList();

        tutors.add("Alex");
        tutors.add("Peter");
        tutors.add("Lucy");
        tutors.add("Tifanny");
        tutors.add("Wanjala");
        tutors.add("Wanjala");
        tutors.add("Ashley");
        tutors.add("Moma");

        classNames.add("Yoga");
        classNames.add("Cardio");
        classNames.add("Zumba");

        ArrayList<GymClass> classes_list = new ArrayList();

       for(int i = 0;i<=42;i++)
       {
           /*
                *Randomly generate a class on the schedule
            */
           GymClass gym_class = new GymClass(i+1, classNames.get(0 + (int)(Math.random() * ((2 - 0) + 1))),tutors.get(0 + (int)(Math.random() * ((7 - 0) + 1))));


           classes_list.add(gym_class);
       }

       serializeSchedule(classes_list);


    }

    public static void serializeSchedule(ArrayList<GymClass> schedule)
    {




        try {

            FileOutputStream fileOut =
                    new FileOutputStream("schedule.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(schedule);
            out.close();
            fileOut.close();
            System.out.printf("Schedule generated successfully!");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static ArrayList<GymClass> deserializeSchedule()
    {
        ArrayList<GymClass> classList= new ArrayList();
        try {
            FileInputStream fileIn = new FileInputStream("schedule.ser");
            ObjectInputStream object_input = new ObjectInputStream(fileIn);
            classList =  (ArrayList<GymClass>) object_input.readObject();
            object_input.close();
            fileIn.close();
        } catch (IOException i) {
            //i.printStackTrace();
            System.out.println("No class schedule available yet");
            return classList;
        } catch (ClassNotFoundException c) {
            System.out.println("Membere class not found");
            c.printStackTrace();
            return classList;
        }

        System.out.println("Deserialized members...");


        return classList;
    }



    public void displaySchedule()
    {
        ArrayList<GymClass> schedule =  deserializeSchedule();

        System.out.println("-----------THIS MONTH CLASS SCHEDULE----------------" +
                        "\nMONDAY\n" +
                        "\t-  8.00 - 9.00 am \t\t"+schedule.get(0).class_name+"("+schedule.get(0).getTutor()+")\n" +
                        "\t-  9.00 - 10.00 am : No Class\n"+
                        "\t-  11.00 - 12.00 am \t\t"+schedule.get(1).class_name+"("+schedule.get(1).getTutor()+")\n" +
                        "\t-  2.00 - 3.00 pm \t\t"+schedule.get(2).class_name+"("+schedule.get(2).getTutor()+")\n" +
                        "\t-  5.00 - 6.00 pm \t\t"+schedule.get(2).class_name+"("+schedule.get(3).getTutor()+")\n" +
                        "\t-  7.00 - 8.00 pm \t\t"+schedule.get(4).class_name+"("+schedule.get(4).getTutor()+")\n" +
                        "\t-  8.00 - 9.00 pm \t\t"+schedule.get(5).class_name+"("+schedule.get(5).getTutor()+")\n"
        );



                System.out.println("\n\n-" +
                "\nMONDAY\n" +
                "\t-  8.00 - 9.00 am \t\t"+schedule.get(6).class_name+"("+schedule.get(6).getTutor()+")\n" +
                "\t-  9.00 - 10.00 am : No Class\n"+
                "\t-  11.00 - 12.00 am \t\t"+schedule.get(7).class_name+"("+schedule.get(7).getTutor()+")\n" +
                "\t-  2.00 - 3.00 pm \t\t"+schedule.get(8).class_name+"("+schedule.get(8).getTutor()+")\n" +
                "\t-  5.00 - 6.00 pm \t\t"+schedule.get(9).class_name+"("+schedule.get(9).getTutor()+")\n" +
                "\t-  7.00 - 8.00 pm \t\t"+schedule.get(10).class_name+"("+schedule.get(10).getTutor()+")\n" +
                "\t-  8.00 - 9.00 pm \t\t"+schedule.get(11).class_name+"("+schedule.get(11).getTutor()+")\n"

        );

        System.out.println("\n\n-" +
                "\nWEDNESDAY\n" +
                "\t-  8.00 - 9.00 am \t\t"+schedule.get(12).class_name+"("+schedule.get(12).getTutor()+")\n" +
                "\t-  9.00 - 10.00 am :\t\t"+schedule.get(13).class_name+"("+schedule.get(13).getTutor()+")\n" +
                "\t-  11.00 - 12.00 am \t\t"+schedule.get(14).class_name+"("+schedule.get(14).getTutor()+")\n" +
                "\t-  2.00 - 3.00 pm \t\t"+schedule.get(15).class_name+"("+schedule.get(15).getTutor()+")\n" +
                "\t-  5.00 - 6.00 pm \t\t"+schedule.get(16).class_name+"("+schedule.get(16).getTutor()+")\n" +
                "\t-  7.00 - 8.00 pm \t\t"+schedule.get(17).class_name+"("+schedule.get(17).getTutor()+")\n" +
                "\t-  8.00 - 9.00 pm \t\t"+schedule.get(18).class_name+"("+schedule.get(18).getTutor()+")\n"

        );

        System.out.println("\n\n-" +
                "\nTHURSDAY\n" +
                "\t-  8.00 - 9.00 am \t\t"+schedule.get(19).class_name+"("+schedule.get(19).getTutor()+")\n" +
                "\t-  9.00 - 10.00 am :\t\t"+schedule.get(20).class_name+"("+schedule.get(20).getTutor()+")\n" +
                "\t-  11.00 - 12.00 am \t\t"+schedule.get(21).class_name+"("+schedule.get(21).getTutor()+")\n" +
                "\t-  2.00 - 3.00 pm \t\t"+schedule.get(22).class_name+"("+schedule.get(22).getTutor()+")\n" +
                "\t-  5.00 - 6.00 pm \t\t"+schedule.get(23).class_name+"("+schedule.get(23).getTutor()+")\n" +
                "\t-  7.00 - 8.00 pm \t\t"+schedule.get(24).class_name+"("+schedule.get(24).getTutor()+")\n" +
                "\t-  8.00 - 9.00 pm \t\t"+schedule.get(25).class_name+"("+schedule.get(25).getTutor()+")\n"

        );

        System.out.println("\n\n-" +
                "\nFRIDAY\n" +
                "\t-  8.00 - 9.00 am \t\t"+schedule.get(26).class_name+"("+schedule.get(26).getTutor()+")\n" +
                "\t-  9.00 - 10.00 am :\t\t"+schedule.get(27).class_name+"("+schedule.get(27).getTutor()+")\n" +
                "\t-  11.00 - 12.00 am \t\t"+schedule.get(28).class_name+"("+schedule.get(28).getTutor()+")\n" +
                "\t-  2.00 - 3.00 pm \t\t"+schedule.get(29).class_name+"("+schedule.get(29).getTutor()+")\n" +
                "\t-  5.00 - 6.00 pm \t\t"+schedule.get(30).class_name+"("+schedule.get(30).getTutor()+")\n" +
                "\t-  7.00 - 8.00 pm \t\t"+schedule.get(31).class_name+"("+schedule.get(31).getTutor()+")\n" +
                "\t-  8.00 - 9.00 pm \t\t"+schedule.get(32).class_name+"("+schedule.get(32).getTutor()+")\n"

        );


        System.out.println("\n\n-" +
                "\nSATURDAY\n" +
                "\t-  8.00 - 9.00 am \t\t"+schedule.get(33).class_name+"("+schedule.get(33).getTutor()+")\n" +
                "\t-  9.00 - 10.00 am :\t\t"+schedule.get(34).class_name+"("+schedule.get(34).getTutor()+")\n" +
                "\t-  11.00 - 12.00 am \t\t"+schedule.get(35).class_name+"("+schedule.get(35).getTutor()+")\n" +
                "\t-  2.00 - 3.00 pm \t\t"+schedule.get(36).class_name+"("+schedule.get(36).getTutor()+")\n" +
                "\t-  5.00 - 6.00 pm \t\t"+schedule.get(37).class_name+"("+schedule.get(37).getTutor()+")\n" +
                "\t-  7.00 - 8.00 pm \t\tNo class\n"+
                "\t-  8.00 - 9.00 pm \t\tNo Class"

        );


        System.out.println("\n\n-" +
                "\nSUNDAY\n" +
                "\t-  8.00 - 9.00 am \t\t"+schedule.get(38).class_name+"("+schedule.get(38).getTutor()+")\n" +
                "\t-  9.00 - 10.00 am :\t\t"+schedule.get(39).class_name+"("+schedule.get(39).getTutor()+")\n" +
                "\t-  11.00 - 12.00 am \t\t"+schedule.get(40).class_name+"("+schedule.get(40).getTutor()+")\n" +
                "\t-  2.00 - 3.00 pm \t\t"+schedule.get(41).class_name+"("+schedule.get(41).getTutor()+")\n" +
                "\t-  5.00 - 6.00 pm \t\t"+schedule.get(42).class_name+"("+schedule.get(42).getTutor()+")\n" +
                "\t-  7.00 - 8.00 pm \t\tNo Class\n"+
                "\t-  8.00 - 9.00 pm \t\tNo class"

        );



    }

}
