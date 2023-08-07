package lk.ijse.thogakade.controller;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

public class HomeFormController {
    public Label lblStatus;
    public ImageView viewCustomer;
    public ImageView viewItem;
    public ImageView viewOrders;
    public AnchorPane root;

    private String path;

    public void mouseEnterde(MouseEvent event) {
        if (event.getSource() instanceof ImageView){
            ImageView view = (ImageView) event.getSource();

            switch (view.getId()){
                case "viewOrders":
                    path = "/view/order_frm.fxml";
                    lblStatus.setText("Go to Order Form");
                    break;
                case "viewCustomer":
                    path = "/view/customer_form.fxml";
                    lblStatus.setText("Go to Customer Form");
                    break;
                case "viewItem" :
                    path = "/view/item_form.fxml";
                    lblStatus.setText("Go to Item Form");
                    break;
                default:
                    break;
            }
        }
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

    public void mouseExsit(MouseEvent event) {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();
            icon.setEffect(null);
        }
        lblStatus.setText("Home");
    }


    public void btnClick(MouseEvent event) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource(path)));
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
}
