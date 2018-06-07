package com.example.yjh.areyouready;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoBookActivity extends AppCompatActivity {
    ImageView bookImageView, ratingImageView;
    TextView titleTextView, authorTextView, descTextView, locationTextView, bookMarkTextvView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_book);

        setTitle("도서 정보");

        bookImageView = findViewById(R.id.iv_book);
        ratingImageView = findViewById(R.id.iv_rating);

        titleTextView = findViewById(R.id.tv_title);
        authorTextView = findViewById(R.id.tv_author);
        descTextView = findViewById(R.id.tv_desc);
        locationTextView = findViewById(R.id.tv_location);
        bookMarkTextvView = findViewById(R.id.tv_bookmark);

        Intent intent = getIntent();
        Bundle bookData = intent.getExtras();

        bookImageView.setImageResource(bookData.getInt("bookResId"));
        ratingImageView.setImageResource(bookData.getInt("ratingResId"));

        // Word wrap(line wrap)을 막아주기 위해 공백을 "\u00a0"으로 처리도 고려해보기.
        titleTextView.setText(bookData.getString("title"));
        authorTextView.setText(bookData.getString("author"));
        descTextView.setText(bookData.getString("desc"));
        locationTextView.setText(bookData.getString("location"));
        bookMarkTextvView.setText(bookData.getString("bookMark"));
    }
}
