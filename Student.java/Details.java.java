package college;

public class Details {
    private String name;
    private int rno;
    private String dept;
    private String transport;
    private String gender;
    private String mobile;
    private String email;

    public Details(String name, int rno, String dept, String transport, String gender, String mobile, String email) {
        this.name = name;
        this.rno = rno;
        this.dept = dept;
        this.transport = transport;
        this.gender = gender;
        this.mobile = mobile;
        this.email = email;
    }

    public String getName() { return name; }
    public int getRno() { return rno; }
    public String getDept() { return dept; }
    public String getTransport() { return transport; }
    public String getGender() { return gender; }

    public String toString() {
        return "Name      : " + name +
               "\nRoll No   : " + rno +
               "\nDept      : " + dept +
               "\nTransport : " + transport +
               "\nGender    : " + gender +
               "\nMobile    : " + mobile +
               "\nEmail     : " + email;
    }
}
