package lk.ijse.thogakade.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.thogakade.bo.BoFactory;
import lk.ijse.thogakade.bo.custom.OrderBO;
import lk.ijse.thogakade.dao.custom.CustomerDAO;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.dto.ItemDTO;
import lk.ijse.thogakade.dto.OrderDTO;
import lk.ijse.thogakade.dto.tm.CartTM;
import lk.ijse.thogakade.entity.Customer;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OrderFormController {

    public AnchorPane root;
    public Label lblOrderId;
    public Label lblOrderDate;
    public JFXComboBox<String> cmbCustomerId;
    public Label lblCustomerName;
    public JFXComboBox<String> cmbItemCode;
    public Label lblDescription;
    public Label lblUnitPrice;
    public Label lblQtyOnHand;
    public TextField txtQty;
    public TableView tblOrderCart;
    public TableColumn colItemCode;
    public TableColumn colDescription;
    public TableColumn colUnitPrice;
    public TableColumn colQty;
    public TableColumn <?,?>colTotal;
    public TableColumn colAction;
    public Label lblNetTotal;

    private ObservableList<CartTM> obList = FXCollections.observableArrayList();

    OrderBO orderBO = BoFactory.getInstance().getBo(BoFactory.BOTypes.ORDER);
    @FXML
    void initialize(){
        setCellValueFactory();
        setCustomerID();
        lblOrderDate.setText(String.valueOf(LocalDate.now()));
        setItemIds();
    }

    void setCellValueFactory() {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("btn"));
    }

    private void setItemIds() {
        ObservableList<String> ids = FXCollections.observableArrayList();
        for (ItemDTO itemId : orderBO.getItemIds()) {
            ids.add(String.valueOf(itemId.getItemCode()));
        }
        cmbItemCode.setItems(ids);
    }

    private void setCustomerID() {
        ObservableList<String> ids = FXCollections.observableArrayList();
        for (CustomerDTO customerDTO : orderBO.getCustomerId()) {
            ids.add(String.valueOf(customerDTO.getId()));
        }
        cmbCustomerId.setItems(ids);
    }

    public void cmbCustomerOnAction(ActionEvent actionEvent) {
        CustomerDTO customer = orderBO.getCustomer(cmbCustomerId.getValue());
        lblCustomerName.setText(customer.getName());
    }

    public void cmbItemOnAction(ActionEvent actionEvent) {
        ItemDTO itemDTO = orderBO.getOrderItem(String.valueOf(cmbItemCode.getValue()));
        lblDescription.setText(itemDTO.getDescription());
        lblQtyOnHand.setText(String.valueOf(itemDTO.getQty()));
        lblUnitPrice.setText(String.valueOf(itemDTO.getPrice()));
        txtQty.requestFocus();
    }

    public void txtQtyOnAction(ActionEvent actionEvent) {
    }

    public void btnAddToCartOnAction(ActionEvent actionEvent) {
        String code = cmbItemCode.getValue();
        String description = lblDescription.getText();
        int qty = Integer.parseInt(txtQty.getText());
        double unitPrice = Double.parseDouble(lblUnitPrice.getText());
        double total = qty * unitPrice;

        Button btn = new Button("Remove");
        setRemoveBtnOnAction(btn); /* set action to the btnRemove */

        if (!obList.isEmpty()) {
            for (int i = 0; i < tblOrderCart.getItems().size(); i++) {
                if (colItemCode.getCellData(i).equals(code)) {
                    qty += (int) colQty.getCellData(i);
                    total = qty * unitPrice;
                    System.out.println(total);
                    obList.get(i).setQty(qty);
                    obList.get(i).setTotal(total);

                    tblOrderCart.refresh();
                    calculateNetTotal();
                    return;
                }
            }
        }

        CartTM tm = new CartTM(code, description, qty, unitPrice, total, btn);

        obList.add(tm);
        tblOrderCart.setItems(obList);

        calculateNetTotal();

        txtQty.setText("");
    }

    private void calculateNetTotal() {
        System.out.println(tblOrderCart.getItems().size());
        double netTotal = 0.0;
        for (int i = 0; i < tblOrderCart.getItems().size(); i++) {
            double total = (double) colTotal.getCellData(i);
            netTotal += total;
        }
        lblNetTotal.setText(String.valueOf(netTotal));
    }

    private void setRemoveBtnOnAction(Button btn) {

        btn.setOnAction((e) -> {
            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

            Optional<ButtonType> result = new Alert(Alert.AlertType.INFORMATION, "Are you sure to remove?", yes, no).showAndWait();

            if (result.orElse(no) == yes) {
                try {
                    int selectedIndex = tblOrderCart.getSelectionModel().getSelectedIndex();
                    System.out.println(selectedIndex);
                    obList.remove(selectedIndex);

                    tblOrderCart.refresh();
                    calculateNetTotal();
                }catch (Exception exception){
                    new Alert(Alert.AlertType.ERROR,"please select delete row... !").show();
                }
            }

        });
    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) {
    }

    public void btnNewCustomerOnAction(ActionEvent actionEvent) {
    }

    public void btnBackOnAction(MouseEvent event) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/home_form.fxml")));
        if (root != null) {
            Scene subScene = new Scene(root);
            Stage primaryStage = (Stage) this.root.getScene().getWindow();
            primaryStage.setScene(subScene);
            primaryStage.centerOnScreen();

            TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
            tt.setFromX(-subScene.getWidth());
            tt.setToX(0);
            tt.play();
        }
    }

    public void mouseEnterd(MouseEvent event) {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(15);
            glow.setHeight(15);
            glow.setRadius(15);
            icon.setEffect(glow);
        }
    }

    public void mouseExit(MouseEvent event) {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();
            icon.setEffect(null);
        }
    }
}
