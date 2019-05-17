package com.derrick.park.assignment3_contacts.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.derrick.park.assignment3_contacts.R;

public class AddActivity extends AppCompatActivity {

    private EditText nameText;
    private EditText phoneText;
    private Button submitButton;
    public final static String MESSAGE_KEY1 = "EXTRA_NAME";
    public final static String MESSAGE_KEY2 = "EXTRA_PHONE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        nameText = findViewById(R.id.nameText);
        phoneText = findViewById(R.id.phoneText);
        submitButton = findViewById(R.id.submitButton);


    }


    public void submitClicked(View view) {

        String name = nameText.getText().toString();

        String phone = phoneText.getText().toString();
        if (phone.length() != 10) {

            Toast toast = Toast.makeText(getApplicationContext(), "You should enter 10 digits!", Toast.LENGTH_LONG);
            toast.show();
        } else if (name.split(" ").length < 2) {
            Toast toast = Toast.makeText(getApplicationContext(), "You should enter name and family", Toast.LENGTH_LONG);
            toast.show();
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(MESSAGE_KEY1, name);
            intent.putExtra(MESSAGE_KEY2, phone);
            setResult(RESULT_OK, intent);
            finish();
        }

    }


}
