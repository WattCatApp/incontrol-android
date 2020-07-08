package no.redbird.libincontrol.util;

import androidx.annotation.Nullable;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import no.redbird.libincontrol.data.jlr.guardianmode.Status;
import no.redbird.libincontrol.data.jlr.service.JlrAuthToken;
import no.redbird.libincontrol.data.jlr.services.ServiceParameter;
import no.redbird.libincontrol.data.jlr.services.ServiceStatusResponse;
import no.redbird.libincontrol.data.jlr.vehicle.departures.DepartureTimer;

public class InControlApi {

    private static final String API_VALUE = "value";

    private static final String API_KEY = "key";

    public static final String TOKEN = "token";

    private static final String TIMERS = "timers";

    private static final String SERVICE_COMMAND = "serviceCommand";

    private static final String TIMER_INDEX = "timerIndex";

    private InControlApi() {
        // No instance
    }

    public static class KnownVehicleTypeCodes {
        private KnownVehicleTypeCodes() {
            // No instance
        }

        public static final String TYPE_CODE_IPACE = "X590";
    }

    public static class API {

        private API() {
            // No Instance
        }

        public static final String VALUE_TRUE = "TRUE";

        public static final String VALUE_STARTED = "Started";

        public static final String VALUE_NORMAL = "NORMAL";

        public static final String END_TIME = "endTime";

        public static final String KM = "km";

        public static final String MILES = "miles";

        public static final String VALUE_CLOSED = "CLOSED";

        public static final String VALUE_LOW = "LOW";
    }

    public static class WAKEUP_TIMER {
        private WAKEUP_TIMER() {
            // No instance
        }

        public static final String RECEIVING_SCHEDULE_ACCEPTANCE_WINDOW = "RECEIVING_SCHEDULE_ACCEPTANCE_WINDOW";

        public static JsonObject getWakeupTimerCreationJsonBody(JlrAuthToken swuToken,
                                                                Date timerDate) {
            JsonObject dataObject = new JsonObject();
            dataObject.addProperty(SERVICE_COMMAND, "START");
            dataObject.addProperty("startTime", timerDate.getTime());
            dataObject.addProperty(TOKEN, swuToken.getToken());

            return dataObject;
        }

        public static JsonObject getWakeupTimerDeletionJsonBody(JlrAuthToken swuToken) {
            JsonObject dataObject = new JsonObject();
            dataObject.addProperty(SERVICE_COMMAND, "END");
            dataObject.addProperty(TOKEN, swuToken.getToken());

            return dataObject;
        }

    }

    public static class VEHICLE {

        private VEHICLE() {
            // No instance
        }

        public static final String IS_CRASH_SITUATION = "IS_CRASH_SITUATION";

        public static final String EV_STATE_OF_CHARGE = "EV_STATE_OF_CHARGE";

        public static final String EV_RANGE_ON_BATTERY_KM = "EV_RANGE_ON_BATTERY_KM";

        public static final String EV_RANGE_ON_BATTERY_MILES = "EV_RANGE_ON_BATTERY_MILES";

        public static final String DOOR_IS_ALL_DOORS_LOCKED = "DOOR_IS_ALL_DOORS_LOCKED";

        public static final String WINDOW_REAR_RIGHT_STATUS = "WINDOW_REAR_RIGHT_STATUS";

        public static final String WINDOW_FRONT_RIGHT_STATUS = "WINDOW_FRONT_RIGHT_STATUS";

        public static final String WINDOW_REAR_LEFT_STATUS = "WINDOW_REAR_LEFT_STATUS";

        public static final String WINDOW_FRONT_LEFT_STATUS = "WINDOW_FRONT_LEFT_STATUS";

        public static final String EV_CHARGING_STATUS = "EV_CHARGING_STATUS";

        public static final String EV_PRECONDITION_OPERATING_STATUS = "EV_PRECONDITION_OPERATING_STATUS";

        public static final String EV_MINUTES_TO_FULLY_CHARGED = "EV_MINUTES_TO_FULLY_CHARGED";

        public static final String EV_CHARGING_RATE_SOC_PER_HOUR = "EV_CHARGING_RATE_SOC_PER_HOUR";

        public static final String VEHICLE_STATE_TYPE = "VEHICLE_STATE_TYPE";

        public static final String EV_PRECONDITION_PRIORITY_SETTING = "EV_PRECONDITION_PRIORITY_SETTING";

