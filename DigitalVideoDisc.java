package LAB03;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private double cost;

    // ===== Getter =====
    public String getTitle() {
        return title;
    }

    // ============================
    // [YÊU CẦU 3 - PASSING PARAMETER]
    // Thêm setter cho thuộc tính title
    // Mục đích: cho phép thay đổi title của object
    // để kiểm tra cách Java truyền tham số (pass by value)
    // ============================
    public void setTitle(String title) {
        this.title = title;
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

    // ===== Constructors =====

    // Constructor 1: chỉ có title
    public DigitalVideoDisc(String title) {
        this.title = title;
    }

    // Constructor 2: category, title, cost
    public DigitalVideoDisc(String category, String title, double cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Constructor 3: đầy đủ thông tin
    public DigitalVideoDisc(String title, String category, String director, int length, double cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }
}
