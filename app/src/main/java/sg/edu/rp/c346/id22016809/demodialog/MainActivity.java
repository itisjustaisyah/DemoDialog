package sg.edu.rp.c346.id22016809.demodialog;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnDemo1;
    TextView tvDemo2;
    Button btnDemo2;
    Button btnDemo3;
    TextView tvDemo3;
    Button buttonE3;
    TextView textViewE3;
    Button btnDemo4;
    TextView tvDemo4;
    Button btnDemo5;
    TextView tvDemo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = findViewById(R.id.buttonDemo1);

        tvDemo2 = findViewById(R.id.textViewDemo2);
        btnDemo2 = findViewById(R.id.buttonDemo2);

        btnDemo3 = findViewById(R.id.buttonDemo3);
        tvDemo3 = findViewById(R.id.textViewDemo3);


        buttonE3 = findViewById(R.id.buttonE3);
        textViewE3 = findViewById(R.id.textViewE3);

        btnDemo4 = findViewById(R.id.buttonDemo4);
        tvDemo4 = findViewById(R.id.textViewDemo4);

        btnDemo5 = findViewById(R.id.buttonDemo5);
        tvDemo5 = findViewById(R.id.textViewDemo5);


        btnDemo1.setOnClickListener(view -> {
            AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
            /*
            //set dialog details
            myBuilder.setTitle("Demo 1-simple Dialog");
            myBuilder.setMessage("I can develop Android App");
            myBuilder.setCancelable(false);
            myBuilder.setPositiveButton("Close", null);*/

            myBuilder.setTitle("Congratulations");
            myBuilder.setMessage("You have completed a simple Dialog Box");
            myBuilder.setCancelable(false);
            myBuilder.setPositiveButton("Dismiss", null);

            AlertDialog myDialog = myBuilder.create();
            myDialog.show();
        });

        btnDemo2.setOnClickListener(view -> {
            AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
            myBuilder.setTitle("Demo 2 Buttons Dialog");
            myBuilder.setMessage("Select one of the buttons below");
            myBuilder.setCancelable(false);

            myBuilder.setPositiveButton("Yes", (dialog, which) -> tvDemo2.setText("You have selected Positive"));
            myBuilder.setNegativeButton("No", (dialog, which) -> tvDemo2.setText("You have selected Negative"));

            myBuilder.setNeutralButton("Cancel", null);
            AlertDialog myDialog = myBuilder.create();
            myDialog.show();
        });

        btnDemo3.setOnClickListener(v -> {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View viewDialog = inflater.inflate(R.layout.input, null);

            final EditText etInput = viewDialog.findViewById(R.id.editTextInput);

            AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
            myBuilder.setView(viewDialog);
            myBuilder.setTitle("Demo 3-Text input dialog");
            myBuilder.setPositiveButton("OK", (dialog, which) -> {
                String message = etInput.getText().toString();
                tvDemo3.setText(message);
            });
            myBuilder.setNegativeButton("CANCEL", null);
            AlertDialog myDialog = myBuilder.create();
            myDialog.show();
        });

        buttonE3.setOnClickListener(v ->{
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View viewDialog = inflater.inflate(R.layout.doubleinput, null);

            final EditText etInput1 = viewDialog.findViewById(R.id.editTextInput1);
            final EditText etInput2 = viewDialog.findViewById(R.id.editTextInput2);

            AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
            myBuilder.setView(viewDialog);
            myBuilder.setTitle("Demo 3-Text input dialog");
            myBuilder.setPositiveButton("OK", (dialog, which) -> {
                int add1 = Integer.parseInt(etInput1.getText().toString());
                int add2 = Integer.parseInt(etInput2.getText().toString());

                String message = "The sum is " + (add1 + add2);
                textViewE3.setText(message);
            });
            myBuilder.setNegativeButton("CANCEL", null);
            AlertDialog myDialog = myBuilder.create();
            myDialog.show();
        });

        btnDemo4.setOnClickListener(v -> {
            DatePickerDialog.OnDateSetListener myDateListener = (view, year, month, dayOfMonth) -> tvDemo4.setText("Date: " + dayOfMonth + "/" + (month + 1) + "/" + year);

            Calendar today = Calendar.getInstance();

            DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListener, today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH));

            myDateDialog.show();
        });

        btnDemo5.setOnClickListener(v -> {
            @SuppressLint("SetTextI18n") TimePickerDialog.OnTimeSetListener myTimeListener = (view, hourOfDay, minute) -> tvDemo5.setText("Time " + hourOfDay + ":" + minute);

            Calendar today = Calendar.getInstance();

            TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener, today.get(Calendar.HOUR_OF_DAY), today.get(Calendar.MINUTE), false);
            myTimeDialog.show();
        });
    }
}