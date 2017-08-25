package com.sinosoft.basebdtransword.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sinosoft.basebdtransword.R;
import com.sinosoft.basebdtransword.adapters.CollectionPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Mars on 2017/6/12.
 */

public class StarFragment extends Fragment {
    private View view;
    private static final String[] titles = {"词句收藏", "文章收藏"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_collection, null);
            ViewPager viewPager = (ViewPager) view.findViewById(R.id.collection_viewpager);
            TabLayout tabLayout = (TabLayout) view.findViewById(R.id.collection_tab);
            init(viewPager, tabLayout);
        }
        return view;
    }

    private void init(ViewPager viewPager, TabLayout tabLayout) {
        ArrayList<Fragment> fragments = new ArrayList<>();
        WordCollectionFragment wordCollectionFragment = new WordCollectionFragment();
        ArticleCollectionFragment articleCollectionFragment = new ArticleCollectionFragment();
        fragments.add(wordCollectionFragment);
        fragments.add(articleCollectionFragment);
        CollectionPagerAdapter checkPageAdapter = new CollectionPagerAdapter(getActivity().getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(checkPageAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setupWithViewPager(viewPager);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (view != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }
}
