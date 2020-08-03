package com.someshwar.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Integer.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click(View view){
        EditText editText=findViewById(R.id.editTextNumber);
        TextView textView=findViewById(R.id.textViewResult);
        if(editText.getText().toString().isEmpty()){
            Toast.makeText(this, "Enter a number", Toast.LENGTH_SHORT).show();
        }else {
            Number myNumber = new Number();
            myNumber.number = parseInt(editText.getText().toString());
            Boolean isT = myNumber.isTriangular(myNumber.number);
            Boolean isS = myNumber.isSquare(myNumber.number);
            String result = "";

            if (isT || isS) {

                //triangular& square
                if (isS && isT) {
                    result = "TRIANGULAR & SQUARE NUMBER";
                }
                if (isS && !isT) {
                    //square
                    result = "SQUARE";
                }
                if (isT && !isS) {
                    //triangular
                    result = "TRIANGULAR";
                }

            } else {
                //Not Both
                result = "NOT BOTH";
            }
            textView.setText(result);
            textView.setVisibility(View.VISIBLE);
        }
    }



    static class Number{
        int number;
        public Boolean isTriangular(int number){
            int x=1;
            int triangularNumber=1;
            while(triangularNumber<number){
                x++;
                triangularNumber=triangularNumber+x;

            }
            return triangularNumber == number;
        }
        public Boolean isSquare(int number){
           double squareRooot=Math.sqrt(number);
            return squareRooot == Math.floor(squareRooot);
        }
    }


}