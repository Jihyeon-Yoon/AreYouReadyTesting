package com.example.yjh.areyouready;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by YJH on 2018-05-19.
 */

public class Check extends Fragment {

    //shared preference
    Context context;
    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;
    int totalCredit;
    int currentCredit;
    int bookNum;
    int volunNum;
    int volunTime;
    String enterYearFix;

    TextView textView_bookPercent;
    TextView textView_bookProgress;
    TextView textView_volunNumPercent;
    TextView textView_volunNumProgress;
    TextView textView_volunTimePercent;
    TextView textView_volunTimeProgress;
    TextView textView_creditPercent;
    TextView textView_creditProgress;
    TextView textView_creditTotal;
    TextView textView_bookNow;
    TextView textView_bookRemain;
    TextView textView_volunNumNow;
    TextView textView_volunNumRemain;
    TextView textView_volunTimeNow;
    TextView textView_volunTimeRemain;
    TextView textView_creditNow;
    TextView textView_creditRemain;

    ProgressBar progressBar_book;
    ProgressBar progressBar_volunteerNum;
    ProgressBar progressBar_volunteerTime;
    ProgressBar progressBar_credit;

    ImageButton bookPlus;
    ImageButton bookMinus;
    ImageButton volNumPlus;
    ImageButton volNumMinus;
    ImageButton volTimePlus;
    ImageButton volTimeMinus;

