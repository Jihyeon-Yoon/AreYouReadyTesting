package com.example.yjh.areyouready;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class CreditThirdFragment extends Fragment {

    TableLayout table2017;
    TableLayout table2016;
    TableLayout table2015;
    TableLayout table2014;
    TableLayout table2013;

    CheckBox chk2017_1;
    CheckBox chk2017_2;
    CheckBox chk2017_3;
    CheckBox chk2017_4;
    CheckBox chk2017_5;
    CheckBox chk2017_6;
    CheckBox chk2017_7;
    CheckBox chk2017_8;
    CheckBox chk2017_9;
    CheckBox chk2017_10;
    CheckBox chk2017_11;
    CheckBox chk2017_12;
    CheckBox chk2017_13;

    CheckBox chk2016_1;
    CheckBox chk2016_2;
    CheckBox chk2016_3;
    CheckBox chk2016_4;
    CheckBox chk2016_5;
    CheckBox chk2016_6;
    CheckBox chk2016_7;
    CheckBox chk2016_8;
    CheckBox chk2016_9;
    CheckBox chk2016_10;
    CheckBox chk2016_11;
    CheckBox chk2016_12;
    CheckBox chk2016_13;
    CheckBox chk2016_14;

    CheckBox chk2015_1;
    CheckBox chk2015_2;
    CheckBox chk2015_3;
    CheckBox chk2015_4;
    CheckBox chk2015_5;
    CheckBox chk2015_6;
    CheckBox chk2015_7;
    CheckBox chk2015_8;
    CheckBox chk2015_9;
    CheckBox chk2015_10;
    CheckBox chk2015_11;
    CheckBox chk2015_12;
    CheckBox chk2015_13;
    CheckBox chk2015_14;

    CheckBox chk2014_1;
    CheckBox chk2014_2;
    CheckBox chk2014_3;
    CheckBox chk2014_4;
    CheckBox chk2014_5;
    CheckBox chk2014_6;
    CheckBox chk2014_7;
    CheckBox chk2014_8;
    CheckBox chk2014_9;
    CheckBox chk2014_10;
    CheckBox chk2014_11;
    CheckBox chk2014_12;
    CheckBox chk2014_13;
    CheckBox chk2014_14;
    CheckBox chk2014_15;
    CheckBox chk2014_16;

    CheckBox chk2013_1;
    CheckBox chk2013_2;
    CheckBox chk2013_3;
    CheckBox chk2013_4;
    CheckBox chk2013_5;
    CheckBox chk2013_6;
    CheckBox chk2013_7;
    CheckBox chk2013_8;
    CheckBox chk2013_9;
    CheckBox chk2013_10;
    CheckBox chk2013_11;
    CheckBox chk2013_12;
    CheckBox chk2013_13;
    CheckBox chk2013_14;
    CheckBox chk2013_15;

    Button button2017;
    Button button2016;
    Button button2015;
    Button button2014;
    Button button2013;

    String file2017_1 = "file2017_1.txt";
    String file2017_2 = "file2017_2.txt";
    String file2017_3 = "file2017_3.txt";
    String file2017_4 = "file2017_4.txt";
    String file2016_1 = "file2016_1.txt";
    String file2016_2 = "file2016_2.txt";
    String file2016_3 = "file2016_3.txt";
    String file2016_4 = "file2016_4.txt";
    String file2015_1 = "file2015_1.txt";
    String file2015_2 = "file2015_2.txt";
    String file2015_3 = "file2015_3.txt";
    String file2015_4 = "file2015_4.txt";
    String file2014_1 = "file2014_1.txt";
    String file2014_2 = "file2014_2.txt";
    String file2014_3 = "file2014_3.txt";
    String file2014_4 = "file2014_4.txt";
    String file2013_1 = "file2013_1.txt";
    String file2013_2 = "file2013_2.txt";
    String file2013_3 = "file2013_3.txt";
    String file2013_4 = "file2013_4.txt";

    //shared preference
    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;
    String enterYear;
    Context context;

    // 연도 - 해당 테이블 매핑(mapping)
    HashMap<Integer, TableLayout> tb_year;

    // 과목순서 - 체크박스 매핑
    HashMap<Integer, CheckBox> defaultChk2017_3;
    HashMap<Integer, CheckBox> defaultChk2016_3;
    HashMap<Integer, CheckBox> defaultChk2015_3;
    HashMap<Integer, CheckBox> defaultChk2014_3;
    HashMap<Integer, CheckBox> defaultChk2013_3;

    public CreditThirdFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        switch(enterYear) {
            case "2017":
                showDefault2017_3();
                break;
            case "2016":
                showDefault2016_3();
                break;
            case "2015":
                showDefault2015_3();
                break;
            case "2014":
                showDefault2014_3();
                break;
            case "2013":
                showDefault2013_3();
                break;
            default:
                break;
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_credit_third, container, false);

        table2017 = rootView.findViewById(R.id.tableLayout2017);
        table2016 = rootView.findViewById(R.id.tableLayout2016);
        table2015 = rootView.findViewById(R.id.tableLayout2015);
        table2014 = rootView.findViewById(R.id.tableLayout2014);
        table2013 = rootView.findViewById(R.id.tableLayout2013);

        chk2017_1 = rootView.findViewById(R.id.chk2017_1);
        chk2017_2= rootView.findViewById(R.id.chk2017_2);
        chk2017_3= rootView.findViewById(R.id.chk2017_3);
        chk2017_4= rootView.findViewById(R.id.chk2017_4);
        chk2017_5= rootView.findViewById(R.id.chk2017_5);
        chk2017_6= rootView.findViewById(R.id.chk2017_6);
        chk2017_7= rootView.findViewById(R.id.chk2017_7);
        chk2017_8= rootView.findViewById(R.id.chk2017_8);
        chk2017_9= rootView.findViewById(R.id.chk2017_9);
        chk2017_10= rootView.findViewById(R.id.chk2017_10);
        chk2017_11= rootView.findViewById(R.id.chk2017_11);
        chk2017_12= rootView.findViewById(R.id.chk2017_12);
        chk2017_13= rootView.findViewById(R.id.chk2017_13);

        chk2016_1 = rootView.findViewById(R.id.chk2016_1);
        chk2016_2= rootView.findViewById(R.id.chk2016_2);
        chk2016_3= rootView.findViewById(R.id.chk2016_3);
        chk2016_4= rootView.findViewById(R.id.chk2016_4);
        chk2016_5= rootView.findViewById(R.id.chk2016_5);
        chk2016_6= rootView.findViewById(R.id.chk2016_6);
        chk2016_7= rootView.findViewById(R.id.chk2016_7);
        chk2016_8= rootView.findViewById(R.id.chk2016_8);
        chk2016_9= rootView.findViewById(R.id.chk2016_9);
        chk2016_10= rootView.findViewById(R.id.chk2016_10);
        chk2016_11= rootView.findViewById(R.id.chk2016_11);
        chk2016_12= rootView.findViewById(R.id.chk2016_12);
        chk2016_13= rootView.findViewById(R.id.chk2016_13);
        chk2016_14= rootView.findViewById(R.id.chk2016_14);

        chk2015_1 = rootView.findViewById(R.id.chk2015_1);
        chk2015_2= rootView.findViewById(R.id.chk2015_2);
        chk2015_3= rootView.findViewById(R.id.chk2015_3);
        chk2015_4= rootView.findViewById(R.id.chk2015_4);
        chk2015_5= rootView.findViewById(R.id.chk2015_5);
        chk2015_6= rootView.findViewById(R.id.chk2015_6);
        chk2015_7= rootView.findViewById(R.id.chk2015_7);
        chk2015_8= rootView.findViewById(R.id.chk2015_8);
        chk2015_9= rootView.findViewById(R.id.chk2015_9);
        chk2015_10= rootView.findViewById(R.id.chk2015_10);
        chk2015_11= rootView.findViewById(R.id.chk2015_11);
        chk2015_12= rootView.findViewById(R.id.chk2015_12);
        chk2015_13= rootView.findViewById(R.id.chk2015_13);
        chk2015_14= rootView.findViewById(R.id.chk2015_14);

        chk2014_1 = rootView.findViewById(R.id.chk2014_1);
        chk2014_2= rootView.findViewById(R.id.chk2014_2);
        chk2014_3= rootView.findViewById(R.id.chk2014_3);
        chk2014_4= rootView.findViewById(R.id.chk2014_4);
        chk2014_5= rootView.findViewById(R.id.chk2014_5);
        chk2014_6= rootView.findViewById(R.id.chk2014_6);
        chk2014_7= rootView.findViewById(R.id.chk2014_7);
        chk2014_8= rootView.findViewById(R.id.chk2014_8);
        chk2014_9= rootView.findViewById(R.id.chk2014_9);
        chk2014_10= rootView.findViewById(R.id.chk2014_10);
        chk2014_11= rootView.findViewById(R.id.chk2014_11);
        chk2014_12= rootView.findViewById(R.id.chk2014_12);
        chk2014_13= rootView.findViewById(R.id.chk2014_13);
        chk2014_14= rootView.findViewById(R.id.chk2014_14);
        chk2014_15= rootView.findViewById(R.id.chk2014_15);
        chk2014_16= rootView.findViewById(R.id.chk2014_16);

        chk2013_1 = rootView.findViewById(R.id.chk2013_1);
        chk2013_2= rootView.findViewById(R.id.chk2013_2);
        chk2013_3= rootView.findViewById(R.id.chk2013_3);
        chk2013_4= rootView.findViewById(R.id.chk2013_4);
        chk2013_5= rootView.findViewById(R.id.chk2013_5);
        chk2013_6= rootView.findViewById(R.id.chk2013_6);
        chk2013_7= rootView.findViewById(R.id.chk2013_7);
        chk2013_8= rootView.findViewById(R.id.chk2013_8);
        chk2013_9= rootView.findViewById(R.id.chk2013_9);
        chk2013_10= rootView.findViewById(R.id.chk2013_10);
        chk2013_11= rootView.findViewById(R.id.chk2013_11);
        chk2013_12= rootView.findViewById(R.id.chk2013_12);
        chk2013_13= rootView.findViewById(R.id.chk2013_13);
        chk2013_14= rootView.findViewById(R.id.chk2013_14);
        chk2013_15= rootView.findViewById(R.id.chk2013_15);

        button2017= rootView.findViewById(R.id.button2017);
        button2016= rootView.findViewById(R.id.button2016);
        button2015= rootView.findViewById(R.id.button2015);
        button2014= rootView.findViewById(R.id.button2014);
        button2013= rootView.findViewById(R.id.button2013);

        // <연도 - 테이블> 해시맵을 생성하고 연도와 그에 해당하는 테이블을 매핑한다.
        tb_year = new HashMap<Integer, TableLayout>();
        tb_year.put(2013, table2013);
        tb_year.put(2014, table2014);
        tb_year.put(2015, table2015);
        tb_year.put(2016, table2016);
        tb_year.put(2017, table2017);

        enterYear = "2017"; // default year - 2017, (별 이유없이 그냥 2017로 설정함...)

        // sharedPreference에 저장된 enterYear값이 있다면 가져온다.
        context = getActivity();
        sh_Pref = context.getSharedPreferences("STORE DATA", MODE_PRIVATE);
        if(sh_Pref != null) {
            enterYear = sh_Pref.getString("enterYearFix", "2017");
        }

        // getArguments()를 이용해 Credit fragment에서 전달된 연도값을 받는다.(spinner에서 연도를 선택한 경우)
        if(getArguments() != null) {
            enterYear = getArguments().getString("enterYearTemp");
        }

        // 2013 ~ 2017중 Credit fragment에서 전달된 값에 해당하는 테이블만 VISIBLE로 바꾸고, 나머지 테이블은 GONE으로 바꾼다.
        for(int i = 2013; i <= 2017; i++) {
            TableLayout tl = tb_year.get(i); // i값에 매핑된 테이블을 참조한다.
            if(i == Integer.parseInt(enterYear)) { // 전달된 값에 해당하는 경우
                tl.setVisibility(View.VISIBLE);
            }
            else { // 전달된 값이 아닌 경우
                tl.setVisibility(View.GONE);
            }
        }

        /*switch(enterYear) {
            case "2017":
                showDefault2017_3();
                break;
            case "2016":
                showDefault2016_3();
                break;
            case "2015":
                showDefault2015_3();
                break;
            case "2014":
                showDefault2014_3();
                break;
            case "2013":
                showDefault2013_3();
                break;
            default:
                break;
        }*/

        //파일 저장, 완료 변경, 총이수 저장, 입학년도 저장, 토스트메시지 / 다른 학번 전부 0으로 reset
        button2017.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    int sum=0;
                    OutputStreamWriter out = new OutputStreamWriter(getActivity().openFileOutput(file2017_3, 0));
                    if(chk2017_1.isChecked()) {
                        chk2017_1.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2017_1.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2017_2.isChecked()) {
                        chk2017_2.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2017_2.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2017_3.isChecked()) {
                        chk2017_3.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2017_3.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2017_4.isChecked()) {
                        chk2017_4.setText("완료");
                        out.write("2\n");
                        sum += 2;
                    } else {
                        chk2017_4.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2017_5.isChecked()) {
                        chk2017_5.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2017_5.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2017_6.isChecked()) {
                        chk2017_6.setText("완료");
                        out.write("1\n");
                        sum += 1;
                    } else {
                        chk2017_6.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2017_7.isChecked()) {
                        chk2017_7.setText("완료");
                        out.write("2\n");
                        sum += 2;
                    } else {
                        chk2017_7.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2017_8.isChecked()) {
                        chk2017_8.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2017_8.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2017_9.isChecked()) {
                        chk2017_9.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2017_9.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2017_10.isChecked()) {
                        chk2017_10.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2017_10.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2017_11.isChecked()) {
                        chk2017_11.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2017_11.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2017_12.isChecked()) {
                        chk2017_12.setText("완료");
                        out.write("1\n");
                        sum += 1;
                    } else {
                        chk2017_12.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2017_13.isChecked()) {
                        chk2017_13.setText("완료");
                        out.write("1\n");
                        sum += 1;
                    } else {
                        chk2017_13.setText("미완");
                        out.write("0\n");
                    }
                    out.close();
                    //2017_3 이수학점 총합 저장
                    sharedPreferencesCreditSum("sum2017_3", sum);
                    sharedPreferences();
                    //다른 학번 파일 전부 0으로 reset
                    reset2016Credit();
                    reset2015Credit();
                    reset2014Credit();
                    reset2013Credit();

                    //다른 학번의 이수 학점 총합을 0으로 reset
                    sharedPreferencesCreditSum("sum2016_1", 0);
                    sharedPreferencesCreditSum("sum2016_2", 0);
                    sharedPreferencesCreditSum("sum2016_3", 0);
                    sharedPreferencesCreditSum("sum2016_4", 0);

                    sharedPreferencesCreditSum("sum2015_1", 0);
                    sharedPreferencesCreditSum("sum2015_2", 0);
                    sharedPreferencesCreditSum("sum2015_3", 0);
                    sharedPreferencesCreditSum("sum2015_4", 0);

                    sharedPreferencesCreditSum("sum2014_1", 0);
                    sharedPreferencesCreditSum("sum2014_2", 0);
                    sharedPreferencesCreditSum("sum2014_3", 0);
                    sharedPreferencesCreditSum("sum2014_4", 0);

                    sharedPreferencesCreditSum("sum2013_1", 0);
                    sharedPreferencesCreditSum("sum2013_2", 0);
                    sharedPreferencesCreditSum("sum2013_3", 0);
                    sharedPreferencesCreditSum("sum2013_4", 0);

                    Toast.makeText(getActivity(), "업데이트 되었습니다", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //파일 저장, 완료 변경, 총이수 저장, 입학년도 저장, 토스트메시지 / 다른 학번 전부 0으로 reset
        button2016.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    int sum=0;
                    OutputStreamWriter out = new OutputStreamWriter(getActivity().openFileOutput(file2016_3, 0));
                    if(chk2016_1.isChecked()) {
                        chk2016_1.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2016_1.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2016_2.isChecked()) {
                        chk2016_2.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2016_2.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2016_3.isChecked()) {
                        chk2016_3.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2016_3.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2016_4.isChecked()) {
                        chk2016_4.setText("완료");
                        out.write("2\n");
                        sum += 2;
                    } else {
                        chk2016_4.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2016_5.isChecked()) {
                        chk2016_5.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2016_5.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2016_6.isChecked()) {
                        chk2016_6.setText("완료");
                        out.write("1\n");
                        sum += 1;
                    } else {
                        chk2016_6.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2016_7.isChecked()) {
                        chk2016_7.setText("완료");
                        out.write("2\n");
                        sum += 2;
                    } else {
                        chk2016_7.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2016_8.isChecked()) {
                        chk2016_8.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2016_8.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2016_9.isChecked()) {
                        chk2016_9.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2016_9.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2016_10.isChecked()) {
                        chk2016_10.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2016_10.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2016_11.isChecked()) {
                        chk2016_11.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2016_11.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2016_12.isChecked()) {
                        chk2016_12.setText("완료");
                        out.write("1\n");
                        sum += 1;
                    } else {
                        chk2016_12.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2016_13.isChecked()) {
                        chk2016_13.setText("완료");
                        out.write("1\n");
                        sum += 1;
                    } else {
                        chk2016_13.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2016_14.isChecked()) {
                        chk2016_14.setText("완료");
                        out.write("2\n");
                        sum += 2;
                    } else {
                        chk2016_14.setText("미완");
                        out.write("0\n");
                    }
                    out.close();
                    //2016_3 이수학점 총합 저장
                    sharedPreferencesCreditSum("sum2016_3", sum);
                    sharedPreferences();
                    //다른 학번 파일 전부 0으로 reset
                    reset2017Credit();
                    reset2015Credit();
                    reset2014Credit();
                    reset2013Credit();

                    //다른 학번의 이수 학점 총합을 0으로 reset
                    sharedPreferencesCreditSum("sum2017_1", 0);
                    sharedPreferencesCreditSum("sum2017_2", 0);
                    sharedPreferencesCreditSum("sum2017_3", 0);
                    sharedPreferencesCreditSum("sum2017_4", 0);

                    sharedPreferencesCreditSum("sum2015_1", 0);
                    sharedPreferencesCreditSum("sum2015_2", 0);
                    sharedPreferencesCreditSum("sum2015_3", 0);
                    sharedPreferencesCreditSum("sum2015_4", 0);

                    sharedPreferencesCreditSum("sum2014_1", 0);
                    sharedPreferencesCreditSum("sum2014_2", 0);
                    sharedPreferencesCreditSum("sum2014_3", 0);
                    sharedPreferencesCreditSum("sum2014_4", 0);

                    sharedPreferencesCreditSum("sum2013_1", 0);
                    sharedPreferencesCreditSum("sum2013_2", 0);
                    sharedPreferencesCreditSum("sum2013_3", 0);
                    sharedPreferencesCreditSum("sum2013_4", 0);

                    Toast.makeText(getActivity(), "업데이트 되었습니다", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //파일 저장, 완료 변경, 총이수 저장, 입학년도 저장, 토스트메시지 / 다른 학번 전부 0으로 reset
        button2015.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    int sum=0;
                    OutputStreamWriter out = new OutputStreamWriter(getActivity().openFileOutput(file2015_3, 0));
                    if(chk2015_1.isChecked()) {
                        chk2015_1.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2015_1.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2015_2.isChecked()) {
                        chk2015_2.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2015_2.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2015_3.isChecked()) {
                        chk2015_3.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2015_3.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2015_4.isChecked()) {
                        chk2015_4.setText("완료");
                        out.write("2\n");
                        sum += 2;
                    } else {
                        chk2015_4.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2015_5.isChecked()) {
                        chk2015_5.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2015_5.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2015_6.isChecked()) {
                        chk2015_6.setText("완료");
                        out.write("1\n");
                        sum += 1;
                    } else {
                        chk2015_6.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2015_7.isChecked()) {
                        chk2015_7.setText("완료");
                        out.write("2\n");
                        sum += 2;
                    } else {
                        chk2015_7.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2015_8.isChecked()) {
                        chk2015_8.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2015_8.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2015_9.isChecked()) {
                        chk2015_9.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2015_9.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2015_10.isChecked()) {
                        chk2015_10.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2015_10.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2015_11.isChecked()) {
                        chk2015_11.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2015_11.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2015_12.isChecked()) {
                        chk2015_12.setText("완료");
                        out.write("1\n");
                        sum += 1;
                    } else {
                        chk2015_12.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2015_13.isChecked()) {
                        chk2015_13.setText("완료");
                        out.write("1\n");
                        sum += 1;
                    } else {
                        chk2015_13.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2015_14.isChecked()) {
                        chk2015_14.setText("완료");
                        out.write("2\n");
                        sum += 2;
                    } else {
                        chk2015_14.setText("미완");
                        out.write("0\n");
                    }
                    out.close();
                    //2015_3 이수학점 총합 저장
                    sharedPreferencesCreditSum("sum2015_3", sum);
                    sharedPreferences();
                    //다른 학번 파일 전부 0으로 reset
                    reset2017Credit();
                    reset2016Credit();
                    reset2014Credit();
                    reset2013Credit();

                    //다른 학번의 이수 학점 총합을 0으로 reset
                    sharedPreferencesCreditSum("sum2017_1", 0);
                    sharedPreferencesCreditSum("sum2017_2", 0);
                    sharedPreferencesCreditSum("sum2017_3", 0);
                    sharedPreferencesCreditSum("sum2017_4", 0);

                    sharedPreferencesCreditSum("sum2016_1", 0);
                    sharedPreferencesCreditSum("sum2016_2", 0);
                    sharedPreferencesCreditSum("sum2016_3", 0);
                    sharedPreferencesCreditSum("sum2016_4", 0);

                    sharedPreferencesCreditSum("sum2014_1", 0);
                    sharedPreferencesCreditSum("sum2014_2", 0);
                    sharedPreferencesCreditSum("sum2014_3", 0);
                    sharedPreferencesCreditSum("sum2014_4", 0);

                    sharedPreferencesCreditSum("sum2013_1", 0);
                    sharedPreferencesCreditSum("sum2013_2", 0);
                    sharedPreferencesCreditSum("sum2013_3", 0);
                    sharedPreferencesCreditSum("sum2013_4", 0);

                    Toast.makeText(getActivity(), "업데이트 되었습니다", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //파일 저장, 완료 변경, 총이수 저장, 입학년도 저장, 토스트메시지 / 다른 학번 전부 0으로 reset
        button2014.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    int sum=0;
                    OutputStreamWriter out = new OutputStreamWriter(getActivity().openFileOutput(file2014_3, 0));
                    if(chk2014_1.isChecked()) {
                        chk2014_1.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2014_1.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2014_2.isChecked()) {
                        chk2014_2.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2014_2.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2014_3.isChecked()) {
                        chk2014_3.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2014_3.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2014_4.isChecked()) {
                        chk2014_4.setText("완료");
                        out.write("2\n");
                        sum += 2;
                    } else {
                        chk2014_4.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2014_5.isChecked()) {
                        chk2014_5.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2014_5.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2014_6.isChecked()) {
                        chk2014_6.setText("완료");
                        out.write("1\n");
                        sum += 1;
                    } else {
                        chk2014_6.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2014_7.isChecked()) {
                        chk2014_7.setText("완료");
                        out.write("1\n");
                        sum += 1;
                    } else {
                        chk2014_7.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2014_8.isChecked()) {
                        chk2014_8.setText("완료");
                        out.write("2\n");
                        sum += 2;
                    } else {
                        chk2014_8.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2014_9.isChecked()) {
                        chk2014_9.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2014_9.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2014_10.isChecked()) {
                        chk2014_10.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2014_10.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2014_11.isChecked()) {
                        chk2014_11.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2014_11.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2014_12.isChecked()) {
                        chk2014_12.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2014_12.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2014_13.isChecked()) {
                        chk2014_13.setText("완료");
                        out.write("1\n");
                        sum += 1;
                    } else {
                        chk2014_13.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2014_14.isChecked()) {
                        chk2014_14.setText("완료");
                        out.write("1\n");
                        sum += 1;
                    } else {
                        chk2014_14.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2014_15.isChecked()) {
                        chk2014_15.setText("완료");
                        out.write("1\n");
                        sum += 1;
                    } else {
                        chk2014_15.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2014_16.isChecked()) {
                        chk2014_16.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2014_16.setText("미완");
                        out.write("0\n");
                    }
                    out.close();
                    //2014_3 이수학점 총합 저장
                    sharedPreferencesCreditSum("sum2014_3", sum);
                    sharedPreferences();
                    //다른 학번 파일 전부 0으로 reset
                    reset2017Credit();
                    reset2016Credit();
                    reset2015Credit();
                    reset2013Credit();

                    //다른 학번의 이수 학점 총합을 0으로 reset
                    sharedPreferencesCreditSum("sum2017_1", 0);
                    sharedPreferencesCreditSum("sum2017_2", 0);
                    sharedPreferencesCreditSum("sum2017_3", 0);
                    sharedPreferencesCreditSum("sum2017_4", 0);

                    sharedPreferencesCreditSum("sum2016_1", 0);
                    sharedPreferencesCreditSum("sum2016_2", 0);
                    sharedPreferencesCreditSum("sum2016_3", 0);
                    sharedPreferencesCreditSum("sum2016_4", 0);

                    sharedPreferencesCreditSum("sum2015_1", 0);
                    sharedPreferencesCreditSum("sum2015_2", 0);
                    sharedPreferencesCreditSum("sum2015_3", 0);
                    sharedPreferencesCreditSum("sum2015_4", 0);

                    sharedPreferencesCreditSum("sum2013_1", 0);
                    sharedPreferencesCreditSum("sum2013_2", 0);
                    sharedPreferencesCreditSum("sum2013_3", 0);
                    sharedPreferencesCreditSum("sum2013_4", 0);

                    Toast.makeText(getActivity(), "업데이트 되었습니다", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //파일 저장, 완료 변경, 총이수 저장, 입학년도 저장, 토스트메시지 / 다른 학번 전부 0으로 reset
        button2013.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    int sum=0;
                    OutputStreamWriter out = new OutputStreamWriter(getActivity().openFileOutput(file2013_3, 0));
                    if(chk2013_1.isChecked()) {
                        chk2013_1.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2013_1.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2013_2.isChecked()) {
                        chk2013_2.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2013_2.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2013_3.isChecked()) {
                        chk2013_3.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2013_3.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2013_4.isChecked()) {
                        chk2013_4.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2013_4.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2013_5.isChecked()) {
                        chk2013_5.setText("완료");
                        out.write("1\n");
                        sum += 1;
                    } else {
                        chk2013_5.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2013_6.isChecked()) {
                        chk2013_6.setText("완료");
                        out.write("1\n");
                        sum += 1;
                    } else {
                        chk2013_6.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2013_7.isChecked()) {
                        chk2013_7.setText("완료");
                        out.write("2\n");
                        sum += 2;
                    } else {
                        chk2013_7.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2013_8.isChecked()) {
                        chk2013_8.setText("완료");
                        out.write("2\n");
                        sum += 2;
                    } else {
                        chk2013_8.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2013_9.isChecked()) {
                        chk2013_9.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2013_9.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2013_10.isChecked()) {
                        chk2013_10.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2013_10.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2013_11.isChecked()) {
                        chk2013_11.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2013_11.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2013_12.isChecked()) {
                        chk2013_12.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2013_12.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2013_13.isChecked()) {
                        chk2013_13.setText("완료");
                        out.write("1\n");
                        sum += 1;
                    } else {
                        chk2013_13.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2013_14.isChecked()) {
                        chk2013_14.setText("완료");
                        out.write("2\n");
                        sum += 2;
                    } else {
                        chk2013_14.setText("미완");
                        out.write("0\n");
                    }
                    if(chk2013_15.isChecked()) {
                        chk2013_15.setText("완료");
                        out.write("3\n");
                        sum += 3;
                    } else {
                        chk2013_15.setText("미완");
                        out.write("0\n");
                    }
                    out.close();
                    //2013_3 이수학점 총합 저장
                    sharedPreferencesCreditSum("sum2013_3", sum);
                    sharedPreferences();
                    //다른 학번 파일 전부 0으로 reset
                    reset2017Credit();
                    reset2016Credit();
                    reset2015Credit();
                    reset2014Credit();

                    //다른 학번의 이수 학점 총합을 0으로 reset
                    sharedPreferencesCreditSum("sum2017_1", 0);
                    sharedPreferencesCreditSum("sum2017_2", 0);
                    sharedPreferencesCreditSum("sum2017_3", 0);
                    sharedPreferencesCreditSum("sum2017_4", 0);

                    sharedPreferencesCreditSum("sum2016_1", 0);
                    sharedPreferencesCreditSum("sum2016_2", 0);
                    sharedPreferencesCreditSum("sum2016_3", 0);
                    sharedPreferencesCreditSum("sum2016_4", 0);

                    sharedPreferencesCreditSum("sum2015_1", 0);
                    sharedPreferencesCreditSum("sum2015_2", 0);
                    sharedPreferencesCreditSum("sum2015_3", 0);
                    sharedPreferencesCreditSum("sum2015_4", 0);

                    sharedPreferencesCreditSum("sum2014_1", 0);
                    sharedPreferencesCreditSum("sum2014_2", 0);
                    sharedPreferencesCreditSum("sum2014_3", 0);
                    sharedPreferencesCreditSum("sum2014_4", 0);

                    Toast.makeText(getActivity(), "업데이트 되었습니다", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        return rootView;
    }

    //2017 파일 모두 0으로 reset
    public void reset2017Credit() {
        try {
            int i;
            //1학년 파일
            OutputStreamWriter out = new OutputStreamWriter(getActivity().openFileOutput(file2017_1, 0));
            for(i=0; i<17; i++) {
                out.write("0\n");
            }
            out.close();
            //2학년 파일
            out = new OutputStreamWriter(getActivity().openFileOutput(file2017_2, 0));
            for(i=0; i<14; i++) {
                out.write("0\n");
            }
            out.close();
            //3학년 파일
            out = new OutputStreamWriter(getActivity().openFileOutput(file2017_3, 0));
            for(i=0; i<13; i++) {
                out.write("0\n");
            }
            out.close();
            //4학년 파일
            out = new OutputStreamWriter(getActivity().openFileOutput(file2017_4, 0));
            for(i=0; i<9; i++) {
                out.write("0\n");
            }
            out.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    //2016 파일 모두 0으로 reset
    public void reset2016Credit() {
        try {
            int i;
            //1학년 파일
            OutputStreamWriter out = new OutputStreamWriter(getActivity().openFileOutput(file2016_1, 0));
            for(i=0; i<14; i++) {
                out.write("0\n");
            }
            out.close();
            //2학년 파일
            out = new OutputStreamWriter(getActivity().openFileOutput(file2016_2, 0));
            for(i=0; i<15; i++) {
                out.write("0\n");
            }
            out.close();
            //3학년 파일
            out = new OutputStreamWriter(getActivity().openFileOutput(file2016_3, 0));
            for(i=0; i<14; i++) {
                out.write("0\n");
            }
            out.close();
            //4학년 파일
            out = new OutputStreamWriter(getActivity().openFileOutput(file2016_4, 0));
            for(i=0; i<9; i++) {
                out.write("0\n");
            }
            out.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    //2015 파일 모두 0으로 reset
    public void reset2015Credit() {
        try {
            int i;
            //1학년 파일
            OutputStreamWriter out = new OutputStreamWriter(getActivity().openFileOutput(file2015_1, 0));
            for(i=0; i<13; i++) {
                out.write("0\n");
            }
            out.close();
            //2학년 파일
            out = new OutputStreamWriter(getActivity().openFileOutput(file2015_2, 0));
            for(i=0; i<14; i++) {
                out.write("0\n");
            }
            out.close();
            //3학년 파일
            out = new OutputStreamWriter(getActivity().openFileOutput(file2015_3, 0));
            for(i=0; i<14; i++) {
                out.write("0\n");
            }
            out.close();
            //4학년 파일
            out = new OutputStreamWriter(getActivity().openFileOutput(file2015_4, 0));
            for(i=0; i<9; i++) {
                out.write("0\n");
            }
            out.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    //2014 파일 모두 0으로 reset
    public void reset2014Credit() {
        try {
            int i;
            //1학년 파일
            OutputStreamWriter out = new OutputStreamWriter(getActivity().openFileOutput(file2014_1, 0));
            for(i=0; i<13; i++) {
                out.write("0\n");
            }
            out.close();
            //2학년 파일
            out = new OutputStreamWriter(getActivity().openFileOutput(file2014_2, 0));
            for(i=0; i<12; i++) {
                out.write("0\n");
            }
            out.close();
            //3학년 파일
            out = new OutputStreamWriter(getActivity().openFileOutput(file2014_3, 0));
            for(i=0; i<16; i++) {
                out.write("0\n");
            }
            out.close();
            //4학년 파일
            out = new OutputStreamWriter(getActivity().openFileOutput(file2014_4, 0));
            for(i=0; i<9; i++) {
                out.write("0\n");
            }
            out.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    //2013 파일 모두 0으로 reset
    public void reset2013Credit() {
        try {
            int i;
            //1학년 파일
            OutputStreamWriter out = new OutputStreamWriter(getActivity().openFileOutput(file2013_1, 0));
            for(i=0; i<13; i++) {
                out.write("0\n");
            }
            out.close();
            //2학년 파일
            out = new OutputStreamWriter(getActivity().openFileOutput(file2013_2, 0));
            for(i=0; i<13; i++) {
                out.write("0\n");
            }
            out.close();
            //3학년 파일
            out = new OutputStreamWriter(getActivity().openFileOutput(file2013_3, 0));
            for(i=0; i<15; i++) {
                out.write("0\n");
            }
            out.close();
            //4학년 파일
            out = new OutputStreamWriter(getActivity().openFileOutput(file2013_4, 0));
            for(i=0; i<8; i++) {
                out.write("0\n");
            }
            out.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void sharedPreferences() {
        context = getActivity();
        sh_Pref = context.getSharedPreferences("STORE DATA", MODE_PRIVATE);
        toEdit = sh_Pref.edit();
        toEdit.putString("enterYearFix", enterYear);
        toEdit.commit();
    }

    public void sharedPreferencesCreditSum(String year, int sum) {
        context = getActivity();
        sh_Pref = context.getSharedPreferences("STORE DATA", MODE_PRIVATE);
        toEdit = sh_Pref.edit();
        toEdit.putInt(year, sum);
        toEdit.commit();
    }

    private void showDefault2017_3() {
        int i=0;
        CheckBox chkTemp;

        //<과목순서 - 체크박스> 해시맵 생성 & 매핑
        defaultChk2017_3 = new HashMap<Integer, CheckBox>();
        defaultChk2017_3.put(1, chk2017_1);
        defaultChk2017_3.put(2, chk2017_2);
        defaultChk2017_3.put(3, chk2017_3);
        defaultChk2017_3.put(4, chk2017_4);
        defaultChk2017_3.put(5, chk2017_5);
        defaultChk2017_3.put(6, chk2017_6);
        defaultChk2017_3.put(7, chk2017_7);
        defaultChk2017_3.put(8, chk2017_8);
        defaultChk2017_3.put(9, chk2017_9);
        defaultChk2017_3.put(10, chk2017_10);
        defaultChk2017_3.put(11, chk2017_11);
        defaultChk2017_3.put(12, chk2017_12);
        defaultChk2017_3.put(13, chk2017_13);

        try {
            InputStream in = getActivity().openFileInput(file2017_3);
            if(in != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String str = "";

                while ((str = reader.readLine()) != null) {
                    i++;
                    //i 값에 매핑된 체크박스 참조
                    chkTemp = defaultChk2017_3.get(i);
                    if(Integer.parseInt(str) != 0) {
                        chkTemp.setChecked(true);
                        chkTemp.setText("완료");
                    } else {
                        chkTemp.setChecked(false);
                        chkTemp.setText("미완");
                    }
                }
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDefault2016_3() {
        int i=0;
        CheckBox chkTemp;

        //<과목순서 - 체크박스> 해시맵 생성 & 매핑
        defaultChk2016_3 = new HashMap<Integer, CheckBox>();
        defaultChk2016_3.put(1, chk2016_1);
        defaultChk2016_3.put(2, chk2016_2);
        defaultChk2016_3.put(3, chk2016_3);
        defaultChk2016_3.put(4, chk2016_4);
        defaultChk2016_3.put(5, chk2016_5);
        defaultChk2016_3.put(6, chk2016_6);
        defaultChk2016_3.put(7, chk2016_7);
        defaultChk2016_3.put(8, chk2016_8);
        defaultChk2016_3.put(9, chk2016_9);
        defaultChk2016_3.put(10, chk2016_10);
        defaultChk2016_3.put(11, chk2016_11);
        defaultChk2016_3.put(12, chk2016_12);
        defaultChk2016_3.put(13, chk2016_13);
        defaultChk2016_3.put(14, chk2016_14);

        try {
            InputStream in = getActivity().openFileInput(file2016_3);
            if(in != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String str = "";

                while ((str = reader.readLine()) != null) {
                    i++;
                    //i 값에 매핑된 체크박스 참조
                    chkTemp = defaultChk2016_3.get(i);
                    if(Integer.parseInt(str) != 0) {
                        chkTemp.setChecked(true);
                        chkTemp.setText("완료");
                    } else {
                        chkTemp.setChecked(false);
                        chkTemp.setText("미완");
                    }
                }
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDefault2015_3() {
        int i=0;
        CheckBox chkTemp;

        //<과목순서 - 체크박스> 해시맵 생성 & 매핑
        defaultChk2015_3 = new HashMap<Integer, CheckBox>();
        defaultChk2015_3.put(1, chk2015_1);
        defaultChk2015_3.put(2, chk2015_2);
        defaultChk2015_3.put(3, chk2015_3);
        defaultChk2015_3.put(4, chk2015_4);
        defaultChk2015_3.put(5, chk2015_5);
        defaultChk2015_3.put(6, chk2015_6);
        defaultChk2015_3.put(7, chk2015_7);
        defaultChk2015_3.put(8, chk2015_8);
        defaultChk2015_3.put(9, chk2015_9);
        defaultChk2015_3.put(10, chk2015_10);
        defaultChk2015_3.put(11, chk2015_11);
        defaultChk2015_3.put(12, chk2015_12);
        defaultChk2015_3.put(13, chk2015_13);
        defaultChk2015_3.put(14, chk2015_14);

        try {
            InputStream in = getActivity().openFileInput(file2015_3);
            if(in != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String str = "";

                while ((str = reader.readLine()) != null) {
                    i++;
                    //i 값에 매핑된 체크박스 참조
                    chkTemp = defaultChk2015_3.get(i);
                    if(Integer.parseInt(str) != 0) {
                        chkTemp.setChecked(true);
                        chkTemp.setText("완료");
                    } else {
                        chkTemp.setChecked(false);
                        chkTemp.setText("미완");
                    }
                }
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDefault2014_3() {
        int i=0;
        CheckBox chkTemp;

        //<과목순서 - 체크박스> 해시맵 생성 & 매핑
        defaultChk2014_3 = new HashMap<Integer, CheckBox>();
        defaultChk2014_3.put(1, chk2014_1);
        defaultChk2014_3.put(2, chk2014_2);
        defaultChk2014_3.put(3, chk2014_3);
        defaultChk2014_3.put(4, chk2014_4);
        defaultChk2014_3.put(5, chk2014_5);
        defaultChk2014_3.put(6, chk2014_6);
        defaultChk2014_3.put(7, chk2014_7);
        defaultChk2014_3.put(8, chk2014_8);
        defaultChk2014_3.put(9, chk2014_9);
        defaultChk2014_3.put(10, chk2014_10);
        defaultChk2014_3.put(11, chk2014_11);
        defaultChk2014_3.put(12, chk2014_12);
        defaultChk2014_3.put(13, chk2014_13);
        defaultChk2014_3.put(14, chk2014_14);
        defaultChk2014_3.put(15, chk2014_15);
        defaultChk2014_3.put(16, chk2014_16);

        try {
            InputStream in = getActivity().openFileInput(file2014_3);
            if(in != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String str = "";

                while ((str = reader.readLine()) != null) {
                    i++;
                    //i 값에 매핑된 체크박스 참조
                    chkTemp = defaultChk2014_3.get(i);
                    if(Integer.parseInt(str) != 0) {
                        chkTemp.setChecked(true);
                        chkTemp.setText("완료");
                    } else {
                        chkTemp.setChecked(false);
                        chkTemp.setText("미완");
                    }
                }
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDefault2013_3() {
        int i=0;
        CheckBox chkTemp;

        //<과목순서 - 체크박스> 해시맵 생성 & 매핑
        defaultChk2013_3 = new HashMap<Integer, CheckBox>();
        defaultChk2013_3.put(1, chk2013_1);
        defaultChk2013_3.put(2, chk2013_2);
        defaultChk2013_3.put(3, chk2013_3);
        defaultChk2013_3.put(4, chk2013_4);
        defaultChk2013_3.put(5, chk2013_5);
        defaultChk2013_3.put(6, chk2013_6);
        defaultChk2013_3.put(7, chk2013_7);
        defaultChk2013_3.put(8, chk2013_8);
        defaultChk2013_3.put(9, chk2013_9);
        defaultChk2013_3.put(10, chk2013_10);
        defaultChk2013_3.put(11, chk2013_11);
        defaultChk2013_3.put(12, chk2013_12);
        defaultChk2013_3.put(13, chk2013_13);
        defaultChk2013_3.put(14, chk2013_14);
        defaultChk2013_3.put(15, chk2013_15);

        try {
            InputStream in = getActivity().openFileInput(file2013_3);
            if(in != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String str = "";

                while ((str = reader.readLine()) != null) {
                    i++;
                    //i 값에 매핑된 체크박스 참조
                    chkTemp = defaultChk2013_3.get(i);
                    if(Integer.parseInt(str) != 0) {
                        chkTemp.setChecked(true);
                        chkTemp.setText("완료");
                    } else {
                        chkTemp.setChecked(false);
                        chkTemp.setText("미완");
                    }
                }
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
