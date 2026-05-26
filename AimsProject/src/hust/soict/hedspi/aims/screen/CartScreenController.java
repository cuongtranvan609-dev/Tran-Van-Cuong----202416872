package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Disc;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.JFrame;

public class CartScreenController {
    private Store store;
    private Cart cart;
    private JFrame parentFrame;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Label lblTotal;

    @FXML
    private Button btnPlaceOrder;

    private FilteredList<Media> filteredList;

    public CartScreenController(Store store, Cart cart, JFrame parentFrame) {
        super();
        this.store = store;
        this.cart = cart;
        this.parentFrame = parentFrame;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        filteredList = new FilteredList<>(cart.getItemsOrdered(), p -> true);
        tblMedia.setItems(filteredList);

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        // Add Selection Listener
        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                if (newValue != null) {
                    updateButtonBar(newValue);
                } else {
                    btnPlay.setVisible(false);
                    btnRemove.setVisible(false);
                }
            }
        });

        // Add Filter Text Listener
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });

        // Add RadioButton Filter Mode Listeners
        radioBtnFilterId.selectedProperty().addListener((observable, oldValue, newValue) -> {
            showFilteredMedia(tfFilter.getText());
        });
        radioBtnFilterTitle.selectedProperty().addListener((observable, oldValue, newValue) -> {
            showFilteredMedia(tfFilter.getText());
        });

        // Initialize Total Cost
        updateTotalCost();

        // Track updates to the cart to dynamically update total cost
        cart.getItemsOrdered().addListener((ListChangeListener<Media>) change -> {
            updateTotalCost();
        });
    }

    private void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    private void updateTotalCost() {
        double total = cart.totalCost();
        lblTotal.setText(String.format("%.2f $", total));
    }

    private void showFilteredMedia(String filterValue) {
        if (filterValue == null || filterValue.trim().isEmpty()) {
            filteredList.setPredicate(media -> true);
        } else {
            String searchStr = filterValue.trim().toLowerCase();
            if (radioBtnFilterId.isSelected()) {
                filteredList.setPredicate(media -> String.valueOf(media.getId()).equals(searchStr));
            } else if (radioBtnFilterTitle.isSelected()) {
                filteredList.setPredicate(media -> media.getTitle().toLowerCase().contains(searchStr));
            }
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Playing Media");
                alert.setHeaderText("Playing " + media.getClass().getSimpleName() + ": " + media.getTitle());
                
                String content = "Playing: " + media.getTitle();
                if (media instanceof Disc) {
                    content += "\nLength: " + ((Disc) media).getLength() + " mins";
                }
                alert.setContentText(content);
                alert.showAndWait();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Playback Error");
                alert.setHeaderText("Error occurred while playing " + media.getTitle());
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Place Order");
            alert.setHeaderText("Empty Cart");
            alert.setContentText("You cannot place an order because your cart is empty.");
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Place Order");
        alert.setHeaderText("Order Received");
        alert.setContentText("Your order has been placed successfully! The cart will be cleared.");
        alert.showAndWait();

        cart.clear();
    }

    // Menu handlers to switch screens
    @FXML
    void menuViewStorePressed(ActionEvent event) {
        new StoreScreen(store, cart);
        parentFrame.dispose();
    }

    @FXML
    void menuAddBookPressed(ActionEvent event) {
        new AddBookToStoreScreen(store, cart);
        parentFrame.dispose();
    }

    @FXML
    void menuAddCDPressed(ActionEvent event) {
        new AddCDToStoreScreen(store, cart);
        parentFrame.dispose();
    }

    @FXML
    void menuAddDVDPressed(ActionEvent event) {
        new AddDVDToStoreScreen(store, cart);
        parentFrame.dispose();
    }
}
