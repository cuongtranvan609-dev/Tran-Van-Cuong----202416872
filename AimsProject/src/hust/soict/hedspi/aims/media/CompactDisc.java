package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {

    private String artist;
    private List<Track> tracks = new ArrayList<>();

    public CompactDisc() {
        super();
    }

    public CompactDisc(int id, String title, String category, float cost,
                        String director, String artist) {
        super(id, title, category, cost, 0, director);
        this.artist = artist;
    }

    public String getArtist() { return artist; }

    // Length of CD = sum of all track lengths
    @Override
    public int getLength() {
        int total = 0;
        for (Track t : tracks) {
            total += t.getLength();
        }
        return total;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track '" + track.getTitle() + "' is already in the CD.");
        } else {
            tracks.add(track);
            System.out.println("Track '" + track.getTitle() + "' added.");
        }
    }

    public void removeTrack(Track track) {
        if (!tracks.contains(track)) {
            System.out.println("Track '" + track.getTitle() + "' is not in the CD.");
        } else {
            tracks.remove(track);
            System.out.println("Track '" + track.getTitle() + "' removed.");
        }
    }

    @Override
    public void play() throws PlayerException {
        int totalLength = getLength();
        if (totalLength <= 0) {
            throw new PlayerException("ERROR: CD '" + getTitle() + "' total length is non-positive (" + totalLength + ")!");
        }
        System.out.println("Playing CD: " + getTitle());
        System.out.println("CD length: " + totalLength);
        for (Track t : tracks) {
            t.play();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CD - Title: ").append(getTitle())
          .append(" | Category: ").append(getCategory())
          .append(" | Artist: ").append(artist)
          .append(" | Director: ").append(getDirector())
          .append(" | Length: ").append(getLength())
          .append(" | Cost: ").append(getCost()).append("$");
        sb.append("\n  Tracks:");
        for (Track t : tracks) {
            sb.append("\n    ").append(t.toString());
        }
        return sb.toString();
    }
}