        public static final String TYRE_PRESSURE_FRONT_LEFT = "TYRE_PRESSURE_FRONT_LEFT";

        public static final String TYRE_PRESSURE_FRONT_RIGHT = "TYRE_PRESSURE_FRONT_RIGHT";

        public static final String TYRE_PRESSURE_REAR_LEFT = "TYRE_PRESSURE_REAR_LEFT";

        public static final String TYRE_PRESSURE_REAR_RIGHT = "TYRE_PRESSURE_REAR_RIGHT";

        public static final String TYRE_STATUS_REAR_LEFT = "TYRE_STATUS_REAR_LEFT";

        public static final String TYRE_STATUS_FRONT_LEFT = "TYRE_STATUS_FRONT_LEFT";

        public static final String TYRE_STATUS_FRONT_RIGHT = "TYRE_STATUS_FRONT_RIGHT";

        public static final String TYRE_STATUS_REAR_RIGHT = "TYRE_STATUS_REAR_RIGHT";

        public static final String EV_CHARGING_RATE_MILES_PER_HOUR = "EV_CHARGING_RATE_MILES_PER_HOUR";

        public static final String EV_CHARGING_RATE_KM_PER_HOUR = "EV_CHARGING_RATE_KM_PER_HOUR";

        public static final String EV_RANGE_VSC_REVISED_HV_BATT_ENERGY_100 = "EV_RANGE_VSC_REVISED_HV_BATT_ENERGYx100";

        public static final String EV_RANGE_VSC_INITIAL_HV_BATT_ENERGY_100 = "EV_RANGE_VSC_INITIAL_HV_BATT_ENERGYx100";

        public static final String EXT_KILOMETERS_TO_SERVICE = "EXT_KILOMETERS_TO_SERVICE";

        public static final String ODOMETER_METER = "ODOMETER_METER";

        public static final String ODOMETER_MILES = "ODOMETER_MILES";

        public static final String BATTERY_VOLTAGE = "BATTERY_VOLTAGE";

        public static final String TU_STATUS_IMEI = "TU_STATUS_IMEI";

        public static final String TU_STATUS_PRIMARY_CHARGE_PERCENT = "TU_STATUS_PRIMARY_CHARGE_PERCENT";

        public static final String TU_STATUS_SW_VERSION_MAIN = "TU_STATUS_SW_VERSION_MAIN";

        public static final String TU_STATUS_SW_VERSION_CONFIG = "TU_STATUS_SW_VERSION_CONFIG";

        public static final String WASHER_FLUID_WARN = "WASHER_FLUID_WARN";

        public static final String BRAKE_FLUID_WARN = "BRAKE_FLUID_WARN";

        public static final String ENG_COOLANT_LEVEL_WARN = "ENG_COOLANT_LEVEL_WARN";

        public static final String EV_PRECONDITION_REMAINING_RUNTIME_MINUTES = "EV_PRECONDITION_REMAINING_RUNTIME_MINUTES";

        public static final String THEFT_ALARM_STATUS = "THEFT_ALARM_STATUS";

        public static final String EV_BATTERY_PRECONDITIONING_STATUS = "EV_BATTERY_PRECONDITIONING_STATUS";

        public static final String PRIVACY_SWITCH = "PRIVACY_SWITCH";

        public static final String TRANSPORT_MODE_STOP = "TRANSPORT_MODE_STOP";

        public static final String SERVICE_MODE_STOP = "SERVICE_MODE_STOP";

    }

    public static class SERVICE {
        private SERVICE() {
            // No instance
        }

        public static final String SERVICE_ECC = "ECC";

        public static final String SERVICE_VHS = "VHS";

        public static final String SERVICE_CP = "CP";

        public static final String SERVICE_RDL = "RDL";

        public static final String SERVICE_RDU = "RDU";

        public static final String SERVICE_SWU = "SWU";

        public static final String SERVICE_HBLF = "HBLF";

        public static final String SERVICE_PROV = "PROV";

        public static final String SERVICE_GM = "GM";

        public static final String SERVICE_STATUS_SUCCESS = "Successful";

        public static final String SERVICE_FAILURE_ALREADY_RUNNING = "serviceAlreadyRunning";


        public static JsonObject getUnprotectedServiceAuthenticationJsonBody(String service) {
            JsonObject authObj = new JsonObject();
            authObj.addProperty("serviceName", service);
            authObj.addProperty("pin", "");

            return authObj;
        }

