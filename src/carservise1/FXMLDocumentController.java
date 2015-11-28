/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carservise1;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;


import java.util.ResourceBundle;
import java.util.SimpleTimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 *
 * @author AlekseiSamoilov
 */
public class FXMLDocumentController implements Initializable {
    
    private static int reg = 0;
    
     ObservableList<String> list 
             = FXCollections.observableArrayList("Женя ГЛМ","Антон ГЛМ","Саня Полазна","Женя Коми","Женя Сварщик","Саня Вышка");
     ObservableList<String> stagesList
             = FXCollections.observableArrayList("Первый у кассы","У ворот","Сзади","Яма","У клиентской");
    
//     ObservableList<String> list 
//             = FXCollections.observableArrayList("Slesar A","Slesar B","Slesar C","Slesar D","Slesar E","Slesar F");
//     ObservableList<String> stagesList
//             = FXCollections.observableArrayList("P1","P2","P3","P4","P5");
    
    @FXML
    private Label label;
    
    @FXML
    private ComboBox<String> comboBox;
     
    @FXML
    private TextField master;
       
    @FXML
    private TextField client;
       
    @FXML
    private TextField tel;
       
    @FXML
    private TextField car;
       
    @FXML
    private TextArea works;
       
    @FXML
    private TextField price;
       
    @FXML
    private TextArea other;
     
    @FXML
    private TableColumn dayT;
     
    @FXML
    private TableColumn masterT;
     
    @FXML
    private TableView<String> tableView;
     
    @FXML
    private TableColumn clientT;
     
    @FXML
    private TextField summ;
     
    @FXML
    private TextField vichet;
    
    @FXML
    private TextArea textVichet;
    
    @FXML
    private TextArea commVichet;
    
    @FXML
    private ListView cashList;
    
    @FXML
    private TextArea printArea;
    
    @FXML
    private TextField account;
            
    @FXML
    private PasswordField password;
    
    @FXML
    private TextArea messageArea;
    
    @FXML
    private TextArea chatArea;
     
    @FXML
    private TextArea putArea;
     
    @FXML
    private TextField putField;
     
    @FXML
    private TextField stagesClient;
     
    @FXML
    private TextField stagesTel;
      
    @FXML
    private TextField stagesCar;
       
    @FXML
    private TextArea stagesOther;
        
    @FXML
    private ComboBox stagesChoiceBox;
    
    @FXML
    private void clickPutMoney() throws ClassNotFoundException, SQLException{
         PutMoney put = new PutMoney();
         label.setText(put.putMany(Float.valueOf(putField.getText()), putArea.getText()));
         summ.setText(String.valueOf(put.getSumm()));
         setAllEvents();
     }
    
    @FXML
    private void clickSentMessage() throws ClassNotFoundException, SQLException{
        if((reg==1)&&(messageArea.getText().trim() != null)){
            String message = messageArea.getText();
            System.out.println(message);
            messageArea.setText("");
            MessageArea mArea = new MessageArea();
            mArea.getMessage(account.getText(), message);      
        }else{ 
            label.setText("Wrong Password or Login!");
        }
    } 
            
    @FXML
    private void clickReg() throws SQLException, ClassNotFoundException, IOException{
        RegistrationUser user = new RegistrationUser();
        if(user.registration(account.getText(), password.getText()).equals("OK")){
            reg = 1;
            messageArea.setEditable(true);
            messageArea.setPromptText("LET'S GO TO CHAT!");
            password.setDisable(true);
            account.setDisable(true);
            messageArea.setDisable(false);
        }else{
            reg=0;
            messageArea.setPromptText("INSERT RIGHT LOGIN AND PASSWORD!");
        messageArea.setEditable(true);}
    label.setText(user.registration(account.getText(), password.getText())); 
    }
    
    @FXML
    private void clickPrint(){
        String printText = cashList.getSelectionModel().getSelectedItems().toString();
        printArea.setText(printText);
        
        
    }
    
