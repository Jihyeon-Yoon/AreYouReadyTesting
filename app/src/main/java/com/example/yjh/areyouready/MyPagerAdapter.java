package com.example.yjh.areyouready;

import android.support.v4.app.Fragment;

public class MyPagerAdapter  {
    private Fragment[] arrFragments;




    public CharSequence getPageTitle(int position) {
        switch(position) {
            case 0:
                return "봉사";
            case 1:
                return "독후감";
            case 2:
                return "이수학점";
            case 3:
                return "영어";
            default:
                return "";
        }
    }
}