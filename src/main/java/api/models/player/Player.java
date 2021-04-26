package api.models.player;

import com.google.gson.annotations.SerializedName;

public class Player {

    @SerializedName(value = "accountId", alternate = {"accountid"})
    private String accountId;

    @SerializedName(value = "displayName", alternate = {"displayname"})
    private String displayName;

    @SerializedName("zone")
    private Zone zone;

    @SerializedName("position")
    private int position;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
