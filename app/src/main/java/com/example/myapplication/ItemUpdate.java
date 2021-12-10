package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ItemUpdate extends AppCompatActivity {
    private Button mBitsure;
    private EditText mEitshop;
    private EditText mEittype;
    private EditText mEitmoney;
    private  Dao updatedao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i=getIntent();
        setContentView(R.layout.activity_item_update);
        mBitsure=findViewById(R.id.bill_itemupdate_sure);
        mEitshop=findViewById(R.id.bill_itemupdate_shop);
        mEittype=findViewById(R.id.bill_itemupdate_type);
        mEitmoney=findViewById(R.id.bill_itemupdate_money);
        updatedao=new Dao(ItemUpdate.this);
        mEitmoney.setText(i.getStringExtra("money"));
        mEittype.setText(i.getStringExtra("type"));
        mEitshop.setText(i.getStringExtra("shop"));

        mBitsure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEitshop=findViewById(R.id.bill_itemupdate_shop);
                mEittype=findViewById(R.id.bill_itemupdate_type);
                mEitmoney=findViewById(R.id.bill_itemupdate_money);
                String shop=mEitshop.getText().toString();
                String type=mEittype.getText().toString();
                String money=mEitmoney.getText().toString();
                Date now = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String time= dateFormat.format( now );

                  String [] updates=new String[]{shop,type,money,time,i.getStringExtra("id")};
                updatedao.update(updates);
                updatedao.getClose();
                Intent i = new Intent(ItemUpdate.this, MainActivity.class);
                startActivity(i);
            }
        });



    }

}