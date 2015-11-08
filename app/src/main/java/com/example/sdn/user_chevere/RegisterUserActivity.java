package com.example.sdn.user_chevere;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseObject;

public class RegisterUserActivity extends AppCompatActivity {


    protected EditText mUsername;
    protected EditText mUserEmail;
    protected EditText mUserPassword;
    protected ImageButton mRegisterLogoButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "H5nqxUHyp6A2nvR6O5wHPGSa0vW6nabXucX5Nf0E", "uGfYMntmiDA0mzoAaQQPLkAAXVxHscpoVWu1sUh2");

        //Inicializa
        mUsername = (EditText)findViewById(R.id.usernameEditText);
        mUserEmail = (EditText)findViewById(R.id.mailEditText);
        mUserPassword = (EditText)findViewById(R.id.passwordEditText);
        mRegisterLogoButton = (ImageButton)findViewById(R.id.botonLogoRegistrarse);

        mRegisterLogoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get the user name password and email and convert it to String
                String username = mUsername.getText().toString().trim();
                String email = mUserEmail.getText().toString().trim();
                String password = mUserPassword.getText().toString().trim();

                ParseObject Usuarios = new ParseObject("Usuarios");
                Usuarios.put("username", username);
                Usuarios.put("email", email);
                Usuarios.put("password", password);
                Usuarios.saveInBackground();

                Toast.makeText(RegisterUserActivity.this, "Bienvenido", Toast.LENGTH_LONG).show();

                //take to home page post login


                Intent userHome = new Intent(RegisterUserActivity.this, UserMainActivity.class);
                startActivity(userHome);
            }
        });
    }
}