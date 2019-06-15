package com.example.dyusef.dicodingandroidfundamental;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String messageName = intent.getStringExtra("stringName");
        String messagePrice = intent.getStringExtra("stringPrice");
        int messagePhotos = intent.getIntExtra("dataPhoto",0);
        int messageDesc = intent.getIntExtra("stringDesc",0);



        TextView textView = (TextView)findViewById(R.id.productName);
        TextView textView2 = (TextView)findViewById(R.id.productPrice);
        ImageView imageView = (ImageView) findViewById(R.id.imgPhotos);
        TextView textView3 = (TextView)findViewById(R.id.productDecs);

        textView.setText(messageName);
        textView2.setText(messagePrice);
        imageView.setImageResource(messagePhotos);
        textView3.setText(messageDesc);


//        Intent mIntent = getIntent();
//        int intValue = mIntent.getIntExtra("intVariableName", 0);
//        if(intValue == 0) {
//            // error handling (Will come in this if when button id is invalid)
//        } else
//        {
//            if(intValue == R.id.button1)
//                // Do work related to button 1
//
//                if(intValue == R.id.button2)
//                    // Do work related to button 2
//
//                    if(intValue == R.id.button3)
//            // Do work related to button 3
//        }
    }
}
