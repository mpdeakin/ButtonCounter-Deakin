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
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    Button addButton;
    Button subButton;
    Button resetButton;
    TextView countText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get references to all current widgets
        addButton = super.findViewById(R.id.countIncButton);
        subButton = super.findViewById(R.id.countDecButton);
        resetButton = super.findViewById(R.id.clearButton);
        countText = super.findViewById(R.id.countText);

        // add click listener for "add" button
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // increase value of count each click event
                String countStr = countText.getText().toString();
                int countVal = (int) Integer.parseInt(countStr) + 1;
                countText.setText(String.valueOf(countVal));
            }
        }
        );

        // add click listener for "sub" button
        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // decrease value of count for each click event
                String countStr = countText.getText().toString();
                int countVal = (int) Integer.parseInt(countStr) - 1;
                countText.setText(String.valueOf(countVal));
            }
        });

        // add click listener for "reset" button
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // set value to 0 when clicked
                countText.setText("0");
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        // save the count val to maintain value when orientation changes
        countText = super.findViewById(R.id.countText);
        int countVal = (int)Integer.parseInt(countText.getText().toString());
        savedInstanceState.putInt("countVal", countVal);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        int countVal = 0;
        // if saved instance exists, should be a count value to restore
        if (savedInstanceState != null)
        {
            countVal = savedInstanceState.getInt("countVal");
        }
        // restore count value to count text
        countText = super.findViewById(R.id.countText);
        countText.setText(Integer.toString(countVal));
    }
}
