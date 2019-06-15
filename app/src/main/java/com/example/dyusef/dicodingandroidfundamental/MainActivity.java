package com.example.dyusef.dicodingandroidfundamental;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Xiaomi>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvCategory = (RecyclerView)findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(XiaomiData.getListData());

        showRecyclerCardView();
    }

    private void showRecyclerCardView(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewXiaomiAdapter cardViewXiaomiAdapter = new CardViewXiaomiAdapter(this);
        cardViewXiaomiAdapter.setListXiaomi(list);
        rvCategory.setAdapter(cardViewXiaomiAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedXiaomi(list.get(position));
            }
        });
    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    private void showSelectedXiaomi(Xiaomi xiaomi){
        //Toast.makeText(this, "Kamu memilih "+xiaomi.getName(), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("stringName", xiaomi.getName()); //where v is button that is cliked, you will find it as a parameter to onClick method
        intent.putExtra("stringPrice", xiaomi.getPrice());
        intent.putExtra("dataPhoto", xiaomi.getPhoto());
        intent.putExtra("stringDesc", xiaomi.getDesc());
        startActivity(intent);
    }
}