package rvt;

public class Person {

    private String name;
    private String adress;

    public Person(String name, String adress) {
        this.name = name;
        this.adress = adress;
    }

    public String getName() {
        return this.name;
    }
    
    public String getAdress() {
        return this.adress;
    }

    public String toString() {
        return this.name + "\n  " + this.adress;
    }
}
