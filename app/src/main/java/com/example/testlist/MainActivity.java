package com.example.testlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtten, edtID;
    Button btnNhap, btnXD;
    RadioGroup rgr;
    RadioButton rbNam, rbNu;
    ListView lv;

    SinhVien sv = new SinhVien();
   public static ArrayList<SinhVien> arrSV = null;
    ArrayAdapter adapter = null;


    public static String ten = "TEN", id = "ID", gioitinh = "Gioi tinh";
    public static String BUNDLE = "EXTRA_BUNDLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtten = findViewById(R.id.editTextTen);
        edtID = findViewById(R.id.editTextID);
        btnNhap = findViewById(R.id.button);
        rgr = findViewById(R.id.radioGroup);
        rbNam = findViewById(R.id.radioButtonNam);
        rbNu = findViewById(R.id.radioButtonNu);
        lv = findViewById(R.id.listview);
        btnXD = findViewById(R.id.buttonNhapList);

        arrSV = new ArrayList<>();
        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_expandable_list_item_1, arrSV);
        lv.setAdapter(adapter);

        btnXD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               nhap();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                Bundle bundle = new Bundle();
                //truyen buldle tung thuoc tinh
                bundle.putString(ten, arrSV.get(i).getTen());
                bundle.putString(id, arrSV.get(i).getId());
                bundle.putString(gioitinh, arrSV.get(i).getGioitinh());
                intent.putExtras(bundle);
                  startActivity(intent);

            }
        });


        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
//                intent.putExtra(ten, edtten.getText().toString());
//                intent.putExtra(id, edtID.getText().toString());


                Bundle bundle = new Bundle();
                bundle.putString(ten, edtten.getText().toString());
                bundle.putString(id, edtID.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
    public void nhap(){
        SinhVien sinhVien = new SinhVien();
        String ten = edtten.getText().toString();
        String id = edtID.getText().toString();
        String gioitinh = "";
        if(rbNam.isChecked())
        {
            gioitinh = "Nam";
        }
        else  {
            gioitinh = "Nữ";
        }
        sinhVien.setId(id);
        sinhVien.setTen(ten);
        sinhVien.setGioitinh(gioitinh);
        arrSV.add(sinhVien);
        adapter.notifyDataSetChanged();
    }
}
