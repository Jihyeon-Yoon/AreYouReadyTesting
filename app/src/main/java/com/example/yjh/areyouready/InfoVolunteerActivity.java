package com.example.yjh.areyouready;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoVolunteerActivity extends AppCompatActivity {

    ImageView volImageView;
    TextView titleTextView,contentTextView, phoneNumTextView, addressTextView, distTextView;
    Button websiteButton;
    ImageButton mapImageButton, phoneCallButton;
    String title, websiteURL, phoneNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_volunteer);

        setTitle("봉사기관 정보");

        volImageView = findViewById(R.id.iv_volunteer);
        titleTextView = findViewById(R.id.tv_title);
        contentTextView = findViewById(R.id.tv_content);
        phoneNumTextView = findViewById(R.id.tv_phone_num);
        addressTextView = findViewById(R.id.tv_address);
        distTextView = findViewById(R.id.tv_dist);
        websiteButton = findViewById(R.id.btn_website);
        mapImageButton = findViewById(R.id.ib_map);
        phoneCallButton = findViewById(R.id.ib_phone_call);

        Intent intent = getIntent();
        Bundle volData = intent.getExtras();

        volImageView.setImageResource(volData.getInt("volResId"));
        titleTextView.setText(volData.getString("title"));
        contentTextView.setText(volData.getString("content"));
        phoneNumTextView.setText(volData.getString("phoneNum"));
        addressTextView.setText(volData.getString("address"));
        distTextView.setText(volData.getInt("dist") + "분");

        title = volData.getString("title");
        websiteURL = volData.getString("website");
        phoneNum = volData.getString("phoneNum").replace("-", "");

        websiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteURL));
                startActivity(intent);
            }
        });

        mapImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VolunteerMapActivity.class);
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });

        phoneCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:" + phoneNum));
                startActivity(intent);
            }
        });
    }
}
