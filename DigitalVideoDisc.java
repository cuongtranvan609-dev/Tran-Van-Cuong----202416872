package LAB02_3103;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private double cost;

    // Getter
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public double getCost() {
        return cost;
    }

    // Constructor 1: chỉ title
    public DigitalVideoDisc(String title) {
        this.title = title;
    }

    // Constructor 2: category, title, cost
    public DigitalVideoDisc(String category, String title, double cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Constructor 3: đầy đủ
    public DigitalVideoDisc(String title, String category, String director, int length, double cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }
}