package com.acb.angela.umusic.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import com.acb.angela.umusic.R;
import com.acb.angela.umusic.adapters.SongAdapter;
import com.acb.angela.umusic.models.Song;

public class SongListActivity extends AppCompatActivity {

    // Keys for extras sent along with an intent
    public static final String SONG_TITLE = "SONG_TITLE";
    public static final String SONG_ARTIST = "SONG_ARTIST";
    public static final String SONG_IMAGE_RESOURCE_ID = "SONG_IMAGE_RESOURCE_ID";

    private SongAdapter mSongAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placeholder);

        // Create a list of songs
        List<Song> songList  = new ArrayList<>();
        for(int i = 0; i < 14; i++) {
            songList.add(new Song( "Song Title " + i,"Song Artist " + i, -1));
        }

        // Create custom adapter
        mSongAdapter = new SongAdapter(this, songList);

        // Find the ListView object in the view hierarchy of the Activity.
        ListView listView = (ListView) findViewById(R.id.list_view);

        // Attach the adapter to the list view.
        listView.setAdapter(mSongAdapter);

        // Set click listeners
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current song that was clicked on.
                Song currentSong = mSongAdapter.getItem(position);

                // Create new intent.
                Intent intent = new Intent(SongListActivity.this, SongDetailsActivity.class);
                if (currentSong != null) {
                    intent.putExtra(SONG_TITLE, currentSong.getTitle());
                    intent.putExtra(SONG_ARTIST, currentSong.getArtist());
                    intent.putExtra(SONG_IMAGE_RESOURCE_ID, currentSong.getImageResourceId());
                }
                startActivity(intent);
            }
        });

    }
}
