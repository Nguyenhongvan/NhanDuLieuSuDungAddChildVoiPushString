package com.vansuzy.nhandulieusudungaddchildvoipushstring;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    DatabaseReference mData;
    TextView txtKhoaHoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtKhoaHoc = (TextView) findViewById(R.id.txtKhoaHoc);

        mData = FirebaseDatabase.getInstance().getReference();

        // nếu không comment dòng bên dưới lại thì mỗi khi run app lên thì nó sẽ push tiếp giá trị Lập trình Unity lên Firebase
        // mData.child("KhoaHoc").push().setValue("Lập trình Unity");
        mData.child("KhoaHoc").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                // đọc tất cả dữ liệu của một node đang có trên firebase về
               txtKhoaHoc.append(dataSnapshot.getValue().toString() + "\n");
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
