package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.*;

import java.util.ResourceBundle;


public class Controller implements Initializable {
    ObservableList list = FXCollections.observableArrayList();


    @FXML
    private TableView<vemaybay> table;
    @FXML
    private TableColumn<vemaybay, String> tennguoimuaColumn;
    @FXML
    private TableColumn<vemaybay, String> socmtColumn;
    @FXML
    private TableColumn<vemaybay, String> noidiColumn;
    @FXML
    private TableColumn<vemaybay, String> noidenColumn;
    @FXML
    private TableColumn<vemaybay, Integer> quangduongbayColumn;
    @FXML
    private TableColumn<vemaybay, String> thoigianbanveColumn;
    @FXML
    private TableColumn<vemaybay, Integer> giaveColumn;

    @FXML
    private TableColumn<vemaybay, String> thoigianbayColumn;
    @FXML
    private TextField tennguoimuaText;

    @FXML
    private TextField socmtText;

    @FXML
    private TextField noidiText;

    @FXML
    private TextField noidenText;
    @FXML
    private TextField quangduongbayText;
    @FXML
    private TextField thoigianbayText;
    @FXML
    private TextField thoigianbanveText;
    @FXML
    private TextField kieuve;
    @FXML
    private TextField filterField;
    @FXML
    private TextField khoangthoigian1Text;
    @FXML
    private TextField khoangthoigian2Text;
    @FXML
    private TextField doanhthutrongkhoangthoigianText;
    @FXML
    private TextField doanhthu2Text;
    @FXML
    private TextField doanhthuText;

    @FXML
    private AnchorPane ap;





    public void changeTennguoimuaCellEvent(TableColumn.CellEditEvent edditedCell) {
        vemaybay vemaybaySelected = table.getSelectionModel().getSelectedItem();
        vemaybaySelected.setTennguoimua(edditedCell.getNewValue().toString());
    }

    public void changeSocmtCellEvent(TableColumn.CellEditEvent edditedCell) {
        vemaybay vemaybaySelected = table.getSelectionModel().getSelectedItem();
        vemaybaySelected.setSocmt(edditedCell.getNewValue().toString());
    }

    public void changeNoidiCellEvent(TableColumn.CellEditEvent edditedCell) {
        vemaybay vemaybaySelected = table.getSelectionModel().getSelectedItem();
        vemaybaySelected.setNoidi(edditedCell.getNewValue().toString());
    }

    public void changeNoidenCellEvent(TableColumn.CellEditEvent edditedCell) {
        vemaybay vemaybaySelected = table.getSelectionModel().getSelectedItem();
        vemaybaySelected.setNoiden(edditedCell.getNewValue().toString());
    }

    public void changethoigianbayCellEvent(TableColumn.CellEditEvent edditedCell) {
        vemaybay vemaybaySelected = table.getSelectionModel().getSelectedItem();
        vemaybaySelected.setThoigianbay(edditedCell.getNewValue().toString());
    }

    public void changethoigianbanveCellEvent(TableColumn.CellEditEvent edditedCell) {
        vemaybay vemaybaySelected = table.getSelectionModel().getSelectedItem();
        vemaybaySelected.setThoigianbay(edditedCell.getNewValue().toString());
    }


    private ObservableList<vemaybay> vemaybayList;


