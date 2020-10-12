package com.example.calculatorx;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ArrowKeyMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button zero, one, two, three, four, five, six, seven, eight, nine,allClear, fpoint, equals;
    ImageButton bckspace, division, product, sub, add;
    private TextView tv_first_op, tv_sec_op, tv_operation, tv_ans, current;
    boolean op_tapped, ans_ready, dot_tapped, first_is_full, sec_is_full;
    private String ans, first_op, sec_op, str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = (findViewById(R.id.nine));
        fpoint = (findViewById(R.id.point));
        equals = (findViewById(R.id.equal));
        allClear = (findViewById(R.id.AC));
        division = (findViewById(R.id.division));
        product = (findViewById(R.id.product));
        bckspace = (findViewById(R.id.clear));
        sub = (findViewById(R.id.minus));
        add = (findViewById(R.id.plus));
        tv_first_op = (findViewById(R.id.first_operand));
        tv_sec_op = (findViewById(R.id.sec_operand));
        tv_operation = (findViewById(R.id.tv_operation));
        tv_ans = (findViewById(R.id.tv_answer));

        all_clear();
    }

    public void all_clear()
    {
        first_op=sec_op=ans=str="";
        current=tv_first_op;
        first_is_full = false;
        sec_is_full = false;
        op_tapped=false;
        dot_tapped=false;
        ans_ready=false;
        tv_first_op.setText("");
        tv_operation.setText("");
        tv_sec_op.setText("");
        tv_ans.setText("");
    }

    public void clear(View view) {

        switch (view.getId()){
            case R.id.AC:
                all_clear();
                break;
            case R.id.clear:
                int n = str.length();
                if (n > 0 && !ans_ready)
                    str = str.substring(0, n-1);
                current.setText(str);
                break;
        }
    }

    public void clickNUMBER(View view) {
        if (ans_ready)
            all_clear();

        switch (view.getId()){
            case R.id.zero:
                if (str.equals("")){
                    str = "0";
                }else
                    str = str + "0";
                current.setText(str);
                break;
            case R.id.one:
                str = str + "1";
                current.setText(str);
                break;
            case R.id.two:
                str = str + "2";
                current.setText(str);
                break;
            case R.id.three:
                str = str + "3";
                current.setText(str);
                break;
            case R.id.four:
                str = str + "4";
                current.setText(str);
                break;
            case R.id.five:
                str = str + "5";
                current.setText(str);
                break;
            case R.id.six:
                str = str + "6";
                current.setText(str);
                break;
            case R.id.seven:
                str = str + "7";
                current.setText(str);
                break;
            case R.id.eight:
                str = str + "8";
                current.setText(str);
                break;
            case R.id.nine:
                str = str + "9";
                current.setText(str);
                break;
            case R.id.point:
                if (str.equals("")){
                    str = "0.";
                    dot_tapped = true;
                    current.setText(str);
                }else if(!dot_tapped){
                    str = str + ".";
                    current.setText(str);
                    dot_tapped = true;
                }
        }
    }

    public void clickOPER(View view) {

        current = tv_operation;
        switch (view.getId()) {
            case R.id.plus:
                current.setText("+");
                break;
            case R.id.minus:
                current.setText("-");
                break;
            case R.id.product:
                current.setText("*");
                break;
            case R.id.division:
                current.setText("/");
                break;
        }
        op_tapped = true;
        current = tv_sec_op;
        str = "";
        dot_tapped = false;
    }

    public void clickEQUAL(View view) {

        first_op = tv_first_op.getText().toString();
        sec_op = tv_sec_op.getText().toString();

        switch (tv_operation.getText().toString()){
            case "+": ans = operationsClass.add(first_op,sec_op);
            break;
            case "-": ans = operationsClass.subtract(first_op,sec_op);
            break;
            case "*": ans = operationsClass.multiply(first_op,sec_op);
            break;
            case "/": ans = operationsClass.divide(first_op,sec_op);
            break;
        }
            tv_ans.setText(ans);
            ans_ready = true;
    }
}


