package controller;

import helpers.ControllerHelpers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class Controller extends ControllerHelpers{

    @FXML
    private Label lbl;
    @FXML
    private Button btn00;
    @FXML
    private Button btn10;
    @FXML
    private Button btn20;
    @FXML
    private Button btn01;
    @FXML
    private Button btn11;
    @FXML
    private Button btn21;
    @FXML
    private Button btn02;
    @FXML
    private Button btn22;
    @FXML
    private Button btn12;
    @FXML
    private Button btnRestart;

    private int state = 0;

    private int[][] array = { {2, 2, 2}, {2, 2, 2}, {2, 2, 2} };

    public void handlePress(ActionEvent actionEvent) {
        int value = 0;
        Button button = (Button)actionEvent.getSource();

        value = Integer.parseInt(button.getText());

        ControllerHelpers.validatedState(array, value, state);

        if (state == 0){
            button.setTextFill(Color.RED);
            button.setText("X");
            state = 1;
        }else{
            button.setTextFill(Color.BLUE);
            button.setText("0");
            state = 0;
        }

        if (ControllerHelpers.validatedStatusH(array) == 1){
            lbl.setText("GANA X");
            restart();
        }else if (ControllerHelpers.validatedStatusH(array) == 2){
            lbl.setText("GANA 0");
            restart();
        }

        if (ControllerHelpers.validatedStatusV(array) == 1){
            lbl.setText("GANA X");
            restart();
        }else if (ControllerHelpers.validatedStatusV(array) == 2){
            lbl.setText("GANA 0");
            restart();
        }

        btnRestart.setDisable(false);
    }

    public void handleRestart() {
        lbl.setText("TIC-TAC-TOE");
        restart();
    }

    private void restart() {
        btn00.setText("1");
        btn00.setTextFill(Color.TRANSPARENT);

        btn01.setText("2");
        btn01.setTextFill(Color.TRANSPARENT);

        btn02.setText("3");
        btn02.setTextFill(Color.TRANSPARENT);

        btn10.setText("4");
        btn10.setTextFill(Color.TRANSPARENT);

        btn11.setText("5");
        btn11.setTextFill(Color.TRANSPARENT);

        btn12.setText("6");
        btn12.setTextFill(Color.TRANSPARENT);

        btn20.setText("7");
        btn20.setTextFill(Color.TRANSPARENT);

        btn21.setText("8");
        btn21.setTextFill(Color.TRANSPARENT);

        btn22.setText("9");
        btn22.setTextFill(Color.TRANSPARENT);

        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++) {
                array[i][j] = 2;
            }
        }
        btnRestart.setDisable(true);
    }

}
