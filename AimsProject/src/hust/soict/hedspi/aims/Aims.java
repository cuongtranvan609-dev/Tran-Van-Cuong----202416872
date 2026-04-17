package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99);

        cart.addDigitalVideoDisc(dvd1);
        cart.addDigitalVideoDisc(dvd2);
        cart.addDigitalVideoDisc(dvd3);

        System.out.println("Total cost is: " + cart.totalCost());

        cart.removeDigitalVideoDisc(dvd3);

        System.out.println("Total cost after removal: " + cart.totalCost());
    }
}

