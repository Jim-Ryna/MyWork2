package com.example.xx.zhanghaisong.utils;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by srtianxia on 2015/5/17.
 */
public abstract class HttpHelper {
    public final String doHttpUrlConnection(String url){
        String result = null;
        HttpURLConnection conn = null;
        try {
            HashMap<String,String> data = new HashMap<>();
            String requestdata = setRequestEntity(getRequestEntity(data));
            URL mUrl = new URL(url);
            conn = (HttpURLConnection) mUrl.openConnection();//123������
            conn.setConnectTimeout(8000);
            //������������HttpURLConnection�����б���Ҫд
            conn.setDoInput(true);//��������
            conn.setDoOutput(true);//�������
            conn.setDefaultUseCaches(false);
            conn.setRequestMethod("POST");//���ַ�ʽ
            OutputStream out = conn.getOutputStream();
            out.write(requestdata.getBytes("UTF-8"));

            if(conn.getResponseCode()==HttpURLConnection.HTTP_OK){
                Log.d("info", "访问成功" + conn.getResponseCode());
                ByteArrayOutputStream outStream = new ByteArrayOutputStream();
                InputStream in = conn.getInputStream();//��ȡ���������ص���Ϣ
                byte[] datas = new byte[1024];
                int len = 0;
                while ((len = in.read(datas)) != -1) {
                    outStream.write(datas, 0, len);
                }
                result= new String(outStream.toByteArray());
            }
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            if (conn != null){
                conn.disconnect();
            }
        }

        return result;
    }
    public abstract HashMap<String, String> getRequestEntity(HashMap<String, String> data);

    public final String setRequestEntity(Map<String,String> map){
        String result= null;
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> entry: map.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        sb.deleteCharAt(sb.length()-1);
        result = sb.toString();
        return result;
    }



}
