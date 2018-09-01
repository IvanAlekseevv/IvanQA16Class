package QA16a.model;

import java.io.File;
import java.util.Objects;

public class ContactData {
    private int id;
    private  String firstname;
    private  String lastname;
    private  String nickname;
    private  String address;
    private  String company;
    private File photo;
    private String group;

    public String getGroup() {
        return group;
    }



    public File getPhoto() {
        return photo;
    }



    public ContactData setId(int id) {
        this.id = id;
        return this;
    }


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

    public ContactData setPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public ContactData setGroup(String group) {
        this.group = group;
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


    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstname, lastname);
    }
}
