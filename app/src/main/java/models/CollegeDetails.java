package models;

public class CollegeDetails {

    String name;
    String domain;
    String email;
    String contact;

    public CollegeDetails(String na, String dom, String ema, String con){
        this.name = na;
        this.domain = dom;
        this.email = ema;
        this.contact = con;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
