package com.example.xx.zhanghaisong.utils;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.xx.zhanghaisong.Adapter.GirlAdapter;
import com.example.xx.zhanghaisong.MyApplication;
import com.example.xx.zhanghaisong.model.girl.GirlComment;
import com.example.xx.zhanghaisong.model.girl.GirlStatus;
import com.example.xx.zhanghaisong.ui.GirlActiviy;
import com.example.xx.zhanghaisong.ui.MainActivity;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

/**
 * Created by xx on 2015/5/30.
 */
public class GirlDownload extends AsyncTask<Void, Integer, Boolean>{
    Context mContext;
    String content;
    ListView girl_list;
    List<GirlComment> comments;
    GirlAdapter girlAdapter;
    public GirlDownload(ListView girl_list, GirlAdapter girlAdapter, Context mContext){
        this.mContext = mContext;
        this.girl_list = girl_list;
        this.girlAdapter = girlAdapter;
    }
    protected void onPreExecute() {
        girl_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (comments != null){
                    String picUrl = comments.get(position).getPics().get(0);
                    Intent intent = new Intent(mContext, GirlActiviy.class);
                    intent.putExtra("picUrl", picUrl);
                    mContext.startActivity(intent);
                }
            }
        });
    }
    @Override
    protected Boolean doInBackground(Void... params) {
        final HttpHelper helper = new HttpHelper() {
            @Override
            public HashMap<String, String> getRequestEntity(HashMap<String, String> data) {
                data.put("oxwlxojflwblxbsapi", "jandan.get_ooxx_comments");
                data.put("page", "1");
                return data;
            }
        };
        content = helper.doHttpUrlConnection("http://jandan.net/?oxwlxojflwblxbsapi=jandan.get_ooxx_comments&page=1");
        return true;
    }
    protected void onPostExecute(Boolean result) {
            Gson gson = new Gson();
            GirlStatus status = gson.fromJson(content, GirlStatus.class);
            comments = status.getComments();
            girlAdapter.setComment(comments);
            girl_list.setAdapter(girlAdapter);
    }
}
