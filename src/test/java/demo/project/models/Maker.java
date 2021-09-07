package demo.project.models;

public class Maker {
    private String id;
    private String image;
    private String name;
    private int votes;

    public Maker () {

    }

    public Maker(String id, String image, String name, int votes) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.votes = votes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
