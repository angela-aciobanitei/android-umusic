package com.acb.angela.umusic.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.acb.angela.umusic.R;


public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the necessary views from layout.
        CardView albums = findViewById(R.id.albums_card_view);
        CardView songs = findViewById(R.id.songs_card_view);
        CardView playlists = findViewById(R.id.playlists_card_view);
        CardView favourites = findViewById(R.id.favourites_card_view);

        // For each view, set a click listener.
        albums.setOnClickListener(this);
        songs.setOnClickListener(this);
        playlists.setOnClickListener(this);
        favourites.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // Because MainActivity implements View.OnClickListener, we need to override this method
        switch (view.getId()) {
            case R.id.albums_card_view:
                startActivity(new Intent(MainActivity.this, AlbumListActivity.class));
                break;
            case R.id.songs_card_view:
                startActivity(new Intent(MainActivity.this, SongListActivity.class));
                break;
            case R.id.playlists_card_view:
                startActivity(new Intent(MainActivity.this, PlaylistsActivity.class));
                break;
            case R.id.favourites_card_view:
                startActivity(new Intent(MainActivity.this, FavouritesListActivity.class));
                break;
        }
    }
}
