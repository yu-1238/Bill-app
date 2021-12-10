package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRVbill;
    private Button mBadd;
    private Dao maindao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBadd=findViewById(R.id.bill_update);
        mBadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,UpadteActivity.class);
                startActivity(i);
            }
        });
        mRVbill=findViewById(R.id.bill_rv);
       maindao=new Dao(MainActivity.this);
        mRVbill.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mRVbill.setAdapter(new MainAdapter(MainActivity.this, new MainAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
//                Toast.makeText(MainActivity.this,"test"+pos,Toast.LENGTH_LONG).show();
            }
        },maindao.inquireData()));
        maindao.getClose();
    }

}