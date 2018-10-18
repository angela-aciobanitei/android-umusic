package com.acb.angela.umusic.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.acb.angela.umusic.R;
import com.acb.angela.umusic.models.Song;


public class SongAdapter extends ArrayAdapter<Song> {

    /**
     * Create a new {@link SongAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param songs is the list of {@link Song}s to be displayed.
     */
    public SongAdapter(@NonNull Context context, @NonNull List<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null){
            // Inflate a new view.
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_list_item,       // ID  for an XML layout to load
                    parent,                        // parent of the generated view hierarchy
                    false);             // !attached to the parent view group

            // Populate holder and store it inside the layout
            holder = new ViewHolder();
            holder.image = convertView.findViewById(R.id.song_image);
            holder.title = convertView.findViewById(R.id.song_title);
            holder.artist = convertView.findViewById(R.id.song_artist);

            // Set tag on the view to be recycled
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Set the data for our list.
        // Get the current song that is being requested for display.
        Song currentSong = getItem(position);

        assert currentSong != null;
        if (currentSong.hasImage()) {
            holder.image.setImageResource(currentSong.getImageResourceId());
            holder.image.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView
            holder.image.setImageResource(R.drawable.ic_default_image);
        }

        holder.title.setText(currentSong.getTitle());
        holder.artist.setText(currentSong.getArtist());

        return convertView;
    }

    // Use the View Holder pattern
    private static class ViewHolder {
        ImageView image;
        TextView title;
        TextView artist;
    }
}
