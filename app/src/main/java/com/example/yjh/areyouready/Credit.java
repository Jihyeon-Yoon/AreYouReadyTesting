package com.example.yjh.areyouready;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by YJH on 2018-05-19.
 */

public class Credit extends Fragment {
    private TextView enterYear_textView;
    private String[] items = {"2017", "2016", "2015", "2014", "2013"};

    //spinner
    Spinner spinner;
    ArrayAdapter<String> adapterSpinner;

    //shared preference
    SharedPreferences sh_Pref;
    String enterYearTemp, enterYearFix;
    Context context;

    //spinner default position
    int defaultPosition;

    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.credit, null);

        enterYear_textView = rootView.findViewById(R.id.enterYear_textView);

        //spinner
        spinner = (Spinner)rootView.findViewById(R.id.enterYear_spinner);
        adapterSpinner = new ArrayAdapter<> (
                getActivity(), android.R.layout.simple_spinner_item, items);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterSpinner);

        //get stored enter year
        applySharedPreference();

        //set spinner default
        defaultPosition = (2017 - (Integer.parseInt(enterYearFix)));
        spinner.setSelection(defaultPosition);
        enterYear_textView.setText(enterYearFix);

        //viewPager
        TabLayout tabLayout = rootView.findViewById(R.id.credit_tab);
        viewPager = rootView.findViewById(R.id.credit_viewPager);

        final Fragment[] arrFragments = new Fragment[4];
        arrFragments[0] = new CreditFirstFragment();
        arrFragments[1] = new CreditSecondFragment();
        arrFragments[2] = new CreditThirdFragment();
        arrFragments[3] = new CreditFourthFragment();

        MyPagerAdapter adapter = new MyPagerAdapter(getChildFragmentManager(), arrFragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        // spinner select event
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView adapterView, View view, int position, long id) {
                enterYear_textView.setText(items[position]);
                enterYearTemp = items[position];

                // 뷰페이저 업데이트 및 데이터 코드 추가
                for(int i = 0; i < 4; i++) {
                    Bundle bundle = new Bundle(1);
                    bundle.putString("enterYearTemp", enterYearTemp);
                    arrFragments[i].setArguments(bundle);
                }

                // 뷰페이저 업데이트
                viewPager.getAdapter().notifyDataSetChanged();
            }
            @Override
            public void onNothingSelected(AdapterView adapterView) {
                spinner.setSelection(defaultPosition);
                enterYear_textView.setText(enterYearFix);
            }
        });


        return rootView;
    }

    public void applySharedPreference() {
        context = getActivity();
        sh_Pref = context.getSharedPreferences("STORE DATA", MODE_PRIVATE);
        if(sh_Pref != null) {
            enterYearFix = sh_Pref.getString("enterYearFix", "2017");
        }
    }


    //private class MyPagerAdapter extends FragmentPagerAdapter {
    private class MyPagerAdapter extends FragmentStatePagerAdapter {

        private Fragment[] arrFragments;

        public MyPagerAdapter(FragmentManager fm, Fragment[] arrFragments) {
            super(fm);
            this.arrFragments = arrFragments;
        }

        @Override
        public Fragment getItem(int position) {
            return arrFragments[position];
        }

        // viewPager.getAdapter().notifyDataSetChanged(); 사용 시에 콜백되는 함수.
        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public int getCount() {
            return arrFragments.length;
        }
        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "1학년";
                case 1:
                    return "2학년";
                case 2:
                    return "3학년";
                case 3:
                    return "4학년";
                default:
                    return "";
            }
        }
    }
}
