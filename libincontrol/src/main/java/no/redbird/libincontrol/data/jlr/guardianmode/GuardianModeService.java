package no.redbird.libincontrol.data.jlr.guardianmode;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GuardianModeService {

    @GET("/if9/jlr/vehicles/{vin}/gm/status")
    @Headers({"Accept: application/vnd.wirelesscar.ngtp.if9.GuardianStatus-v1+json",
            "Content-Type: application/json"})
    Call<GuardianModeStatus> getStatus(@Path("vin") String vin);


    @POST("/if9/jlr/vehicles/{vin}/gm/alarms")
    @Headers({"Accept: application/vnd.wirelesscar.ngtp.if9.GuardianAlarmList-v1+json",
            "Content-Type: application/json"})
    Call<Void> enableGuardianMode(@Path("vin") String vin,
                                    @Body JsonObject guardianModeEnableBody);

    @DELETE("/if9/jlr/vehicles/{vin}/gm/alarms/{gm_id}")
    Call<Void> removeGuardianMode(@Header ("X-servicetoken") String gmToken,
                                  @Path("vin") String vin, @Path("gm_id") String gmId);

    @DELETE("/if9/jlr/vehicles/{vin}/gm/alerts")
    Call<Void> deleteGuardianAlert(@Header("X-servicetoken") String gmToken,
                                   @Path("vin") String vin);

    @GET("/if9/jlr/vehicles/{vin}/gm/alerts")
    @Headers({"Content-Type: application/wirelesscar.GuardianAlert-v1+json"})
    Call<GuardianAlert> getGuardianAlert(@Path("vin") String vin);
}
