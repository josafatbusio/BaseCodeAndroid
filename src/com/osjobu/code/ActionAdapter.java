package com.osjobu.code;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Oscar
 * Date: 1/07/12
 * Time: 07:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class ActionAdapter extends ArrayAdapter<Action> {

    Context context;
    Action data[]=null;
    int layoutResourceId;

    public ActionAdapter(Context context, int layoutResourceId, Action[] data){
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

   @Override
   public View getView (int position, View convertView, ViewGroup parent){
           View row =convertView;
           ActionHolder holder=null;

       if(row==null){
           LayoutInflater inflater=((Activity)context).getLayoutInflater();
           row=inflater.inflate(layoutResourceId,parent,false);

           holder=new ActionHolder();
           holder.icon=(ImageView)row.findViewById(R.id.list_image) ;
           holder.title=(TextView)row.findViewById(R.id.title);
           holder.artist=(TextView)row.findViewById(R.id.artist);
           holder.duration=(TextView)row.findViewById(R.id.duration);

           row.setTag(holder);
       }
       else{
           holder=(ActionHolder)row.getTag();
       }
       Action action = data[position];
       holder.icon.setImageResource(action.icon);
       holder.title.setText(action.title);
       holder.artist.setText(action.artist);
       holder.duration.setText(action.duration);

       return row;
   }

    static class ActionHolder
    {
        ImageView icon;
        TextView title;
        TextView artist;
        TextView duration;
    }

}
