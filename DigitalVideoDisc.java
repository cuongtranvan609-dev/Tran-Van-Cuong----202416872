package LAB03;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private double cost;

    // ============================
    // [YÊU CẦU 5 - CLASS MEMBERS]
    // nbDigitalVideoDiscs: biến static dùng chung cho toàn bộ class
    // dùng để đếm số lượng DVD đã được tạo
    // ============================
    private static int nbDigitalVideoDiscs = 0;

    // id: biến instance, mỗi object có giá trị riêng
    private int id;

    // ===== Getter =====
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

    // Getter cho id (phục vụ test)
    public int getId() {
        return id;
    }

    // ===== Constructors =====

    // Constructor 1: chỉ title
    public DigitalVideoDisc(String title) {
        this.title = title;
        this.id = ++nbDigitalVideoDiscs; // tăng biến đếm và gán id
    }

    // Constructor 2: category, title, cost
    public DigitalVideoDisc(String category, String title, double cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }

    // Constructor 3: đầy đủ
    public DigitalVideoDisc(String title, String category, String director, int length, double cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }
}