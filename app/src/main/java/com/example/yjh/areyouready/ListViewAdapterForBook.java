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
 * Created by 이상원 on 2018-05-20.
 */

public class ListViewAdapterForBook extends BaseAdapter {
    // Adapter에 추가한 데이터를 저장하기 위한 ArrayList
    //private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();
    private ArrayList<ListViewItemForBook> listViewItemList;

    // ListViewAdatper의 생성자
    public ListViewAdapterForBook(ArrayList<ListViewItemForBook> itemList) {
        if(itemList == null) {
            listViewItemList = new ArrayList<ListViewItemForBook>();
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
            convertView = inflater.inflate(R.layout.lv_book_item, parent, false);
        }

        // 화면에 표시될 View(layout이 inflate됨)로 부터 위젯에 대한 참조 획득
        ImageView bookImageView = convertView.findViewById(R.id.iv_book);
        TextView titleTextView = convertView.findViewById(R.id.tv_title);
        ImageView ratingImageView = convertView.findViewById(R.id.iv_rating);
        TextView libTextView = convertView.findViewById(R.id.tv_mainLibrary);

        // Data set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        ListViewItemForBook listViewItem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        bookImageView.setImageResource(listViewItem.getBookResId());
        titleTextView.setText(listViewItem.getTitle());
        ratingImageView.setImageResource(listViewItem.getRatingResId());

        String lib;
        String location = listViewItem.getLocation();
        if(location.equals("0"))
            lib = "중앙도서관 미보유";
        else
            lib = "중앙도서관 보유";

        libTextView.setText(lib);

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
    // temp 0: 이미지 인덱스, 1: 평점, 2: 제목, 3: 저자, 4: 소개, 5: 중앙도서관 위치, 6: 청구기호
    public void addItem(int bookResId, int ratingResId, int rating, String title, String author, String desc, String location, String bookMark) {
        ListViewItemForBook item = new ListViewItemForBook();

        item.setBookResId(bookResId);
        item.setRatingResId(ratingResId);
        item.setRating(rating);
        item.setTitle(title);
        item.setAuthor(author);
        item.setDesc(desc);
        item.setLocation(location);
        item.setBookMark(bookMark);

        listViewItemList.add(item);
    }
}
