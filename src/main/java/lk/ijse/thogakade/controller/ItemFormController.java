package lk.ijse.thogakade.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.thogakade.bo.BoFactory;
import lk.ijse.thogakade.bo.custom.ItemBO;
import lk.ijse.thogakade.dto.ItemDTO;
import lk.ijse.thogakade.dto.tm.ItemTM;
import lk.ijse.thogakade.util.CustomAlert;

import java.io.IOException;
import java.util.Objects;

public class ItemFormController {
    public AnchorPane root;
    public JFXTextField txtName;
    public JFXTextField txtQty;
    public JFXTextField txtItemPrice;
    public JFXTextField txtCode;
    public JFXButton btnSave;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public JFXComboBox <String> cmbId;
    public TableView <ItemTM> tblItem;
    public TableColumn<? extends Object, ? extends Object> colCode;
    public TableColumn<? extends Object, ? extends Object> colItemName;
    public TableColumn<? extends Object, ? extends Object> colQty;
    public TableColumn<? extends Object, ? extends Object> colPrice;
    private final ItemBO itemBO = BoFactory.getInstance().getBo(BoFactory.BOTypes.ITEM);

    private String itemCode;
    private String description;
    private Double price;
    private Integer qty;

    @FXML
    void initialize(){
        initUI();
        setCellValueFactory();
        fillTable();
        btnUpdate.setDisable(false);
        setItemIDs();
    }

    private void setItemIDs() {
        ObservableList<String> idList = FXCollections.observableArrayList();
        for (ItemDTO itemDTO : itemBO.getAll()) {
            idList.add(itemDTO.getItemCode());
        }
        cmbId.setItems(idList);
    }

    private void fillTable() {
        ObservableList<ItemTM> itemTMS = FXCollections.observableArrayList();
        for (ItemDTO itemDTO : itemBO.getAll()) {
            itemTMS.add(new ItemTM(
                    itemDTO.getItemCode(),
                    itemDTO.getDescription(),
                    itemDTO.getPrice(),
                    itemDTO.getQty())
            );
        }
    tblItem.setItems(itemTMS);
    }

    private void setCellValueFactory() {
        colCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colItemName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
    }

    private void initUI() {
        txtName.clear();
        txtQty.clear();
        txtItemPrice.clear();
        txtCode.clear();
        txtName.setDisable(true);
        txtQty.setDisable(true);
        txtItemPrice.setDisable(true);
        txtCode.setDisable(true);
        btnSave.setDisable(true);
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
    }


    private void setDetail() {
       description = txtName.getText();
       itemCode = txtCode.getText();
       price = Double.valueOf(txtItemPrice.getText());
       qty = Integer.valueOf(txtQty.getText());
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        setDetail();
        boolean save = itemBO.save(new ItemDTO(itemCode, description, price, qty));
        if (save){
            new CustomAlert(Alert.AlertType.CONFIRMATION,"Save ","Saved !","Item Save successful !").show();
        }else {
            new CustomAlert(Alert.AlertType.ERROR,"Save ","Not Saved !","Save not successful !").show();
        }
        fillTable();
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        setDetail();
        if (itemBO.update(new ItemDTO(cmbId.getValue(),description,price,qty)))
            new CustomAlert(Alert.AlertType.CONFIRMATION,"Update ","Updated !","Item Update successful !").show();
        else
            new CustomAlert(Alert.AlertType.ERROR,"Update ","Not Update !","Update not successful !").show();

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        if (itemBO.delete(cmbId.getValue()))
            new CustomAlert(Alert.AlertType.CONFIRMATION,"Delete ","Deleted !","Item Deleted successful !").show();
        else
            new CustomAlert(Alert.AlertType.ERROR,"Delete ","Not Deleted !","Delete not successful !").show();
    }

    public void btnAddNewOnAction(ActionEvent actionEvent) {
        txtName.setDisable(false);
        txtName.requestFocus();
        txtQty.setDisable(false);
        txtItemPrice.setDisable(false);
        txtCode.setDisable(false);
        btnSave.setDisable(false);
    }

    public void cmbIdOnAction(ActionEvent actionEvent) {
        btnDelete.setDisable(false);
        btnUpdate.setDisable(false);
    }

    public void btnBackClicked(MouseEvent event) throws IOException {
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
        if (event.getSource() instanceof javafx.scene.image.ImageView) {
            javafx.scene.image.ImageView icon = (ImageView) event.getSource();

            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.valueOf("#EF233C"));
//            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(15);
            glow.setHeight(15);
            glow.setRadius(15);
            icon.setEffect(glow);
        }
    }

    public void mouseExsits(MouseEvent event) {
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
