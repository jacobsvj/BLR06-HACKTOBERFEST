import java.io.FileWriter;
import java.io.IOException;

public class WriteStudent {
    private Student student;
    private String fileName;

    public WriteStudent(Student student) {
        this.student = student;

    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void write() {
        String text = student.toString() + "\n";

        try {

            fileName = "File/" + java.time.LocalDate.now();
            FileWriter fWriter = new FileWriter(fileName, true);
            FileWriter fWriter2 = new FileWriter("EID", true);
            fWriter.write(text);
            fWriter2.write(student.getEnroll_id()+"\n");

            System.out.println(text);

            fWriter.close();
            fWriter2.close();

            System.out.println("File is created successfully with the content.");
        }

        catch (IOException e) {

            // Print the exception
            System.out.print(e.getMessage());
        }
    }

}