    Button button_update;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.check, null);

        textView_bookPercent = rootView.findViewById(R.id.textView_bookPercent);
        textView_bookProgress = rootView.findViewById(R.id.textView_bookProgress);
        textView_volunNumPercent = rootView.findViewById(R.id.textView_volunNumPercent);
        textView_volunNumProgress = rootView.findViewById(R.id.textView_volunNumProgress);
        textView_volunTimePercent = rootView.findViewById(R.id.textView_volunTimePercent);
        textView_volunTimeProgress = rootView.findViewById(R.id.textView_volunTimeProgress);
        textView_creditPercent = rootView.findViewById(R.id.textView_creditPercent);
        textView_creditProgress = rootView.findViewById(R.id.textView_creditProgress);
        textView_creditTotal = rootView.findViewById(R.id.textView_creditTotal);
        textView_bookNow = rootView.findViewById(R.id.textView_bookNow);
        textView_bookRemain = rootView.findViewById(R.id.textView_bookRemain);
        textView_volunNumNow = rootView.findViewById(R.id.textView_volunNumNow);
        textView_volunNumRemain = rootView.findViewById(R.id.textView_volunNumRemain);
        textView_volunTimeNow = rootView.findViewById(R.id.textView_volunTimeNow);
        textView_volunTimeRemain = rootView.findViewById(R.id.textView_volunTimeRemain);
        textView_creditNow = rootView.findViewById(R.id.textView_creditNow);
        textView_creditRemain = rootView.findViewById(R.id.textView_creditRemain);

        progressBar_book = rootView.findViewById(R.id.progressBar_book);
        progressBar_volunteerNum = rootView.findViewById(R.id.progressBar_volunteerNum);
        progressBar_volunteerTime = rootView.findViewById(R.id.progressBar_volunteerTime);
        progressBar_credit = rootView.findViewById(R.id.progressBar_credit);

        bookPlus = rootView.findViewById(R.id.bookPlus);
        bookMinus = rootView.findViewById(R.id.bookMinus);
        volNumPlus = rootView.findViewById(R.id.volNumPlus);
        volNumMinus = rootView.findViewById(R.id.volNumMinus);
        volTimePlus = rootView.findViewById(R.id.volTimePlus);
        volTimeMinus = rootView.findViewById(R.id.volTimeMinus);

        button_update = rootView.findViewById(R.id.button_update);

        //call stored data
        applySharedPreference();
        getTotalCredit();
        getCurrentCredit();
        showStoredData();

        bookPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bookNum<40) {
                    bookNum++;
                    textView_bookNow.setText(String.valueOf(bookNum));
                    textView_bookRemain.setText(String.valueOf(40-bookNum));
                } else {
                    Toast.makeText(getActivity(), "독후감을 모두 완료했습니다", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bookMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bookNum>0) {
                    bookNum--;
                    textView_bookNow.setText(String.valueOf(bookNum));
                    textView_bookRemain.setText(String.valueOf(40-bookNum));
                } else {
                    Toast.makeText(getActivity(), "0이 최소값입니다", Toast.LENGTH_SHORT).show();
                }
            }
        });

        volNumPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(volunNum<10) {
                    volunNum++;
                    textView_volunNumNow.setText(String.valueOf(volunNum));
                    textView_volunNumRemain.setText(String.valueOf(10-volunNum));
                } else {
                    Toast.makeText(getActivity(), "봉사 횟수를 모두 완료했습니다", Toast.LENGTH_SHORT).show();
                }
            }
        });

        volNumMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(volunNum>0) {
                    volunNum--;
                    textView_volunNumNow.setText(String.valueOf(volunNum));
                    textView_volunNumRemain.setText(String.valueOf(10-volunNum));
                } else {
                    Toast.makeText(getActivity(), "0이 최소값입니다", Toast.LENGTH_SHORT).show();
                }
            }
        });

        volTimePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(volunTime<20) {
                    volunTime++;
                    textView_volunTimeNow.setText(String.valueOf(volunTime));
                    textView_volunTimeRemain.setText(String.valueOf(20-volunTime));
                } else {
                    Toast.makeText(getActivity(), "봉사 시간을 모두 완료했습니다", Toast.LENGTH_SHORT).show();
                }
            }
        });

        volTimeMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(volunTime>0) {
                    volunTime--;
                    textView_volunTimeNow.setText(String.valueOf(volunTime));
                    textView_volunTimeRemain.setText(String.valueOf(20-volunTime));
                } else {
                    Toast.makeText(getActivity(), "0이 최소값입니다", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //update
        button_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences();
                applySharedPreference();
                showStoredData();

                Toast.makeText(getActivity(), "업데이트 되었습니다", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

    private void getTotalCredit() {
        switch(Integer.parseInt(enterYearFix)) {
            case 2017:
            case 2016:
                totalCredit = 121;
                break;
            case 2015:
            case 2014:
            case 2013:
                totalCredit = 120;
                break;
            default:
                break;
        }
        storeTotalCredit(totalCredit);
    }

    private void storeTotalCredit(int total) {
        context = getActivity();
        sh_Pref = context.getSharedPreferences("STORE DATA", MODE_PRIVATE);
        toEdit = sh_Pref.edit();

        toEdit.putInt("totalCredit", total);

        toEdit.commit();
    }

    private void getCurrentCredit() {
        switch(Integer.parseInt(enterYearFix)) {
            case 2017:
                get2017SharedPreference();
                break;
            case 2016:
                get2016SharedPreference();
                break;
            case 2015:
                get2015SharedPreference();
                break;
            case 2014:
                get2014SharedPreference();
                break;
            case 2013:
                get2013SharedPreference();
                break;
            default:
                break;
        }
        storeCurrentCredit(currentCredit);
    }

    private void storeCurrentCredit(int sum) {
        context = getActivity();
        sh_Pref = context.getSharedPreferences("STORE DATA", MODE_PRIVATE);
        toEdit = sh_Pref.edit();

        toEdit.putInt("currentCredit", sum);

        toEdit.commit();
    }

    private void showStoredData() {
        String temp;
        //percent
        temp=String.format("%.1f", bookNum/40.0*100);
        textView_bookPercent.setText(temp);
        temp=String.format("%.1f", volunNum/10.0*100);
        textView_volunNumPercent.setText(temp);
        temp=String.format("%.1f", volunTime/20.0*100);
        textView_volunTimePercent.setText(temp);
        temp=String.format("%.1f", (double)currentCredit/totalCredit*100);
        textView_creditPercent.setText(temp);
        //progress num
        textView_bookProgress.setText(String.valueOf(bookNum));
        textView_volunNumProgress.setText(String.valueOf(volunNum));
        textView_volunTimeProgress.setText(String.valueOf(volunTime));
        textView_creditProgress.setText(String.valueOf(currentCredit));
        textView_creditTotal.setText(String.valueOf(totalCredit));
        //progress bar
        progressBar_book.setProgress(bookNum);
        progressBar_volunteerNum.setProgress(volunNum);
        progressBar_volunteerTime.setProgress(volunTime);
        progressBar_credit.setProgress(currentCredit);
        //current & remain
        textView_bookNow.setText(String.valueOf(bookNum));
        textView_bookRemain.setText(String.valueOf(40-bookNum));
        textView_volunNumNow.setText(String.valueOf(volunNum));
        textView_volunNumRemain.setText(String.valueOf(10-volunNum));
        textView_volunTimeNow.setText(String.valueOf(volunTime));
        textView_volunTimeRemain.setText(String.valueOf(20-volunTime));
        textView_creditNow.setText(String.valueOf(currentCredit));
        textView_creditRemain.setText(String.valueOf(totalCredit-currentCredit));
    }

    public void sharedPreferences() {
        context = getActivity();
        sh_Pref = context.getSharedPreferences("STORE DATA", MODE_PRIVATE);
        toEdit = sh_Pref.edit();

        toEdit.putInt("bookNum", bookNum);
        toEdit.putInt("volunNum", volunNum);
        toEdit.putInt("volunTime", volunTime);

        toEdit.commit();
    }

    public void applySharedPreference() {
        context = getActivity();
        sh_Pref = context.getSharedPreferences("STORE DATA", MODE_PRIVATE);
        if(sh_Pref != null) {
            bookNum = sh_Pref.getInt("bookNum", 0);
        }
        if(sh_Pref != null) {
            volunNum = sh_Pref.getInt("volunNum", 0);
        }
        if(sh_Pref != null) {
            volunTime = sh_Pref.getInt("volunTime", 0);
        }
        if(sh_Pref != null) {
            enterYearFix = sh_Pref.getString("enterYearFix", "2017");
        }
        if(sh_Pref != null) {
            totalCredit = sh_Pref.getInt("totalCredit", 121);
        }
        if(sh_Pref != null) {
            currentCredit = sh_Pref.getInt("currentCredit", 0);
        }
    }

    private void get2017SharedPreference() {
        int sum=0;
        context = getActivity();
        sh_Pref = context.getSharedPreferences("STORE DATA", MODE_PRIVATE);

        if(sh_Pref != null && sh_Pref.contains("sum2017_1")) {
            sum += sh_Pref.getInt("sum2017_1", 0);
        }

        if(sh_Pref != null && sh_Pref.contains("sum2017_2")) {
            sum += sh_Pref.getInt("sum2017_2", 0);
        }

        if(sh_Pref != null && sh_Pref.contains("sum2017_3")) {
            sum += sh_Pref.getInt("sum2017_3", 0);
        }

        if(sh_Pref != null && sh_Pref.contains("sum2017_4")) {
            sum += sh_Pref.getInt("sum2017_4", 0);
        }

        currentCredit = sum;
        storeCurrentCredit(sum);
    }

    private void get2016SharedPreference() {
        int sum=0;
        context = getActivity();
        sh_Pref = context.getSharedPreferences("STORE DATA", MODE_PRIVATE);

        if(sh_Pref != null && sh_Pref.contains("sum2016_1")) {
            sum += sh_Pref.getInt("sum2016_1", 0);
        }

        if(sh_Pref != null && sh_Pref.contains("sum2016_2")) {
            sum += sh_Pref.getInt("sum2016_2", 0);
        }

        if(sh_Pref != null && sh_Pref.contains("sum2016_3")) {
            sum += sh_Pref.getInt("sum2016_3", 0);
        }

        if(sh_Pref != null && sh_Pref.contains("sum2016_4")) {
            sum += sh_Pref.getInt("sum2016_4", 0);
        }
        currentCredit = sum;
        storeCurrentCredit(sum);
    }

    private void get2015SharedPreference() {
        int sum=0;
        context = getActivity();
        sh_Pref = context.getSharedPreferences("STORE DATA", MODE_PRIVATE);

        if(sh_Pref != null && sh_Pref.contains("sum2015_1")) {
            sum += sh_Pref.getInt("sum2015_1", 0);
        }

        if(sh_Pref != null && sh_Pref.contains("sum2015_2")) {
            sum += sh_Pref.getInt("sum2015_2", 0);
        }

        if(sh_Pref != null && sh_Pref.contains("sum2015_3")) {
            sum += sh_Pref.getInt("sum2015_3", 0);
        }

        if(sh_Pref != null && sh_Pref.contains("sum2015_4")) {
            sum += sh_Pref.getInt("sum2015_4", 0);
        }
        currentCredit = sum;
        storeCurrentCredit(sum);
    }

    private void get2014SharedPreference() {
        int sum=0;
        context = getActivity();
        sh_Pref = context.getSharedPreferences("STORE DATA", MODE_PRIVATE);

        if(sh_Pref != null && sh_Pref.contains("sum2014_1")) {
            sum += sh_Pref.getInt("sum2014_1", 0);
        }

        if(sh_Pref != null && sh_Pref.contains("sum2014_2")) {
            sum += sh_Pref.getInt("sum2014_2", 0);
        }

        if(sh_Pref != null && sh_Pref.contains("sum2014_3")) {
            sum += sh_Pref.getInt("sum2014_3", 0);
        }

        if(sh_Pref != null && sh_Pref.contains("sum2014_4")) {
            sum += sh_Pref.getInt("sum2014_4", 0);
        }
        currentCredit = sum;
        storeCurrentCredit(sum);
    }

    private void get2013SharedPreference() {
        int sum=0;
        context = getActivity();
        sh_Pref = context.getSharedPreferences("STORE DATA", MODE_PRIVATE);

        if(sh_Pref != null && sh_Pref.contains("sum2013_1")) {
            sum += sh_Pref.getInt("sum2013_1", 0);
        }

        if(sh_Pref != null && sh_Pref.contains("sum2013_2")) {
            sum += sh_Pref.getInt("sum2013_2", 0);
        }

        if(sh_Pref != null && sh_Pref.contains("sum2013_3")) {
            sum += sh_Pref.getInt("sum2013_3", 0);
        }

        if(sh_Pref != null && sh_Pref.contains("sum2013_4")) {
            sum += sh_Pref.getInt("sum2013_4", 0);
        }
        currentCredit = sum;
        storeCurrentCredit(sum);
    }

}