    @FXML
    private void clickPrint2() throws IOException{
        if(printArea.getText()!=null){
            String printText = printArea.getText();
            SavePrintFile sf = new SavePrintFile();
            label.setText(sf.saveFile(printText));
             CustomPrint printP = new CustomPrint();
        printP.printPage();
        printArea.setText(null);
        }
        
        
       
    }
    
    
    @FXML
    private void clickZarplata() throws ClassNotFoundException, SQLException{
        WorkersCash cash = new WorkersCash();
        String masterZ = comboBox.getSelectionModel().getSelectedItem();
        float many = cash.manyOfSlesar(masterZ);
        summ.setText(String.valueOf(many));
        comboBox.getSelectionModel().select("Выбери!");     
    }
    
    @FXML
    private void clickVichet(){
        try{
         String vichet1 = vichet.getText();
         float valueVichet = Float.valueOf(vichet1);
         System.out.println(valueVichet);
         CheckBox cashBox = new CheckBox();
        valueVichet = -valueVichet;
         System.out.println(valueVichet);
         String vichetArea = commVichet.getText();
         label.setText(cashBox.getMany(valueVichet, vichetArea));
         vichet.setText("");
         commVichet.setText("");
         setAllEvents(); 
        }catch(Exception ex1){
        label.setText("wrong operation with vichet!" + ex1 );
    }    
    }
    
    @FXML
    private void clickCashBox() throws ClassNotFoundException, SQLException{
        setAllEvents();
        GetWorks a = new GetWorks();
        ResultSet result  =a.getTable();
        CheckBox box = new CheckBox();
        float summa = box.getSumm();
        String summa1 = String.valueOf(summa);
        summ.setText(summa1);
    }
     
     
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        SimpleDateFormat date = new SimpleDateFormat("kk:mm dd/M/yyyy");
        String ss = date.format(new Date());
        String timeB = ss;
        String masterB = comboBox.getSelectionModel().getSelectedItem();
        String clientB = client.getText().toUpperCase(Locale.FRENCH);
        String telB = tel.getText();
        String carB = car.getText();
        String worksB = works.getText();
        float priceB = 0;
       
        if((masterB == null)||(masterB.equals("Выбери!"))){
            label.setText("viberi mastera");
        }else{
        try{
        priceB = Float.valueOf(price.getText().trim());
        }catch(NumberFormatException ex){
            price.setText("НЕВЕРНО! Введите просто цифру!");
        }
        String otherB = other.getText();
        
        ConnSQL asss = new ConnSQL();
        String asss2 = asss.connected(masterB, timeB, clientB, telB, carB, worksB, priceB, otherB);
    
        label.setText(asss2);
        
             if (asss2.equals("All right!")){
      client.setText("");
      tel.setText("");
      car.setText("");
      works.setText("");
      price.setText("");
      other.setText("");
      
        
    }
             comboBox.getSelectionModel().select("Выбери!");
             setAllEvents();
        } 
    }

     public void startMessages() throws ClassNotFoundException, SQLException{
         
    chatArea.setText(null);
    ChatArea chat = new ChatArea();
    String chatList = chat.getMessageList();
    chatArea.setText(chatList);  
     }
     static String checkChat = "";
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            
             Timer timer = new Timer();
       
            
        timer.scheduleAtFixedRate(new TimerTask() {
                 @Override
                 public void run() { try {
                      ChatArea chat = new ChatArea();
        String chatList = chat.getMessageList();
                     if(!chatList.equals(checkChat)){
                     startMessages();
                     checkChat = chatList;
                     }
                     } catch (ClassNotFoundException ex) {
                         Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (SQLException ex) {
                         Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
        }, 0, 1000);      
        
        setAllEvents();
    }    
    
    private void setAllEvents(){
         try{
         GetAll all = new GetAll();
        ObservableList listAll = all.getAll();
        Collections.reverse(listAll);
        cashList.setItems(listAll);
        }catch(Exception ex){
            System.out.println(ex);
        }
      comboBox.setItems(list);
      stagesChoiceBox.setItems(stagesList);
    }
}
