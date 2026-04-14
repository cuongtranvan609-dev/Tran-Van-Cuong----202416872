package LAB03_1404;


public class DigitalVideoDisc {
    private static int nbDigitalVideoDiscs = 0; 

    private int id; 
    private String title;
    private String category;
    private String director;
    private int length;
    private double cost;

   
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

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Constructor 1
    public DigitalVideoDisc(String title) {
        this.title = title;
        this.id = ++nbDigitalVideoDiscs;
    }

    // Constructor 2
    public DigitalVideoDisc(String category, String title, double cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }

    // Constructor 3 (đầy đủ )
    public DigitalVideoDisc(String title, String category, String director, int length, double cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }

    // toString
    @Override
    public String toString() {
        return "DVD - " + title + " - " + category + " - " + director
                + " - " + length + ": " + cost + " $";
    }

    //SEARCH
    public boolean isMatch(String title) {
        return this.title.toLowerCase().contains(title.toLowerCase());
    }

    // EQUALS
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DigitalVideoDisc)) return false;

        DigitalVideoDisc other = (DigitalVideoDisc) obj;

        return this.title.equals(other.title);
    }
}