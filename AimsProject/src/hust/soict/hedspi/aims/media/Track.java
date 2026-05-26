package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class Track implements Playable {

    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() { return title; }
    public int getLength() { return length; }

    // Override equals: two Tracks are equal if same title AND same length (Section 10)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Track)) return false;
        Track other = (Track) o;
        return this.length == other.length
            && this.title != null && this.title.equals(other.title);
    }

    @Override
    public void play() throws PlayerException {
        if (length <= 0) {
            throw new PlayerException("ERROR: Track '" + title + "' length is non-positive (" + length + ")!");
        } else {
            System.out.println("  Playing track: " + title);
            System.out.println("  Track length: " + length);
        }
    }

    @Override
    public String toString() {
        return "Track{title='" + title + "', length=" + length + "}";
    }
}