package com.cookandroid.and0802_06_cuslist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    Context context; // 메인 엑티비티 컨텍스트 저장변수
    ArrayList<Movie> data; // 데이터

    public MovieAdapter(Context context, ArrayList data){
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
        TextView txtGenre = view.findViewById(R.id.txtGenre);
        img.setImageDrawable(data.get(i).getImgae()); // Moive의 image 변수값 가져와서 연결
        txtTitle.setText(data.get(i).getTitle()); // Movie의 title값 가져와서 연결
        txtGenre.setText(data.get(i).getGenre()); // Movie의 Genre값 가져와서 연결

        return view;
    }
}
