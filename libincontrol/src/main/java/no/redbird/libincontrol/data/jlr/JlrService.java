package no.redbird.libincontrol.data.jlr;

import com.google.gson.JsonObject;

import no.redbird.libincontrol.data.jlr.contactinfo.ContactInfoObject;
import no.redbird.libincontrol.data.jlr.geocode.ReverseGeoCodeResponse;
import no.redbird.libincontrol.data.jlr.service.JlrAuthToken;
import no.redbird.libincontrol.data.jlr.services.ServiceStatusResponse;
import no.redbird.libincontrol.data.jlr.services.ServicesList;
import no.redbird.libincontrol.data.jlr.user.UserInfo;
import no.redbird.libincontrol.data.jlr.vehicle.VehicleAttributesJsonResponse;
import no.redbird.libincontrol.data.jlr.vehicle.departures.VehicleDepartureTimersResponse;
import no.redbird.libincontrol.data.jlr.vehicle.VehicleJsonResponse;
import no.redbird.libincontrol.data.jlr.vehicle.status.VehicleStatusJsonResponse;
import no.redbird.libincontrol.data.jlr.vehicle.position.PositionResponse;
import no.redbird.libincontrol.data.jlr.vehicle.subscriptions.SubscriptionResponse;
import no.redbird.libincontrol.data.jlr.vehicle.trips.TripsResponse;
import no.redbird.libincontrol.data.jlr.vehicle.tripwaypoints.TripWaypoints;
import no.redbird.libincontrol.data.jlr.vehicle.wakeuptime.WakeupTimeJsonResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JlrService {

    @GET("if9/jlr/vehicles/{vin}/contactinfo/{mcc}")
    Call<ContactInfoObject> getContactHelp(@Path("vin") String vin,
                                           @Path("mcc") String mcc);

    @Headers("Accept: application/vnd.wirelesscar.ngtp.if9.User-v3+json")
    @GET("/if9/jlr/users")
    Call<UserInfo> loginUser(@Query("loginName") String username);

    @GET("/if9/jlr/users/{userid}/vehicles?primaryOnly=true")
    Call<VehicleJsonResponse> getVehicles(@Path("userid") String userId);

    @Headers("Accept: application/vnd.ngtp.org.if9.healthstatus-v3+json")
    @GET("/if9/jlr/vehicles/{vin}/status?includeInactive=true")
    Call<VehicleStatusJsonResponse> getVehicleStatus(@Path("vin") String vin);

    @Headers("Accept: application/vnd.ngtp.org.VehicleAttributes-v4+json")
    @GET("/if9/jlr/vehicles/{vin}/attributes")
    Call<VehicleAttributesJsonResponse> getVehicleAttributes(@Path("vin") String vin);

    @POST("/if9/jlr/vehicles/{vin}/attributes")
    @Headers({"Content-Type: application/vnd.ngtp.org.VehicleAttributes-v4+json",
            "X-Requestor: wattcat"})
    Call<Void> updateAttributes(@Path("vin") String vin, @Body JsonObject attributesObject);

    @Headers({"Accept: application/vnd.wirelesscar.ngtp.if9.DepartureTimerSettings-v1+json",
            "X-Requestor: wattcat"})
    @GET("/if9/jlr/vehicles/{vin}/departuretimers")
    Call<VehicleDepartureTimersResponse> getDepartureTimers(@Path("vin") String vin);

    @Headers("Accept: application/vnd.wirelesscar.ngtp.if9.ServiceStatus-v4+json")
    @GET("/if9/jlr/vehicles/{vin}/services/{service_id}")
    Call<ServiceStatusResponse> getServiceStatus(@Path("vin") String vin,
                                                 @Path("service_id") String serviceId);

    @GET("/if9/jlr/vehicles/{vin}/services")
    Call<ServicesList> getServices(@Path("vin") String vin);


    @Headers({"Accept: application/vnd.wirelesscar.ngtp.if9.ServiceStatus-v5+json",
            "Content-Type: application/vnd.wirelesscar.ngtp.if9.PhevService-v1+json; charset=utf-8"})
    @POST("/if9/jlr/vehicles/{vin}/chargeProfile")
    Call<ServiceStatusResponse> deleteDepartureTimer(@Path("vin") String vin,
                                                     @Body JsonObject departureDeleteBody);

    @Headers({"Accept: application/vnd.wirelesscar.ngtp.if9.ServiceStatus-v5+json",
            "Content-Type: application/vnd.wirelesscar.ngtp.if9.PhevService-v1+json; charset=utf-8"})
    @POST("/if9/jlr/vehicles/{vin}/chargeProfile")
    Call<ServiceStatusResponse> createDepartureTimer(@Path("vin") String vin,
                                                     @Body JsonObject departureCreationBody);

    @Headers({"Accept: application/vnd.wirelesscar.ngtp.if9.ServiceStatus-v5+json",
            "Content-Type: application/vnd.wirelesscar.ngtp.if9.PhevService-v1+json; charset=utf-8"})
    @POST("/if9/jlr/vehicles/{vin}/chargeProfile")
    Call<ServiceStatusResponse> toggleCharging(@Path("vin") String vin,
                                               @Body JsonObject chargingControlBody);

    @Headers({"Content-Type: application/vnd.wirelesscar.ngtp.if9.StartServiceConfiguration-v3+json"})
    @POST("/if9/jlr/vehicles/{vin}/preconditioning")
    Call<ServiceStatusResponse> togglePreconditioning(@Path("vin") String vin,
                                                      @Body JsonObject preconditionBody);

    @POST("/if9/jlr/vehicles/{vin}/users/{userid}/authenticate")
    Call<JlrAuthToken> authenticateService(@Path("vin") String vin, @Path("userid") String userId,
                                           @Body JsonObject serviceBody);

    @Headers({"Content-Type: application/vnd.wirelesscar.ngtp.if9.StartServiceConfiguration-v3+json"})
    @POST("/if9/jlr/vehicles/{vin}/healthstatus")
    Call<ServiceStatusResponse> refreshHealthStatus(@Path("vin") String vin,
                                                    @Body JsonObject tokenBody);

    @Headers({"Content-Type: application/vnd.wirelesscar.ngtp.if9.StartServiceConfiguration-v2+json"})
    @POST("/if9/jlr/vehicles/{vin}/lock")
    Call<ServiceStatusResponse> lockVehicle(@Path("vin") String vin,
                                            @Body JsonObject rdlToken);

    @Headers({"Content-Type: application/vnd.wirelesscar.ngtp.if9.StartServiceConfiguration-v2+json"})
    @POST("/if9/jlr/vehicles/{vin}/unlock")
    Call<ServiceStatusResponse> unlockVehicle(@Path("vin") String vin,
                                              @Body JsonObject rduToken);

    @GET("/if9/jlr/vehicles/{vin}/position")
    Call<PositionResponse> getVehiclePosition(@Path("vin") String vin);

    @Headers({"Accept: application/vnd.wirelesscar.ngtp.if9.VehicleWakeupTime-v2+json"})
    @GET("if9/jlr/vehicles/{vin}/wakeuptime")
    Call<WakeupTimeJsonResponse> getWakeupTime(@Path("vin") String vin);

    @Headers({"Content-Type: application/vnd.wirelesscar.ngtp.if9.StartServiceConfiguration-v3+json; charset=utf-8",
            "Accept: application/vnd.wirelesscar.ngtp.if9.ServiceStatus-v3+json"})
    @POST("if9/jlr/vehicles/{vin}/swu")
    Call<ServiceStatusResponse> setWakeupTime(@Path("vin") String vin,
                                              @Body JsonObject serviceBody);

    @Headers({"Content-Type: application/vnd.wirelesscar.ngtp.if9.StartServiceConfiguration-v3+json; charset=utf-8",
            "Accept: application/vnd.wirelesscar.ngtp.if9.ServiceStatus-v3+json"})
    @POST("if9/jlr/vehicles/{vin}/swu")
    Call<ServiceStatusResponse> deleteWakeupTime(@Path("vin") String vin,
                                                 @Body JsonObject serviceBody);

    @GET("if9/jlr/vehicles/{vin}/subscriptionpackages")
    Call<SubscriptionResponse> getSubscriptionPackages(@Path("vin") String vin);

    @Headers({"Content-Type: application/vnd.wirelesscar.ngtp.if9.StartServiceConfiguration-v3+json; charset=utf-8",
            "Accept: application/vnd.wirelesscar.ngtp.if9.ServiceStatus-v4+json"})
    @POST("if9/jlr/vehicles/{vin}/honkBlink")
    Call<ServiceStatusResponse> honkBlink(@Path("vin") String vin,
                                          @Body JsonObject serviceBody);

    @Headers({"Content-Type: application/vnd.wirelesscar.ngtp.if9.StartServiceConfiguration-v3+json"})
    @POST("if9/jlr/vehicles/{vin}/prov")
    Call<ServiceStatusResponse> provCommand(@Path("vin") String vin,
                                            @Body JsonObject serviceBody);

    @Headers({"Accept: application/vnd.ngtp.org.triplist-v2+json"})
    @GET("if9/jlr/vehicles/{vin}/trips?count=1000")
    Call<TripsResponse> getTrips(@Path("vin") String vin);

    @GET("if9/jlr/vehicles/{vin}/trips/{trip_id}/route?pageSize=1000&page=0")
    Call<TripWaypoints> getTrip(@Path("vin") String vin,
                                @Path("trip_id") long tripId);

    @DELETE("if9/jlr/vehicles/{vin}/trips/{tripid}")
    Call<ServiceStatusResponse> deleteTrip(@Path("vin") String vin, @Path("tripid") long tripId);


    @GET("if9/jlr/geocode/reverse/{lat}/{lon}/en")
    Call<ReverseGeoCodeResponse> reverseGeoCode(@Path("lat") String lat, @Path("lon") String lon);
}
