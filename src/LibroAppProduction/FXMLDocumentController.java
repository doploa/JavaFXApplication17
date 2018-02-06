/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibroAppProduction;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Kingsley
 */
public class FXMLDocumentController implements Initializable {
    
     public class Record{
      private SimpleStringProperty fieldMonth;
      private SimpleDoubleProperty fieldValue;
     
      Record(String fMonth, double fValue){
          this.fieldMonth = new SimpleStringProperty(fMonth);
          this.fieldValue = new SimpleDoubleProperty(fValue);
      }
     
      public String getFieldMonth() {
          return fieldMonth.get();
      }
     
      public double getFieldValue() {
          return fieldValue.get();
      }
     
  }
     
     private ObservableList<Record> dataList =
          FXCollections.observableArrayList(          
              new Record("January", 100),
              new Record("February", 200),
              new Record("March", 50),
              new Record("April", 75),
              new Record("May", 110),
              new Record("June", 300),
              new Record("July", 111),
              new Record("August", 30),
              new Record("September", 75),
              new Record("October", 55),
              new Record("November", 225),
              new Record("December", 99));
     
     
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @FXML
    private TableView<Record> tableView = new TableView<>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //primaryStage.setTitle("java-buddy.blogspot.com");
     
      //Group root = new Group();
 
      TableColumn columnMonth = new TableColumn("Month");
      columnMonth.setCellValueFactory(
              new PropertyValueFactory<Record,String>("fieldMonth"));
 
      TableColumn columnValue = new TableColumn("Value");
      columnValue.setCellValueFactory(
              new PropertyValueFactory<Record,Double>("fieldValue"));
      
      
     
      tableView.setItems(dataList);
      //tableView.getColumns().addAll(columnMonth, columnValue);
      tableView.getColumns().setAll(columnMonth, columnValue);
        // TODO
    }    
    
}
