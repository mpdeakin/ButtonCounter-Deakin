/*
Author: Michael Deakin
Info:   CSCI370-Spring-2020-HW3
Last:   01/31/2020
Desc:   An application that includes the ability to increase, decrease, and reset
        the integer value displayed.
*/

package com.example.button_counter_deakin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // when the button labeled "+" is tapped,
    // increase the value of count
    public void increaseCount(View view)
    {
        TextView countText = super.findViewById(R.id.countText);
        String countStr = countText.getText().toString();
        int countVal = (int)Integer.parseInt(countStr);
        countVal++;
        countText.setText(String.valueOf(countVal));
        return;
    }

    // when the button labeled "-" is tapped,
    // decrease the value of count
    public void decreaseCount(View view)
    {
        TextView countText = super.findViewById(R.id.countText);
        String countStr = countText.getText().toString();
        int countVal = (int)Integer.parseInt(countStr);
        countVal--;
        countText.setText(String.valueOf(countVal));
        return;
    }

    // when the button labeled "RESET" is tapped,
    // reset the value of count
    public void resetCount(View view)
    {
        TextView countText = super.findViewById(R.id.countText);
        countText.setText("0");
        return;
    }
}
