package com.example.yjh.areyouready;

/**
 * Created by 이상원 on 2018-05-16.
 */

public class ListViewItemForVolunteer {
    // temp 0: 이미지 인덱스, 1: 봉사 기관 이름, 2: 봉사 내용, 3: 전화번호, 4: 주소, 5: 거리(분), 6: 관련웹사이트
    private int volResId;
    private String title;
    private String content;
    private String phoneNum;
    private String address;
    private int dist;
    private String website;

    public void setVolResId(int volResId) {
        this.volResId = volResId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    // temp 0: 이미지 인덱스, 1: 봉사 기관 이름, 2: 봉사 내용, 3: 전화번호, 4: 주소, 5: 거리(분), 6: 관련페이지
    public int getVolResId() {
        return volResId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public int getDist() {
        return dist;
    }

    public String getWebsite() {
        return website;
    }
}
