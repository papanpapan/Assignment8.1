package com.example.amitroy.assignment81;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
Button Ascending,Descending;
    ListView list;
    List<String>stringList;
    StringAdapter stringAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Ascending=(Button)findViewById(R.id.assending);
        Descending=(Button)findViewById(R.id.desending);
        list=(ListView)findViewById(R.id.list);
        stringList=new ArrayList<String>();
        stringList.add("January");
        stringList.add("February");
        stringList.add("March");
        stringList.add("April");
        stringList.add("May");
        stringList.add("June");
        stringList.add("July");
        stringList.add("August");
        stringList.add("September");
        stringList.add("October");
        stringList.add("November");
        stringList.add("December");
        stringAdapter=new StringAdapter(MainActivity.this,R.layout.sort_list_item,stringList);
        list.setAdapter(stringAdapter);

        final Comparator<String>StringAscComparator=new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String stringName1=o1;
                String stringName2=o2;
                return stringName1.compareToIgnoreCase(stringName2);

            }
        };
        final Comparator<String>StringDescComparator=new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String stringName1=o1;
                String stringName2=o2;
                return stringName2.compareToIgnoreCase(stringName1);
            }
        };
        Ascending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(stringList,StringAscComparator);
                Toast.makeText(MainActivity.this, "Sorting in Ascending Order", Toast.LENGTH_LONG).show();
                stringAdapter.notifyDataSetChanged();
            }
        });
        Descending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(stringList,StringDescComparator);
                Toast.makeText(MainActivity.this, "Sorting in Descending Order", Toast.LENGTH_LONG).show();
                stringAdapter.notifyDataSetChanged();
            }

        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Cilck ON...." +  stringList.get(position),Toast.LENGTH_SHORT).show();
            }
        });



    }
}
