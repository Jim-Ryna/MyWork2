package com.example.xx.zhanghaisong.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.xx.zhanghaisong.MyApplication;
import com.example.xx.zhanghaisong.R;
import com.example.xx.zhanghaisong.model.girl.duanzi.DuanComment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xx on 2015/5/30.
 */
public class DuanzaiAdapter extends BaseAdapter{
    List<DuanComment> mComments;
    public void setComment(List<DuanComment> comments){
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
    public View getView(int position, View convertView, ViewGroup parent) {
        DuanComment comment = mComments.get(position);
        View view = LayoutInflater.from(MyApplication.getContext()).inflate(R.layout.duanzi, parent, false);
        ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();
            viewHolder.author_text = (TextView) view.findViewById(R.id.author_text);
            viewHolder.content_text = (TextView) view.findViewById(R.id.content_text);
            viewHolder.date_text = (TextView) view.findViewById(R.id.date_text);
            viewHolder.zan_text = (TextView) view.findViewById(R.id.zan_text);
            viewHolder.trample_text = (TextView) view.findViewById(R.id.trample_text);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.content_text.setText(comment.getComment_content());
        viewHolder.author_text.setText(comment.getComment_author());
        viewHolder.date_text.setText(comment.getComment_date());
        viewHolder.zan_text.setText(comment.getVote_positive());
        viewHolder.trample_text.setText(comment.getVote_negative());
        return view;
    }
    class ViewHolder{
        TextView author_text;
        TextView date_text;
        TextView content_text;
        TextView zan_text;
        TextView trample_text;
    }
}
