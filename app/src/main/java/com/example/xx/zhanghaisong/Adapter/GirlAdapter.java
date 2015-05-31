package com.example.xx.zhanghaisong.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.example.xx.zhanghaisong.MyApplication;
import com.example.xx.zhanghaisong.R;
import com.example.xx.zhanghaisong.model.girl.GirlComment;
import com.example.xx.zhanghaisong.utils.BitmapCache;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xx on 2015/5/30.
 */
public class GirlAdapter extends BaseAdapter {
    List<GirlComment> mComments;
    public void setComment(List<GirlComment> comments){
        mComments = comments;
    }

    @Override
    public int getCount() {
        return mComments.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        RequestQueue mQueue = Volley.newRequestQueue(MyApplication.getContext());
        ImageLoader imageLoader = new ImageLoader(mQueue, new BitmapCache());
        GirlComment comment = mComments.get(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(MyApplication.getContext()).inflate(R.layout.meizi, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.networkImageView = (NetworkImageView) view.findViewById(R.id.network_image_view);
            viewHolder.author_text = (TextView) view.findViewById(R.id.author_text);
            viewHolder.date_text = (TextView) view.findViewById(R.id.date_text);
            viewHolder.trample_text = (TextView) view.findViewById(R.id.trample_text);
            viewHolder.zan_text = (TextView) view.findViewById(R.id.zan_text);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.zan_text.setText(comment.getVote_positive());
        viewHolder.trample_text.setText(comment.getVote_negative());
        viewHolder.date_text.setText(comment.getComment_date());
        viewHolder.author_text.setText(comment.getComment_author());
        viewHolder.networkImageView.setDefaultImageResId(R.drawable.default_image);
        viewHolder.networkImageView.setErrorImageResId(R.drawable.failed_image);
        viewHolder.networkImageView.setImageUrl(comment.getPics().get(0),
                imageLoader);

        return view;
    }
    class ViewHolder{
        TextView zan_text;
        TextView trample_text;
        TextView author_text;
        TextView date_text;
        NetworkImageView networkImageView;
    }
}
