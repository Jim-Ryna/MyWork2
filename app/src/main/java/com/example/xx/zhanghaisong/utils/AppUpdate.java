package com.example.xx.zhanghaisong.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.example.xx.zhanghaisong.MyApplication;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by xx on 2015/5/31.
 */
public class AppUpdate extends AsyncTask<Void, Integer, Boolean>{
    Context mContext;
    String versionCode = "";
    String versionName = "";
    String updateContent = "";
    String apkURL = "";
    AlertDialog.Builder dialog;
    public AppUpdate(Context mContext){
        this.mContext = mContext;
    }
    protected void onPreExecute() {
        dialog = new AlertDialog.Builder(mContext);
        dialog.setCancelable(false);
        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
    }
    @Override
    protected Boolean doInBackground(Void... params) {
        Log.e("123", "doIn");
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://hongyan.cqupt.edu.cn/app/cyxbsAppUpdate.xml");
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode() == 200){
                HttpEntity entity = httpResponse.getEntity();
                String response = EntityUtils.toString(entity,"utf-8");
                Log.e("123", response);
                parseXML(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    private void parseXML(String xmlData){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser pullParser = factory.newPullParser();
            pullParser.setInput(new StringReader(xmlData));
            int eventType = pullParser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String nodeName = pullParser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG: {
                        if ("versionCode".equals(nodeName)) {
                            versionCode = pullParser.nextText();
                            Log.e("123", versionCode);
                        } else if ("versionName".equals(nodeName)) {
                            versionName = pullParser.nextText();
                            Log.e("123", versionName);
                        } else if ("updateContent".equals(nodeName)) {
                            updateContent = pullParser.nextText();
                            Log.e("123", updateContent);
                        } else if ("apkURL".equals(nodeName)) {
                            apkURL = pullParser.nextText();
                            Log.e("123", apkURL);
                        }
                        break;
                    }
                    default:
                        break;
                }
                eventType = pullParser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void onPostExecute(Boolean result) {
        if (result) {
            Log.e("123",versionCode);
            Log.e("123",versionName);
            Log.e("123",apkURL);
            dialog.setTitle("掌上重邮" + versionName);
            dialog.setMessage(updateContent);
            dialog.setPositiveButton("检查更新", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(apkURL));
                    MyApplication.getContext().startActivity(intent);
                }
            });
            dialog.show();
        }
    }
}
