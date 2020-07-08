package no.redbird.libincontrol.data.jlr.vehicle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.Objects;

import no.redbird.libincontrol.util.DateParser;

public class VehicleAlert implements Comparable<VehicleAlert> {

    /**
     * "key": "PRECONDITIONING_STARTED",
     * "value": "true",
     * "active": true,
     * "lastUpdatedTime": "2019-05-21T07:40:33+0000"
     */

    @SerializedName("key")
    private final String key;

    @SerializedName("value")
    private final String value;

    @SerializedName("active")
    private final boolean active;

    @SerializedName("lastUpdatedTime")
    private final String lastUpdatedTime;

    public VehicleAlert(String key, String value, boolean active, String lastUpdatedTime) {
        this.key = key;
        this.value = value;
        this.active = active;
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public static final DiffUtil.ItemCallback<VehicleAlert> DIFF_CALLBACK = new DiffUtil.ItemCallback<VehicleAlert>() {
        @Override
        public boolean areItemsTheSame(@NonNull VehicleAlert oldItem, @NonNull VehicleAlert newItem) {
            return oldItem.getTimestamp().equals(newItem.getTimestamp());
        }

        @Override
        public boolean areContentsTheSame(@NonNull VehicleAlert oldItem, @NonNull VehicleAlert newItem) {
            return oldItem.equals(newItem);
        }
    };

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public boolean getActive() {
        return active;
    }

    public Date getTimestamp() {
        return DateParser.jlrTimestampToDate(lastUpdatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey(), getTimestamp());
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        VehicleAlert alert = (VehicleAlert) obj;

        return getKey().equals(alert.getKey())
                && getTimestamp().equals(alert.getTimestamp());
    }

    @Override
    public int compareTo(VehicleAlert comparedObject) {
        return getTimestamp().compareTo(comparedObject.getTimestamp());
    }
}
