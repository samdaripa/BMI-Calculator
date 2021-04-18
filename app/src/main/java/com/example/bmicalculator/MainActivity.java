package com.example.bmicalculator;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    public  void bmiCalc(View view){
        EditText editHeight = (EditText) findViewById(R.id.height1);
        EditText editWeight = (EditText) findViewById(R.id.weight1);
        final TextView outputBmi = (TextView) findViewById(R.id.result);
        final TextView message = (TextView) findViewById(R.id.result2);

        //Get Value from Text Edit and parse into Double
        String strHeight= editHeight.getText().toString().trim();
        double height = Double.parseDouble(strHeight);
        String strWeight= editWeight.getText().toString().trim();
        double weight = Double.parseDouble(strWeight);

        //BMI Working Formula
       double hm= height/100.0;   //Convert into Meter
       double bmi = 1.0*weight/(hm*hm);
        DecimalFormat df = new DecimalFormat("#.##");   // Define Decimal format for display 2 decimal pint
        String res = df.format(bmi);


       //Message print according to your BMI according to BMI value
       if(bmi<18.5){
           message.setText("Time to grab a Bite !");
           message.setTextColor(Color.RED);
           outputBmi.setTextColor(Color.RED);
       }
       else if(bmi<25.0){
           message.setText("Great Shape !");
           message.setTextColor(Color.rgb(8,194,70));
           outputBmi.setTextColor(Color.rgb(8,194,70));

       }
       else{
           message.setText("Time for a Run !");
           message.setTextColor(Color.rgb(255, 183,0));
           outputBmi.setTextColor(Color.rgb(255, 183,0));
       }
       //Display BMI Value in Screen
        outputBmi.setText(res);

        // Use toaster for Button is working or not.  Just use it for fun nothing else
        Toast.makeText(getApplicationContext(),
               "SUCCESSFULL",
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Define Window object and WindowManager for changeing the color of toolbar
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        int colorCodeDark = Color.parseColor("#13b50b");
        window.setStatusBarColor(colorCodeDark);

        // Define ActionBar object
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
        ColorDrawable colorDrawable= new ColorDrawable(Color.parseColor("#13b50b"));
        actionBar.setBackgroundDrawable(colorDrawable);  //set a background color for action Bar

        Button btn = (Button)findViewById(R.id.ButtonBMI);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                bmiCalc(v);   // Call our bmical() function
            }
        });
    }

}