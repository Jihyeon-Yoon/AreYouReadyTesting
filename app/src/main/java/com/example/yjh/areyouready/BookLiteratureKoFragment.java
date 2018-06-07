package com.example.yjh.areyouready;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookLiteratureKoFragment extends Fragment {

    Button ratingSortBtn, nameSortBtn;
    ListView listView;
    ListViewAdapterForBook adapter;

    // 여기서 생성해 놓으면, onCreateView 호출될 때마다 itemList에 누적되어 리스트뷰에 아이템들이 중복 출력되는 문제!!
    //ArrayList<ListViewItem> itemList = new ArrayList<ListViewItem>();
    ArrayList<ListViewItemForBook> itemList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_book_literature_ko, container, false);

        // 어레이리스트 새로 생성.
        itemList = new ArrayList<ListViewItemForBook>();

        //Adapter 생성
        adapter = new ListViewAdapterForBook(itemList);

        // 리스트뷰 참조 및 adpater 달기
        listView = (ListView) rootView.findViewById(R.id.listview1);
        listView.setAdapter(adapter);

        try {
            InputStream is  = getResources().openRawResource(R.raw.literature_k);
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String[] temp = new String[7];
            // temp 0: 이미지 인덱스, 1: 평점, 2: 제목, 3: 저자, 4: 소개, 5: 중앙도서관 위치, 6: 청구기호
            while ((br.readLine()) != null) { // 책 사이의 개행(빈 줄 하나) 읽기

                for(int i = 0; i < 7; i++) {
                    temp[i] = br.readLine();
                }

                // k : 한국문학, f : 외국문학, h : 인문사회, a : 예술, s : 과학
                String bookImgName = "k" + temp[0];
                // BOM 문제 디버깅
               /* for(char c : temp[0].toCharArray()) {
                    //test
                    System.out.printf("0x%04x", (int)c); //test
                }
                System.out.println(); //test*/
                int bookResId = getResources().getIdentifier(bookImgName, "drawable", "com.example.yjh.areyouready");

                String ratingImgName = "rating" + temp[1];
                int ratingResId = getResources().getIdentifier(ratingImgName, "drawable", "com.example.yjh.areyouready");
                int rating = Integer.parseInt(temp[1]);
                String title = temp[2];
                String author = temp[3];
                String desc = temp[4];
                String location = temp[5];
                String bookMark = temp[6];

                adapter.addItem(bookResId, ratingResId, rating, title, author, desc, location, bookMark);
            }

            br.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

        // 리스트뷰 아이템 클릭시 이벤트 처리
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                //get item
                ListViewItemForBook item = (ListViewItemForBook) parent.getItemAtPosition(position);

                // temp 0: 이미지 인덱스, 1: 평점, 2: 제목, 3: 저자, 4: 소개, 5: 중앙도서관 위치, 6: 청구기호
                int bookResId = item.getBookResId();
                int ratingResId = item.getRatingResId();
                String title = item.getTitle();
                String author = item.getAuthor();
                String desc = item.getDesc();
                String location = item.getLocation();
                String bookMark = item.getBookMark();

                //TODO : use item data, use intent, call activity
                Bundle bookData = new Bundle();
                bookData.putInt("bookResId", bookResId);
                bookData.putInt("ratingResId", ratingResId);
                bookData.putString("title", title);
                bookData.putString("author", author);
                bookData.putString("desc", desc);

                int intLocation = Integer.parseInt(location);
                switch (intLocation) {
                    case 0:
                        location =  "중앙도서관 미보유";
                        bookMark = "";
                        break;
                    case 1:
                        location = "중앙도서관/보존자료실(1층)";
                        bookMark = "청구기호 : " + bookMark;
                        break;
                    case 2:
                        location = "중앙도서관/동양서실(2층)";
                        bookMark = "청구기호 : " + bookMark;
                        break;
                    default:
                        break;
                }
                bookData.putString("location", location);
                bookData.putString("bookMark", bookMark);

                Intent intent = new Intent(getActivity(), InfoBookActivity.class);
                intent.putExtras(bookData);
                startActivity(intent);
            }
        });

        // 목록 정렬 버튼 클릭 이벤트 처리
        // 평점순으로 정렬하는 버튼, 버튼을 누르면 평점 내림차순으로 정렬한다.
        ratingSortBtn = rootView.findViewById(R.id.btn_sort_rating);
        ratingSortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Comparator<ListViewItemForBook> ratingAsc = new Comparator<ListViewItemForBook>() {
                    @Override
                    public int compare(ListViewItemForBook item1, ListViewItemForBook item2) {
                        int ret;

                        if(item1.getRating() < item2.getRating()) {
                            ret = 1;
                        }
                        else if(item1.getRating() == item2.getRating()) {
                            ret = 0;
                        }
                        else {
                            ret = -1;
                        }

                        return ret;
                    }
                };

                Collections.sort(itemList, ratingAsc);
                adapter.notifyDataSetChanged();
            }
        });
        // 이름순으로 정렬하는 버튼, 버튼을 누르면 이름순(가나다순))으로 정렬한다.
        nameSortBtn = rootView.findViewById(R.id.btn_sort_name);
        nameSortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Comparator<ListViewItemForBook> nameAsc = new Comparator<ListViewItemForBook>() {
                    @Override
                    public int compare(ListViewItemForBook item1, ListViewItemForBook item2) {
                        return item1.getTitle().compareTo(item2.getTitle());
                    }
                };

                Collections.sort(itemList, nameAsc);
                adapter.notifyDataSetChanged();
            }
        });

        // 처음 시작 시에는 이름순으로 정렬되어 있도록 한다.
        nameSortBtn.callOnClick();

        return rootView;
    }

}
