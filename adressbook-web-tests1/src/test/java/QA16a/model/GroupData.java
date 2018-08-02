package QA16a.model;

public class GroupData {
    private  String name;
    private  String header;
    private  String footer;


    public GroupData setName(String name) {
        this.name = name;
        return this;
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

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }
}
