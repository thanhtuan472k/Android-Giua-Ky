package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    Button btnBack;
    ListView lv;
    ArrayList<SinhVien> user = new ArrayList<SinhVien>();
    SinhvienAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        String username = getIntent().getExtras().getString("user");
        String password = getIntent().getExtras().getString("pass");
        btnBack = (Button) findViewById(R.id.btnback);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
//        user.add(new User(username,password,"Hồ Thị Tuyết","CNTT","18t3"));
        user.add(new SinhVien("tuan", "tuan", "Ngô Thanh Tuấn", "CNTT", "18t2"));
        user.add(new SinhVien("an123", "123", "Bùi Phú Ân", "CNTT", "18t1"));

        lv = (ListView) findViewById(R.id.listview);
        adapter = new SinhvienAdapter(this, R.layout.user, user);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                SinhVien sinhvien = user.get(i);
                Dialog dialog = new Dialog(HomeActivity.this);
                dialog.setCancelable(false);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.detail);
                Window window = dialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                TextView txtuser = (TextView) dialog.findViewById(R.id.tentk);
                TextView txtpass = (TextView) dialog.findViewById(R.id.matkhau);
                TextView txtname = (TextView) dialog.findViewById(R.id.tensv);
                TextView txtKhoa = (TextView) dialog.findViewById(R.id.masv);
                TextView txtLop = (TextView) dialog.findViewById(R.id.lop);
                Button btnexit = (Button) dialog.findViewById(R.id.btnexit);
                txtuser.setText(sinhvien.getUsername());
                txtpass.setText(sinhvien.getPassword());
                txtname.setText(sinhvien.getTen_Sv());
                txtKhoa.setText(sinhvien.getKhoa());
                txtLop.setText(sinhvien.getLop());
                btnexit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
            }
        });

    }
}