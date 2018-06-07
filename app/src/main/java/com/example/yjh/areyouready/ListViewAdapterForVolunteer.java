package com.example.yjh.areyouready;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 이상원 on 2018-05-16.
 */

public class ListViewAdapterForVolunteer extends BaseAdapter {
    // Adapter에 추가한 데이터를 저장하기 위한 ArrayList
    //private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();
    private ArrayList<ListViewItemForVolunteer> listViewItemList;

    // ListViewAdatper의 생성자
    public ListViewAdapterForVolunteer(ArrayList<ListViewItemForVolunteer> itemList) {
        if(itemList == null) {
            listViewItemList = new ArrayList<ListViewItemForVolunteer>();
        }
        else {
            listViewItemList = itemList;
        }
    }

    // Adapter에 사용되는 데이터의 개수를 리턴 : 필수 구현
    public int getCount() {
        return listViewItemList.size();
    }

    // position에 위치한 데이터를 화면에 출력하는 데 사용될 view를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // listview_item layout을 inflate하여 convertView 참조 획득
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.iv_volunteer_item, parent, false);
        }

        // 화면에 표시될 View(layout이 inflate됨)로 부터 위젯에 대한 참조 획득
        ImageView volImageView = convertView.findViewById(R.id.iv_volunteer);
        TextView titleTextView = convertView.findViewById(R.id.tv_volunteer_title);
        TextView contentTextView = convertView.findViewById(R.id.tv_volunteer_content);

        // Data set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        ListViewItemForVolunteer listViewItem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        volImageView.setImageResource(listViewItem.getVolResId());
        titleTextView.setText(listViewItem.getTitle());
        contentTextView.setText(listViewItem.getContent());

        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계 된  아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position;
    }

    // 지정한 위치(position)에 있는 데이터 리턴. : 필수 구현
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    // 아이템 데이터 추가를 위한 함수, 개발자가 원하는대로 작성 가능
    // temp 0: 이미지 인덱스, 1: 봉사 기관 이름, 2: 봉사 내용, 3: 전화번호, 4: 주소, 5: 거리(분), 6: 관련페이지
    public void addItem(int volResId, String title, String content, String phoneNum, String address, int dist, String website) {
        ListViewItemForVolunteer item = new ListViewItemForVolunteer();

        item.setVolResId(volResId);
        item.setTitle(title);
        item.setContent(content);
        item.setPhoneNum(phoneNum);
        item.setAddress(address);
        item.setDist(dist);
        item.setWebsite(website);

        listViewItemList.add(item);
    }
}
