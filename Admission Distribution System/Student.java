

public class Student {
    private String name;
    private String enroll_id;
    private String phone;
    private int counter;


    public Student(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getEnroll_id() {
        if (enroll_id.isEmpty()) {
            return "Not enrolled";
        }
        return enroll_id;
    }

    public void setEnroll_id() {
        this.enroll_id = this.phone.substring(6, 10) + this.name.substring(0, 4) + "";
    }

    @Override
    public String toString() {
        return "Student [enroll_id=" + enroll_id + ", name=" + name + ", phone=" + phone + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (enroll_id == null) {
            if (other.enroll_id != null)
                return false;
        } else if (!enroll_id.equals(other.enroll_id))
            return false;
        if (phone == null) {
            if (other.phone != null)
                return false;
        } else if (!phone.equals(other.phone))
            return false;
        return true;
    }

    public boolean verify(){
        ReadStudent readStudent = new ReadStudent();
        String s =  readStudent.read();
        if(s.contains(enroll_id)){
            return true;
        }
        return false;
    }

    


}
