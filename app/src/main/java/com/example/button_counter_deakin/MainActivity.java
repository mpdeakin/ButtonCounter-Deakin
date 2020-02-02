/*
Author: Michael Deakin
Info:   CSCI370-Spring-2020-HW3
Last:   01/31/2020
Desc:   An application that includes the ability to increase, decrease, and reset
        the integer value displayed. Maintains state across orientation changes.
*/

package com.example.button_counter_deakin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // by default, count val is 0
        // if a saved instance exists, there should be a saved count val
        int countVal = 0;
        if (savedInstanceState != null)
        {
            countVal = savedInstanceState.getInt("countVal");
        }
        setContentView(R.layout.activity_main);
        updateCountString(countVal);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        // save the count val to maintain value when orientation changes
        int countVal = parseCountInt();
        savedInstanceState.putInt("countVal", countVal);
    }

    // when the button labeled "+" is tapped,
    // increase the value of count
    public void increaseCount(View view)
    {
        int countVal = parseCountInt() + 1;
        updateCountString(countVal);
        return;
    }

    // when the button labeled "-" is tapped,
    // decrease the value of count
    public void decreaseCount(View view)
    {
        int countVal = parseCountInt() - 1;
        updateCountString(countVal);
        return;
    }

    // when the button labeled "RESET" is tapped,
    // reset the value of count
    public void resetCount(View view)
    {
        updateCountString(0);
        return;
    }

    // parse the int value from the count text object
    private int parseCountInt()
    {
        TextView countText = super.findViewById(R.id.countText);
        String countStr = countText.getText().toString();
        int countVal = (int)Integer.parseInt(countStr);
        return countVal;
    }

    // get the count text object and set its value to countVal
    private void updateCountString(int countVal)
    {
        TextView countText = super.findViewById(R.id.countText);
        countText.setText(String.valueOf(countVal));
        return;
    }
}
