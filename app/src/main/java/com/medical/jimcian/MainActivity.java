package com.medical.jimcian;

import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    FirebaseAuth auth;
    FirebaseUser user;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    return true;
                case R.id.navigation_dashboard:

                    return true;
                case R.id.navigation_notifications:

                    return true;
                case R.id.navigation_profile:
                    return true;
                case R.id.navigation_menu:
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();

        if (user != null) {
           checkProfileComplete(user.getUid());
        }


        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
 private  void checkProfileComplete(String userid){
     FirebaseFirestore db=FirebaseFirestore.getInstance();
     DocumentReference doc=db.collection("Users").document(userid);
     doc.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
         @Override
         public void onComplete(@NonNull Task<DocumentSnapshot> task) {
             if (task.isSuccessful()){
                DocumentSnapshot snapshot=task.getResult();
                if (snapshot.exists()){
                    Toast.makeText(MainActivity.this, "Welcome JIMCIAN!!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Please Complete Your Profile!!", Toast.LENGTH_SHORT).show();

                }
             }
         }
     });

 }
}
