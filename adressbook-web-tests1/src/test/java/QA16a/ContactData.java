package QA16a;

public class ContactData {
    private final String firstname;
    private final String lastname;
    private final String nickname;
    private final String address;
    private final String company;



    public ContactData(String firstname, String lastname, String nickname, String address, String company ) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.nickname = nickname;
        this.address = address;
        this.company = company;


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
