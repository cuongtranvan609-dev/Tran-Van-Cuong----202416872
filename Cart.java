package LAB03;
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    // ================= ADD =================
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is full");
        }
    }

    // ================= REMOVE =================
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;

        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                found = true;

                for (int j = i + 1; j < qtyOrdered; j++) {
                    itemsOrdered[j - 1] = itemsOrdered[j];
                }

                itemsOrdered[qtyOrdered - 1] = null; // clear phần tử cuối
                qtyOrdered--;

                System.out.println("The disc has been removed");
                break;
            }
        }

        if (!found) {
            System.out.println("The disc was not found");
        }
    }

    // ================= TOTAL COST =================
    public double totalCost() {
        double sum = 0;

        for (int i = 0; i < qtyOrdered; i++) {
            sum += itemsOrdered[i].getCost();
        }

        return sum;
    }

    // ================= YÊU CẦU 6 =================

    // In danh sách DVD trong cart
    public void print() {
        System.out.println("***************CART***************");

        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
        }

        System.out.println("Total cost: " + totalCost());
        System.out.println("**********************************");
    }

    // Tìm kiếm theo title
    public void search(String title) {
        boolean found = false;

        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found: " + itemsOrdered[i].toString());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching DVD found");
        }
    }
}