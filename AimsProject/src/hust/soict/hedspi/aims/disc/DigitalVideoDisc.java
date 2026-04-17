package hust.soict.hedspi.aims.disc;

public class DigitalVideoDisc {

    // ================= ATTRIBUTES =================
    private String title;
    private String category;
    private String director;
    private int length;
    private double cost;

    // ================= YÊU CẦU 5 =================
    // Biến static (class member) - đếm tổng số DVD đã tạo
    private static int nbDigitalVideoDiscs = 0;

    // Biến instance - mỗi DVD có id riêng
    private int id;

    // ================= GETTER =================
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

    // Getter cho id (phục vụ test yêu cầu 5)
    public int getId() {
        return id;
    }

    // ================= YÊU CẦU 3 =================
    // Setter cho title (dùng để test passing parameter)
    public void setTitle(String title) {
        this.title = title;
    }

    // ================= CONSTRUCTORS =================

    // Constructor 1: chỉ title
    public DigitalVideoDisc(String title) {
        this.title = title;
        this.id = ++nbDigitalVideoDiscs;
    }

    // Constructor 2: category, title, cost
    public DigitalVideoDisc(String category, String title, double cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }

    // Constructor 3: đầy đủ thông tin
    public DigitalVideoDisc(String title, String category, String director, int length, double cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }

    // ================= YÊU CẦU 6 =================
    // toString dùng để in thông tin DVD trong Cart
    @Override
    public String toString() {
        return "DVD - " + id + " - " + title + " - " + category + " - "
                + director + " - " + length + ": " + cost + " $";
    }

    // Hàm kiểm tra title (phục vụ search)
    public boolean isMatch(String title) {
        return this.title != null && this.title.equalsIgnoreCase(title);
    }
}