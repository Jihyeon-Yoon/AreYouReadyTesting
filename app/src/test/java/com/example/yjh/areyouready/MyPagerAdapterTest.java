package com.example.yjh.areyouready;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyPagerAdapterTest {



    @Test
    public void getPageTitle() {
       int index=0;
        MyPagerAdapter mp=new MyPagerAdapter();
        assertEquals("봉사", mp.getPageTitle(index));
    }




}

