package api.models.player;

import com.google.gson.annotations.SerializedName;

public class Player {

    @SerializedName(value = "id")
    private String id;

    @SerializedName(value = "name")
    private String name;

    @SerializedName(value="zone")
    private Zone zone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }
}
