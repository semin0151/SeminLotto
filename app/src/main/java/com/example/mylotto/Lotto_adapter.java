package com.example.mylotto;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Lotto_adapter extends RecyclerView.Adapter<Lotto_adapter.ViewHolder>{          //Adapter for RecyclerView
    private ArrayList<Lotto_makenumber> lists = new ArrayList<>();
    private Context mContext;

    Lotto_adapter(Context context){
        mContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv0,tv1,tv2,tv3,tv4,tv5;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv0 = (TextView)itemView.findViewById(R.id.tv0);
            tv1 = (TextView)itemView.findViewById(R.id.tv1);
            tv2 = (TextView)itemView.findViewById(R.id.tv2);
            tv3 = (TextView)itemView.findViewById(R.id.tv3);
            tv4 = (TextView)itemView.findViewById(R.id.tv4);
            tv5 = (TextView)itemView.findViewById(R.id.tv5);
        }
    }
    @NonNull
    @Override
    public Lotto_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate((R.layout.lotto_list),parent,false);
        Lotto_adapter.ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Lotto_adapter.ViewHolder holder, int position) {
        Lotto_makenumber lotto = lists.get(position);

        holder.tv0.setText(lotto.getResult().get(0).toString());
        holder.tv1.setText(lotto.getResult().get(1).toString());
        holder.tv2.setText(lotto.getResult().get(2).toString());
        holder.tv3.setText(lotto.getResult().get(3).toString());
        holder.tv4.setText(lotto.getResult().get(4).toString());
        holder.tv5.setText(lotto.getResult().get(5).toString());

        changeColor(holder.tv0,(int)lotto.getResult().get(0));
        changeColor(holder.tv1,(int)lotto.getResult().get(1));
        changeColor(holder.tv2,(int)lotto.getResult().get(2));
        changeColor(holder.tv3,(int)lotto.getResult().get(3));
        changeColor(holder.tv4,(int)lotto.getResult().get(4));
        changeColor(holder.tv5,(int)lotto.getResult().get(5));
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    void addItem(int num) {
        for(int i = 0; i < num; i++){
            Lotto_makenumber lotto = new Lotto_makenumber();
            lists.add(lotto);
        }
    }

    void removeItem(){
        lists.clear();
    }

    void changeColor(TextView tv, int num){
        switch( ( num - 1 ) / 10){
            case 0 : tv.setBackground(ContextCompat.getDrawable(mContext,R.drawable.lotto_yellow));
                break;
            case 1 : tv.setBackground(ContextCompat.getDrawable(mContext,R.drawable.lotto_blue));
                break;
            case 2 : tv.setBackground(ContextCompat.getDrawable(mContext,R.drawable.lotto_red));
                break;
            case 3 : tv.setBackground(ContextCompat.getDrawable(mContext,R.drawable.lotto_black));
                break;
            case 4 : tv.setBackground(ContextCompat.getDrawable(mContext,R.drawable.lotto_green));
                break;
        }
    }
}
