package com.myapp.smartagricultureplus.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myapp.smartagricultureplus.Monitor_Fragment.Monitor_All_Fragment;
import com.myapp.smartagricultureplus.Monitor_Fragment.Monitor_To1_Fragment;
import com.myapp.smartagricultureplus.Monitor_Fragment.Monitor_To2_Fragment;
import com.myapp.smartagricultureplus.Monitor_Fragment.Monitor_To3_Fragment;
import com.myapp.smartagricultureplus.Monitor_Fragment.Monitor_To4_Fragment;
import com.myapp.smartagricultureplus.Monitor_Fragment.Monitor_To5_Fragment;
import com.myapp.smartagricultureplus.R;

/**
 * 监测 1
 */
public class Monitor_Fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_monitor_, container, false);
    }

    //滑动
    private ViewPager mVpMonitor;
    //Fragment
    private Monitor_All_Fragment all_fragment;
    private Monitor_To1_Fragment to1_fragment;
    private Monitor_To2_Fragment to2_fragment;
    private Monitor_To3_Fragment to3_fragment;
    private Monitor_To4_Fragment to4_fragment;
    private Monitor_To5_Fragment to5_fragment;
    //数据
    private SparseArray<Fragment> fgtSparseArray = new SparseArray<>();
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
        initAdapter();
    }

    private void initAdapter()
    {
        TextView lw;
    }

    private void initData()
    {
        mVpMonitor.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                switch (position)
                {
                    case 1:
                        return fgtSparseArray.get(1);
                    case 2:
                        return fgtSparseArray.get(2);
                    case 3:
                        return fgtSparseArray.get(3);
                    case 4:
                        return fgtSparseArray.get(4);
                    case 5:
                        return fgtSparseArray.get(5);
                }
                return fgtSparseArray.get(0);
            }

            @Override
            public int getCount() {
                return fgtSparseArray.size();
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                return super.instantiateItem(container, position);
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                super.destroyItem(container, position, object);
            }
        });
    }

    private void initView()
    {
        mVpMonitor = getActivity().findViewById(R.id.vp_monitor);

        all_fragment = new Monitor_All_Fragment();
        to1_fragment = new Monitor_To1_Fragment();
        to2_fragment = new Monitor_To2_Fragment();
        to3_fragment = new Monitor_To3_Fragment();
        to4_fragment = new Monitor_To4_Fragment();
        to5_fragment = new Monitor_To5_Fragment();

        fgtSparseArray.append(0,all_fragment);
        fgtSparseArray.append(1,to1_fragment);
        fgtSparseArray.append(2,to2_fragment);
        fgtSparseArray.append(3,to3_fragment);
        fgtSparseArray.append(4,to4_fragment);
        fgtSparseArray.append(5,to5_fragment);
    }
}