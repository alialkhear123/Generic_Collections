/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author Ali Abo Alkhear
 */
public class main1 extends Application {

    Account account;
    ArrayList<Account> list = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {

        FlowPane fp = new FlowPane();
        fp.setHgap(12);
        fp.setPadding(new Insets(10));
        Label labelNo = new Label("Account Number : ");
        TextField AccNo = new TextField();
        AccNo.setPromptText("Account Number ");
        Label labelName = new Label("Account Name : ");
        TextField AccName = new TextField();
        AccName.setPromptText("Account Name ");
        Label labelBalance = new Label("Account Balance : ");
        TextField AccBalance = new TextField();
        AccBalance.setPromptText("Account Balance ");
        Button butSave = new Button("Save");
        Button butShow = new Button("Show");

        fp.getChildren().addAll(labelNo, AccNo, labelName, AccName,
                labelBalance, AccBalance, butSave, butShow);

        butSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {

                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./src/Account/AccDet.ser", true));
                    account = new Account(Integer.valueOf(AccNo.getText()), AccName.getText(),
                            Integer.valueOf(AccBalance.getText()));
                    oos.writeObject(account);
                    oos.flush();
                    oos.close();
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("The Object was Written Successfully");
                    a.show();
                    System.out.println(account);

                    AccNo.setText(null);
                    AccName.setText(null);
                    AccBalance.setText(null);

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(main1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(main1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        butShow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./src/Account/AccDet.ser"));
                    String s1 = String.format("Account : \n%-10s %-10s %-10s\n", "NO", "Name", "Balance");
                    System.out.println(s1);
                    while (true) {
                        Account a1 = (Account) ois.readObject();
                        list.add(a1);
                        String s = String.format("%06d | %-15s | %2.2f",
                                a1.getAccNo(), a1.getAccName(), a1.getAccBalance());
                        System.out.println(s);

                    }

                } catch (IOException ex) {
                    Logger.getLogger(main1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(main1.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        Scene scene = new Scene(fp, 300, 150);

        primaryStage.setTitle("Account Information");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
