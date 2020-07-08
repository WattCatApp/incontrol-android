package no.redbird.libincontrol.data.jlr.vehicle;

import com.google.gson.annotations.SerializedName;

public class VehicleAttributesJsonResponse {

    @SerializedName("engineCode")
    private final String engineCode;

    @SerializedName("exteriorCode")
    private final String exteriorCode;

    @SerializedName("registrationNumber")
    private final String registrationNumber;

    @SerializedName("nickname")
    private final String nickname;

    @SerializedName("grossWeight")
    private final String grossWeight;

    @SerializedName("modelYear")
    private final String modelYear;

    @SerializedName("country")
    private final String country;

    @SerializedName("vehicleBrand")
    private final String vehicleBrand;

    @SerializedName("vehicleType")
    private final String vehicleType;

    @SerializedName("vehicleTypeCode")
    private final String vehicleTypeCode;

    public VehicleAttributesJsonResponse(String engineCode, String exteriorCode,
                                         String registrationNumber, String nickname,
                                         String grossWeight, String vehicleBrand,
                                         String modelYear, String country,
                                         String vehicleType, String vehicleTypeCode) {
        this.engineCode = engineCode;
        this.exteriorCode = exteriorCode;
        this.registrationNumber = registrationNumber;
        this.nickname = nickname;
        this.grossWeight = grossWeight;
        this.modelYear = modelYear;
        this.country = country;
        this.vehicleType = vehicleType;
        this.vehicleTypeCode = vehicleTypeCode;
        this.vehicleBrand = vehicleBrand;
    }

    public String getEngineCode() {
        return engineCode;
    }

    public String getExteriorCode() {
        return exteriorCode;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getNickname() {
        return nickname;
    }

    public String getGrossWeight() {
        return grossWeight;
    }

    public String getModelYear() {
        return modelYear;
    }

    public String getCountry() {
        return country;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getVehicleTypeCode() {
        return vehicleTypeCode;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }
}
