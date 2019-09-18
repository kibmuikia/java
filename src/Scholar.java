import java.util.Date;

public class Scholar {
    String name;
    Date dateBirth;
    String RegNo;
    String course;

    public Scholar(String name, Date dateBirth, String RegNo, String course){
        this.name=name;
        this.dateBirth=dateBirth;
        this.RegNo=RegNo;
        this.course=course;


    }

    public String getName() {
        return name;
    }



    public Date getDateBirth() {
        return dateBirth;
    }


    public String getRegNo() {
        return RegNo;
    }



    public String getCourse() {
        return course;
    }


}
