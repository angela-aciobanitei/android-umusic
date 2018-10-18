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

import static com.acb.angela.umusic.ui.SongListActivity.SONG_ARTIST;
import static com.acb.angela.umusic.ui.SongListActivity.SONG_IMAGE_RESOURCE_ID;
import static com.acb.angela.umusic.ui.SongListActivity.SONG_TITLE;

public class FavouritesListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placeholder);

        // Create a list of favourite songs
        List<Song> favourites = new ArrayList<>();
        for(int i = 0; i < 14; i++) {
            favourites.add(new Song( "Song Title " + i,"Song Artist " + i, -1));
        }

        // Create custom adapter
        SongAdapter songAdapter = new SongAdapter(this, favourites);

        // Find the ListView object in the view hierarchy of the Activity.
        ListView listView = (ListView) findViewById(R.id.list_view);

        // Attach the adapter to the list view.
        listView.setAdapter(songAdapter);

    }
}
