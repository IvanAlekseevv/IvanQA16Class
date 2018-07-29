package QA16a;

public class ContactData {
    private  String firstname;
    private  String lastname;
    private  String nickname;
    private  String address;
    private  String company;





    public ContactData setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public ContactData setAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData setCompany(String company) {
        this.company = company;
        return this;
    }
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() { return nickname; }

    public String getAddress() {
        return address;
    }

    public String getCompany() {
        return company;
    }



}
