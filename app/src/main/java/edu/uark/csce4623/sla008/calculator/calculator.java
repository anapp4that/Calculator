package edu.uark.csce4623.sla008.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;
import java.text.DecimalFormat;
import java.text.NumberFormat;


public class calculator extends AppCompatActivity implements View.OnClickListener{
    //Variables
    //strings to keep track of the numbers
    float temp;
    String oprand1 = "";
    String oprand2 = "";
    //keep track of what math operation we are doing
    String operator = "";
    String result = "";

    //keep track of which operand we are entering in
    boolean flag1 = false;
    boolean resultFlag = false;

    //format the decimals
    DecimalFormat deci = new DecimalFormat(".##");

    //update the text displayed
    TextView num;


    //this function gets called when ever we do a calculation.
    public String calc(String op1, String op2, String operator){
        double temp;

        if(operator == "+"){
            temp = Double.valueOf(op1) + Double.valueOf(op2);
        }
        else if(operator == "-"){
            temp = Double.valueOf(op1) - Double.valueOf(op2);
        }
        else if(operator == "*"){
            temp = Double.valueOf(op1) * Double.valueOf(op2);
        }
        else /*(operator == "÷")*/{ //remove the previous comment to easily add more math functions
            temp = Double.valueOf(op1) / Double.valueOf(op2);
        }
        return Double.toString(temp);
    }

    //Choose the best way to format the string we want to display
    public String formatDisplayString(String string){
        NumberFormat nf = DecimalFormat.getInstance();
        //if whole number
        if(Double.valueOf(string) > 999999 || Double.valueOf(string) < 0.001){
            
        }
        else if(Double.valueOf(string) % 1 == 0){
            Log.d("myTag", "formatting string");
            nf.setMaximumFractionDigits(0);
            return nf.format(Double.valueOf(string));
        }
        //if there are decimals
        else{
            Log.d("myTag", "formatting string");
            nf.setMaximumFractionDigits(3);
            return nf.format(Double.valueOf(string));
        }
    }

    public void updateDisplay(){
        //display result
        if(resultFlag){
            num.setText(formatDisplayString(result));
            resultFlag = false;
        }//display the first part of the equation
        else if(!flag1 && !resultFlag){
            num.setText(formatDisplayString(oprand1));
        }//display the first part, the operator, and the second part of the equation
        else if(flag1 && operator != "" && oprand2 != ""){
            num.setText(formatDisplayString(oprand1) + operator + formatDisplayString(oprand2));
        }//dispaly the first part and the operation symbol
        else if(flag1 && operator != ""){
            num.setText(formatDisplayString(oprand1) + operator);
        }

    }

