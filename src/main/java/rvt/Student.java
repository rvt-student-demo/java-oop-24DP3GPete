package rvt;

public class Student extends Person{
    private int credits;
    public Student(String name, String adress) {
        super(name, adress);
    }

    public void study() {
            credits += 1;
    }

    public int credits() {
        return credits;
    }

    @Override
    public String toString() {
        return this.getName() + "\n  " + this.getAdress() + "\n  Study credits: " + this.credits;
    }
}
