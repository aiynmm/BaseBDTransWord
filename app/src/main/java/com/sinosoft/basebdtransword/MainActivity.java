package com.sinosoft.basebdtransword;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.sinosoft.basebdtransword.adapters.MyFragmentPagerAdapter;
import com.sinosoft.basebdtransword.fragments.LittleAppFragment;
import com.sinosoft.basebdtransword.fragments.LookUpFragment;
import com.sinosoft.basebdtransword.fragments.MeFragment;
import com.sinosoft.basebdtransword.fragments.StarFragment;
import com.sinosoft.basebdtransword.helper.BottomNavigationViewHelper;
import com.sinosoft.basebdtransword.views.NoScrollViewPager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView mToolbarTitle;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragments;
    private BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mToolbarTitle.setText(R.string.title_home);
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_collection:
                    mToolbarTitle.setText(R.string.title_collection);
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_dashboard:
                    mToolbarTitle.setText(R.string.title_dashboard);
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.navigation_me:
                    mToolbarTitle.setText(R.string.title_me);
                    viewPager.setCurrentItem(3);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");//这里是让title居中
        setSupportActionBar(toolbar);


        mToolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        //viewPager.setScroll(true);
        FragmentManager manager = getSupportFragmentManager();
        fragments = new ArrayList<>();
        init();
        MyFragmentPagerAdapter pagerAdapter = new MyFragmentPagerAdapter(manager, fragments);
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        navigation.setSelectedItemId(R.id.navigation_home);
                        break;
                    case 1:
                        navigation.setSelectedItemId(R.id.navigation_collection);
                        break;
                    case 2:
                        navigation.setSelectedItemId(R.id.navigation_dashboard);
                        break;
                    case 3:
                        navigation.setSelectedItemId(R.id.navigation_me);
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void init() {
        LookUpFragment lookUpFragment = new LookUpFragment();
        StarFragment starFragment = new StarFragment();
        LittleAppFragment littleAppFragment = new LittleAppFragment();
        MeFragment meFragment = new MeFragment();
        fragments.add(lookUpFragment);
        fragments.add(starFragment);
        fragments.add(littleAppFragment);
        fragments.add(meFragment);
    }

}
