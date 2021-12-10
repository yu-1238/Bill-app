package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class UpadteActivity extends AppCompatActivity {
    private Button mBsure;
    private EditText mEshop;
    private EditText mEtype;
    private EditText mEmoney;
   private  Dao updatedao;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updatedao=new Dao(UpadteActivity.this);
        setContentView(R.layout.activity_upadte);
        mBsure=findViewById(R.id.bill_update_sure);
        mBsure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEshop=findViewById(R.id.bill_update_shop);
                mEtype=findViewById(R.id.bill_update_type);
                mEmoney=findViewById(R.id.bill_update_money);
                String shop=mEshop.getText().toString();
                String type=mEtype.getText().toString();
                String money=mEmoney.getText().toString();
                Date now = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String time= dateFormat.format( now );
                String [] updates=new String[]{shop,type,money,time};
                String [] keys=new String[] {"shop","type","money","time"};
                updatedao.addData("BillInfo",keys,updates);
                List<Bill> L=updatedao.inquireData();
                System.out.println(L.size());
                updatedao.getClose();
                Intent i = new Intent(UpadteActivity.this, MainActivity.class);
                startActivity(i);

            }
        });
    }
}