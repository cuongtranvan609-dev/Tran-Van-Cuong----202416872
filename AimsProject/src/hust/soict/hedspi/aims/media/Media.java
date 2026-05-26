package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media {

    private int id;
    private String title;
    private String category;
    private float cost;

    // Comparators (Section 12)
    public static final Comparator<Media> COMPARE_BY_TITLE_COST =
        Comparator.comparing(Media::getTitle)
                  .thenComparing(Comparator.comparingDouble(Media::getCost).reversed());

    public static final Comparator<Media> COMPARE_BY_COST_TITLE =
        Comparator.comparingDouble(Media::getCost).reversed()
                  .thenComparing(Media::getTitle);

    // Constructors
    public Media() {}

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public float getCost() { return cost; }
    public void setCost(float cost) { this.cost = cost; }

    // Override equals: two Media are equal if they have the same title (Section 10)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Media)) return false;
        Media other = (Media) o;
        return this.title != null && this.title.equals(other.title);
    }

    @Override
    public abstract String toString();
}