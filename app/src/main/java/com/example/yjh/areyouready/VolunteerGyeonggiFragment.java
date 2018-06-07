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
public class VolunteerGyeonggiFragment extends Fragment {

    Button distSortBtn, nameSortBtn;
    ListView listView;
    ListViewAdapterForVolunteer adapter;

    // 여기서 생성해 놓으면, onCreateView 호출될 때마다 itemList에 누적되어 리스트뷰에 아이템들이 중복 출력되는 문제!!
    //ArrayList<ListViewItem> itemList = new ArrayList<ListViewItem>();
    ArrayList<ListViewItemForVolunteer> itemList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_volunteer_gyeonggi, container, false);

        // 어레이리스트 새로 생성.
        itemList = new ArrayList<ListViewItemForVolunteer>();

        //Adapter 생성
        adapter = new ListViewAdapterForVolunteer(itemList);

        // 리스트뷰 참조 및 adpater 달기
        listView = (ListView) rootView.findViewById(R.id.listview1);
        listView.setAdapter(adapter);

        try {
            InputStream is  = getResources().openRawResource(R.raw.volunteer_in60min);
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String[] temp = new String[7];
            // temp 0: 이미지 인덱스, 1: 봉사 기관 이름, 2: 봉사 내용, 3: 전화번호, 4: 주소, 5: 거리(분), 6: 관련페이지
            while ((br.readLine()) != null) { // 책 사이의 개행(빈 줄 하나) 읽기

                for(int i = 0; i < 7; i++) {
                    temp[i] = br.readLine();
                }

                // v : 가천대로부터 30분 이내, vh : 가천대로부터 1시간 이내
                String volImgName = "vh" + temp[0];
                // BOM 문제 디버깅
               /* for(char c : temp[0].toCharArray()) {
                    //test
                    System.out.printf("0x%04x", (int)c); //test
                }
                System.out.println(); //test*/
                int volResId = getResources().getIdentifier(volImgName, "drawable", "com.example.yjh.areyouready");
                String title = temp[1];
                String content = temp[2];
                String phoneNum = temp[3];
                String address = temp[4];
                int dist = Integer.parseInt(temp[5]);
                String website = temp[6];

                adapter.addItem(volResId, title, content, phoneNum, address, dist, website);
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
                ListViewItemForVolunteer item = (ListViewItemForVolunteer) parent.getItemAtPosition(position);

                // temp 0: 이미지 인덱스, 1: 봉사 기관 이름, 2: 봉사 내용, 3: 전화번호, 4: 주소, 5: 거리(분), 6: 관련페이지
                int volResId = item.getVolResId();
                String title = item.getTitle();
                String content = item.getContent();
                String phoneNum = item.getPhoneNum();
                String address = item.getAddress();
                int dist = item.getDist();
                String website = item.getWebsite();

                //TODO : use item data, use intent, call activity
                Bundle volData = new Bundle();

                volData.putInt("volResId", volResId);
                volData.putString("title", title);
                volData.putString("content", content);
                volData.putString("phoneNum", phoneNum);
                volData.putString("address", address);
                volData.putInt("dist", dist);
                volData.putString("website", website);

                Intent intent = new Intent(getActivity(), InfoVolunteerActivity.class);
                intent.putExtras(volData);
                startActivity(intent);
            }
        });

        // 목록 정렬 버튼 클릭 이벤트 처리
        // 거리으로 정렬하는 버튼, 버튼을 누르면 평점 내림차순으로 정렬한다.
        distSortBtn = rootView.findViewById(R.id.btn_sort_dist);
        distSortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Comparator<ListViewItemForVolunteer> distAsc = new Comparator<ListViewItemForVolunteer>() {
                    @Override
                    public int compare(ListViewItemForVolunteer item1, ListViewItemForVolunteer item2) {
                        int ret;

                        if(item1.getDist() < item2.getDist()) {
                            ret = -1;
                        }
                        else if(item1.getDist() == item2.getDist()) {
                            ret = 0;
                        }
                        else {
                            ret = 1;
                        }

                        return ret;
                    }
                };

                Collections.sort(itemList, distAsc);
                adapter.notifyDataSetChanged();
            }
        });
        // 이름순으로 정렬하는 버튼, 버튼을 누르면 이름순(가나다순))으로 정렬한다.
        nameSortBtn = rootView.findViewById(R.id.btn_sort_name);
        nameSortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Comparator<ListViewItemForVolunteer> nameAsc = new Comparator<ListViewItemForVolunteer>() {
                    @Override
                    public int compare(ListViewItemForVolunteer item1, ListViewItemForVolunteer item2) {
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
