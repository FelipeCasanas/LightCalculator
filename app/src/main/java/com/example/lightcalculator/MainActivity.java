package com.example.lightcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private short operation = 0, repeat = 1;
    private static double number1 = 0, number2 = 0, result = 0;
    private String numberString = "";
    private TextView txtResult, txtPreResult;
    private Button txtN1;
    private Button txtN2;
    private Button txtN3;
    private Button txtN4;
    private Button txtN5;
    private Button txtN6;
    private Button txtN7;
    private Button txtN8;
    private Button txtN9;
    private Button txtN0;
    private Button txtPlus;
    private Button txtMinus;
    private Button txtMultiply;
    private Button txtDivision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResult = findViewById(R.id.txt_result);
        txtPreResult = findViewById(R.id.txtPreResult);


        txtN1 = findViewById(R.id.number1);
        txtN1.setOnClickListener(this);

        txtN2 = findViewById(R.id.number2);
        txtN2.setOnClickListener(this);

        txtN3 = findViewById(R.id.number3);
        txtN3.setOnClickListener(this);

        txtN4 = findViewById(R.id.number4);
        txtN4.setOnClickListener(this);

        txtN5 = findViewById(R.id.number5);
        txtN5.setOnClickListener(this);

        txtN6 = findViewById(R.id.number6);
        txtN6.setOnClickListener(this);

        txtN7 = findViewById(R.id.number7);
        txtN7.setOnClickListener(this);

        txtN8 = findViewById(R.id.number8);
        txtN8.setOnClickListener(this);

        txtN9 = findViewById(R.id.number9);
        txtN9.setOnClickListener(this);

        txtN0 = findViewById(R.id.number0);
        txtN0.setOnClickListener(this);


        Button txtDelete = findViewById(R.id.delete);
        txtDelete.setOnClickListener(this);
        txtDelete.setOnLongClickListener(this);

        Button txtEnter = findViewById(R.id.enter);
        txtEnter.setOnClickListener(this);

        txtPlus = findViewById(R.id.plusButton);
        txtPlus.setOnClickListener(this);

        txtMinus = findViewById(R.id.minusButton);
        txtMinus.setOnClickListener(this);

        txtMultiply = findViewById(R.id.multiplyButton);
        txtMultiply.setOnClickListener(this);

        txtDivision = findViewById(R.id.divisionButton);
        txtDivision.setOnClickListener(this);
    }

    public void setResult(String result) {
        txtResult.setText(result);
    }

    public void printNumber() {
        txtPreResult.setText(numberString);
    }
    public void resetVariables() {
        number1 = 0;
        number2 = 0;
    }

    public void buttonSetVisible(){
        txtPlus.setEnabled(true);
        txtMinus.setEnabled(true);
        txtMultiply.setEnabled(true);
        txtDivision.setEnabled(true);
    }

    public void buttonSetInvisible() {
        txtPlus.setEnabled(false);
        txtMinus.setEnabled(false);
        txtMultiply.setEnabled(false);
        txtDivision.setEnabled(false);
    }

    public void clearNumber(short mode) {
        if(mode == 1) {
            int numberLength = numberString.length();
            if(numberLength < 1) {
                Toast.makeText(this, "El campo esta vacío", Toast.LENGTH_SHORT).show();
            } else {
                numberString = numberString.substring(0, numberLength - 1);
                printNumber();
            }
        } else if(mode == 2) {
                numberString = "";
                result = 0;
                repeat--;
                resetVariables();
                setResult("");
                printNumber();
        }
    }

    public void Enter() {
        if(operation == 1) {
            if(repeat == 1) {
                number2 = Double.parseDouble(numberString);
                numberString = "";
                result = number1 + number2;
                resetVariables();
                printNumber();
                setResult("Resultado: " + result);
                operation = 0;
                repeat++;

                buttonSetVisible();
            } else if(repeat == 2) {
                number2 = Double.parseDouble(numberString);
                numberString = "";
                result += number2;
                resetVariables();
                printNumber();
                setResult("Resultado: " + result);
                operation = 0;

                buttonSetVisible();
            }
        }
        if(operation == 2) {
            if(repeat == 1) {
                number2 = Double.parseDouble(numberString);
                numberString = "";
                result = number1 - number2;
                resetVariables();
                printNumber();
                setResult("Resultado: " + result);
                operation = 0;
                repeat++;

                buttonSetVisible();
            } else if(repeat == 2) {
                number2 = Double.parseDouble(numberString);
                numberString = "";
                result -= number2;
                resetVariables();
                printNumber();
                setResult("Resultado: " + result);
                operation = 0;

                buttonSetVisible();
            }
        }
        if(operation == 3) {
            if(repeat == 1) {
                number2 = Double.parseDouble(numberString);
                numberString = "";
                result = number1 * number2;
                resetVariables();
                printNumber();
                setResult("Resultado: " + result);
                operation = 0;
                repeat++;

                buttonSetVisible();
            } else if(repeat == 2) {
                number2 = Double.parseDouble(numberString);
                numberString = "";
                result *= number2;
                resetVariables();
                printNumber();
                setResult("Resultado: " + result);
                operation = 0;

                buttonSetVisible();
            }
        }
        if(operation == 4) {
            if(repeat == 1) {
                number2 = Double.parseDouble(numberString);
                numberString = "";
                result = number1 / number2;
                resetVariables();
                printNumber();
                setResult("Resultado: " + result);
                operation = 0;
                repeat++;

                buttonSetVisible();
            } else if(repeat == 2) {
                number2 = Double.parseDouble(numberString);
                if(number2 > 0) {
                    numberString = "";
                    result /= number2;
                    resetVariables();
                    printNumber();
                    setResult("Resultado: " + result);
                    operation = 0;

                    buttonSetVisible();
                } else {
                    Toast.makeText(this, "No se puede dividir por 0", Toast.LENGTH_SHORT).show();
                    numberString = "";
                    printNumber();
                }
            }
        }
    }

    public void Plus() {
        if(repeat == 1) {
            number1 = Double.parseDouble(numberString);
            numberString = "";
            buttonSetInvisible();
            operation = 1;
        } else if(repeat == 2) {
            buttonSetInvisible();
            operation = 1;
        }
    }

    public void Minus() {
        if(repeat == 1) {
            number1 = Double.parseDouble(numberString);
            numberString = "";
            buttonSetInvisible();
            operation = 2;
        } else if(repeat == 2) {
            buttonSetInvisible();
            operation = 2;
        }
    }

    public void Multiply() {
        if(repeat == 1) {
            number1 = Double.parseDouble(numberString);
            numberString = "";
            buttonSetInvisible();
            operation = 3;
        } else if(repeat == 2) {
            buttonSetInvisible();
            operation = 3;
        }
    }

    public void Division() {
        if(repeat == 1) {
            number1 = Double.parseDouble(numberString);
            numberString = "";
            buttonSetInvisible();
            operation = 4;
        } else if(repeat == 2) {
            buttonSetInvisible();
            operation = 4;
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == txtN1.getId()) {
            numberString += "1";
            printNumber();
        }
        if(view.getId() == txtN2.getId()) {
            numberString += "2";
            printNumber();
        }
        if(view.getId() == txtN3.getId()) {
            numberString += "3";
            printNumber();
        }
        if(view.getId() == txtN4.getId()) {
            numberString += "4";
            printNumber();
        }
        if(view.getId() == txtN5.getId()) {
            numberString += "5";
            printNumber();
        }
        if(view.getId() == txtN6.getId()) {
            numberString += "6";
            printNumber();
        }
        if(view.getId() == txtN7.getId()) {
            numberString += "7";
            printNumber();
        }
        if(view.getId() == txtN8.getId()) {
            numberString += "8";
            printNumber();
        }
        if(view.getId() == txtN9.getId()) {
            numberString += "9";
            printNumber();
        }
        if(view.getId() == txtN0.getId()) {
            numberString += "0";
            printNumber();
        }
        if(view.getId() == R.id.delete) {
            short mode = 1;
            clearNumber(mode);
        }
        if(view.getId() == R.id.enter) {
            Enter();
        }
        if(view.getId() == R.id.plusButton) {
                Plus();
        }
        if(view.getId() == R.id.minusButton) {
            Minus();
        }
        if(view.getId() == R.id.multiplyButton) {
            Multiply();
        }
        if(view.getId() == R.id.divisionButton) {
            Division();
        }
    }

    @Override
    public boolean onLongClick(View view) {
        short mode = 2;
        clearNumber(mode);
        return false;
    }
}