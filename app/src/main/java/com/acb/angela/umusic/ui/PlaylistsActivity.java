package com.acb.angela.umusic.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import com.acb.angela.umusic.R;

public class PlaylistsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placeholder);

        // Create a list of playlists
        ArrayList<String> playlists = new ArrayList<>();
        for(int i = 0; i < 14; i++){
            playlists.add("playlist_" +i);
        }

        // Create a default adapter
        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                playlists);

        // Find the ListView object in the view hierarchy of the Activity.
        ListView listView = (ListView) findViewById(R.id.list_view);

        // Attach the adapter to the list view.
        listView.setAdapter(adapter);

    }
}
