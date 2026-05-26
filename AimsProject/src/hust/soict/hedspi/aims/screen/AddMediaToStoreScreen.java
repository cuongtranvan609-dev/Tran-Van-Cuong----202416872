package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.cart.Cart;

import javax.swing.*;
import java.awt.*;

public abstract class AddMediaToStoreScreen extends JFrame {
    protected Store store;
    protected Cart cart;
    protected JPanel formPanel;

    public AddMediaToStoreScreen(Store store, Cart cart, String title) {
        this.store = store;
        this.cart = cart;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        // Create common MenuBar
        cp.add(createMenuBar(), BorderLayout.NORTH);

        // Center panel for input fields
        formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        cp.add(formPanel, BorderLayout.CENTER);

        // Submit Button Panel in the south
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnSubmit = new JButton("Add Item");
        btnSubmit.addActionListener(e -> {
            try {
                boolean success = handleAdd();
                if (success) {
                    JOptionPane.showMessageDialog(this, 
                        "Item added to store successfully!", 
                        "Success", 
                        JOptionPane.INFORMATION_MESSAGE);
                    // Return to Store screen
                    new StoreScreen(store, cart);
                    this.dispose();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                    "Invalid number format: please check ID, Cost, or Length fields.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        });
        buttonPanel.add(btnSubmit);
        cp.add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setSize(500, 450);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> {
            new AddBookToStoreScreen(store, cart);
            this.dispose();
        });
        smUpdateStore.add(addBook);

        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> {
            new AddCDToStoreScreen(store, cart);
            this.dispose();
        });
        smUpdateStore.add(addCD);

        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> {
            new AddDVDToStoreScreen(store, cart);
            this.dispose();
        });
        smUpdateStore.add(addDVD);

        menu.add(smUpdateStore);

        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(e -> {
            new StoreScreen(store, cart);
            this.dispose();
        });
        menu.add(viewStore);

        JMenuItem viewCart = new JMenuItem("View cart");
        viewCart.addActionListener(e -> {
            new CartScreen(store, cart);
            this.dispose();
        });
        menu.add(viewCart);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    // GridBagConstraints helper
    protected void addFormField(String labelText, JComponent field, int row) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(8, 8, 8, 8);

        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0.3;
        formPanel.add(new JLabel(labelText), gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.weightx = 0.7;
        formPanel.add(field, gbc);
    }

    protected abstract boolean handleAdd() throws Exception;
}
