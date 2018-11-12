/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bugs;

import com.sun.javafx.logging.Logger;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import static javafx.application.Platform.exit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.DataFormat;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author 05220139
 */
public class FXMLDocumentController implements Initializable {

    int contador = 1;
    @FXML

    private TextField text_name;
    @FXML
    private TextField text_email;
    @FXML
    private ComboBox<String> system_group;
    @FXML
    private TextField text_title;
    @FXML
    private ComboBox<String> priority_group;
    @FXML
    private TextArea text_description;
    @FXML
    private RadioButton radioSim;
    @FXML
    private ToggleGroup resposta;
    @FXML
    private RadioButton radioNao;

    Calendar data1 = Calendar.getInstance();
    String data = new SimpleDateFormat("dd/MM/yyyy").format(data1.getTime());
    String hora = new SimpleDateFormat("HH:mm:ss").format(data1.getTime());
    @FXML
    private ToggleGroup radioGroup;
    @FXML
    private Button bt_tela;
    @FXML
    private Label label;
    @FXML
    private AnchorPane tela_bugs;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        resposta = new ToggleGroup();
        radioNao.setToggleGroup(resposta);
        radioSim.setToggleGroup(resposta);
        

        //Seta combo box do sistema.
        ObservableList<String> comboSistema = FXCollections.observableArrayList(
                        "Moodle",
                        "SIA",
                        "IFRS"
                );
        system_group.setItems(comboSistema);

        adiciona_cor_comboBox();

    }

    @FXML
    public void goTo_calc(ActionEvent event) throws IOException {
        Parent temp = FXMLLoader.load(getClass().getResource("FXML_calculadora.FXML"));
        changeScreen(temp);
    }

    private void changeScreen(Parent fxmlLoad) {
        HaveStage.instance(null).loadNewStage(fxmlLoad);
    }

    @FXML
    private void sair_app(ActionEvent event) {
        exit();
    }

    @FXML
    private void confirma_ok(ActionEvent event) {

        alerta_confirmacao();
    }

    public void limpa_campos() {
        text_description.clear();
        text_email.clear();
        text_name.clear();
        text_title.clear();
    }

    public void alerta_confirmacao() {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Cadastro de Bugs");
        alert.setHeaderText("Confirmar o Cadastro do Bug: " + text_title.getText());
        alert.setContentText("Descrição: " + text_description.getText() + '\n'
                + "Sistema: " + system_group.getValue()
                + '\n' + "Prioridade: " + priority_group.getValue());
        
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            Alert alert_Type = new Alert(AlertType.INFORMATION);
            alert_Type.setTitle("Cadastro de Bugs");
            alert_Type.setHeaderText("Bug cadastrado com sucesso!!!");
            alert_Type.setContentText("Data: " + data + '\n'
                    + "Hora: " + hora);

            alert_Type.showAndWait();

            Alert alert_chamado = new Alert(AlertType.WARNING);
            alert_chamado.setHeaderText("Chamado de número: " + contador++);
            alert_chamado.showAndWait();
            limpa_campos();
            libera_bt();
        } else if (result.get() == ButtonType.CANCEL) {
            ButtonData CANCEL_CLOSE = ButtonData.CANCEL_CLOSE;
        }

    }

    public void libera_bt() {
        if (contador >= 2) {
            bt_tela.setVisible(true);
        }
    }

    public void adiciona_cor_comboBox() {
        priority_group.getItems().addAll("Alta", "Média", "Baixa");
        priority_group.setCellFactory(
                new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                final ListCell<String> cell = new ListCell<String>() {
                    {
                        super.setPrefWidth(100);
                    }

                    @Override
                    public void updateItem(String item,
                            boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item);
                            if (item.contains("Alta")) {
                                setTextFill(Color.RED);
                            } else if (item.contains("Média")) {
                                setTextFill(Color.YELLOW);
                            } else {
                                setTextFill(Color.GREEN);
                            }
                        } else {
                            setText(null);
                        }
                    }
                };
                return cell;
            }

        });

    }

}
