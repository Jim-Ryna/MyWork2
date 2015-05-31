package com.example.xx.zhanghaisong.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.xx.zhanghaisong.Adapter.DuanzaiAdapter;
import com.example.xx.zhanghaisong.R;
import com.example.xx.zhanghaisong.utils.DuanZiDownload;

/**
 * Created by xx on 2015/5/30.
 */
public class SecondFragment extends Fragment{
    ListView duanzi_list;
    DuanzaiAdapter adapter;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        duanzi_list = (ListView) view.findViewById(R.id.duanzi_list);
        adapter = new DuanzaiAdapter();
        new DuanZiDownload(duanzi_list, adapter, getActivity()).execute();
        return view;
    }
}
