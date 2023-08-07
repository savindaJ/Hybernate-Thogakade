package lk.ijse.thogakade.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class CustomerController {
    public AnchorPane root;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtSalary;
    public JFXTextField txtId;
    public JFXButton btnSave;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public JFXComboBox cmbId;
    public JFXButton btnAddNew;
    public TableView tblCustomer;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colSalary;

    public void btnSaveOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }

    public void cmbIdOnAction(ActionEvent actionEvent) {
    }

    public void btnAddNewOnAction(ActionEvent actionEvent) {
    }

    public void btnBackOnAction(MouseEvent event) {
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
