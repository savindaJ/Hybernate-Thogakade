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
    public JFXComboBox cmbId;
    public TableView tblItem;
    public TableColumn<? extends Object, ? extends Object> colCode;
    public TableColumn<? extends Object, ? extends Object> colItemName;
    public TableColumn<? extends Object, ? extends Object> colQty;
    public TableColumn<? extends Object, ? extends Object> colPrice;
    private final ItemBO itemBO = BoFactory.getInstance().getBo(BoFactory.BOTypes.ITEM);

    @FXML
    void initialize(){
        initUI();
        setCellValueFactory();
        fillTable();
    }

    private void fillTable() {
        ObservableList<ItemTM> itemTMS = FXCollections.observableArrayList();
        for (ItemDTO itemDTO : itemBO.getAll()) {
            itemTMS.add(new ItemTM(
                    itemDTO.getItemCode(),
                    itemDTO.getName(),
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

    public void btnSaveOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
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
