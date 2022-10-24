import java.util.Arrays;

public class AdmissionQueue {

    private CQueue[] admCQueues;
    private int counters;
    private int capacity;
    private boolean[] status;
    private int[] elements;

    public CQueue[] getAdmCQueues() {
        return admCQueues;
    }

    public AdmissionQueue(int c, int n) {
        counters = c;
        capacity = n;
        this.admCQueues = new CQueue[c]; // Created C counters
        this.status = new boolean[c];
        this.elements = new int[c];

        for (int i = 0; i < c; i++) {
            admCQueues[i] = new CQueue(n); // Created Queues of n member capacity in each counter
            status[i] = false;
            elements[i] = 0;
        }
        status[0] = true;
    }

    public int enqueue(Student s) // checkin
    {
        int counter = findPosition(); // Finding Available Counter

        int opCode = admCQueues[counter].enQueue(s);
        if (opCode == -1) {
            System.out.println("Please wait for someone to checkout");
        } else {
            s.setCounter(counter);
            elements[counter] = elements[counter] + 1;
        }
        return opCode;
    }

    public Student dequeue(int counter) // checkout
    {
        Student ret = admCQueues[counter].deQueue();
        elements[counter] = elements[counter] - 1; // need bug fix
        return ret;
    }

    private int findPosition() {
        int tempMin = capacity + 1, minCounter = 0, itr = 0; // -1 -> Capacity Reached
        // -2 -> Error
        for (int i = 0; i < counters; i++) {
            if (admCQueues[i].isFull() && i < counters - 1) {
                status[i + 1] = true;
            }

        }

        while (itr < counters && status[itr]) {
            if (elements[itr] < tempMin) {
                tempMin = elements[itr];
                minCounter = itr;
            }
            ++itr;
        }

        return minCounter;
    }

    @Override
    public String toString() {
        return "AdmissionQueue [admCQueues=" + Arrays.toString(admCQueues) + "]";
    }

    public int search(String mPhone) {
        for (CQueue cQueue : admCQueues) {
            if (cQueue.search(mPhone) != -1) {
                return cQueue.search(mPhone);
            }
        }
        return -1;
    }

}
