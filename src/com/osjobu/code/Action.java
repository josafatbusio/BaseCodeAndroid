package com.osjobu.code;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Oscar
 * Date: 1/07/12
 * Time: 07:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class Action {

    public int icon;
    public String title;
    public String artist;
    public String duration;

    public Action(){
        super();
    }

    public Action(int icon, String title, String artist, String duration) {
        super();
        this.icon = icon;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }
}
