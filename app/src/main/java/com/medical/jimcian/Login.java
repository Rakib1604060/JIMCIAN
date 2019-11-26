package com.medical.jimcian;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
       EditText emailtex, passwordtext;
       Button signupbutton;
       FirebaseAuth auth;
       FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailtex=findViewById(R.id.email_text);
        passwordtext=findViewById(R.id.password_text);
        signupbutton=findViewById(R.id.signupbtn);
        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (emailtex.getText().toString().equals("")||passwordtext.getText().toString().equals("")){
                    Toast.makeText(Login.this, "Please Insert All data", Toast.LENGTH_SHORT).show();
                }else{
                    Signupnow(emailtex.getText().toString(),passwordtext.getText().toString());

                }


            }
        });




    }

    private void Signupnow(String email, String pass) {
        auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    Toast.makeText(Login.this, "Successfull signup", Toast.LENGTH_SHORT).show();
                    user= auth.getCurrentUser();
                    UpdateUi(user);


                }else{
                    Toast.makeText(Login.this, "Hoy nai vai . sorry.", Toast.LENGTH_SHORT).show();

                }

            }
        });


    }


    private  void UpdateUi(FirebaseUser user){
        startActivity(new Intent(Login.this,MainActivity.class));
        finish();
    }
    @Override
    protected void onStart() {
        super.onStart();
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        if (user!=null){

            UpdateUi(user);

        }


    }
}
