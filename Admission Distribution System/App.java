import java.util.Scanner;

public class App {
    static AdmissionQueue admissionQueue;
    static Scanner scanner;
    static int n = 0;
    static int c = 0;

    public static void main(String[] args) {

        //int c = 0; // Entering manually number of counters
        //int n = 0; // Entering manually counter capacity

        scanner = new Scanner(System.in);

        while (c <= 0 || n <= 0) {
            System.out.println("Please provide positive value");

            System.out.println("Enter number of counters: ");
            c = Util.takePositiveIntegerInput(scanner);

            System.out.println("Enter capacity of each counter: ");
            n = Util.takePositiveIntegerInput(scanner);
        }

        admissionQueue = new AdmissionQueue(c, n);

        System.out.println("Welcome to Admission Queue");

        String userChoice;

        start: while (true) {
            System.out.print("Please enter you choice:\n1. Get Position\n2. Checkout\n3. Exit\n:");
            userChoice = scanner.nextLine();

            switch (userChoice) {
                case "1":
                    getPosition();
                    break;
                case "2":
                    checkOut();
                    break;
                case "3":
                    break start;
                default:
                    System.out.println("Invalid = " + userChoice);

            }

        }
        scanner.close();

    }

    public static void getPosition() {
        String name = "";
        String phone = "";

        while (!Util.verifyName(name)) {
            System.out.println("Only Upper case, Lower Case and space is allowed.");
            System.out.println("Enter Your Name: ");
            name = scanner.nextLine();
        }
        while (!Util.verifyPhone(phone)) {
            System.out.println("Enter Phone Number: ");
            phone = scanner.nextLine();
        }

        Student s = new Student(name, phone);
        s.setEnroll_id();
        if (!s.verify()) {
            int opcode = admissionQueue.enqueue(s);
            if (opcode != -1) {
                new WriteStudent(s).write();
                System.out.println("Please go to counter: " + s.getCounter());
            }
        } else {
            System.out.println("Student Already exist");
        }

    }
    // public static void checkOut()
    // {
    // System.out.println("Enter phone number: ");
    // String mPhone = scanner.nextLine();
    // int c = admissionQueue.search(mPhone);
    // if(c != -1){
    // Student r = admissionQueue.dequeue(c);
    // System.out.println(r);

    // }else{
    // System.out.println("No Such User");
    // }
    // }

    public static void checkOut() {
        System.out.println("Enter Counter Number: ");
        int mC = Integer.parseInt(scanner.nextLine());
        if(mC < c){
        Student dequed = admissionQueue.dequeue(mC);
        System.out.println(dequed);
        }
        else{
            System.out.println("Invalid Counter");
        }
    }
}