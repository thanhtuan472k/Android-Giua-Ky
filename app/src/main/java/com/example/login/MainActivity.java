package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    EditText editUser, editPass;
    Button btnlogin, btndangki;
    CheckBox CheckBox;
    String username, password;
    public ArrayList<SinhVien> user = new ArrayList<SinhVien>();
    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        ControlBtnEvent();
    }

    private void Anhxa() {
        editUser = (EditText) findViewById(R.id.editUser);
        editPass = (EditText) findViewById(R.id.editPass);
        btnlogin = findViewById(R.id.btlg);
        btndangki = findViewById(R.id.btndk);

        CheckBox = findViewById(R.id.showpass);
        EditText edtk = (EditText) findViewById(R.id.editUser_DK);
        final EditText edmk = (EditText) findViewById(R.id.editPass_DK);
        EditText edname = (EditText) findViewById(R.id.editTen_DK);
        EditText edID = (EditText) findViewById(R.id.editKhoa_DK);
        EditText edCL = (EditText) findViewById(R.id.editLop_DK);
        Button btndongy = (Button) findViewById(R.id.btndongy);
        Button btnback = (Button) findViewById(R.id.btnthoat);

        user.add(new SinhVien("tuan", "tuan", "Ngô Thanh Tuấn", "CNTT", "18t2"));
        user.add(new SinhVien("an123", "123", "Bùi Phú Ân", "CNTT", "18t1"));

        CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if (b) {
                    editPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    editPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }

    private void ControlBtnEvent() {
        btndangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setTitle("Dialog đăng kí");
                dialog.setCancelable(false);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.signup);
                Window window = dialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                EditText edtk = (EditText) dialog.findViewById(R.id.editUser_DK);
                final EditText edmk = (EditText) dialog.findViewById(R.id.editPass_DK);
                EditText edname = (EditText) dialog.findViewById(R.id.editTen_DK);
                EditText edID = (EditText) dialog.findViewById(R.id.editKhoa_DK);
                EditText edCL = (EditText) dialog.findViewById(R.id.editLop_DK);
                Button btndongy = (Button) dialog.findViewById(R.id.btndongy);
                Button btnback = (Button) dialog.findViewById(R.id.btnthoat);
                btnback.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                btndongy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        user.add(new SinhVien(edtk.getText().toString(), edmk.getText().toString(), edname.getText().toString(), edID.getText().toString(), edCL.getText().toString()));
                        dialog.cancel();
                    }
                });

            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editUser.getText().length() != 0 && editPass.getText().length() != 0) {
                    if (isPassword(user, editUser.getText().toString(), editPass.getText().toString()) == true) {
                        Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        username = editUser.getText().toString();
                        password = editPass.getText().toString();
                        Bundle bundle = new Bundle();
                        bundle.putString("user", username);
                        bundle.putString("pass", password);
                        intent = new Intent(MainActivity.this, HomeActivity.class);
                        intent.putExtras(bundle);
                        startActivity(intent);

                    } else {
                        Toast.makeText(MainActivity.this, "Tài khoản hoặc mật khẩu sai", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }

    public boolean isPassword(ArrayList<SinhVien> data, String username, String password) {
        for (SinhVien i : data) {
            if (i.getPassword().compareTo(password) == 0 && i.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

}