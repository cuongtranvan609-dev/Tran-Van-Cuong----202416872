package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc() {
        super();
    }

    public DigitalVideoDisc(int id, String title, String category, float cost,
                             int length, String director) {
        super(id, title, category, cost, length, director);
        if (id > nbDigitalVideoDiscs) {
            nbDigitalVideoDiscs = id;
        }
    }

    public DigitalVideoDisc(String title) {
        super(++nbDigitalVideoDiscs, title, null, 0.0f, 0, null);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, 0, null);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, length, director);
    }

    @Override
    public void play() throws PlayerException {
        if (getLength() <= 0) {
            throw new PlayerException("ERROR: DVD '" + getTitle() + "' length is non-positive (" + getLength() + ")!");
        } else {
            System.out.println("Playing DVD: " + getTitle());
            System.out.println("DVD length: " + getLength());
        }
    }

    @Override
    public String toString() {
        return "DVD - Title: " + getTitle()
            + " | Category: " + getCategory()
            + " | Director: " + getDirector()
            + " | Length: " + getLength()
            + " | Cost: " + getCost() + "$";
    }
}