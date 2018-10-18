package com.acb.angela.umusic.models;

/**
 * {@link Song} is a data model object with the following properties
 *      title
 *      artist
 *      image
 */

public class Song {

    private static final int NO_IMAGE_PROVIDED = -1;

    private String mTitle;
    private String mArtist;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    public Song(String title, String artist, int imageResourceId) {
        mTitle = title;
        mArtist = artist;
        mImageResourceId = imageResourceId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getArtist() {
        return mArtist;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
