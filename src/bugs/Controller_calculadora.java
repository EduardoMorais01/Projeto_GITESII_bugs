package bugs;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author 05220139
 */
public class Controller_calculadora implements Initializable {

    private Label label;
    @FXML
    private TextField tela;
    @FXML
    private Button bt_soma, bt_divide, bt_multiplica, bt_igual, bt_1, bt_4, bt_7,
            bt_sub, bt_2, bt_5, bt_8, bt_3, bt_6, bt_9, bt_0;
    Calcula calc = new Calcula();
    String num_1;
    String num_2;
    String num_separados[] = new String[1];

    char operacao_soma = '+';
    char operacao_divide = '/';
    char operacao_multiplica = '*';
    char operacao_subtrai = '-';
    @FXML
    private Button bt_clear;
    @FXML
    private AnchorPane calculator;
    @FXML
    private Button bt_voltar;

    @FXML
    private void bt_0(ActionEvent event) {
        tela.setText(tela.getText() + "0");

    }

    @FXML
    private void bt_1(ActionEvent event) {
        tela.setText(tela.getText() + "1");

    }

    @FXML
    private void bt_2(ActionEvent event) {
        tela.setText(tela.getText() + "2");

    }

    @FXML
    private void bt_3(ActionEvent event) {
        tela.setText(tela.getText() + "3");

    }

    @FXML
    private void bt_4(ActionEvent event) {
        tela.setText(tela.getText() + "4");

    }

    @FXML
    private void bt_5(ActionEvent event) {
        tela.setText(tela.getText() + "5");

    }

    @FXML
    private void bt_6(ActionEvent event) {
        tela.setText(tela.getText() + "6");

    }

    @FXML
    private void bt_7(ActionEvent event) {
        tela.setText(tela.getText() + "7");

    }

    @FXML
    private void bt_8(ActionEvent event) {
        tela.setText(tela.getText() + "8");

    }

    @FXML
    private void bt_9(ActionEvent event) {
        tela.setText(tela.getText() + "9");

    }

    @FXML
    private void bt_soma(ActionEvent event) {
        tela.setText(tela.getText() + "+");

    }

    @FXML
    private void bt_divide(ActionEvent event) {
        tela.setText(tela.getText() + "/");

    }

    @FXML
    private void bt_multiplica(ActionEvent event) {
        tela.setText(tela.getText() + "*");

    }

    @FXML
    private void bt_sub(ActionEvent event) {
        tela.setText(tela.getText() + "-");

    }

    @FXML
    private void bt_clear(ActionEvent event) {
        tela.setText("");
        this.num_1 = "0";
        this.num_2 = "0";

    }

    @FXML
    private void bt_igual(ActionEvent event) {
        tela.setText(tela.getText() + "=");
        String total = tela.getText();

        for (int i = 0; i < total.length(); i++) {
            if (total.charAt(i) == operacao_soma) {
                num_separados = total.split(String.valueOf("\\+"));
                num_1 = num_separados[0];
                num_2 = num_separados[1].replace("=", "");

                int num2 = Integer.parseInt(num_2);
                int num1 = Integer.parseInt(num_1);
                tela.setText(tela.getText() + " " + String.valueOf(calc.Soma(num1, num2)));
            }

            if (total.charAt(i) == operacao_subtrai) {
                num_separados = total.split(String.valueOf("\\-"));
                num_1 = num_separados[0];
                num_2 = num_separados[1].replace("=", "");

                int num2 = Integer.parseInt(num_2);
                int num1 = Integer.parseInt(num_1);
                tela.setText(tela.getText() + " " + String.valueOf(calc.Subs(num1, num2)));

            }

            if (total.charAt(i) == operacao_multiplica) {
                num_separados = total.split(String.valueOf("\\*"));
                num_1 = num_separados[0];
                num_2 = num_separados[1].replace("=", "");

                int num2 = Integer.parseInt(num_2);
                int num1 = Integer.parseInt(num_1);
                tela.setText(tela.getText() + " " + String.valueOf(calc.Multiplica(num1, num2)));

            }
            if (total.charAt(i) == operacao_divide) {
                num_separados = total.split(String.valueOf("\\/"));
                num_1 = num_separados[0];
                num_2 = num_separados[1].replace("=", "");

                int num2 = Integer.parseInt(num_2);
                int num1 = Integer.parseInt(num_1);
                tela.setText(tela.getText() + " " + String.valueOf(calc.Divisiao(num1, num2)));

            }

        }

    }

    @FXML
    public void goTo_home(ActionEvent event) throws IOException {
            Parent temp = FXMLLoader.load(getClass().getResource("FXMLDocument.FXML"));
            changeScreen(temp);
    }

     private void changeScreen(Parent fxmlLoad) {
        HaveStage.instance(null).loadNewStage(fxmlLoad);
    }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
