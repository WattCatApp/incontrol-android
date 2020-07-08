package no.redbird.libincontrol.data.jlr.vehicle.position;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import no.redbird.libincontrol.util.DateParser;

public class Position implements Parcelable {

    /**
     * {'longitude': 10.777671944444444, 'latitude': 59.94206888888889, 'timestamp': '2019-06-12T16:25:02+0000', 'speed': 0, 'heading': 0, 'positionQuality': None}
     */

    @SerializedName("longitude")
    private final
    float longitude;

    @SerializedName("latitude")
    private final
    float latitude;

    @SerializedName("timestamp")
    private final
    String timestamp;

    public Position(float lat, float lon, String timestamp) {
        this.longitude = lon;
        this.latitude = lat;
        this.timestamp = timestamp;
    }

    private Position(Parcel in) {
        longitude = in.readFloat();
        latitude = in.readFloat();
        timestamp = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(longitude);
        dest.writeFloat(latitude);
        dest.writeString(timestamp);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Position> CREATOR = new Creator<Position>() {
        @Override
        public Position createFromParcel(Parcel in) {
            return new Position(in);
        }

        @Override
        public Position[] newArray(int size) {
            return new Position[size];
        }
    };

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public Date getTimestamp() {
        return DateParser.jlrTimestampToDate(timestamp);
    }
}
