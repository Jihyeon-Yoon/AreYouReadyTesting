package com.example.yjh.areyouready;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by YJH on 2018-05-17.
 */

public class Volunteer extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.volunteer, null);

        // TabLayout + ViewPager
        // TabLayout을 쓰기 위해서 build.gradle(Module: app)의 dependencies에 디자인 라이브러리 추가
        TabLayout tabLayout = rootView.findViewById(R.id.volunteer_tab);
        ViewPager viewPager = rootView.findViewById(R.id.volunteer_viewPager);

        Fragment[] arrFragments = new Fragment[2];
        arrFragments[0] = new VolunteerGachonFragment();
        arrFragments[1] = new VolunteerGyeonggiFragment();

        //MyPagerAdapter adapter = new MyPagerAdapter(getActivity().getSupportFragmentManager());
        // 프래그먼트 안의 프래그먼트라서 getChidFragmentManager를 써야하는 듯...
        MyPagerAdapter adapter = new MyPagerAdapter(getChildFragmentManager(), arrFragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        return rootView;
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        private Fragment[] arrFragments;

        public MyPagerAdapter(FragmentManager fm, Fragment[] arrFragments) {
            super(fm);
            this.arrFragments = arrFragments;
        }

        @Override
        public Fragment getItem(int position) {
            return arrFragments[position];
        }

        @Override
        public int getCount() {
            return arrFragments.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch(position) {
                case 0:
                    return "30분 이내";
                case 1:
                    return  "30분 ~ 1시간";
                default:
                    return "";
            }
        }
    }
}
