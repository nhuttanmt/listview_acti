package com.example.testlist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    Button btnve;
    TextView tvid, tvTen, tvgt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnve = findViewById(R.id.button2);
        tvTen = findViewById(R.id.textViewTen);
        tvgt = findViewById(R.id.textViewgioitinh);
        tvid = findViewById(R.id.textViewID);

        //get
        final Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        tvid.setText(bundle.getString(MainActivity.id) + " - " + bundle.getString(MainActivity.ten) +" - "+
                bundle.getString(MainActivity.gioitinh ));
//        tvTen.setText(bundle.getString(MainActivity.ten));
//        tvgt.setText((bundle.getString(MainActivity.gioitinh)));


        btnve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);

                startActivity(intent);
            }
        });
    }
}
