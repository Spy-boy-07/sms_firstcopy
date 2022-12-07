//package com.spydison.sms;
//
//import android.os.Bundle;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//import java.util.HashMap;
//
//public class challenges_tt extends AppCompatActivity {
//    DatabaseReference user_ref,challenge_req;
//    FirebaseAuth mauth;
//    FirebaseUser muser;
//    String state="nothing";
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        String userid =getIntent().getStringExtra("userkey");
//        user_ref = FirebaseDatabase.getInstance().getReference().child("users").child(userid);
//        challenge_req = FirebaseDatabase.getInstance().getReference().child("requests");
//        mauth = FirebaseAuth.getInstance();
//        muser = mauth.getCurrentUser();
//        performaction(userid);
//
//
//
//    }
//
//    private void performaction(String userid) {
//        if(state.equals("nothing"))
//        {
//            HashMap mapp = new HashMap();
//            mapp.put("status","pending");
//            challenge_req.child(userid).child(muser.getUid()).updateChildren(mapp).addOnCompleteListener(new OnCompleteListener() {
//                @Override
//                public void onComplete(@NonNull Task task) {
//                    if(task.isSuccessful())
//                    {
//                        state="pending";
//                    }
//                }
//            });
//        }
//
//    }
//
//
//}
