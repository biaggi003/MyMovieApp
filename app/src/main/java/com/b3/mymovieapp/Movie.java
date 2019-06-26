package com.b3.mymovieapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    private int photo, photocast, photocast2, photocast3;
    private String name, description, director, cast;

    public int getPhoto() {
        return photo;
    }
    public void setPhoto(int photo) {
        this.photo = photo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setPhotoCast(int photocast) {
        this.photocast = photocast;
    }

    public int getPhotoCast() {
        return photocast;
    }

    public void setPhotoCast2(int photocast2) {
        this.photocast2 = photocast2;
    }

    public int getPhotoCast2() {
        return photocast2;
    }

    public void setPhotoCast3(int photocast3) {
        this.photocast3 = photocast3;
    }

    public int getPhotoCast3() {
        return photocast3;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getCast() {
        return cast;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.photo);
        dest.writeString(this.description);
        dest.writeInt(this.photocast);
        dest.writeInt(this.photocast2);
        dest.writeInt(this.photocast3);
        dest.writeString(this.director);
        dest.writeString(this.cast);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.name = in.readString();
        this.photo = in.readInt();
        this.description = in.readString();
        this.photocast = in.readInt();
        this.photocast2 = in.readInt();
        this.photocast3 = in.readInt();
        this.director = in.readString();
        this.cast = in.readString();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}