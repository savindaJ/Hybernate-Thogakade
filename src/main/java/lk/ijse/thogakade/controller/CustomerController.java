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
import lk.ijse.thogakade.bo.custom.CustomerBo;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.dto.tm.CustomerTM;
import lk.ijse.thogakade.util.CustomAlert;

import java.io.IOException;
import java.util.Objects;

public class CustomerController {
    public AnchorPane root;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtSalary;
    public JFXTextField txtId;
    public JFXButton btnSave;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public JFXComboBox<String> cmbId;
    public JFXButton btnAddNew;
    public TableView<CustomerTM> tblCustomer;
    public TableColumn<? extends Object, ? extends Object> colId;
    public TableColumn<? extends Object, ? extends Object> colName;
    public TableColumn<? extends Object, ? extends Object> colAddress;
    public TableColumn<? extends Object, ? extends Object> colSalary;
    private String name;
    private String id;
    private Double salary;
    private String address;
    private final CustomerBo customerBo = BoFactory.getInstance().getBo(BoFactory.BOTypes.CUSTOMER);

    @FXML
    void initialize(){
        initUi();
        setCellValueFactory();
        fillTable();
        setIds();
    }

    private void setIds() {
        ObservableList<String> ids = FXCollections.observableArrayList();
        for (CustomerDTO customerDTO : customerBo.getAll()) {
            ids.add(customerDTO.getId());
        }
        cmbId.setItems(ids);
    }

    void setDetail(){
         name = txtName.getText();
         id = txtId.getText();
         salary= Double.valueOf(txtSalary.getText());
         address = txtAddress.getText();
    }

    private void fillTable() {
        ObservableList<CustomerTM> customerTMS = FXCollections.observableArrayList();
        for (CustomerDTO customerDTO : customerBo.getAll()) {
            customerTMS.add(new CustomerTM(
                    customerDTO.getName(),
                    customerDTO.getAddress(),
                    customerDTO.getSalary(),
                    customerDTO.getId())
            );
        }
        tblCustomer.setItems(customerTMS);
    }

    private void setCellValueFactory() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        setDetail();
        boolean save = customerBo.save(new CustomerDTO(name, address, salary, id));
        if (save){
            new CustomAlert(Alert.AlertType.CONFIRMATION,"Save ","Saved !","Save successful !").show();
        }else {
            new CustomAlert(Alert.AlertType.ERROR,"Save ","Not Saved !","Save not successful !").show();
        }
        fillTable();
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        setDetail();
        boolean update = customerBo.update(new CustomerDTO(name, address, salary, id));
        if (update){
            new CustomAlert(Alert.AlertType.CONFIRMATION,"Update ","Updated !","Update successful !").show();
        }else {
            new CustomAlert(Alert.AlertType.ERROR,"Update ","Not Update !","Update not successful !").show();
        }
        fillTable();
        initUi();
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        boolean delete = customerBo.delete(cmbId.getValue());
        if (delete){
            new CustomAlert(Alert.AlertType.CONFIRMATION,"Delete ","Deleted !","Delete successful !").show();
        }else {
            new CustomAlert(Alert.AlertType.ERROR,"Delete ","Not Delete !","Delete not successful !").show();
        }
        fillTable();
        initUi();
    }

    public void cmbIdOnAction(ActionEvent actionEvent) {
        txtAddress.setDisable(false);
        txtId.setDisable(true);
        txtName.setDisable(false);
        txtSalary.setDisable(false);
        btnUpdate.setDisable(false);
        btnDelete.setDisable(false);

        CustomerDTO customerDTO = customerBo.getItem(cmbId.getValue());
        txtSalary.setText(String.valueOf(customerDTO.getSalary()));
        txtId.setText(customerDTO.getId());
        txtAddress.setText(customerDTO.getAddress());
        txtName.setText(customerDTO.getName());
        txtName.requestFocus();
    }

    public void btnAddNewOnAction(ActionEvent actionEvent) {
        txtAddress.setDisable(false);
        txtId.setDisable(false);
        txtId.setDisable(false);
        txtSalary.setDisable(false);
        btnSave.setDisable(false);
        txtName.setDisable(false);
        txtName.requestFocus();
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
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

    private void initUi(){
        txtAddress.clear();
        txtId.clear();
        txtName.clear();
        txtSalary.clear();
        txtAddress.setDisable(true);
        txtId.setDisable(true);
        txtId.setDisable(true);
        txtSalary.setDisable(true);
        btnSave.setDisable(true);
        txtName.setDisable(true);
        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);
    }
}
