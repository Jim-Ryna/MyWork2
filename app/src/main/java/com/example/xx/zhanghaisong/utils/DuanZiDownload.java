package com.example.xx.zhanghaisong.utils;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.xx.zhanghaisong.Adapter.DuanzaiAdapter;
import com.example.xx.zhanghaisong.Adapter.GirlAdapter;
import com.example.xx.zhanghaisong.MyApplication;
import com.example.xx.zhanghaisong.model.girl.GirlComment;
import com.example.xx.zhanghaisong.model.girl.GirlStatus;
import com.example.xx.zhanghaisong.model.girl.duanzi.DuanComment;
import com.example.xx.zhanghaisong.model.girl.duanzi.DuanZi;
import com.example.xx.zhanghaisong.ui.DuanziActivity;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

/**
 * Created by xx on 2015/5/30.
 */
public class DuanZiDownload extends AsyncTask<Void, Integer, Boolean> {
    Context mContext;
    String content;
    ListView duanzi_list;
    List<DuanComment> comments;
    DuanzaiAdapter duanzaiAdapter;
    public DuanZiDownload(ListView duanzi_list, DuanzaiAdapter duanzaiAdapter, Context mContext){
        this.mContext = mContext;
        this.duanzi_list = duanzi_list;
        this.duanzaiAdapter = duanzaiAdapter;
    }
    protected void onPreExecute() {
        duanzi_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(comments != null) {
                    Intent intent = new Intent(mContext,DuanziActivity.class);
                    intent.putExtra("content", comments.get(position).getText_content());
                    mContext.startActivity(intent);
                }
            }
        });
    }
    @Override
    protected Boolean doInBackground(Void... params) {
        Log.d("123", "doin");
        final HttpHelper helper = new HttpHelper() {
            @Override
            public HashMap<String, String> getRequestEntity(HashMap<String, String> data) {
                data.put("oxwlxojflwblxbsapi", "jandan.get_duan_comments");
                data.put("page", "1");
                return data;
            }
        };
        content = helper.doHttpUrlConnection("http://jandan.net/?oxwlxojflwblxbsapi=jandan.get_duan_comments&page=1");
        return true;
    }
    protected void onPostExecute(Boolean result) {
        Gson gson = new Gson();
        DuanZi duanZi = gson.fromJson(content, DuanZi.class);
        comments = duanZi.getComments();
        duanzaiAdapter.setComment(comments);
        duanzi_list.setAdapter(duanzaiAdapter);
    }
}
