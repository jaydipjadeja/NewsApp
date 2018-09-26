package com.example.android.newsapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NewsAdapter extends ArrayAdapter<News> {


    // Tag for log messages
    private static final String LOG_TAG = NewsAdapter.class.getName();

    private Context mContext;
    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param news A List of news objects to display in a list
     */
    public NewsAdapter(Activity context, ArrayList<News> news){
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context,0,news);
        mContext = context;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list, parent, false);
        }

        // Find the news at the given position in the list of news
        News currentNews = getItem(position);

        // Find the TextView with view ID title
        TextView titleView = (TextView) listItemView.findViewById(R.id.title);
        titleView.setText(currentNews.getNewsTitle());

        // Find the TextView with view ID section
        TextView sectionView = (TextView) listItemView.findViewById(R.id.section);
        sectionView.setText(currentNews.getSection());

//        // Create a new Date object from the time in milliseconds of the earthquake
//        Date dateObject = new Date(currentNews.getNewsTime());


        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formatTime(currentNews.getNewsTime()).toString());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.no_image);
        Glide.with(mContext).load(currentNews.getImageUrl()).into(imageView);

        return listItemView;

    }

    private CharSequence formatTime(String time) {

        // Convert the Date object of format {yyyy-MM-dd'T'hh:mm:ss'Z'} into
        // string format of {yyyy-MM-dd HH:mm:ss}
        @SuppressLint("SimpleDateFormat") SimpleDateFormat outDate
                = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // Parse the date-time string into Date object of format {yyyy-MM-dd HH:mm:ss}
        // And get the time in milliseconds from Date object
        long currentTimeInMillis = 0;
        try {
            Date currentDateObject = outDate.parse(time);
            currentTimeInMillis = currentDateObject.getTime();
        } catch (ParseException e) {
            Log.e(LOG_TAG, "Error parsing date object : getTimeAndDate() method,e");
        }
        // Returns the date-time in more human readable format
        return DateUtils.getRelativeTimeSpanString(
                currentTimeInMillis
                , System.currentTimeMillis()
                , DateUtils.MINUTE_IN_MILLIS);
    }

}
