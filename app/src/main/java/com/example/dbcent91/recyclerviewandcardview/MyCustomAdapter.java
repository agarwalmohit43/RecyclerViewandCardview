package com.example.dbcent91.recyclerviewandcardview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by dbcent91 on 20/7/17.
 */

public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyViewHolder> {

    Context context;
    ArrayList<Information> data;

    int previousPostion = 0;

    LayoutInflater inflater;

    public MyCustomAdapter(Context context, ArrayList<Information> data) {
        this.context = context;
        this.data = data;
        inflater=LayoutInflater.from(context);

    }

    @Override
    public MyCustomAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View view = inflater.inflate(R.layout.list_item_row, parent, false);

        MyViewHolder holder=new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, final int position) {

        final int currentPostion=position;
        final Information infoObj=data.get(position);


        myViewHolder.textView.setText(data.get(position).title);
        myViewHolder.imageView.setImageResource(data.get(position).imageId);

        if(position > previousPostion){// we are scrolling down

            AnimationUtil.animate(myViewHolder, true);

        }else{// we are scrolling up

            AnimationUtil.animate(myViewHolder, false);
        }

        previousPostion = position;

        myViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"OnClick called at -> "+position,Toast.LENGTH_SHORT).show();
                addItem(currentPostion, infoObj);
            }
        });

        myViewHolder.imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Toast.makeText(context,"OnLongClick called at -> "+position,Toast.LENGTH_SHORT).show();

                removeItem(infoObj);
                return true;
            }
        });
    }

    //add in recyclerview
    public void addItem(int position, Information infoData){

        data.add(position,infoData);
        notifyItemInserted(position);
    }

    //remove from recyclerview
    public void removeItem(Information infodata){

        int position = data.indexOf(infodata);
        data.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.txv_row);
            imageView = (ImageView) itemView.findViewById(R.id.img_row);


        }
    }
}
