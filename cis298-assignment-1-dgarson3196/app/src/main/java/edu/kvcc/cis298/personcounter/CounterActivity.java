package edu.kvcc.cis298.personcounter;


// Daniel Garson
//CIS 298
//Assignment #1

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CounterActivity extends AppCompatActivity {

    // variables
    private Button pButton;
    private Button mButton;
    private TextView NumberInc;
    private int Count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        // Assign variables
        pButton= (Button)findViewById(R.id.plus_button);
        mButton = (Button)findViewById(R.id.minus_button);
        NumberInc = (TextView)findViewById(R.id.number_Incrementer);

        pButton.setOnClickListener(new View.OnClickListener() {
            // On click of Plus button Increment by 1
            // call the method updatenum to display new number
            // call Toastmessage to display message if over 20
            @Override
            public void onClick(View v) {
                Count++;
                Updatenum();
                ToastMessage();
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            // On click of Minus button Decrement by 1
            // call the method updatenum to display new number
            @Override
            public void onClick(View v) {
                Count--;
                Updatenum();
            }
        });

    }

    // method for Incrementing and Decrementing number based on + & - button
    private void Updatenum() {
        NumberInc.setText(Integer.toString(Count));
    }

   // method used for toast message only called if count is over 20
    private void ToastMessage() {
        if (Count > 20 & (Count - 1) == 20) {
            Toast.makeText(this, R.string.count_message,
                            Toast.LENGTH_SHORT).show();
        }
    }
}