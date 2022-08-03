package com.cookandroid.and0803_01_carlist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CarAdatper extends BaseAdapter {
    Context context; // 메인 엑티비티 컨텍스트 저장변수
    ArrayList<Car> data; // 데이터

    public CarAdatper(Context context, ArrayList data){
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size(); // 원소 배열의 사이즈

    }

    @Override
    public Object getItem(int i) { // i >> 인덱스
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = View.inflate(context, R.layout.listitem, null);
        }
        ImageView img = view.findViewById(R.id.imgPoster);
        TextView txtTitle = view.findViewById(R.id.txtTitle);
        img.setImageDrawable(data.get(i).getImage()); // Moive의 image 변수값 가져와서 연결
        txtTitle.setText(data.get(i).getTitle()); // Movie의 title값 가져와서 연결

        return view;
    }
}
