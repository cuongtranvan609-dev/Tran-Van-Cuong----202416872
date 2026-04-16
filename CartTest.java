package LAB03;
//yc6
public class CartTest {
 public static void main(String[] args) {
     // Tạo một giỏ hàng mới
     Cart cart = new Cart();

     // Tạo DVD
     DigitalVideoDisc dvd1 = new DigitalVideoDisc(
         "The Lion King", "Hoạt hình", "Roger Allers", 87, 19.95f);
     cart.addDigitalVideoDisc(dvd1);

     DigitalVideoDisc dvd2 = new DigitalVideoDisc(
         "Star Wars", "Khoa học viễn tưởng", "George Lucas", 87, 24.95f);
     cart.addDigitalVideoDisc(dvd2);

     DigitalVideoDisc dvd3 = new DigitalVideoDisc(
         "Aladin", "Hoạt hình", 18.99f);
     cart.addDigitalVideoDisc(dvd3);

     // ===== TEST PRINT =====
     cart.print();

     // ===== TEST SEARCH =====
     System.out.println("\nSearch results:");

     cart.search("Star Wars");   // có
     cart.search("Harry Potter"); // không có
 }
}