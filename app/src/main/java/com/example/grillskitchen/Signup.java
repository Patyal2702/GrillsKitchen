package com.example.grillskitchen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.grillskitchen.models.UserModel;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {

    Button signup;
    EditText name,email,password;
    TextView signIn;
    FirebaseAuth auth;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        auth=FirebaseAuth.getInstance();
       database=FirebaseDatabase.getInstance();
        signup=findViewById(R.id.reg);
        name=findViewById(R.id.reg_editText1);
        email=findViewById(R.id.reg_editText2);
        password=findViewById(R.id.reg_editText3);
        signIn=findViewById(R.id.sign_up);

        TextView tv=(TextView) findViewById(R.id.sign_up);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();

            }
        });
    }

    private void createUser() {
        String userName=name.getText().toString();
        String userEmail=email.getText().toString();
        String userPassword=password.getText().toString();

        if(TextUtils.isEmpty(userName)){
            Toast.makeText(this,"Name is Empty",Toast.LENGTH_LONG).show();
            return;
        }
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
       auth.createUserWithEmailAndPassword(userEmail,userPassword)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            UserModel userModel=new UserModel(userName,userEmail,userPassword);
                            String id=task.getResult().getUser().getUid();
                            database.getReference().child("User").child(id).setValue(userModel);
                            Toast.makeText(Signup.this,"Registration Successful",Toast.LENGTH_LONG).show();
                            openshopping();
                        }
                        else{

                            Toast.makeText(Signup.this,"Error :"+task.getException(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    private void openshopping() {
        Intent intent=new Intent(this,Purchasing.class);
        startActivity(intent);
    }

    public void openActivity2(){
        Intent intent=new Intent(this,Login.class);
        startActivity(intent);
    }
}