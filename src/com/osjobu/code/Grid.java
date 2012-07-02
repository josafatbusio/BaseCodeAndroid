package com.osjobu.code;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: Oscar
 * Date: 25/06/12
 * Time: 04:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class Grid extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //To change body of implemented methods use File | Settings | File Templates.
                Toast.makeText(Grid.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });


    }
}