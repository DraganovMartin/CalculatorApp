package com.example.devm.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.BigInteger;


public class MainActivity extends AppCompatActivity {

    private Button button0 = null;
    private Button button1 = null;
    private Button button2 = null;
    private Button button3 = null;
    private Button button4 = null;
    private Button button5 = null;
    private Button button6 = null;
    private Button button7 = null;
    private Button button8 = null;
    private Button button9 = null;
    private Button buttonPlus = null;
    private Button buttonMult = null;
    private Button buttonDiv = null;
    private Button buttonRes = null;
    private Button buttonClear = null;
    private Button buttonSub = null;
    private Button buttonDot = null;
    private Button buttonBack = null;
    private Menu menu = null;
    private TextView data = null;
    private BigDecimal equals = new BigDecimal("0");
    private String num1=null;
    private String num2 = null;
    private String op =null;
    private boolean equalsClicked=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button0 = (Button) findViewById(R.id.button_0);
        button1 = (Button) findViewById(R.id.button_1);
        button2 = (Button) findViewById(R.id.button_2);
        button3 = (Button) findViewById(R.id.button_3);
        button4 = (Button) findViewById(R.id.button_4);
        button5 = (Button) findViewById(R.id.button_5);
        button6 = (Button) findViewById(R.id.button_6);
        button7 = (Button) findViewById(R.id.button_7);
        button8 = (Button) findViewById(R.id.button_8);
        button9 = (Button) findViewById(R.id.button_9);
        buttonPlus = (Button) findViewById(R.id.button_plus);
        buttonMult = (Button) findViewById(R.id.button_multiply);
        buttonDiv = (Button) findViewById(R.id.button_divide);
        buttonRes = (Button) findViewById(R.id.button_res);
        buttonClear = (Button) findViewById(R.id.button_clr);
        buttonSub = (Button) findViewById(R.id.button_substract);
        buttonDot = (Button) findViewById(R.id.button_dot);
        buttonBack = (Button) findViewById(R.id.button_back);

        data = (TextView) findViewById(R.id.result);
        if(savedInstanceState != null){
            data.setText(savedInstanceState.get("DATA").toString());
            num1 = savedInstanceState.getString("StringOne");
            num2 = savedInstanceState.getString("StringTwo");
            op = savedInstanceState.getString("Operation");
            equalsClicked = savedInstanceState.getBoolean("equalsClicked");
            equals = (BigDecimal) savedInstanceState.getSerializable("EQUALS");
        }

        //String b = "2";

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button_1:
                        if (data.getText().toString().equals("0")) {
                            data.setText("1");
                        } else data.append("1");
                        break;
                    case R.id.button_2:
                        if (data.getText().toString().equals("0")) {
                            data.setText("2");
                        } else data.append("2");

                        break;
                    case R.id.button_3:
                        if (data.getText().toString().equals("0")) {
                            data.setText("3");
                        } else data.append("3");
                        break;
                    case R.id.button_4:
                        if (data.getText().toString().equals("0")) {
                            data.setText("4");
                        } else data.append("4");
                        break;
                    case R.id.button_5:
                        if (data.getText().toString().equals("0")) {
                            data.setText("5");
                        } else data.append("5");
                        break;
                    case R.id.button_6:
                        if (data.getText().toString().equals("0")) {
                            data.setText("6");
                        } else data.append("6");
                        break;
                    case R.id.button_7:
                        if (data.getText().toString().equals("0")) {
                            data.setText("7");
                        } else data.append("7");
                        break;
                    case R.id.button_8:
                        if (data.getText().toString().equals("0")) {
                            data.setText("8");
                        } else data.append("8");
                        break;
                    case R.id.button_9:
                        if (data.getText().toString().equals("0")) {
                            data.setText("9");
                        } else data.append("9");
                        break;
                    case R.id.button_0:
                        if (data.getText().toString().equals("0")) {
                            data.setText("0");
                        } else data.append("0");
                        break;
                    case R.id.button_dot:
                        if(data.getText().toString().contains(".")){
                            break;
                        }
                        else {
                            data.append(".");
                        }
                        break;
                    case R.id.button_plus:
                            op = "+";
                            num1 = data.getText().toString();
                            data.setText("0");
                            equalsClicked=false;
                        break;
                    case R.id.button_multiply:
                            op = "*";
                            num1 = data.getText().toString();
                            data.setText("0");
                            equalsClicked=false;
                        break;
                    case R.id.button_substract:
                            if(data.getText().toString().isEmpty() || data.getText().toString().equals("0")){
                                data.setText("-");
                            }
                            else {
                                op = "-";
                                num1 = data.getText().toString();
                                data.setText("0");
                                equalsClicked = false;
                            }

