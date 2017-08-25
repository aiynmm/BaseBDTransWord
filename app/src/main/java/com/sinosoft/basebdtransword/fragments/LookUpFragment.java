package com.sinosoft.basebdtransword.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sinosoft.basebdtransword.R;
import com.sinosoft.basebdtransword.adapters.BookNameAdapter;
import com.sinosoft.basebdtransword.mycamera.CameraActivity;

/**
 * Created by Mars on 2017/6/12.
 */

public class LookUpFragment extends Fragment {
    private static final String TAG = LookUpFragment.class.getName();
    private View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG,"onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG,"onCreateView");
        if (null == view) {
            view = inflater.inflate(R.layout.fragment_lookup, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.take_picture);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), CameraActivity.class);
                    startActivity(intent);
                }
            });

            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
            GridLayoutManager manager = new GridLayoutManager(getActivity(), 3);
            recyclerView.setLayoutManager(manager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            BookNameAdapter adapter = new BookNameAdapter(getActivity().getLayoutInflater());
            recyclerView.setAdapter(adapter);
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (null != view) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }
}
