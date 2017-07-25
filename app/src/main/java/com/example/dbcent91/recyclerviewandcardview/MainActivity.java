package com.example.dbcent91.recyclerviewandcardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    Toolbar toolbar;

    MyCustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);

        adapter=new MyCustomAdapter(this,Data.getData());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));// Vertical Orientation By Default

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();

        switch(id){
            case R.id.linearViewHorizontal:
                LinearLayoutManager mlLinearLayoutManagerHorizontal=new LinearLayoutManager(this);
                mlLinearLayoutManagerHorizontal.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(mlLinearLayoutManagerHorizontal);
                break;

            case R.id.linearViewVertical:
                LinearLayoutManager mlLinearLayoutManagerVertical=new LinearLayoutManager(this);
                mlLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(mlLinearLayoutManagerVertical);
                break;

            case R.id.gridView:
                GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
                recyclerView.setLayoutManager(gridLayoutManager);
                break;

            case R.id.staggeredViewHorizontal:
                StaggeredGridLayoutManager staggeredGridLayoutManagerHorizontal=new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(staggeredGridLayoutManagerHorizontal);
                break;

            case R.id.staggeredViewVertical:
                StaggeredGridLayoutManager staggeredGridLayoutManagerVertical=new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(staggeredGridLayoutManagerVertical);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
