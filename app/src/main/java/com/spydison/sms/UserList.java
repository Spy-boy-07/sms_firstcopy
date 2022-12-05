package com.spydison.sms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class UserList extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    MyAdapter myAdapter;
    ArrayList<User> list;
    FloatingActionButton button ;
    FirebaseAuth authcurr = FirebaseAuth.getInstance();
    FirebaseUser currentUser = authcurr.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        recyclerView = findViewById(R.id.userlist_UL);
        database = FirebaseDatabase.getInstance().getReference("users");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        myAdapter = new MyAdapter(this,list);
        recyclerView.setAdapter(myAdapter);

//        User.class = (String) FirebaseDatabase.getInstance().getReference("users").child(currentUser.getUid());

//        FirebaseDatabase database123 = FirebaseDatabase.getInstance();
//
//        DatabaseReference reference = database123.getReference("users").child(currentUser.getUid());

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    User user = dataSnapshot.getValue(User.class);
                    assert user != null;
                    if (!Objects.equals(user.email, currentUser.getEmail()))
                    list.add(user);
                }
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
//If you uncomment the portion after this and then run it, IT crashes...
        //Please someone find a way

//        button.findViewById(R.id.challButt);

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (myAdapter.getSelected() != null){
//                    Toast.makeText(UserList.this, myAdapter.getSelected().getName()+" Challenged", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    Toast.makeText(UserList.this, "No Selection", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

    }

    public void challenged(View objectView){
        if (myAdapter.getSelected() != null){
                    Toast.makeText(UserList.this, "Challenged to "+myAdapter.getSelected().getName(), Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(UserList.this, "No Selection", Toast.LENGTH_SHORT).show();
                }
    }

}