        public static JsonObject getPrivilegedServiceAuthenticationJsonBody(String service,
                                                                            String pin) {
            JsonObject authObj = new JsonObject();
            authObj.addProperty("serviceName", service);
            authObj.addProperty("pin", pin);

            return authObj;
        }

        public static JsonObject getGenericTokenBody(JlrAuthToken token) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(TOKEN, token.getToken());

            return jsonObject;
        }

        public static JsonObject getVehicleAttributesBody(String regNumber, String name) {
            JsonObject data = new JsonObject();
            data.addProperty("nickname", name);
            data.addProperty("registrationNumber", regNumber);
            return data;
        }

        public static JsonObject getServiceParametersFromResponse(String serviceParameters) {
            return new JsonParser().parse(serviceParameters).getAsJsonObject();
        }

        public static JsonObject getPrivacyModeToggleBody(boolean wantServiceMode,
                                                          JlrAuthToken token) {
            JsonObject serviceObj = new JsonObject();
            serviceObj.addProperty(TOKEN, token.getToken());
            String serviceCommand = "privacySwitch_off";
            if (wantServiceMode) {
                serviceCommand = "privacySwitch_on";
            }
            serviceObj.addProperty(SERVICE_COMMAND, serviceCommand);
            serviceObj.addProperty("startTime", (String) null);
            serviceObj.addProperty(API.END_TIME, (String) null);

            return serviceObj;
        }

        public static JsonObject getTransportModeBody(long expirationTime, JlrAuthToken token) {
            JsonObject serviceObj = new JsonObject();
            serviceObj.addProperty(TOKEN, token.getToken());
            serviceObj.addProperty(SERVICE_COMMAND, "protectionStrategy_transportMode");
            serviceObj.addProperty(API.END_TIME, expirationTime);

            return serviceObj;
        }

        public static JsonObject getServiceModeBody(long expirationTime, JlrAuthToken token) {
            JsonObject serviceObj = new JsonObject();
            serviceObj.addProperty(TOKEN, token.getToken());
            serviceObj.addProperty(SERVICE_COMMAND, "protectionStrategy_serviceMode");
            serviceObj.addProperty(API.END_TIME, expirationTime);

            return serviceObj;
        }

        @Nullable
        public static String parseServiceIdentifierFromUri(String uriString) {
            if (uriString.length() <= 100) {
                String pattern = "(\\d+_\\d+_\\d+_@\\S+)";
                // Create a Pattern object
                Pattern re = Pattern.compile(pattern);

                // Now create matcher object.
                Matcher m = re.matcher(uriString);
                if (m.find()) {
                    return m.group(0);
                }
            }

            return null;
        }

