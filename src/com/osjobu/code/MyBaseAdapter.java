package com.osjobu.code;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.ImageView;
import android.widget.TextView;
import org.w3c.dom.ls.LSException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oscar
 * Date: 1/07/12
 * Time: 12:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyBaseAdapter extends BaseAdapter {

    private Activity activity;
    private String[] data;
    private static LayoutInflater inflater=null;
    //public ImageLoader imageLoader;

    public MyBaseAdapter(Activity a, String[] d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //imageLoader=new ImageLoader(activity.getApplicationContext());
    }
    public int getCount() {
        return data.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_row, null);

        TextView title = (TextView)vi.findViewById(R.id.title); // title
        TextView artist = (TextView)vi.findViewById(R.id.artist); // artist name
        TextView duration = (TextView)vi.findViewById(R.id.duration); // duration
        ImageView thumb_image=(ImageView)vi.findViewById(R.id.list_image); // thumb image

        // Setting all values in listview
        title.setText("Title");//song.get(CustomizedListView.KEY_TITLE));
        artist.setText("Mili Padilla");//song.get(CustomizedListView.KEY_ARTIST));
        duration.setText("5:04");//song.get(CustomizedListView.KEY_DURATION));

        //imageLoader.DisplayImage(song.get(CustomizedListView.KEY_THUMB_URL), thumb_image);

        return vi;
    }
}
