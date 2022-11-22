import java.io.*;
import java.util.ArrayList;

public class Enrol implements java.io.Serializable{
    private int member_id;
    private String name, plan, class_type;

    public Enrol() {
    }

    public Enrol(int member_id, String name, String plan, String class_type) {
        this.member_id = member_id;
        this.name = name;
        this.plan = plan;
        this.class_type = class_type;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public void setClass_type(String class_type) {
        this.class_type = class_type;
    }


    public int getMember_id_id() {
        return member_id;
    }

    public String getName() {
        return name;
    }

    public String getPlan() {
        return plan;
    }

    public String getClass_type() {
        return class_type;
    }





    public void serializeEnrolment(Enrol enrol)
    {
        ArrayList<Enrol> enrols_list;

        enrols_list = deserializeEnrolment();

        try {
            enrols_list.add(enrol);
            FileOutputStream fileOut =
                    new FileOutputStream("enrolment.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(enrols_list);
            out.close();
            fileOut.close();
            System.out.printf("Errolment done successfully!");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public ArrayList<Enrol> deserializeEnrolment()
    {
        ArrayList<Enrol> enrol_list= new ArrayList();
        try {
            FileInputStream fileIn = new FileInputStream("enrolment.ser");
            ObjectInputStream object_input = new ObjectInputStream(fileIn);
            enrol_list =  (ArrayList<Enrol>) object_input.readObject();
            object_input.close();
            fileIn.close();
        } catch (IOException i) {
            //i.printStackTrace();
            System.out.println("No records found, none might might have been created before.");
            return enrol_list;
        } catch (ClassNotFoundException c) {
            System.out.println("Enrol class not found");
            c.printStackTrace();
            return enrol_list;
        }

        System.out.println("Deserialized enrolments...");


        return enrol_list;
    }


    public void serializeEnrolmentUpdate(ArrayList<Enrol> enrols_list)
    {


        try {

            FileOutputStream fileOut =
                    new FileOutputStream("enrolment.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(enrols_list);
            out.close();
            fileOut.close();
            System.out.printf("Plan switching done successfully!");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /*
     * ----------------------------------------Enrolment------------------------------------
     */
}
