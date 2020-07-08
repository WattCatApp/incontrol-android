package no.redbird.libincontrol.data.jlr.vehicle.position;

import com.google.gson.annotations.SerializedName;

public class PositionResponse {

    @SerializedName("position")
    private final
    Position position;

    public PositionResponse(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}
