package com.example.viikko9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class AddUserActivity extends AppCompatActivity {
    private EditText firstName;
    private EditText lastName;
    private EditText email;

    private String degreeProgram;
    private int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
    }

    public void addUser(View view) {
        firstName = findViewById(R.id.idFirstname);
        lastName = findViewById(R.id.idLastname);
        email = findViewById(R.id.idEmail);
        RadioGroup rgFieldType = findViewById(R.id.rgField);
        RadioGroup rgImageType = findViewById(R.id.rgImage);
        switch (rgFieldType.getCheckedRadioButtonId()) {
            case R.id.rbTite:
                degreeProgram = "Tietotekniikka";
                break;
            case R.id.rbTuta:
                degreeProgram = "Tuotantotalous";
                break;
            case R.id.rbLate:
                degreeProgram = "Laskennallinen tekniikka";
                break;
            case R.id.rbSate:
                degreeProgram = "Sähkötekniikka";
        }
        switch (rgImageType.getCheckedRadioButtonId()) {
            case R.id.rbimage1:
                image = R.drawable.image1;
                break;
            case R.id.rbimage2:
                image = R.drawable.image2;
                break;
            case R.id.rbimage3:
                image = R.drawable.image3;
                break;
        }
        User user = new User(firstName.getText().toString(), lastName.getText().toString(), email.getText().toString(), degreeProgram, image);
        UserStorage.getInstance().addUser(user);
    }


}