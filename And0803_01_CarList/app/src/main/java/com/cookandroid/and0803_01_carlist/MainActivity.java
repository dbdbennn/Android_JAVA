package com.cookandroid.and0803_01_carlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ListView list, list1;
    CarAdatper cAdapter;
    ArrayList<Car> cArray;
    Car cItem;
    Integer[] image = {R.drawable.car1, R.drawable.car2,R.drawable.car3,R.drawable.car4,
            R.drawable.car5,R.drawable.car6,R.drawable.car7,R.drawable.car8,R.drawable.car9,
            R.drawable.car10};
    String [] title = {"차1", "차2", "차3","차4", "차5",
            "차6","차7","차8","차9", "차10"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Custom Car list[유정은]");
        list = findViewById(R.id.list);
        cArray = new ArrayList<>();

        for (int i = 0; i < image.length; i++) {
            cItem = new Car(ContextCompat.getDrawable(this, image[i]), title[i]);
            cArray.add(cItem);
        }//무비 객체 배열 초기화(ArrayList에 값으로 생성)
        cAdapter = new CarAdatper(this, cArray);
        list.setAdapter(cAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Car item = (Car)list.getItemAtPosition(i);
                customToast(item);
            }
        });

    }
    public void customToast(Car item){
        View layout = getLayoutInflater().inflate(R.layout.car_toast, null);
        ImageView img = layout.findViewById(R.id.toast_img);
        TextView txt = layout.findViewById(R.id.toast_txt);
        img.setImageDrawable(item.getImage());
        txt.setText(item.getTitle());

        Toast t = new Toast(getApplicationContext());
        t.setView(layout);
        // 위치 지정
        t.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        t.setDuration(Toast.LENGTH_SHORT);
        t.show();
    }
}