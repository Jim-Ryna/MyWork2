package com.example.xx.zhanghaisong.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.xx.zhanghaisong.Adapter.GirlAdapter;
import com.example.xx.zhanghaisong.R;
import com.example.xx.zhanghaisong.model.girl.GirlComment;
import com.example.xx.zhanghaisong.model.girl.GirlStatus;
import com.example.xx.zhanghaisong.utils.GirlDownload;
import com.example.xx.zhanghaisong.utils.HttpHelper;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

/**
 * Created by xx on 2015/5/30.
 */
public class FirstFragment extends Fragment{
    ListView girl_list;
    GirlAdapter adapter;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        girl_list = (ListView) view.findViewById(R.id.girl_list);
        adapter = new GirlAdapter();
        new GirlDownload(girl_list, adapter, getActivity()).execute();

        return view;
    }
}
