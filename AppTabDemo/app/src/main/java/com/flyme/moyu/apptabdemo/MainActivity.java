package com.flyme.moyu.apptabdemo;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * ViewPager实现Tab
 */
public class MainActivity extends Activity implements View.OnClickListener {

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private List<View> list = new ArrayList<>();
    //TAB
    private LinearLayout mTabLoc;
    private LinearLayout mTabShr;
    private LinearLayout mTabQzo;
    private LinearLayout mTabTwi;

    private ImageButton mTabLocImg;
    private ImageButton mTabShrImg;
    private ImageButton mTabQzoImg;
    private ImageButton mTabtwiImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();//初始化控件
        initEvents();//初始化事件
    }


    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);

        mTabLoc = (LinearLayout) findViewById(R.id.id_tab_loc);
        mTabShr = (LinearLayout) findViewById(R.id.id_tab_shr);
        mTabQzo = (LinearLayout) findViewById(R.id.id_tab_qzo);
        mTabTwi = (LinearLayout) findViewById(R.id.id_tab_twi);

        mTabLocImg = (ImageButton) findViewById(R.id.id_tab_loc_img);
        mTabShrImg = (ImageButton) findViewById(R.id.id_tab_shr_img);
        mTabQzoImg = (ImageButton) findViewById(R.id.id_tab_qzo_img);
        mTabtwiImg = (ImageButton) findViewById(R.id.id_tab_twi_img);

        LayoutInflater inflater = LayoutInflater.from(this);
        View tab01 = inflater.inflate(R.layout.tab01, null);
        View tab02 = inflater.inflate(R.layout.tab02, null);
        View tab03 = inflater.inflate(R.layout.tab03, null);
        View tab04 = inflater.inflate(R.layout.tab04, null);

        list.add(tab01);
        list.add(tab02);
        list.add(tab03);
        list.add(tab04);
        mPagerAdapter = new PagerAdapter()

        {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object o) {
                return view == o;
            }

            /*
             *初始化View
             */
            @Override
            public Object instantiateItem(ViewGroup container, int position) {

                View view = list.get(position);
                container.addView(view);//将view添加到ViewGroup
                return view;
            }

            /*
             *摧毁View
             */
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(list.get(position));//在ViewGroup移除view
            }
        };

        mViewPager.setAdapter(mPagerAdapter);//为viewPager设置Adapter
        mViewPager.setCurrentItem(0);//默认情况下设置显示Tab01
        mTabLocImg.setImageResource(R.mipmap.sns_shoot_location_pressed);

    }

    private void initEvents() {
        mTabLoc.setOnClickListener(this);
        mTabShr.setOnClickListener(this);
        mTabQzo.setOnClickListener(this);
        mTabTwi.setOnClickListener(this);

        //当Viewpager滑动时监听
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                resetTabImg();
                int currentItem = mViewPager.getCurrentItem();
                switch (currentItem) {
                    case 0:
                        mTabLocImg.setImageResource(R.mipmap.sns_shoot_location_pressed);
                        break;
                    case 1:
                        mTabShrImg.setImageResource(R.mipmap.sns_shoot_share_pressed);
                        break;
                    case 2:
                        mTabQzoImg.setImageResource(R.mipmap.sns_shoot_shareqzone_pressed);
                        break;
                    case 3:
                        mTabtwiImg.setImageResource(R.mipmap.sns_shoot_twitter_pressed);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        resetTabImg();
        switch (view.getId()) {
            case R.id.id_tab_loc:
                mViewPager.setCurrentItem(0);
                mTabLocImg.setImageResource(R.mipmap.sns_shoot_location_pressed);
                break;
            case R.id.id_tab_shr:
                mViewPager.setCurrentItem(1);
                mTabShrImg.setImageResource(R.mipmap.sns_shoot_share_pressed);
                break;
            case R.id.id_tab_qzo:
                mViewPager.setCurrentItem(2);
                mTabQzoImg.setImageResource(R.mipmap.sns_shoot_shareqzone_pressed);
                break;
            case R.id.id_tab_twi:
                mViewPager.setCurrentItem(3);
                mTabtwiImg.setImageResource(R.mipmap.sns_shoot_twitter_pressed);
                break;
        }
    }

    //重置tab状态
    private void resetTabImg() {
        mTabLocImg.setImageResource(R.mipmap.sns_shoot_location_normal);
        mTabShrImg.setImageResource(R.mipmap.sns_shoot_share_normal);
        mTabQzoImg.setImageResource(R.mipmap.sns_shoot_shareqzone_normal);
        mTabtwiImg.setImageResource(R.mipmap.sns_shoot_twitter_normal);
    }
}
