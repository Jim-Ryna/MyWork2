package com.example.xx.zhanghaisong.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;
import com.example.xx.zhanghaisong.R;
import com.example.xx.zhanghaisong.utils.AppUpdate;
import com.example.xx.zhanghaisong.view.FirstFragment;
import com.example.xx.zhanghaisong.view.SecondFragment;
import com.example.xx.zhanghaisong.view.ThirdFragment;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    private ArrayList<Fragment>fragments = new ArrayList<Fragment>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragments.add(new FirstFragment());
        fragments.add(new SecondFragment());
        fragments.add(new ThirdFragment());
        Log.d("123", String.valueOf(fragments));
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        Log.d("123", String.valueOf(pager));
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            String[] title = { "妹子", "段子", "项目三" };
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
            public CharSequence getPageTitle(int position) {
                return title[position];
            }
        });

        // Bind the tabs to the ViewPager
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setViewPager(pager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            new AppUpdate(MainActivity.this).execute();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
