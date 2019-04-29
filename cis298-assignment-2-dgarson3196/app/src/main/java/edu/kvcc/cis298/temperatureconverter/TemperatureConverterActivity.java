package edu.kvcc.cis298.temperatureconverter;

//Daniel Garson
//CIS 298
//Due 2-13-19

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TemperatureConverterActivity extends AppCompatActivity {

    //input variables
    private EditText uInput;
    double varInput;

    //button selection variables
    int mfromSelected;
    int mtoSelected;

    //string variables for temperature symbols
    private String mfromString;
    private String mtoString;

    private String mConvertedTemp;

    private String mequation;

    //radio button group variables
    private RadioGroup mfromGroup;
    private RadioGroup mtoGroup;

    //from and to radio buttons for each temperature
    private RadioButton mfromC;
    private RadioButton mfromF;
    private RadioButton mfromK;
    private RadioButton mtoC;
    private RadioButton mtoF;
    private RadioButton mtoK;


    //convert button
    private Button mconvertButton;

    // equation and type of conversion text variables
    private TextView mConversion;
    private TextView meText;

    //convert temperatures
    private Conversion convertTemps;

    //update the temperatures
    private void UpdateTemperature() {

        //from
        switch (mfromGroup.getCheckedRadioButtonId()) {

            //Celsius
            case R.id.from_celsius:
                mfromSelected = 0;
                mfromString = "°C";
                break;

           //Fahrenheit
            case R.id.from_fahrenheit:
                mfromSelected = 1;
                mfromString = "°F";
                break;

            //Kelvin
            case R.id.from_kelvin:
                mfromSelected = 2;
                mfromString = "K";
                break;


        }

        //To
        switch (mtoGroup.getCheckedRadioButtonId()) {

            //Celsius
            case R.id.to_celsius:
                mtoSelected = 0;
                mtoString = "°C";
                break;

            //Fahrenheit
            case R.id.to_fahrenheit:
                mtoSelected = 1;
                mtoString = "°F";
                break;

            //Kelvin
            case R.id.to_kelvin:
                mtoSelected = 2;
                mtoString = "K";
                break;


        }

    }

    //onCreate Method
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_converter);

        uInput = (EditText) findViewById(R.id.user_input);

        mfromGroup = (RadioGroup) findViewById(R.id.from_radio_group);
        mtoGroup = (RadioGroup) findViewById(R.id.to_radio_group);

        mfromC = (RadioButton) findViewById(R.id.from_celsius);
        mfromF = (RadioButton) findViewById(R.id.from_fahrenheit);
        mfromK = (RadioButton) findViewById(R.id.from_kelvin);


        mtoC = (RadioButton) findViewById(R.id.to_celsius);
        mtoF = (RadioButton) findViewById(R.id.to_fahrenheit);
        mtoK = (RadioButton) findViewById(R.id.to_kelvin);


        meText = (TextView) findViewById(R.id.equation_output);
        mConversion = (TextView) findViewById(R.id.conversion_output);

        mconvertButton = (Button) findViewById(R.id.convert_button);
        mconvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //call updateTemperature onclick
                UpdateTemperature();

                //error handling

                //try catch starts here
                try {
                    varInput = Double.parseDouble(uInput.getText().toString());
                    convertTemps = new Conversion(mfromSelected, mtoSelected, varInput);


                    mequation = convertTemps.getType();
                    mConvertedTemp = String.format("%.2f", convertTemps.Convert());

                    meText.setText(mequation + "");
                    mConversion.setText(varInput + "" + mfromString + " = " + mConvertedTemp + mtoString);
                }
                //catch if invalid input
                catch (NumberFormatException e) {
                    Toast.makeText(TemperatureConverterActivity.this,"Error: Enter A Number",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

        // check if saveInstance isn't null
        if (savedInstanceState != null) {
            varInput = savedInstanceState.getDouble("User_Input", 0);
            uInput.setText(varInput + "");

            mConvertedTemp = savedInstanceState.getString("Conversion_Text");
            mequation = savedInstanceState.getString("Equation_Text");

            mfromString = savedInstanceState.getString("From_Symbol");
            mtoString = savedInstanceState.getString("To_Symbol");

            if (mfromString != null) {
                meText.setText(mequation + "");
                mConversion.setText(varInput + "" + mfromString +
                        " = " + mConvertedTemp + mtoString);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outputState) {
        super.onSaveInstanceState(outputState);
        outputState.putDouble("User_Input", varInput);
        outputState.putString("From_Symbol", mfromString);
        outputState.putString("To_Symbol", mtoString);
        outputState.putString("Conversion_Text", mConvertedTemp);
        outputState.putString("Equation_Text", mequation);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // adds items to the action bar if it exists.
        getMenuInflater().inflate(R.menu.menu_temperature_converter, menu);
        return true;
    }


}