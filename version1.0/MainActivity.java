package com.example.project_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {
    InputOutput io= new InputOutput();
    Calculate cal = new Calculate();
    ArrayList history = new ArrayList();
    boolean toggle;
    String result="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Toggle(){
        if(toggle) {
            io.delete("AC");
            toggle = false;
        }
    }

    public void auto_Mul() {
        if(io.str_expression.isEmpty()) return;
        String s = (String) io.str_expression.get(io.str_expression.size()-1);
        Pattern p = Pattern.compile("[0-9\\)]");
        Matcher m = p.matcher(s);
        if(m.matches()) io.input("*");
    }

    public void onClick(View view) {

        TextView textView = (TextView)findViewById(R.id.textView);
        TextView historyView = (TextView) findViewById(R.id.historyView);
        ScrollView scrollView = (ScrollView) findViewById(R.id.sv);

        switch (view.getId())
        {
            case R.id.button0:
                Toggle();
                io.input("0");
                break;
            case R.id.button1:
                Toggle();
                io.input(".");
                break;
            case R.id.button2:
                Toggle();
                auto_Mul();
                io.input("10");
                io.input("^");
                io.input("(");
                break;
            case R.id.button3:
                Toggle();
                io.input(result);
                break;
            case R.id.button4:
                String expression = String.join("",io.str_expression);
                io.str_to_array();
                io.delete("AC");
                result = String.valueOf(cal.postfixCalculation(io.input_array));
                io.input(result);

                history.add( expression +"=" +result+"\n");
                historyView.append((CharSequence) history.get(history.size()-1));
                scrollView.fullScroll(View.FOCUS_DOWN);


                cal.init();
                io.input_array.clear();
                toggle = true;

                break;
            case R.id.button5:
                Toggle();
                io.input("1");
                break;
            case R.id.button6:
                Toggle();
                io.input("2");
                break;
            case R.id.button7:
                Toggle();
                io.input("3");
                break;
            case R.id.button8:
                Toggle();
                io.input("+");
                break;
            case R.id.button9:
                Toggle();
                io.input("-");
                break;
            case R.id.button10:
                Toggle();
                io.input("4");
                break;
            case R.id.button11:
                Toggle();
                io.input("5");
                break;
            case R.id.button12:
                Toggle();
                io.input("6");
                break;
            case R.id.button13:
                Toggle();
                io.input("*");
                break;
            case R.id.button14:
                Toggle();
                io.input("/");
                break;
            case R.id.button15:
                Toggle();
                io.input("7");
                break;
            case R.id.button16:
                Toggle();
                io.input("8");
                break;
            case R.id.button17:
                Toggle();
                io.input("9");
                break;
            case R.id.button18:
                Toggle();
                io.delete("Del");
                break;
            case R.id.button19:
                Toggle();
                io.delete("AC");
                break;
            case R.id.button20:
                Toggle();
                io.input("(");
                break;
            case R.id.button21:
                Toggle();
                io.input(")");
                break;
            case R.id.button22:
                Toggle();
                auto_Mul();
                io.input("s");
                io.input("(");
                break;
            case R.id.button23:
                Toggle();
                auto_Mul();
                io.input("c");
                io.input("(");
                break;
            case R.id.button24:
                Toggle();
                auto_Mul();
                io.input("t");
                io.input("(");
                break;
            case R.id.button25:
                Toggle();
                io.input("_");
                break;
            case R.id.button26:
                Toggle();
                io.input("a");
                break;
            case R.id.button27:
                Toggle();
                auto_Mul();
                io.input("r");
                io.input("(");
                io.input("2");
                io.input(")");
                io.input("(");
                break;
            case R.id.button28:
                Toggle();
                io.input("^");
                io.input("2");
                break;
            case R.id.button29:
                Toggle();
                auto_Mul();
                io.input("l");
                io.input("(");
                io.input("10");
                io.input(")");
                io.input("(");
                break;
            case R.id.button30:
                Toggle();
                io.input("!");
                break;
            case R.id.button31:
                Toggle();
                io.input("%");
                break;
            case R.id.button32:
                Toggle();
                auto_Mul();
                io.input("r");
                io.input("(");
                break;
            case R.id.button33:
                Toggle();
                io.input("^");
                break;
            case R.id.button34:
                Toggle();
                auto_Mul();
                io.input("l");
                io.input("(");
                io.input("e");
                io.input(")");
                io.input("(");
                break;
            case R.id.button35:
                Toggle();
                auto_Mul();
                io.input("e");
                break;
            case R.id.button36:
                Toggle();
                auto_Mul();
                io.input("p");
                break;
            case R.id.button37:
                Toggle();
                io.input("d");
                break;
            case R.id.button38:
                Toggle();
                io.input("^");
                io.input("(");
                io.input("-1");
                io.input(")");
                break;
            case R.id.button39:
                Toggle();
                auto_Mul();
                io.input("l");
                io.input("(");
                break;
        }

        textView.setText(String.join("",io.str_expression));
    }



}