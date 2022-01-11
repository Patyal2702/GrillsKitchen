package com.example.grillskitchen;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    Button signIn;
    EditText password,email;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signIn=findViewById(R.id.log);
        email=findViewById(R.id.log_editText1);
        password=findViewById(R.id.log_editText3);
        auth=FirebaseAuth.getInstance();
        TextView tv= findViewById(R.id.sign_in);
        tv.setOnClickListener(v -> openActivity3());
        signIn.setOnClickListener(v -> loginUser());
    }

    private void loginUser() {

        String userEmail=email.getText().toString();
        String userPassword=password.getText().toString();

        if(TextUtils.isEmpty(userEmail)){
            Toast.makeText(this,"Email is Empty",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(userPassword)){
            Toast.makeText(this,"Password is Empty,Please create one",Toast.LENGTH_LONG).show();
            return;
        }
        if(userPassword.length()<6){
            Toast.makeText(this,"password is too short",Toast.LENGTH_LONG).show();
            return;
        }
        auth.signInWithEmailAndPassword(userEmail,userPassword)
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        Toast.makeText(Login.this,"Login Successfully\t Happy Shopping",Toast.LENGTH_LONG).show();
                        openShopping();
                    }
                    else{
                        Toast.makeText(Login.this,"Error :"+task.getException(),Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void openShopping() {
        Intent intent=new Intent(this,Purchasing.class);
        startActivity(intent);
    }

    public void openActivity3(){
        Intent intent=new Intent(this,Signup.class);
        startActivity(intent);
    }
}