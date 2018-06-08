package com.example.yjh.areyouready;

import org.junit.Test;

import static org.junit.Assert.*;

public class CheckTest {

    @Test
    public void onCreateView() {
    }

    @Test
    public void getTotalCredit() throws Exception {
        Check testCheck = new Check();
        testCheck.enterYearFix = "2016";
        testCheck.getTotalCredit();
        assertEquals(121, testCheck.totalCredit );
    }

    @Test
    public void storeTotalCredit() {
    }

    @Test
    public void getCurrentCredit() {
    }

    @Test
    public void storeCurrentCredit() {
    }

    @Test
    public void showStoredData() {
    }

    @Test
    public void sharedPreferences() {
    }

    @Test
    public void applySharedPreference() {
    }

    @Test
    public void get2017SharedPreference() {
    }

    @Test
    public void get2016SharedPreference() {
    }

    @Test
    public void get2015SharedPreference() {
    }

    @Test
    public void get2014SharedPreference() {
    }

    @Test
    public void get2013SharedPreference() {
    }
}