    @Override
    public void initialize(URL location, ResourceBundle resource) {
        vemaybayList = FXCollections.observableArrayList(

        );

        tennguoimuaColumn.setCellValueFactory(new PropertyValueFactory<vemaybay, String>("tennguoimua"));
        socmtColumn.setCellValueFactory(new PropertyValueFactory<vemaybay, String>("socmt"));
        noidiColumn.setCellValueFactory(new PropertyValueFactory<vemaybay, String>("noidi"));
        noidenColumn.setCellValueFactory(new PropertyValueFactory<vemaybay, String>("noiden"));
        quangduongbayColumn.setCellValueFactory(new PropertyValueFactory<vemaybay, Integer>("quangduongbay"));
        thoigianbayColumn.setCellValueFactory(new PropertyValueFactory<vemaybay, String>("thoigianbay"));
        thoigianbanveColumn.setCellValueFactory(new PropertyValueFactory<vemaybay, String>("thoigianbanve"));
        giaveColumn.setCellValueFactory(new PropertyValueFactory<vemaybay, Integer>("giave"));
        FilteredList<vemaybay> filteredData = new FilteredList<>(vemaybayList, p -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((vemaybay -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                if (String.valueOf(vemaybay.getGiave()).toLowerCase().contains(lowerCaseFilter)) {

                } else if (vemaybay.getTennguoimua().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (vemaybay.getNoidi().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (vemaybay.getNoiden().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (vemaybay.getThoigianbay().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                }
                return false; // Does not match.
            }));
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<vemaybay> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(table.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.


        table.setItems(sortedData);
        table.setEditable(true);
        tennguoimuaColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        socmtColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        noidiColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        noidenColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        thoigianbayColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        thoigianbanveColumn.setCellFactory(TextFieldTableCell.forTableColumn());


    }


    @FXML
    void displayValue(ActionEvent event) {
        int quangduongbay = Integer.parseInt(quangduongbayText.getText());
        int giave1 = quangduongbay * 20000;
        kieuve.setText(String.valueOf(giave1)) ;
    }

    @FXML
    void displayValue1(ActionEvent event) {
        int quangduongbay = Integer.parseInt(quangduongbayText.getText());
        int giave2 = quangduongbay * 30000 + 1000000;

        kieuve.setText(String.valueOf(giave2));
    }

    @FXML
    void displayValue2(ActionEvent event) {
        String keySearch =khoangthoigian1Text.getText();
        List<vemaybay> veMayBayFromTable = table.getItems();
        int doanhThu = 0;
        for (vemaybay o : veMayBayFromTable) {
            if(keySearch.equals(o.getThoigianbanve())) {
                doanhThu += (o.getGiave());
            }
        }
        doanhthuText.setText(String.valueOf(doanhThu));
    }
    @FXML
    void displayValue3(ActionEvent event) {
        String keySearch2 = khoangthoigian2Text.getText();
        List<vemaybay> veMayBayFromTable = table.getItems();
        int doanhThu = 0;
        for (vemaybay o : veMayBayFromTable) {
            if(keySearch2.equals(o.getThoigianbanve())) {
                doanhThu += (o.getGiave());
            }
        }
        doanhthu2Text.setText(String.valueOf(doanhThu));
    }
    @FXML
    void displayValue4(ActionEvent event) {
        int doanhthu1 = Integer.parseInt(doanhthuText.getText());
            int doanhthu2 = Integer.parseInt(doanhthu2Text.getText());
            doanhthutrongkhoangthoigianText.setText("Doanh thu : "  + (doanhthu1 + doanhthu2) + " đồng ");
        }

    public void add(ActionEvent e) {
        vemaybay newvemaybay = new vemaybay();
        newvemaybay.setTennguoimua(tennguoimuaText.getText());
        newvemaybay.setSocmt(socmtText.getText());
        newvemaybay.setNoidi(noidiText.getText());
        newvemaybay.setNoiden(noidenText.getText());
        newvemaybay.setQuangduongbay(Integer.parseInt(quangduongbayText.getText()));
        newvemaybay.setThoigianbay(thoigianbayText.getText());
        newvemaybay.setThoigianbanve(thoigianbanveText.getText());
        newvemaybay.setGiave(Integer.parseInt(kieuve.getText()));


        vemaybayList.add(newvemaybay);
    }

    public void delete(ActionEvent e) {
        vemaybay selected = table.getSelectionModel().getSelectedItem();
        vemaybayList.remove(selected);

    }

}







