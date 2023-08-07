package lk.ijse.thogakade.controller;

import javafx.animation.ScaleTransition;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class HomeFormController {
    public Label lblStatus;
    public ImageView viewCustomer;
    public ImageView viewItem;
    public ImageView viewOrders;

    public void mouseEnterde(MouseEvent event) {
        if (event.getSource() instanceof ImageView){
            ImageView view = (ImageView) event.getSource();

            switch (view.getId()){
                case "viewOrders":
                    lblStatus.setText("Go to Order Form");
                    break;
                case "viewCustomer":
                    lblStatus.setText("Go to Customer Form");
                    break;
                case "viewItem" :
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

    public void btnCustomerOnAction(MouseEvent event) {
    }

    public void btnItemOnAction(MouseEvent event) {
    }

    public void btnOrderOnAction(MouseEvent event) {

    }
}
