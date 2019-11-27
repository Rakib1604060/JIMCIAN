package com.medical.jimcian;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;

public class Spalsh extends AppCompatActivity {

    ImageView logoimg;
    FirebaseAuth auth;
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_spalsh);

        logoimg=findViewById(R.id.logoid);
        ObjectAnimator animation = ObjectAnimator.ofFloat(logoimg, "translationY", -300f);
        animation.setDuration(700);
        animation.start();
        Handler myhander=new Handler();
        myhander.postDelayed(new Runnable() {
            @Override
            public void run() {
                auth=FirebaseAuth.getInstance();
                user=auth.getCurrentUser();
                if (user==null){
                    startActivity(new Intent(Spalsh.this,Login.class));
                    finish();
                }else{
                    startActivity(new Intent(Spalsh.this,MainActivity.class));
                    finish();
                }

            }
        },1000);



    }
}
