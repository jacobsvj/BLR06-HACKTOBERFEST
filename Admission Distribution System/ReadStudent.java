import java.io.FileReader;
import java.util.ArrayList;

public class ReadStudent {
    ArrayList<Student> students;
    String startDate = "";
    String endDate = "";

    public ReadStudent() {
        students = new ArrayList<>();
    }

    public ReadStudent(String startDate) {
        students = new ArrayList<>();
        this.startDate = startDate;
    }

    public ReadStudent(String startDate, String endDate) {
        students = new ArrayList<>();
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String read() {
        String data = "";
        try
        {
            FileReader fr=new FileReader("EID");    
            int i;    
            while((i=fr.read())!=-1)    
            //System.out.print((char)i);
            data = data + (char)i;
            fr.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return data;
    }

}
