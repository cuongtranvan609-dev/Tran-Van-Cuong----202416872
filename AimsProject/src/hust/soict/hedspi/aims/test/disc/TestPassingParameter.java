package hust.soict.hedspi.aims.test.disc;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
    	
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        System.out.println("--- Before any changes ---");
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        // Thử nghiệm hàm swap gốc trong Lab (không hoạt động) 

        swap(jungleDVD, cinderellaDVD);
        System.out.println("\n--- After original swap (No change) ---");
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
        
        // Thử nghiệm hàm thay đổi tiêu đề

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("\n--- After changeTitle ---");
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        
        // Thử nghiệm hàm hoán đổi đúng (Yêu cầu bổ sung)
        
        correctSwap(jungleDVD, cinderellaDVD);
        System.out.println("\n--- After correctSwap (Swapped) ---");
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        
    }

    // Phương thức swap gốc của Lab: không thay đổi được biến bên ngoài vì Java truyền tham trị 
    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }
  // Phương thức thay đổi tiêu đề theo mẫu của Lab 
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle); 
    }

    // Phương thức hoán đổi chính xác: hoán đổi giá trị thuộc tính bên trong vùng nhớ 
    public static void correctSwap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        String tmpTitle = dvd1.getTitle();
        dvd1.setTitle(dvd2.getTitle());
        dvd2.setTitle(tmpTitle);
    }

    }