package com.example.aninterface;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.aninterface.HelperClass.SharedPreferencesUtil;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginPage extends AppCompatActivity {
    EditText loginphonenumber, loginpassword;
    Button loginButton;
    TextView registerRedirectText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login_page);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login_page), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loginphonenumber = findViewById(R.id.edit_login_phoneNumber);
        loginpassword = findViewById(R.id.edit_login_password);
        registerRedirectText = findViewById(R.id.text_login_signUp);
        loginButton = findViewById(R.id.btn_login_login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validatePassword() | !validateUser()){
                }
                else{
                    checkUser();

                }
            }
        });

        registerRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPage.this, CreateAccountPage.class);
                startActivity(intent);
            }
        });

    }
    public Boolean validateUser() {
        String val = loginphonenumber.getText().toString();
        if (val.isEmpty()) {
            loginphonenumber.setError("Phone Number cannot be empty!");
            return false;
        } else {
            loginphonenumber.setError(null);
            return true;
        }
    }

    public Boolean validatePassword() {
        String val = loginpassword.getText().toString();
        if (val.isEmpty()) {
            loginpassword.setError("Password cannot be empty!");
            return false;
        } else {
            loginpassword.setError(null);
            return true;
        }
    }

    public void checkUser() {
        String userPhonenumber = loginphonenumber.getText().toString().trim();
        String userPassword = loginpassword.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("phonenumber").equalTo(userPhonenumber);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    loginphonenumber.setError(null);
                    String passwordFromDB = snapshot.child(userPhonenumber).child("password").getValue(String.class);

                    if (passwordFromDB.equals(userPassword)) {
                        loginphonenumber.setError(null);
                        SharedPreferencesUtil.savePhoneNumber(LoginPage.this, userPhonenumber);

                        String nameFromDB = snapshot.child(userPhonenumber).child("fullname").getValue(String.class);
                        String emailFromDB = snapshot.child(userPhonenumber).child("email").getValue(String.class);

                        SharedPreferencesUtil.saveUserName(LoginPage.this, nameFromDB);
                        SharedPreferencesUtil.saveEmail(LoginPage.this, emailFromDB);
                        SharedPreferencesUtil.savePassword(LoginPage.this, passwordFromDB);

//                        intent.putExtra("phoneNumber", userPhonenumber);
                        Intent intent = new Intent(LoginPage.this, HomePage.class);
                        startActivity(intent);
                    } else {
                        loginphonenumber.setError("Invalid Phone Number/Password");
                        loginphonenumber.requestFocus();
                    }
                } else {
                    loginphonenumber.setError("Phone Number do not exist");
                    loginphonenumber.requestFocus();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}


