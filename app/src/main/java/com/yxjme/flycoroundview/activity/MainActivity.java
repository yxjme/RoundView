package com.yxjme.flycoroundview.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;
import com.gigamole.navigationtabstrip.NavigationTabStrip;
import com.google.android.material.tabs.TabLayout;
import com.yxjme.flycoroundview.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    private NavigationTabStrip mNavigationTabStrip;
    private TabLayout mTableLayout;
    private ViewPager mViewPager;
    private List<View> views =new ArrayList<>();
    private List<String> title = new ArrayList<>();

    private SlidingTabLayout  tl_1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        init();
    }




    private void init() {
        StringBuffer stringBuffer=new StringBuffer();
        for (int i = 0 ; i<10 ; i++){
            TextView textView = new TextView(MainActivity.this);
            textView.setTextSize(14);
            textView.setGravity(Gravity.CENTER);
            textView.setTextColor(Color.BLACK);
            textView.setText("标题"+i);
            title.add("标题"+i);
            mTableLayout.addTab(mTableLayout.newTab().setCustomView(textView));


            Button button = new Button(this);
            button.setText("标题"+i);
            views.add(button);
        }
        mNavigationTabStrip.setTitles("标题","标题","标题","标题","标题","标题","标题","标题","标题","标题");


        mViewPager.setAdapter(new MyPagerAdapter());
        mNavigationTabStrip.setViewPager(mViewPager);
        mTableLayout.addOnTabSelectedListener(listener);
        setCurrentPosition(0);


        tl_1.setViewPager(mViewPager);

    }



    private void initView() {
        mNavigationTabStrip = findViewById(R.id.mNavigationTabStrip);
        mTableLayout = findViewById(R.id.mTableLayout);
        mViewPager = findViewById(R.id.mViewPager);
        mTableLayout.setupWithViewPager(mViewPager);
        mViewPager.setOffscreenPageLimit(0);
        tl_1 = findViewById(R.id.tl_1);

    }


    /**
     * 指定选中
     *
     * @param i
     */
    private void setCurrentPosition(int i) {
        if (null != mTableLayout&&mTableLayout.getChildCount()>0){
            View view = mTableLayout.getTabAt(i).getCustomView();
            if (null != view && view instanceof TextView) {
                ((TextView) view).setTextSize(16);
                ((TextView) view).setTextColor(Color.RED);
            }
        }
    }


    private TabLayout.OnTabSelectedListener listener= new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            //在这里可以设置选中状态下  tab字体显示样式
            View view = tab.getCustomView();
            if (null != view && view instanceof TextView) {
                ((TextView) view).setTextSize(16);
                ((TextView) view).setTextColor(Color.RED);
                ((TextView) view).getPaint().setFakeBoldText(true);
            }
        }


        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
            //在这里可以设置选中状态下  tab字体显示样式
            View view = tab.getCustomView();
            if (null != view && view instanceof TextView) {
                ((TextView) view).setTextSize(14);
                ((TextView) view).setTextColor(Color.BLACK);
                ((TextView) view).getPaint().setFakeBoldText(false);
            }
        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };



    public class MyPagerAdapter extends PagerAdapter{


        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            container.addView(views.get(position));
            return views.get(position);
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//            super.destroyItem(container, position, object);
            container.removeView(views.get(position));
        }


        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return title.get(position);
        }
    }
}
