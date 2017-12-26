package br.com.luciano.popularmovies;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MovieObject implements Parcelable {

    private String coverPath;
    private String title;
    private String synopsis;
    private Double rating;
    private String releaseDate;
    private String detailURL;

    public String getDetailURL() {
        return detailURL;
    }

    public void setDetailURL(String detailURL) {
        this.detailURL = detailURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    public String getSynopsis() { return synopsis;  }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getReleaseDate() throws ParseException {
        SimpleDateFormat convertedFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
        return convertedFormat.format(originalFormat.parse(releaseDate));
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public MovieObject(){}

    private MovieObject(Parcel in) {
        this.coverPath = in.readString();
        this.title = in.readString();
        this.synopsis = in.readString();
        this.rating = in.readDouble();
        this.releaseDate = in.readString();
        this.detailURL = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(coverPath);
        parcel.writeString(title);
        parcel.writeString(synopsis);
        parcel.writeDouble(rating);
        parcel.writeString(releaseDate);
        parcel.writeString(detailURL);
    }

    public static final Parcelable.Creator<MovieObject> CREATOR = new Parcelable.Creator<MovieObject>() {
        @Override
        public MovieObject createFromParcel(Parcel parcel) {
            return new MovieObject(parcel);
        }

        @Override
        public MovieObject[] newArray(int i) {
            return new MovieObject[i];
        }

    };

}
