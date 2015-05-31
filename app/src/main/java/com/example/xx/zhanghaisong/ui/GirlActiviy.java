package com.example.xx.zhanghaisong.ui;

import android.app.NotificationManager;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.example.xx.zhanghaisong.R;
import com.example.xx.zhanghaisong.utils.BitmapCache;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class GirlActiviy extends ActionBarActivity {
    NetworkImageView networkImageView;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girl_activiy);
        networkImageView = (NetworkImageView) findViewById(R.id.girl_big_image);
        Intent intent = getIntent();
        url =intent.getStringExtra("picUrl");
        RequestQueue mQueue = Volley.newRequestQueue(GirlActiviy.this);
        ImageLoader imageLoader = new ImageLoader(mQueue, new BitmapCache());
        networkImageView.setDefaultImageResId(R.drawable.default_image);
        networkImageView.setErrorImageResId(R.drawable.failed_image);
        networkImageView.setImageUrl(url,
                imageLoader);
        networkImageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent mIntent1 = new Intent(Intent.ACTION_SEND);
                mIntent1.setType("text/plain");
                mIntent1.putExtra(Intent.EXTRA_SUBJECT, "分享");
                mIntent1.putExtra(Intent.EXTRA_TEXT, url );
                networkImageView.getDrawable();
                mIntent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(Intent.createChooser(mIntent1, getTitle()));
                return true;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_girl_activiy, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
