package com.example.login;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class SinhvienAdapter  extends BaseAdapter {
    private Context context;
    private int layout;
    private List<SinhVien> userList;

    public SinhvienAdapter(Context context, int layout, List<SinhVien> userList) {
        this.context = context;
        this.layout = layout;
        this.userList = userList;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view= inflater.inflate(layout,null);
        //ánh xạ view
        TextView txtuser= (TextView) view.findViewById(R.id.user);
        //gán giá trị
        SinhVien user = userList.get(i);
        txtuser.setText(user.getUsername());
        return view;
    }
}
