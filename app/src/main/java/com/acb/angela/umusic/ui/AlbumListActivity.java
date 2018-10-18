package com.acb.angela.umusic.ui;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import com.acb.angela.umusic.R;
import com.acb.angela.umusic.adapters.AlbumAdapter;
import com.acb.angela.umusic.models.Album;



public class AlbumListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placeholder);

        // Create a list of songs
        List<Album> albumList = new ArrayList<>();
        for(int i = 0; i < 14;i++)  {
            albumList.add(new Album( this.getString(R.string.album_title),
                    this.getString(R.string.album_artist) , -1));
        }

        // Create custom adapter
        final AlbumAdapter adapter = new AlbumAdapter(this, albumList);

        // Find the ListView object in the view hierarchy of the Activity.
        ListView listView = (ListView) findViewById(R.id.list_view);

        // Attach the adapter to the list view.
        listView.setAdapter(adapter);

    }

}
