package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnClear,btnCE,btnDot,btnEqual,btnDel,btnMulti,btnDiv,btnSub,btnAdd,btnPlusMinus;
    private TextView txtDisplay,txtSecDisplay;

    private Double operand1;
    private Double operand2;
    private char operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize UI components
        setupUI();
        //adding a new toolbar instead of default actionbar
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_dock_black_24dp);
        setSupportActionBar(toolbar);

        //ActionListner for Clear(C) button
        //execute on click
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtDisplay.setText(null);
                txtSecDisplay.setText(null);
                operand1 =null;
                operand2 =null;
            }
        });

        //ActionListner for Clear Entry(CE) button
        //execute on click
        btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtDisplay.setText(null);
            }
        });

        //ActionListner for Delete(DEL) button
        //execute on click
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtDisplay.getText().length()>0){
                    txtDisplay.setText(txtDisplay.getText().toString().substring(0,txtDisplay.getText().length()-1));
                }
                else if(txtDisplay.getText().length()==0){
                    txtDisplay.setText(null);
                }
            }
        });

        //ActionListner for Decimal(.) button
        //execute on click
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtDisplay.getText().toString().isEmpty()){
                    txtDisplay.setText(txtDisplay.getText().toString().concat("0."));
                }
                else if(txtDisplay.getText().toString().indexOf(".")<0){
                    txtDisplay.setText(txtDisplay.getText().toString().concat("."));
                }
            }
        });

        //ActionListner for Change Sign(+-) button
        //execute on click
        btnPlusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtDisplay.getText().toString().isEmpty() && txtDisplay.getText().toString()!="0" && txtDisplay.getText().toString()!="."){
                    //txtDisplay.setText(Double.toString(Double.parseDouble(txtDisplay.getText().toString())*(-1)));
                    displayOnPrimaryDisplay(Double.parseDouble(txtDisplay.getText().toString())*(-1));
                }
            }
        });

        //ActionListner for Add(+) button
        //execute on click
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operand1 ==null){
                    if(!txtDisplay.getText().toString().isEmpty() && txtDisplay.getText().toString()!="."){
                        operand1 =Double.parseDouble(txtDisplay.getText().toString());
                        operation = '+';
                        displayOnSecondaryDisplay();
                        txtDisplay.setText("");
                    }
                }
                else{
                    operation='+';
                    displayOnSecondaryDisplay();
                }

            }
        });

        //ActionListner for Subtract(-) button
        //execute on click
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operand1 ==null){
                    if(!txtDisplay.getText().toString().isEmpty() && txtDisplay.getText().toString()!="."){
                        operand1 =Double.parseDouble(txtDisplay.getText().toString());
                        operation = '-';
                        displayOnSecondaryDisplay();
                        txtDisplay.setText(null);
                    }
                }
                else{
                    operation='-';
                    displayOnSecondaryDisplay();
                }

            }
        });

        //ActionListner for Divition(÷) button
        //execute on click
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operand1 ==null){
                    if(!txtDisplay.getText().toString().isEmpty() && txtDisplay.getText().toString()!="."){
                        operand1 =Double.parseDouble(txtDisplay.getText().toString());
                        operation = '÷';
                        displayOnSecondaryDisplay();
                        txtDisplay.setText(null);
                    }
                }
                else{
                    operation='÷';
                    displayOnSecondaryDisplay();
                }

            }
        });

        //ActionListner for Multiplication(×) button
        //execute on click
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operand1 ==null){
                    if(!txtDisplay.getText().toString().isEmpty() && txtDisplay.getText().toString()!="."){
                        operand1 =Double.parseDouble(txtDisplay.getText().toString());
                        operation = '×';
                        displayOnSecondaryDisplay();
                        txtDisplay.setText(null);
                    }

                }
                else{
                    operation='×';
                    displayOnSecondaryDisplay();
                }

            }
        });

        //ActionListner for Equal(=) button
        //execute on click
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtDisplay.getText().toString().isEmpty() && operand1 != null){
                    operand2 =Double.parseDouble(txtDisplay.getText().toString());
                    double answer;
                    switch(operation){
                        case '+' :
                            answer = operand1 + operand2;
                            displayOnPrimaryDisplay(answer);
                            break;
                        case '-' :
                            answer = operand1 - operand2;
                            displayOnPrimaryDisplay(answer);
                            break;
                        case '÷' :
                            answer = operand1 / operand2;
                            displayOnPrimaryDisplay(answer);
                            break;
                        case '×' :
                            answer = operand1 * operand2;
                            displayOnPrimaryDisplay(answer);
                            break;
                        default:
                    }
                    txtSecDisplay.setText(null);
                    operand1 =null;
                    operand2 =null;
                }

            }
        });

        //ActionListner for Zero(0) button
        //execute on click
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtDisplay.getText().toString()!="0"){
                    txtDisplay.setText(txtDisplay.getText().toString().concat("0"));
                }
                else{
                    txtDisplay.setText("0");
                }
            }
        });

        //ActionListner for One(1) button
        //execute on click
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtDisplay.getText().toString()=="0"){
                    txtDisplay.setText("1");
                }
                else{
                    txtDisplay.setText(txtDisplay.getText().toString().concat("1"));
                }
            }
        });

        //ActionListner for Two(2) button
        //execute on click
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtDisplay.getText().toString()=="0"){
                    txtDisplay.setText("2");
                }
                else{
                    txtDisplay.setText(txtDisplay.getText().toString().concat("2"));
                }
            }
        });

        //ActionListner for Three(3) button
        //execute on click
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtDisplay.getText().toString()=="0"){
                    txtDisplay.setText("3");
                }
                else{
                    txtDisplay.setText(txtDisplay.getText().toString().concat("3"));
                }
            }
        });

        //ActionListner for Four(4) button
        //execute on click
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtDisplay.getText().toString()=="0"){
                    txtDisplay.setText("4");
                }
                else{
                    txtDisplay.setText(txtDisplay.getText().toString().concat("4"));
                }
            }
        });

        //ActionListner for Five(5) button
        //execute on click
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtDisplay.getText().toString()=="0"){
                    txtDisplay.setText("5");
                }
                else{
                    txtDisplay.setText(txtDisplay.getText().toString().concat("5"));
                }
            }
        });

        //ActionListner for Six(6) button
        //execute on click
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtDisplay.getText().toString()=="0"){
                    txtDisplay.setText("6");
                }
                else{
                    txtDisplay.setText(txtDisplay.getText().toString().concat("6"));
                }
            }
        });

        //ActionListner for Seven(7) button
        //execute on click
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtDisplay.getText().toString()=="0"){
                    txtDisplay.setText("7");
                }
                else{
                    txtDisplay.setText(txtDisplay.getText().toString().concat("7"));
                }
            }
        });

        //ActionListner for eight(8) button
        //execute on click
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtDisplay.getText().toString()=="0"){
                    txtDisplay.setText("8");
                }
                else{
                    txtDisplay.setText(txtDisplay.getText().toString().concat("8"));
                }
            }
        });

        //ActionListner for Nine(9) button
        //execute on click
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtDisplay.getText().toString()=="0"){
                    txtDisplay.setText("9");
                }
                else{
                    txtDisplay.setText(txtDisplay.getText().toString().concat("9"));
                }
            }
        });
    }

    /*
    This method will populate first operand for the operation and the operator
    This method will drop decimal part if the value is a whole number
     */
    private void displayOnSecondaryDisplay(){
        if(operand1 %1==0){
            txtSecDisplay.setText(Integer.toString(operand1.intValue()).concat(" ").concat(Character.toString(operation)));
        }
        else{
            txtSecDisplay.setText(Double.toString(operand1).concat(" ").concat(Character.toString(operation)));
        }
    }

    /*
    This method will populate given values in the primary display
    This method will drop decimal part if the value is a whole number
     */
    private void displayOnPrimaryDisplay(double value){
        if(value % 1 ==0){
            txtDisplay.setText(Integer.toString((int)value));
        }
        else{
            txtDisplay.setText(Double.toString(value));
        }
    }

    /*
    initialize variables with UI components
     */
    private void setupUI(){
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnClear = findViewById(R.id.btnclear);
        btnCE = findViewById(R.id.btnCE);
        btnDot = findViewById(R.id.btndot);
        btnEqual = findViewById(R.id.btnequal);
        btnDel = findViewById(R.id.btndel);
        btnMulti = findViewById(R.id.btnmulti);
        btnDiv = findViewById(R.id.btndiv);
        btnSub = findViewById(R.id.btnsub);
        btnAdd = findViewById(R.id.btnadd);
        btnPlusMinus = findViewById(R.id.btnPlusMinus);
        txtDisplay = findViewById(R.id.txtDisplay);
        txtSecDisplay = findViewById(R.id.txtSecDisplay);
    }

}
