package com.sar.user.list_base;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String title[],subtitle[];
    List<Model> list;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=new ArrayList<>();
        listView=findViewById(R.id.lol);
        title=getResources().getStringArray(R.array.title);
        subtitle=getResources().getStringArray(R.array.sub_title);
        for (int i=0; i<title.length;i++)
        {
            Model model=new Model(title[i],subtitle[i]);
            list.add(model);
        }
        BaseA baseA=new BaseA(getApplicationContext(),list);
        baseA.getData(title,subtitle);
        baseA.notifyDataSetChanged();
        listView.setAdapter(baseA);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });



    }
}
