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
import com.acb.angela.umusic.models.Album;


public class AlbumAdapter extends ArrayAdapter<Album> {

    /**
     * Create a new {@link AlbumAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param albums is the list of Albums to be displayed.
     */
    public AlbumAdapter(@NonNull Context context, @NonNull List<Album> albums) {
        super(context, 0, albums);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null){
            // Inflate a new view.
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.album_list_item,       // ID  for an XML layout to load
                    parent,                        // parent of the generated view hierarchy
                    false);             // !attached to the parent view group

            // Populate holder and store it inside the layout
            holder = new ViewHolder();
            holder.image = convertView.findViewById(R.id.album_image);
            holder.title = convertView.findViewById(R.id.album_title);
            holder.artist = convertView.findViewById(R.id.album_artist);

            // Set tag on the view to be recycled
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Set the data for our list.
        // Get the current song that is being requested for display.
        Album currentAlbum = getItem(position);

        assert currentAlbum != null;
        if (currentAlbum.hasImage()) {
            holder.image.setImageResource(currentAlbum.getImageResourceId());
            holder.image.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView
            holder.image.setImageResource(R.drawable.ic_album);
        }

        holder.title.setText(currentAlbum.getTitle());
        holder.artist.setText(currentAlbum.getArtist());

        return convertView;
    }

    // Use the View Holder pattern
    private static class ViewHolder {
        ImageView image;
        TextView title;
        TextView artist;
    }
}