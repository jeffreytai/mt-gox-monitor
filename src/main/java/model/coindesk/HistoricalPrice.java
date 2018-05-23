package model.coindesk;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class HistoricalPrice {
    @SerializedName("bpi")
    private Map<String, Double> bpi;

    @SerializedName("disclaimer")
    private String disclaimer;

    @SerializedName("time")
    private ResponseTime time;

    public Map<String, Double> getBpi() {
        return bpi;
    }

    public void setBpi(Map<String, Double> bpi) {
        this.bpi = bpi;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public ResponseTime getTime() {
        return time;
    }

    public void setTime(ResponseTime time) {
        this.time = time;
    }
}