    @Override
    public void onClick(View view){
        num = (TextView)findViewById(R.id.display);
        //Listen for click and do something when we get one
        switch(view.getId()){

            case R.id.btn0:
                //if we havent finished entering the first operand
                if(!flag1){
                    if(oprand1 != "0" && oprand1 != ""){
                        oprand1 = oprand1 + "0";
                        updateDisplay();
                        //Log.d("myTag", oprand1);
                    }
                } //if we have finished entering the first operand
                else{
                    if(oprand2 != "0" && oprand2 != ""){
                        oprand2 = oprand2 + "0";
                        updateDisplay();
                        //Log.d("myTag", oprand2);
                    }
                }
                break;

            case R.id.btn1:
                if(!flag1) {
                    oprand1 = oprand1 + "1";
                    updateDisplay();
                    //Log.d("myTag", oprand1);
                }
                else{
                    oprand2 = oprand2 + "1";
                    updateDisplay();
                    //Log.d("myTag", oprand2);
                }
                break;

            case R.id.btn2:
                if(!flag1) {
                    oprand1 = oprand1 + "2";
                    updateDisplay();
                    //Log.d("myTag", oprand1);
                }
                else{
                    oprand2 = oprand2 + "2";
                    updateDisplay();
                    //Log.d("myTag", oprand2);
                }
                break;

            case R.id.btn3:
                if(!flag1) {
                    oprand1 = oprand1 + "3";
                    updateDisplay();
                    //Log.d("myTag", oprand1);
                }
                else{
                    oprand2 = oprand2 + "3";
                    updateDisplay();
                    //Log.d("myTag", oprand2);
                }
                break;

            case R.id.btn4:
                if(!flag1) {
                    oprand1 = oprand1 + "4";
                    updateDisplay();
                    //Log.d("myTag", oprand1);
                }
                else{
                    oprand2 = oprand2 + "4";
                    updateDisplay();
                    //Log.d("myTag", oprand2);
                }
                break;

            case R.id.btn5:
                if(!flag1) {
                    oprand1 = oprand1 + "5";
                    updateDisplay();
                    //Log.d("myTag", oprand1);
                }
                else{
                    oprand2 = oprand2 + "5";
                    updateDisplay();
                    //Log.d("myTag", oprand2);
                }
                break;

            case R.id.btn6:
                if(!flag1) {
                    oprand1 = oprand1 + "6";
                    updateDisplay();
                    //Log.d("myTag", oprand1);
                }
                else{
                    oprand2 = oprand2 + "6";
                    updateDisplay();
                    //Log.d("myTag", oprand2);
                }
                break;

            case R.id.btn7:
                if(!flag1) {
                    oprand1 = oprand1 + "7";
                    updateDisplay();
                    //Log.d("myTag", oprand1);
                }
                else{
                    oprand2 = oprand2 + "7";
                    updateDisplay();
                    //Log.d("myTag", oprand2);
                }
                break;

            case R.id.btn8:
                if(!flag1) {
                    oprand1 = oprand1 + "8";
                    updateDisplay();
                    //Log.d("myTag", oprand1);
                }
                else{
                    oprand2 = oprand2 + "8";
                    updateDisplay();
                    //Log.d("myTag", oprand2);
                }
                break;

            case R.id.btn9:
                if(!flag1) {
                    oprand1 = oprand1 + "9";
                    updateDisplay();
                    //Log.d("myTag", oprand1);
                }
                else{
                    oprand2 = oprand2 + "9";
                    updateDisplay();
                    //Log.d("myTag", oprand2);
                }
                break;

            //non numbers
            case R.id.btn10:
                if(!flag1) {
                    oprand1 = oprand1 + ".";
                    updateDisplay();
                    //Log.d("myTag", oprand1);
                }
                else{
                    oprand2 = oprand2 + ".";
                    updateDisplay();
                    //Log.d("myTag", oprand2);
                }
                break;

            //delete
            case R.id.btn11:
                if(!flag1 && oprand1 != ""){
                    String temp = "";
                    for(int i =0; i < oprand1.length()-1; i++){
                        temp = temp + oprand1.charAt(i);
                    }
                    oprand1 = temp;
                    updateDisplay();
                    //Log.d("myTag", oprand1);
                }
                else{
                    String temp = "";
                    for(int i =0; i < oprand2.length()-1; i++){
                        temp = temp + oprand2.charAt(i);
                    }
                    oprand2 = temp;
                    updateDisplay();
                    //Log.d("myTag", oprand2);
                }
                break;

            //TODO on math functions, make it so you dont have to hit ==, IE when you do 1+2+3
            case R.id.btn12:
                //"÷" button
                //Log.d("myTag", "Button ÷ Pushed");


                //this if/else logic allows user to do something like 1+2+3= and get 6
                //if we are not already done with operand ones input
                //if we have an operator
                if(operator != "" && flag1 && oprand2 !=""){
                    oprand1 = calc(oprand1, oprand2, operator);
                    flag1 = false;
                    resultFlag = false;
                    oprand2 = "";
                    operator = "";
                    updateDisplay();

                }
                if(!flag1){
                    if(oprand1 == ""){
                        oprand1 = result;
                    }
                    //we are done with operand ones entry
                    flag1 = true;
                    operator = "÷";
                    updateDisplay();
                }
                else{
                    //do the calculation and save the result to oprand1
                    result = calc(oprand1,oprand2,operator);
                    updateDisplay();
                    //Log.d("myTag", "Result = " + result);

                }

                break;
            case R.id.btn13:
                //"*" button
                //Log.d("myTag", "Button * Pushed");
                if(operator != "" && flag1 && oprand2 !=""){
                    oprand1 = calc(oprand1, oprand2, operator);
                    flag1 = false;
                    resultFlag = false;
                    oprand2 = "";
                    operator = "";
                    updateDisplay();

                }
                //if we are not already done with operand ones input
                if(!flag1){
                    if(result == "" && oprand1 == ""){
                        oprand1="0";
                    }
                    if(oprand1==""){
                        oprand1 = result;
                    }
                    //we are done with operand ones entry
                    flag1 = true;
                    operator = "*";
                    updateDisplay();
                }
                else{
                    result = calc(oprand1,oprand2,operator);
                    oprand1 = "";
                    flag1 = false;
                    oprand2 = "";
                    updateDisplay();
                    //Log.d("myTag", "Result = " + result);
                }
                break;
            case R.id.btn14:
                //"-" button
                if(operator != "" && flag1 && oprand2 !=""){
                    oprand1 = calc(oprand1, oprand2, operator);
                    flag1 = false;
                    resultFlag = false;
                    oprand2 = "";
                    operator = "";
                    updateDisplay();

                }
                //if we are not already done with operand ones input
                if(!flag1){
                    if(result == "" && oprand1 == ""){
                        oprand1="0";
                    }
                    if(oprand1==""){
                        oprand1 = result;
                    }
                    //we are done with operand ones entry
                    flag1 = true;
                    operator = "-";
                    updateDisplay();
                }
                else{
                    result = calc(oprand1,oprand2,operator);
                    updateDisplay();
                    //Log.d("myTag", "Result = " + result);
                }
                break;
            case R.id.btn15:
                //"+" button
                if(operator != "" && flag1 && oprand2 !=""){
                    oprand1 = calc(oprand1, oprand2, operator);
                    flag1 = false;
                    resultFlag = false;
                    oprand2 = "";
                    operator = "";
                    updateDisplay();

                }
                //if we are not already done with operand ones input
                if(!flag1) {
                    if(result == "" && oprand1 == ""){
                        oprand1="0";
                    }
                    if(oprand1==""){
                        oprand1 = result;
                    }
                    //we are done with operand ones entry
                    flag1 = true;
                    operator = "+";
                    updateDisplay();
                }
                else{
                    result = calc(oprand1,oprand2,operator);
                    updateDisplay();
                    //Log.d("myTag", "Result = " + result);
                }
                break;
            case R.id.btn16:
                //"=" button
                //if we are not already done with operand ones input
                if(flag1){
                    if(result == "" && oprand1 == ""){
                        oprand1="0";
                    }
                    result = calc(oprand1,oprand2,operator);
                    Log.d("myTag", "Result = " + result);
                    //num.setText(result);
                    flag1 = false;
                    resultFlag = true;
                    updateDisplay();

                    oprand1 = "";
                    oprand2 = "";
                    operator = "";
                }
                break;
            case R.id.btn17:
                //clear button
                num.setText("0");
                flag1 = false;
                resultFlag = false;
                oprand1 = "";
                oprand2 = "";
                result = "";
                break;
            case R.id.btn18:
                //"+/-" button
                if(!flag1){
                    if(oprand1==""){
                        oprand1 = result;
                    }
                    if(oprand1 != "") {
                        //change the value of oprand1
                        double numToNegate = Double.valueOf(oprand1);
                        numToNegate = numToNegate * -1;
                        oprand1 = Double.toString(numToNegate);
                        updateDisplay();
                    }
                }
                else {
                    //change the value of oprand 2
                    if(oprand2 != "") {
                        double numToNegate = Double.valueOf(oprand2);
                        numToNegate = numToNegate * -1;
                        oprand2 = Double.toString(numToNegate);
                        updateDisplay();
                    }
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        //Set up buttons and onClickListeners for the numbers
        Button zero = (Button) findViewById(R.id.btn0);
        zero.setOnClickListener(this);
        Button one = (Button) findViewById(R.id.btn1);
        one.setOnClickListener(this);
        Button two = (Button) findViewById(R.id.btn2);
        two.setOnClickListener(this);
        Button three = (Button) findViewById(R.id.btn3);
        three.setOnClickListener(this);
        Button four = (Button) findViewById(R.id.btn4);
        four.setOnClickListener(this);
        Button five = (Button) findViewById(R.id.btn5);
        five.setOnClickListener(this);
        Button six = (Button) findViewById(R.id.btn6);
        six.setOnClickListener(this);
        Button seven = (Button) findViewById(R.id.btn7);
        seven.setOnClickListener(this);
        Button eight = (Button) findViewById(R.id.btn8);
        eight.setOnClickListener(this);
        Button nine = (Button) findViewById(R.id.btn9);
        nine.setOnClickListener(this);

        //onClickListeners for the symbols
        // . button
        Button dec = (Button) findViewById(R.id.btn10);
        dec.setOnClickListener(this);
        // delete button
        Button del = (Button) findViewById(R.id.btn11);
        del.setOnClickListener(this);
        // ÷ button
        Button div = (Button) findViewById(R.id.btn12);
        div.setOnClickListener(this);
        // * button
        Button mult = (Button) findViewById(R.id.btn13);
        mult.setOnClickListener(this);
        // - button
        Button minus = (Button) findViewById(R.id.btn14);
        minus.setOnClickListener(this);
        // + button
        Button plus = (Button) findViewById(R.id.btn15);
        plus.setOnClickListener(this);
        // = button
        Button equals = (Button) findViewById(R.id.btn16);
        equals.setOnClickListener(this);
        // clear button
        Button clr = (Button) findViewById(R.id.btn17);
        clr.setOnClickListener(this);
        // +/- button
        Button sign = (Button) findViewById(R.id.btn18);
        sign.setOnClickListener(this);
    }
}
