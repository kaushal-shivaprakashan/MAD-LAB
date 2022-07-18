package com.example.simplecalculator;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Pattern;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnone,btntwo,btnthree,btnfour,btnfive,btnsix,btnseven,btneight,btnnine,btnzero;
    Button btnAdd,btnSub,btnMul,btnDiv;
    Button btnclear,btnequal,btndot;
    EditText txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnone =(Button) findViewById(R.id.btn_1);
        btnone.setOnClickListener(this);
        btntwo =(Button) findViewById(R.id.btn_2);
        btntwo.setOnClickListener(this);
        btnthree =(Button) findViewById(R.id.btn_3);
        btnthree.setOnClickListener(this);
        btnfour =(Button) findViewById(R.id.btn_4);
        btnfour.setOnClickListener(this);
        btnfive =(Button) findViewById(R.id.btn_5);
        btnfive.setOnClickListener(this);
        btnsix =(Button) findViewById(
                R
                        .id
                        .btn_6);
        btnsix.setOnClickListener(this);
        btnseven =(Button) findViewById(
                R
                        .id
                        .btn_7);
        btnseven.setOnClickListener(this);
        btneight =(Button) findViewById(
                R
                        .id
                        .btn_8);
        btneight.setOnClickListener(this);
        btnnine =(Button) findViewById(
                R
                        .id
                        .btn_9);
        btnnine.setOnClickListener(this);
        btnzero =(Button) findViewById(
                R
                        .id
                        .btn_0);
        btnzero.setOnClickListener(this);
        btnAdd =(Button) findViewById(
                R
                        .id
                        .btn_plus);
        btnAdd
                .setOnClickListener(this);
        btnSub =(Button) findViewById(
                R
                        .id
                        .btn_minus);
        btnSub.setOnClickListener(this);
        btnMul =(Button) findViewById(
                R
                        .id
                        .btn_mul);
        btnMul.setOnClickListener(this);
        btnDiv =(Button) findViewById
                (
                        R
                                .id
                                .btn_div);
        btnDiv.setOnClickListener(this);
        btndot =(Button) findViewById(
                R
                        .id
                        .btn_dot);
        btndot.setOnClickListener(this);
        btnclear =(Button) findViewById(
                R
                        .id
                        .btn_clear);
        btnclear.setOnClickListener(this);
        btnequal =(Button) findViewById(
                R
                        .id
                        .btn_equals);
        btnequal.setOnClickListener(this);
        txtResult = (EditText) findViewById(
                R
                        .id
                        .edit_txt);
        txtResult.setText("");

    }
    @Override
    public void onClick
            (View view) {
        if(view.equals(btnone))
            txtResult.append("1");
        if(view.equals(btntwo))
            txtResult.append("2");
        if(view.equals(btnthree))
            txtResult.append("3");
        if(view.equals(btnfour))
            txtResult.append("4");
        if(view.equals(btnfive))
            txtResult.append("5");
        if(view.equals(btnsix))
            txtResult.append("6");
        if(view.equals(btnseven))
            txtResult.append("7");
        if(view.equals(btneight))
            txtResult.append("8");
        if(view.equals(btnnine))
            txtResult.append("9");
        if(view.equals(btnzero))
            txtResult.append("0");
        if(view.equals(btndot))
            txtResult.append(".");
        if(view.equals(btnAdd))
            txtResult.append("+");
        if(view.equals(btnSub))
            txtResult.append("-");
        if(view.equals(btnMul))
            txtResult.append("*");
        if(view.equals(btnDiv))
            txtResult.append("/");
        if(view.equals(btnclear))
            txtResult.setText("");
        if(view.equals(btnequal))
            try {
                String data = txtResult.getText().toString();
                if(data.contains("/"))
                {
                    divide(data);
                }
                else if(data.contains("*"))
                {
                    multiplication(data);
                } else if(data.contains("+"))
                {
                    addition(data);
                } else if(data.contains("-"))
                {
                    subtration(data);
                }
            } catch (Exception e)
            {
                displayInvalidMessage("Invalid Operation");
            }
    }
    private void displayInvalidMessage(String mes) {
        Toast.makeText(getBaseContext(),mes,Toast.LENGTH_LONG).show();
    }
    private void subtration(String data) {
        String[] operands = data.split("-");
        if (operands.length == 2) {
            Double operand1 = Double.parseDouble(operands[0]);
            Double operand2 = Double
                    .parseDouble
                            (operands
                                    [
                                    1]);
            Double result = operand1
                    - operand2
                    ;
            txtResult.setText(String
                    .valueOf(result));
        } else

        {
            displayInvalidMessage("invalid input");

        }

    }
    private void addition
            (String data) {
        String[] operands = data.split(Pattern
                .quote
                        ("+"));
        if
        (operands
                .length ==
                2) {
            Double operand1 = Double
                    .parseDouble
                            (operands
                                    [
                                    0]);
            Double operand2 = Double
                    .parseDouble
                            (operands
                                    [
                                    1]);
            Double result = operand1 + operand2
                    ;
            txtResult.setText(String
                    .valueOf(result));
        } else

        {
            displayInvalidMessage("invalid input");

        }

    }
    private void divide
            (String data) {
        String[] operands = data.split(" / ");
        if
        (operands
                .length ==
                2) {
            Double operand1 = Double
                    .parseDouble
                            (operands
                                    [
                                    0]);
            Double operand2 = Double
                    .parseDouble
                            (operands
                                    [
                                    1]);
            Double result = operand1 / operand2
                    ;
            txtResult.setText(String
                    .valueOf(result));
        } else

        {
            displayInvalidMessage("invalid input");

        }

    }
    private void multiplication
            (String data) {
        String[] operands = data.split(Pattern
                .quote
                        ("*"));
        if
        (operands
                .length ==
                2) {
            Double operand1 = Double
                    .parseDouble
                            (operands
                                    [
                                    0]);
            Double operand2 = Double
                    .parseDouble
                            (operands
                                    [
                                    1]);
            Double result = operand1 * operand2
                    ;
            txtResult.setText(String
                    .valueOf(result));
        } else

        {
            displayInvalidMessage("invalid input");

        }

    }
}