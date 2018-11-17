package com.example.taruc.lab34picker;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    int age,balance;

    double eligibleAmount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),getString(R.string.datepicker));
    }
    public void calculate(View view){
        if(age >=16 && age <=20 && balance>=5000 ){
            eligibleAmount = (balance - 5000)*0.3;
        }else if(age >=21 && age <=25 &&balance>=14000){
            eligibleAmount = (balance - 14000)*0.3;
        }else if(age >=26 && age <=30 &&balance>=29000) {
            eligibleAmount = (balance - 29000)*0.3 ;
        }else if(age >=31 && age <=35 &&balance>=50000){
            eligibleAmount = (balance - 50000)*0.3 ;
        }else if(age >=36 && age <=40 &&balance>=78000){
            eligibleAmount = (balance - 78000)*0.3 ;
        }else if(age >=41 && age <=45 &&balance>=116000){
            eligibleAmount = (balance - 116000)*0.3 ;
        }else if(age >=46 && age <=50 &&balance>=165000){
            eligibleAmount = (balance - 165000)*0.3 ;
        }else if(age >=51 && age <=55 &&balance>=228000){
            eligibleAmount = (balance - 228000)*0.3 ;
        }else
        {
            eligibleAmount=0;
        }

        TextView textViewEligibleAmount = findViewById(R.id.textViewEligibleAmount);
        textViewEligibleAmount.setText("Eligible Amount : " + eligibleAmount);
    }

    public void processDatePickerResult(int year, int month, int day) {

        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string +
                "/" + day_string + "/" + year_string);
        TextView buttonDOB = findViewById(R.id.buttonDOB);
        buttonDOB.setText(dateMessage);

        EditText editTextAccountBalance = findViewById(R.id.editTextAccountBalance);
        balance = Integer.parseInt(editTextAccountBalance.getText().toString());

        Toast.makeText(this, "Date: " + dateMessage,
                Toast.LENGTH_SHORT).show();

        Calendar calendar = Calendar.getInstance();
        int thisyear = calendar.get(Calendar.YEAR);
        age = thisyear-year;

        TextView textViewAge = findViewById(R.id.textViewAge);
        textViewAge.setText("Age :"+ Integer.toString(age) );





    }
    public void reset(View view){
        EditText editTextAccountBalance = findViewById(R.id.editTextAccountBalance);
        editTextAccountBalance.setText("");
        TextView textViewAge = findViewById(R.id.textViewAge);
        textViewAge.setText("Age :");
        TextView textViewEligibleAmount = findViewById(R.id.textViewEligibleAmount);
        textViewEligibleAmount.setText("Eligible Amount : ");
        TextView buttonDOB = findViewById(R.id.buttonDOB);
        buttonDOB.setText("Select Date of Birth");







    }

}
