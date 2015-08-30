package com.flyme.moyu.myapplication;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A placeholder fragment containing a simple view.
 * 在Fragment中使用ButterKnife
 */
public class SecondActivityFragment extends Fragment {

    @Bind(R.id.lv_show)
    ListView mListView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        ButterKnife.bind(this, view);//此处进行绑定

        MeiziAdapter meiziAdapter = new MeiziAdapter(getActivity());
        mListView.setAdapter(meiziAdapter);

        Toast.makeText(getActivity(), "fragmentShow", Toast.LENGTH_SHORT).show();

        return view;
    }

    @OnClick(R.id.iv_back)
    public void finishActivity() {
        getActivity().finish();
    }
}
