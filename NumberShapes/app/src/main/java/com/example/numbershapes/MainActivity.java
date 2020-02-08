package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number
    {
        int number;

        public boolean isSquare()
        {
            double squareRoot = Math.sqrt(number);
            if(squareRoot == Math.floor(squareRoot))
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public boolean isTriangular()
        {
            int x = 1;
            int triangularNumber = 1;
            while(triangularNumber<number)
            {
                x++;
                triangularNumber += x;
            }

            if(number == triangularNumber)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
        public void CheckFunction(View view)
        {
            Log.i("Value", "Button Clicked");

            EditText editText = (EditText) findViewById(R.id.editText);

            String msg;
            if(editText.getText().toString().isEmpty())
            {
                msg = "Field can't be left empty";
            }
            else
            {
                Number num = new Number();
                num.number = Integer.parseInt(editText.getText().toString());
                msg = editText.getText().toString();

                if(num.isTriangular() && num.isSquare())
                {
                    msg += " is both Triangular and Square Number";
                }
                else if(num.isSquare())
                {
                    msg += " is a Square Number";
                }
                else if(num.isTriangular())
                {
                    msg += " is a Triangular Number";
                }
                else
                {
                    msg += " is neither Triangular nor Square Number";
                }
            }

            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
