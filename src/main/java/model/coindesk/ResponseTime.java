package model.coindesk;

import com.google.gson.annotations.SerializedName;

public class ResponseTime {
    @SerializedName("updated")
    private String updated;

    @SerializedName("updatedISO")
    private String updatedIso;

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getUpdatedIso() {
        return updatedIso;
    }

    public void setUpdatedIso(String updatedIso) {
        this.updatedIso = updatedIso;
    }
}
