package com.example.dyusef.dicodingandroidfundamental;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewXiaomiAdapter extends RecyclerView.Adapter<CardViewXiaomiAdapter.CardViewViewHolder>{
    private ArrayList<Xiaomi> listXiaomi;
    private Context context;

    public CardViewXiaomiAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Xiaomi> getListXiaomi() {
        return listXiaomi;
    }

    public void setListXiaomi(ArrayList<Xiaomi> listXiaomi) {
        this.listXiaomi = listXiaomi;
    }
    @Override
    public CardViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_xiaomi, parent, false);
        CardViewViewHolder viewHolder = new CardViewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CardViewViewHolder holder, int position) {

        Xiaomi p = getListXiaomi().get(position);

        Glide.with(context)
                .load(p.getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(holder.imgPhoto);

        holder.tvName.setText(p.getName());
        holder.tvPrice.setText(p.getPrice());
        holder.tvDesc.setText(p.getDesc());

        holder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {

            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Add Favorite "+ getListXiaomi().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));

        holder.btnShareBuy.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {

            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Buy " + getListXiaomi().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListXiaomi().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvName, tvPrice, tvDesc;
        Button btnFavorite, btnShareBuy;
        public CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = (ImageView)itemView.findViewById(R.id.img_item_photo);
            tvName = (TextView)itemView.findViewById(R.id.tv_item_name);
            tvPrice = (TextView)itemView.findViewById(R.id.tv_item_price);
            tvDesc = (TextView)itemView.findViewById(R.id.tv_item_desc);
            btnFavorite = (Button)itemView.findViewById(R.id.btn_set_favorite);
            btnShareBuy = (Button)itemView.findViewById(R.id.btn_set_share);
        }
    }
}
