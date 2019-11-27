package com.medical.jimcian;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
       EditText emailtex, passwordtext,passwordtext1;
       Button signupbutton;
       FirebaseAuth auth;
       FirebaseUser user;
       boolean islogin=true;
       TextView forgotpass,policy,signuplogintext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailtex=findViewById(R.id.email_text);
        passwordtext=findViewById(R.id.password_text);
        signupbutton=findViewById(R.id.Loginbtn);
        signuplogintext=findViewById(R.id.signuptext);
        forgotpass=findViewById(R.id.forgotpassword);
        policy=findViewById(R.id.policytext);
        passwordtext1=findViewById(R.id.password_text1);

        //Forgot Passsword;
        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (emailtex.getText().toString().equals("")){
                    ShowDialgoue("Enter Your Email and press forgot password !!",false);
                }else{

                }
            }
        });

//      signup button click
        signuplogintext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (islogin){
                    islogin=false;
                    passwordtext1.setVisibility(View.VISIBLE);
                    signupbutton.setText("Sign Up");
                    signuplogintext.setText("Already Registered? Login now");

                }
                else{
                    islogin=true;
                    passwordtext1.setVisibility(View.GONE);
                    signupbutton.setText("Login");
                    signuplogintext.setText("Not Registered Yet? Sign up now");
                }
            }
        });







        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (islogin){
                    if (emailtex.getText().toString().equals("")||passwordtext.getText().toString().equals("")) {
                        Toast.makeText(Login.this, "Please Insert All data", Toast.LENGTH_SHORT).show();}
                    else{
                        loginNow(emailtex.getText().toString(),passwordtext.getText().toString());

                    }


                }else{
                    //do signup stuff here
                    if (emailtex.getText().toString().equals("")||passwordtext.getText().toString().equals("")||passwordtext1.getText().toString().equals("")) {
                        Toast.makeText(Login.this, "Please Insert All data", Toast.LENGTH_SHORT).show();
                    }else if (passwordtext.getText().toString().equals(passwordtext1.getText().toString())){
                        Toast.makeText(Login.this, "Password Mismatch !!!", Toast.LENGTH_SHORT).show();
                    }else{
                        Signupnow(emailtex.getText().toString(),passwordtext.getText().toString());

                    }


                }




            }
        });




    }

    private void loginNow(String toString, String toString1) {
        auth.signInWithEmailAndPassword(toString,toString1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    Toast.makeText(Login.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                    user=auth.getCurrentUser();
                    UpdateUi(user);
                }else{
                    Toast.makeText(Login.this, "Something Went Wrong.Please try again later!!", Toast.LENGTH_SHORT).show();

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
    private  void ShowDialgoue(String msg,boolean isemailed){

        if (isemailed){
            new AlertDialog.Builder(this)
                    .setTitle("ATTENTION!!!")
                    .setMessage(msg)
                    .setCancelable(true)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                           auth.sendPasswordResetEmail(emailtex.getText().toString())
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()){
                                            Toast.makeText(Login.this, "Password Reset Email Has Been Sent!!! check your email", Toast.LENGTH_SHORT).show();
                                        }else{
                                            Toast.makeText(Login.this, "Something Went Wrong !!!", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });


                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();

                        }
                    })
                    .show();
        }else{
            new AlertDialog.Builder(this)
                    .setTitle("ATTENTION!!!")
                    .setMessage(msg)
                    .setCancelable(true)
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();

                        }
                    })
                    .show();
        }
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