        public static List<Integer> getDepartureTimerIndicesFromServiceParameter(ServiceParameter serviceParameter) {
            List<Integer> indices = new ArrayList<>();
            if (serviceParameter.getKey().equals(DEPARTURES.DEPARTURETIMER_SETTINGS) &&
                    serviceParameter.getValue() != null) {
                // parse out service index.
                JsonObject data = serviceParameter.getValue();
                JsonArray timers = data.getAsJsonArray(TIMERS);
                for (JsonElement timer : timers) {
                    JsonObject timerObj = timer.getAsJsonObject();
                    indices.add(timerObj.get(TIMER_INDEX).getAsInt());
                }
            }

            return indices;
        }
    }

    public static class AUTH {
        private AUTH() {
            // No instance
        }

        public static JsonObject getAuthJsonBody(String username, String password) {

            JsonObject authObj = new JsonObject();
            authObj.addProperty("username", username);
            authObj.addProperty("password", password);
            authObj.addProperty("grant_type", "password");

            return authObj;
        }


        public static JsonObject getTokenRefreshJsonBody(String refreshToken) {
            JsonObject authObj = new JsonObject();
            authObj.addProperty("grant_type", "refresh_token");
            authObj.addProperty("refresh_token", refreshToken);

            return authObj;
        }
    }

    public static class DEPARTURES {
        private DEPARTURES() {
            // No instance
        }

        public static final String DEPARTURETIMER_SETTINGS = "DEPARTURETIMER_SETTINGS";

        public static JsonObject getDepartureDeleteJsonBody(JlrAuthToken authToken,
                                                            List<DepartureTimer> departureTimers) {
            JsonObject dataObject = new JsonObject();

            JsonObject departureTimerSetting = new JsonObject();
            JsonArray departureTimersArray = new JsonArray();
            for (DepartureTimer departureTimer : departureTimers) {
                JsonObject departureEntry = new JsonObject();
                departureEntry.addProperty(TIMER_INDEX, departureTimer.getTimerIndex());
                departureTimersArray.add(departureEntry);
            }

            departureTimerSetting.add(TIMERS, departureTimersArray);

            dataObject.addProperty(TOKEN, authToken.getToken());
            dataObject.add("departureTimerSetting", departureTimerSetting);

            return dataObject;
        }

        public static JsonObject createSingleDepartureTimer(JlrAuthToken authToken, int year,
                                                            int month, int day,
                                                            int hour, int minute) {
            // Single Day target
            JsonObject singleDay = new JsonObject();
            JsonObject singleDayParams = new JsonObject();
            singleDayParams.addProperty("day", day);
            singleDayParams.addProperty("month", month);
            singleDayParams.addProperty("year", year);
            singleDay.add("singleDay", singleDayParams);

            return createDepartureTimer(authToken, hour, minute, 50, singleDay);
        }

        public static JsonObject createRepeatedDepartureTimer(JlrAuthToken authToken, int hour,
                                                              int minute, boolean monday,
                                                              boolean tuesday,
                                                              boolean wednesday,
                                                              boolean thursday,
                                                              boolean friday,
                                                              boolean saturday,
                                                              boolean sunday) {
            JsonObject repeatSchedule = new JsonObject();
            JsonObject repeatScheduleParams = new JsonObject();
            repeatScheduleParams.addProperty("monday", monday);
            repeatScheduleParams.addProperty("tuesday", tuesday);
            repeatScheduleParams.addProperty("wednesday", wednesday);
            repeatScheduleParams.addProperty("thursday", thursday);
            repeatScheduleParams.addProperty("friday", friday);
            repeatScheduleParams.addProperty("saturday", saturday);
            repeatScheduleParams.addProperty("sunday", sunday);
            repeatSchedule.add("repeatSchedule", repeatScheduleParams);

            return createDepartureTimer(authToken, hour, minute, 50, repeatSchedule);
        }

        private static JsonObject createDepartureTimer(JlrAuthToken authToken, int hour, int minute,
                                                       int index, JsonObject timerTarget) {
            // Token
            JsonObject data = new JsonObject();
            data.addProperty(TOKEN, authToken.getToken());

            // Departure Time
            JsonObject departureTime = new JsonObject();
            departureTime.addProperty("hour", hour);
            departureTime.addProperty("minute", minute);

            // TimerType
            JsonObject timerType = new JsonObject();
            timerType.addProperty(API_KEY, "BOTHCHARGEANDPRECONDITION");
            timerType.addProperty(API_VALUE, true);

            // Timers
            JsonArray timers = new JsonArray();

            // Timer Entry
            JsonObject timer = new JsonObject();
            timer.add("departureTime", departureTime);
            timer.addProperty(TIMER_INDEX, index);
            timer.add("timerTarget", timerTarget);
            timer.add("timerType", timerType);

            timers.add(timer);

            // departureTimerSetting
            JsonObject departureTimerSetting = new JsonObject();
            departureTimerSetting.add(TIMERS, timers);

            data.add("departureTimerSetting", departureTimerSetting);

            return data;
        }

        public static List<Integer> getDepartureDeletionIndicesFromServiceStatus(ServiceStatusResponse serviceStatusResponse) {
            List<Integer> departureTimerDeletionServiceIdentifiers = new ArrayList<>();
            if (serviceStatusResponse.getServiceType().equals(InControlApi.SERVICE.SERVICE_CP)) {
                List<ServiceParameter> params = serviceStatusResponse.getServiceParameters();
                for (ServiceParameter param : params) {
                    if (param.getKey().equals(InControlApi.DEPARTURES.DEPARTURETIMER_SETTINGS)) {
                        // a departure timer related service is active.
                        JsonObject departureTimerObj = param.getValue();
                        JsonArray timersArray = departureTimerObj.getAsJsonArray(TIMERS);
                        for (JsonElement timerElement : timersArray) {
                            // Departure timer deletion is indicated by
                            // departureTimerDefinition being null
                            JsonObject timerElementObj = timerElement.getAsJsonObject();
                            if (timerElementObj.get("departureTimerDefinition").isJsonNull()) {
                                // Parse timer index
                                int timerIndex = timerElementObj.get(TIMER_INDEX).getAsInt();
                                departureTimerDeletionServiceIdentifiers.add(timerIndex);
                            }
                        }
                    }
                }
            }

            return departureTimerDeletionServiceIdentifiers;
        }
    }

    public static class GUARDIAN_MODE {
        private GUARDIAN_MODE() {
        }

        public static final String GUARDIAN_MODE_STATUS = "status";

        public static JsonObject getGuardianModeEnableObject(long expirationTime,
                                                             JlrAuthToken authToken) {
            JsonObject data = new JsonObject();
            data.addProperty(TOKEN, authToken.getToken());
            data.addProperty(GUARDIAN_MODE_STATUS, Status.ACTIVE.toString());
            data.addProperty(API.END_TIME, expirationTime);

            return data;
        }
    }

    public static class CHARGING {
        private CHARGING() {
            // No instance
        }

        public static final String CHARGING_STATE_CHARGING = "CHARGING";
        public static final String CHARGING_STATE_PAUSED = "PAUSED";
        public static final String CHARGING_STATE_FULLY_CHARGED = "FULLYCHARGED";
        public static final String CHARGING_STATE_FAULT = "FAULT";
        public static final String CHARGING_STATE_WAITING_TO_CHARGE = "WAITINGTOCHARGE";
        public static final String CHARGING_STATE_INITIALIZATION = "INITIALIZATION";
        public static final String CHARGING_STATE_UNKNOWN = "UNKNOWN";
        public static final String CHARGING_STATE_NO_MESSAGE = "No Message";
        public static final String CHARGE_NOW_SETTING = "CHARGE_NOW_SETTING";
        public static final String CHARGE_FORCE_OFF = "FORCE_OFF";
        static final String CHARGE_FORCE_ON = "FORCE_ON";

        public static JsonObject getChargingToggleJsonBody(JlrAuthToken authToken,
                                                           boolean wantStop) {
            // Token
            JsonObject data = new JsonObject();
            data.addProperty(TOKEN, authToken.getToken());

            // serviceParameters
            JsonArray serviceParameters = new JsonArray();

            JsonObject chargeNowSetting = new JsonObject();
            chargeNowSetting.addProperty(API_KEY, CHARGE_NOW_SETTING);
            if (wantStop) {
                chargeNowSetting.addProperty(API_VALUE, CHARGE_FORCE_OFF);
            } else {
                chargeNowSetting.addProperty(API_VALUE, CHARGE_FORCE_ON);
            }

            serviceParameters.add(chargeNowSetting);

            data.add("serviceParameters", serviceParameters);

            return data;
        }
    }

    public static class CONTACT {
        private CONTACT() {

        }

        public static final String SECURE_VEHICLE_TRACKER = "SVT";
        public static final String TYPE_PHONE_NUMBER = "PHONENUMBER";
    }

    public static class PRECONDITIONING {
        private PRECONDITIONING() {
            // No instance
        }

        public static final String PRIORITIZE_RANGE = "PRIORITIZE_RANGE";
        public static final String PRIORITIZE_COMFORT = "PRIORITIZE_COMFORT";
        public static final String PRECONDITIONING_UNKNOWN = "UNKNOWN";
        public static final String PRECONDITIONING_STATUS_PRECLIM = "PRECLIM";

        public static JsonObject getPreconditioningJsonBody(JlrAuthToken authToken,
                                                            boolean startPreconditioning,
                                                            float temperature) {
            JsonObject dataObject = new JsonObject();
            JsonArray serviceParameters = new JsonArray();
            JsonObject preconditioningParams = new JsonObject();
            preconditioningParams.addProperty(API_KEY, "PRECONDITIONING");
            if (startPreconditioning) {
                preconditioningParams.addProperty(API_VALUE, "START");
            } else {
                preconditioningParams.addProperty(API_VALUE, "STOP");
            }
            serviceParameters.add(preconditioningParams);
            if (startPreconditioning) {
                JsonObject targetTemperature = new JsonObject();
                targetTemperature.addProperty(API_KEY, "TARGET_TEMPERATURE_CELSIUS");
                targetTemperature.addProperty(API_VALUE,
                        convertTemperatureFloatToApiString(temperature));
                serviceParameters.add(targetTemperature);
            }

            dataObject.addProperty(TOKEN, authToken.getToken());
            dataObject.add("serviceParameters", serviceParameters);

            return dataObject;
        }

        private static String convertTemperatureFloatToApiString(float temperature) {
            double roundedTemperature = Math.round(temperature * 2) / 2.0;
            String temperatureString = String.valueOf(roundedTemperature);
            return temperatureString.replace(".", "");
        }

    }
}