                        break;
                    case R.id.button_divide:
                            op = "/";
                            num1 = data.getText().toString();
                            data.setText("0");
                            equalsClicked=false;
                        break;
                    case R.id.button_res:
                        if(op != null) {
                            switch (op) {
                                case "+":
                                    if (equalsClicked) {
                                        BigDecimal tmp = new BigDecimal(data.getText().toString());
                                        tmp = tmp.add(new BigDecimal(num2));
                                        data.setText(tmp.toString());
                                    } else {
                                        equals = equals.add(new BigDecimal(num1));
                                        num2 = data.getText().toString();
                                        equals = equals.add(new BigDecimal(num2));
                                        data.setText(equals.toString());
                                        equals = new BigDecimal("0");
                                        equalsClicked = true;
                                    }
                                    break;
                                case "-":
                                    if (equalsClicked) {
                                        BigDecimal tmp = new BigDecimal(data.getText().toString());
                                        tmp = tmp.subtract(new BigDecimal(num2));
                                        data.setText(tmp.toString());
                                    } else {
                                        equals = equals.add(new BigDecimal(num1));
                                        num2 = data.getText().toString();
                                        equals = equals.subtract(new BigDecimal(num2));
                                        data.setText(equals.toString());
                                        equals = new BigDecimal("0");
                                        equalsClicked = true;
                                    }

                                    break;
                                case "*":
                                    if (equalsClicked) {
                                        BigDecimal tmp = new BigDecimal(data.getText().toString());
                                        tmp = tmp.multiply(new BigDecimal(num2));
                                        data.setText(tmp.toString());
                                    } else {
                                        equals = equals.add(new BigDecimal(num1));
                                        num2 = data.getText().toString();
                                        equals = equals.multiply(new BigDecimal(num2));
                                        data.setText(equals.toString());
                                        equals = new BigDecimal("0");
                                        equalsClicked = true;
                                    }

                                    break;
                                case "/":
                                    if (equalsClicked) {
                                        BigDecimal tmp = new BigDecimal(data.getText().toString());
                                        tmp = tmp.divide(new BigDecimal(num2), 5);
                                        data.setText(tmp.toString());
                                    } else {
                                        equals = equals.add(new BigDecimal(num1));
                                        num2 = data.getText().toString();
                                        equals = equals.divide(new BigDecimal(num2), 5);
                                        data.setText(equals.toString());
                                        equals = new BigDecimal("0");
                                        equalsClicked = true;
                                    }
                                    break;
                            }
                        }
                        break;

                }
            }
        };


        button0.setOnClickListener(listener);
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);
        buttonPlus.setOnClickListener(listener);
        buttonMult.setOnClickListener(listener);
        buttonSub.setOnClickListener(listener);
        buttonRes.setOnClickListener(listener);
        buttonDiv.setOnClickListener(listener);
        buttonDot.setOnClickListener(listener);

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.setText("0");
                num1="0";
                num2="0";
                equals = equals.subtract(equals);
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tmp = data.getText().toString();
                if(tmp.length() >=1 && !tmp.isEmpty()) {
                    tmp = tmp.substring(0, tmp.length() - 1);
                    data.setText(tmp);
                }
                else{
                    data.setText("");
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.help:
                Toast toast = Toast.makeText(getApplicationContext(),"If you want quick calculation please choose operation only once and then repeatedly press the RESULT button.",Toast.LENGTH_LONG);
                toast.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("StringOne",num1);
        outState.putString("StringTwo",num2);
        outState.putString("Operation",op);
        outState.putString("DATA",data.getText().toString());
        outState.putBoolean("equalsClicked",equalsClicked);
        outState.putSerializable("EQUALS",equals);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
}
