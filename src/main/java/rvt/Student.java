package rvt;
//package studentu.registracija; //???

public class Student {
    private String vards;
    private String uzvards;
    private String epasts;
    private String persKods;
    private String regLaiks;

    public Student(String vards, String uzvards, String epasts, String persKods, String regLaiks) {
        this.vards = vards;
        this.uzvards = uzvards;
        this.epasts = epasts;
        this.persKods = persKods;
        this.regLaiks = regLaiks;
    }

    // Getteri (nepieciešami tabulas izvadei un saglabāšanai)
    public String getVards() { return vards; }
    public String getUzvards() { return uzvards; }
    public String getEpasts() { return epasts; }
    public String getPersKods() { return persKods; }
    public String getRegLaiks() { return regLaiks; }

    // Setteri (nepieciešami datu maiņai)
    public void setVards(String vards) { this.vards = vards; }
    public void setUzvards(String uzvards) { this.uzvards = uzvards; }
    public void setEpasts(String epasts) { this.epasts = epasts; }

    public String toCsvRow() {
        return String.join(",", vards, uzvards, epasts, persKods, regLaiks);
    }
}