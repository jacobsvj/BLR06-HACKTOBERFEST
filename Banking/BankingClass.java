
abstract class Account {
    abstract void calculateInterest();
}

class SBAccount extends Account {

    public void calculateInterest() {
        System.out.println("SBAccount Interest calculated.");
    }
}
class DAAccount extends Account {

    public void calculateInterest() {
        System.out.println("DAAccount Interest calculated.");
    }
}
class FDAccount extends Account {

    public void calculateInterest() {
        System.out.println("FDAccount Interest calculated.");
    }
}

class Main {
    public static void main(String[] args) {

        SBAccount sba = new SBAccount();
        DAAccount da = new DAAccount();
        FDAccount fda = new FDAccount();

        sba.calculateInterest();
        da.calculateInterest();
        fda.calculateInterest();
    }
}