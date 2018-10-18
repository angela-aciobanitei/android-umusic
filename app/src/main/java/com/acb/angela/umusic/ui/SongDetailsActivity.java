package com.acb.angela.umusic.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.acb.angela.umusic.R;

import static com.acb.angela.umusic.ui.SongListActivity.SONG_ARTIST;
import static com.acb.angela.umusic.ui.SongListActivity.SONG_IMAGE_RESOURCE_ID;
import static com.acb.angela.umusic.ui.SongListActivity.SONG_TITLE;

public class SongDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_details);

        // Get the intent that launched this activity.
        Intent intent = getIntent();

        // Get extras.
        String songTitle = intent.getStringExtra(SONG_TITLE);
        String songArtist = intent.getStringExtra(SONG_ARTIST);
        int songImageId = intent.getIntExtra(SONG_IMAGE_RESOURCE_ID,-1);

        // Set the title and artist view to display the appropriate information.
        TextView titleView = findViewById(R.id.details_song_title);
        titleView.setText(songTitle);

        TextView artistView = findViewById(R.id.details_song_artist);
        artistView.setText(songArtist);

        ImageView coverImage = findViewById(R.id.background_image);
        if (songImageId != -1)
            coverImage.setImageResource(songImageId);
    }
}
