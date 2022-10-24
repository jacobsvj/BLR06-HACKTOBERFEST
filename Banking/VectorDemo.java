import java.util.*;

public class VectorDemo {

    public static void main(String[] args){
        Vector v1 = new Vector(5,2);
        System.out.println(v1.size());
        System.out.println(v1.capacity());

        v1.add(21);
        v1.add(33.33);
        v1.add(2.1f);
        v1.add("Akash");
        v1.add(true);

        System.out.println(v1);

        v1.add('c');

        System.out.println(v1.size());
        System.out.println(v1.capacity());
        System.out.println(v1.toString());

    }
}
