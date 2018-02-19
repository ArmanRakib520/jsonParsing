package com.example.admin.cryptoparse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Date;

public class Details extends AppCompatActivity {
    Item item =new Item();
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        item = (Item) getIntent().getSerializableExtra("data");
        Log.d("data", item.toString());

        textView=findViewById(R.id.details);
        long lg=Long.parseLong(item.getLast_updated());

        textView.setText("Rank "+"1"+"\n"+"Name "+item.getName()+"\n"+"Price "+item.getPrice_usd()+" USD"+"\n"+"Last Updated \n"+new Date(lg));
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
