import java.util.ArrayList;
import java.util.List;

public class GymClass {

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
        //List tutors = ["Alex","Peter","Lucy","Tifanny"];
        //List classNames =["Yoga","Cardio","Zumba"];

        //ArrayList<Class> classes_list = new ArrayList();


    }
}
