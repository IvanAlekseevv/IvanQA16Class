package QA16a.model;

import java.util.Objects;

public class GroupData {
    private int id;
    private  String name;
    private  String header;
    private  String footer;


    public GroupData setName(String name) {
        this.name = name;
        return this;
    }

    public int getId() {
        return id;
    }

    public GroupData setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ",Name=" + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return Objects.equals(name, groupData.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    public GroupData setHeader(String header) {
        this.header = header;
        return this;
    }

    public GroupData setFooter(String footer) {
        this.footer = footer;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getHeader() { return header;
    }

    public String getFooter() {
        return footer;
    }
}
