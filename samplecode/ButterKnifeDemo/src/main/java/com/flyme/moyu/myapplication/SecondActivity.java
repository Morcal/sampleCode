package com.flyme.moyu.myapplication;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;



public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fgTransaction = fragmentManager.beginTransaction();
            SecondActivityFragment seFragment = new SecondActivityFragment();
            //一定要注意，要么是app下的碎片，要么是support.v4下的
            fgTransaction.add(R.id.fragment_contaion, seFragment);
            fgTransaction.commit();
        }
        com.orhanobut.logger.Logger.d("secondShow", SecondActivity.this);

    }

}
