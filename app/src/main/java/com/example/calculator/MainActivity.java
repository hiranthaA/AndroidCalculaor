package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnClear;
    private Button btnCE;
    private Button btnDot;
    private Button btnEqual;
    private Button btnDel;
    private Button btnMulti;
    private Button btnDiv;
    private Button btnSub;
    private Button btnAdd;
    private Button btnPlusMinus;
    private TextView txtDisplay;
    private TextView txtSecDisplay;

    private Double input1;
    private Double input2;
    private char operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
        System.out.println("hirantha".concat(txtDisplay.getText().toString()));

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtDisplay.setText(null);
                txtSecDisplay.setText(null);
                input1=null;
                input2=null;
            }
        });

        btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtDisplay.setText(null);
            }
        });

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

        btnPlusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtDisplay.getText().toString().isEmpty() && txtDisplay.getText().toString()!="0" && txtDisplay.getText().toString()!="."){
                    //txtDisplay.setText(Double.toString(Double.parseDouble(txtDisplay.getText().toString())*(-1)));
                    displayOnPrimaryDisplay(Double.parseDouble(txtDisplay.getText().toString())*(-1));
                }
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input1==null){
                    if(!txtDisplay.getText().toString().isEmpty() && txtDisplay.getText().toString()!="."){
                        input1=Double.parseDouble(txtDisplay.getText().toString());
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

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input1==null){
                    if(!txtDisplay.getText().toString().isEmpty() && txtDisplay.getText().toString()!="."){
                        input1=Double.parseDouble(txtDisplay.getText().toString());
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

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input1==null){
                    if(!txtDisplay.getText().toString().isEmpty() && txtDisplay.getText().toString()!="."){
                        input1=Double.parseDouble(txtDisplay.getText().toString());
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

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input1==null){
                    if(!txtDisplay.getText().toString().isEmpty() && txtDisplay.getText().toString()!="."){
                        input1=Double.parseDouble(txtDisplay.getText().toString());
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

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtDisplay.getText().toString().isEmpty() || input1 == null){
                    //TODO
                }
                else{
                    input2=Double.parseDouble(txtDisplay.getText().toString());
                    double answer;
                    switch(operation){
                        case '+' :
                            answer = input1+input2;
                            displayOnPrimaryDisplay(answer);
                            break;
                        case '-' :
                            answer = input1-input2;
                            displayOnPrimaryDisplay(answer);
                            break;
                        case '÷' :
                            answer = input1/input2;
                            displayOnPrimaryDisplay(answer);
                            break;
                        case '×' :
                            answer = input1*input2;
                            displayOnPrimaryDisplay(answer);
                            break;
                        default:
                            //TODO
                            System.out.println("Invalid Operation");
                    }
                    txtSecDisplay.setText(null);
                    input1=null;
                    input2=null;
                }

            }
        });

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

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtDisplay.getText().toString().trim()=="0"){
                    txtDisplay.setText("1");
                }
                else{
                    txtDisplay.setText(txtDisplay.getText().toString().concat("1"));
                }
            }
        });

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

    private void displayOnSecondaryDisplay(){
        if(input1%1==0){
            txtSecDisplay.setText(Integer.toString(input1.intValue()).concat(" ").concat(Character.toString(operation)));
        }
        else{
            txtSecDisplay.setText(Double.toString(input1).concat(" ").concat(Character.toString(operation)));
        }
    }

    private void displayOnPrimaryDisplay(double value){
        if(value % 1 ==0){
            txtDisplay.setText(Integer.toString((int)value));
        }
        else{
            txtDisplay.setText(Double.toString(value));
        }
    }

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
