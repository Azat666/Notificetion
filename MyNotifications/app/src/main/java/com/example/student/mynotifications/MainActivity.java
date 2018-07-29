package com.example.student.mynotifications;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Calendar callendar = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        showSnackbar();
        showTost();
        showAlert();
        showDatePicker();
        showTimePicker();
    }

    private void showTimePicker(){

        final Button timepiker = findViewById(R.id.time_picker);
        timepiker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final TimePickerDialog pikerdialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {

                    }
                },
                        callendar.get(Calendar.HOUR_OF_DAY),
                        callendar.get(Calendar.MINUTE),true);
                pikerdialog.show();
            }
        });
    }

    private void showDatePicker() {
        final Button picker = findViewById(R.id.date_picker);
        picker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DatePickerDialog datePickerDialog =
                        new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                             callendar.set(Calendar.YEAR,year);
                             callendar.set(Calendar.MONTH,month);
                             callendar.set(Calendar.DAY_OF_MONTH,day);
                            }
                        }       ,callendar.get(Calendar.YEAR)
                                ,callendar.get(Calendar.MONTH)
                                ,callendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

    }

    private void showAlert() {
        final Button button = findViewById(R.id.buttonalert);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final String[] items = {"Question 1 ", "Question 2 ", "Question 3 ", "Question 4 "};
                final boolean[] answers = {false, true, false, false};

                new AlertDialog.Builder(MainActivity.this, R.style.DialogStyle).
                        setTitle("My Cool Applicetion")
                       // .setMessage("Are you sure to exit  ?")
                        /*.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })*/
                     /*   .setMultiChoiceItems(items, answers, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                Toast.makeText(MainActivity.this, items[i], Toast.LENGTH_LONG).show();
                            }
                        })*/
                        .setSingleChoiceItems(items, 2, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setPositiveButton("OK",null)
                        .setNegativeButton("Cancel",null)
                        //.setCancelable(false)
                        .show();

            }
        });
    }

    private void showSnackbar() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                final Snackbar snackbar = Snackbar.make(view, "Good Morning", Snackbar.LENGTH_LONG);
                snackbar.setAction("Toolbar", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        toolbar.setBackgroundColor(
                                ContextCompat.getColor(MainActivity.this,
                                        R.color.colorAccent));
                    }
                });
                snackbar.setActionTextColor(ContextCompat.getColor(MainActivity.this,
                        R.color.colorPrimary));
                final View layout = snackbar.getView();
                final TextView textView = layout.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.GREEN);
                textView.setTextSize(30);
                layout.setBackgroundColor(Color.GRAY);
                snackbar.show();
            }
        });
    }

    private void showTost() {
        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Hello word", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
