package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class MainAdapter extends RecyclerView.Adapter <RecyclerView.ViewHolder>{
    @NonNull
    private Context mContext;
    private OnItemClickListener mListener;
    private List<Bill> mLbill;

    public MainAdapter(Context context , OnItemClickListener listener,List<Bill> mLbill){
        this.mContext = context;
        this.mListener = listener;
        this.mLbill=mLbill;


    }

    @Override
    public  RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.activity_bill_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
//
            ((LinearViewHolder)holder).shop.setText(mLbill.get(position).getShop());
            ((LinearViewHolder)holder).time.setText(mLbill.get(position).getTime());
            ((LinearViewHolder)holder).type.setText(mLbill.get(position).getType());
            ((LinearViewHolder)holder).money.setText(mLbill.get(position).getMoney());
        ((LinearViewHolder)holder).update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(mContext,ItemUpdate.class);
                i.putExtra("shop",mLbill.get(position).getShop());
//                i.putExtra("time",);
                i.putExtra("type",mLbill.get(position).getType());
                i.putExtra("money",mLbill.get(position).getMoney());
                i.putExtra("id",mLbill.get(position).getBillid());
                mContext.startActivity(i);

            }
        });
        ((LinearViewHolder)holder).delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Dao deledao=new Dao(mContext);
               deledao.delData("id=?",new String[]{mLbill.get(position).getBillid()});

//               mLbill.remove(position);
                List<Bill> newList = deledao.inquireData();

                 mLbill.clear();
               mLbill.addAll(newList);
                deledao.getClose();
                MainAdapter.this.notifyDataSetChanged();

            }
        });



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mListener.onClick(position);
            }
        });
    }


    @Override
    public int getItemViewType(int position) {
        if(position % 2 == 0){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public int getItemCount() {
        return mLbill.size();
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{
        private TextView shop;
        private TextView money;
        private TextView type;
        private TextView time;
        private Button update;
        private Button delete;

        public LinearViewHolder(View itemView){
            super(itemView);
            shop = itemView.findViewById(R.id.bill_rv_shop);
            money=itemView.findViewById(R.id.bill_rv_money);
            type=itemView.findViewById(R.id.bill_rv_type);
            time=itemView.findViewById(R.id.bill_rv_time);
            update=itemView.findViewById(R.id.bill_rv_update);
            delete=itemView.findViewById(R.id.bill_rv_delete);


        }
    }



    public interface  OnItemClickListener{
        void onClick(int pos);
    }
}

