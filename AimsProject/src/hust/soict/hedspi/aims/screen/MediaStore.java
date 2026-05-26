package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Disc;
import hust.soict.hedspi.aims.cart.Cart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnAddToCart = new JButton("Add to cart");
        btnAddToCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cart.addMedia(media);
                    JOptionPane.showMessageDialog(null,
                        "Successfully added '" + media.getTitle() + "' to the cart!",
                        "Add to Cart",
                        JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,
                        ex.getMessage(),
                        "Add to Cart Error",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        container.add(btnAddToCart);

        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            btnPlay.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        ((Playable) media).play();
                        
                        // Show play dialog
                        JDialog dialog = new JDialog();
                        dialog.setTitle("Playing: " + media.getTitle());
                        dialog.setSize(350, 150);
                        dialog.setModal(true);
                        dialog.setLayout(new BorderLayout());
                        
                        String infoHtml = "<html><div style='text-align: center; font-size: 13px;'>"
                                + "Playing " + media.getClass().getSimpleName() + ": <br/>"
                                + "<b>" + media.getTitle() + "</b>";
                        if (media instanceof Disc) {
                            infoHtml += "<br/>Length: " + ((Disc) media).getLength() + " mins";
                        }
                        infoHtml += "</div></html>";
                        
                        JLabel msg = new JLabel(infoHtml, SwingConstants.CENTER);
                        dialog.add(msg, BorderLayout.CENTER);
                        
                        JButton closeBtn = new JButton("Close");
                        closeBtn.addActionListener(evt -> dialog.dispose());
                        JPanel p = new JPanel(new FlowLayout());
                        p.add(closeBtn);
                        dialog.add(p, BorderLayout.SOUTH);
                        
                        dialog.setLocationRelativeTo(null);
                        dialog.setVisible(true);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null,
                            ex.getMessage(),
                            "Player Error",
                            JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            container.add(btnPlay);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
