package com.example.samy.recyclerviewfilter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
   RecyclerView recyclerView;
   RecyclerView.LayoutManager layoutManager;
   CoursesRecyclerViewAdapter coursesRecyclerViewAdapter;
   Toolbar toolbar;
    List<String> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        list=Arrays.asList(getResources().getStringArray(R.array.courses));
        coursesRecyclerViewAdapter=new CoursesRecyclerViewAdapter(list);
        recyclerView.setAdapter(coursesRecyclerViewAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.app_menu,menu);
        MenuItem menuItem=menu.findItem(R.id.search_menu);
        SearchView searchView= (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        return true;


    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        String userInput=s.toLowerCase();
        List<String> newList=new ArrayList<>();
        for(String l:list){
           if(l.toLowerCase().contains(userInput)) {
               newList.add(l);
           }
        }
        coursesRecyclerViewAdapter.onUpdate(newList);
        return true;
    }
}
