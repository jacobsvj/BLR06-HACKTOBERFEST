import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

class Student{
    private String id;
    private String name;
    private String address;
    private String phone;

    private int[] marks = new int[4];

    public Student(String id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMarks(int m,int e,int p,int g){
        marks[0] = m;
        marks[1] = e;
        marks[2] = p;
        marks[3] = g;
    }

    @Override
    public String toString() {
        return "Student [address=" + address + ", id=" + id + ", marks=" + Arrays.toString(marks) + ", name=" + name
                + ", phone=" + phone + "]";
    }
}

class Write
{
    public static void writeToBinary(Student s)
    {
        File file = new File("StudentData.txt");
        byte[] bytes = s.toString().getBytes(StandardCharsets.UTF_8);

        try (FileOutputStream fos = new FileOutputStream(file))
        {
            fos.write(bytes);
            System.out.println("Successfully written data to the file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Dev {
    static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        String name, address,id,phone;
        int m,e,p,g;
        System.out.println("Enter Student Details");
        System.out.println("Enter Student Name: ");
        name = sc.nextLine();
        System.out.println("Enter Student Address: ");
        address = sc.nextLine();
        System.out.println("Enter Student id: ");
        id = sc.nextLine();
        System.out.println("Enter Student Phone: ");
        phone = sc.nextLine();

        System.out.println("Enter Maths marks: ");
        m = Integer.parseInt(sc.nextLine());
        System.out.println("Enter English marks: ");
        e = Integer.parseInt(sc.nextLine());
        System.out.println("Enter Physics marks: ");
        p = Integer.parseInt(sc.nextLine());
        System.out.println("Enter Geography marks: ");
        g = Integer.parseInt(sc.nextLine());

        Student s = new Student(id, name, address, phone);
        s.setMarks(m,e,p,g);

        Write.writeToBinary(s);
        System.out.println(s);
    }
}