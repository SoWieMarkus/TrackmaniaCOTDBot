package api.models;

import com.google.gson.annotations.SerializedName;

public class Competition {
    @SerializedName("id")
    private long id;
    @SerializedName("name")
    private String name;
    @SerializedName("players")
    private int players;
    @SerializedName("starttime")
    private long startTime;
    @SerializedName("endtime")
    private long endTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayers() {
        return players;
    }

    public void setPlayers(int players) {
        this.players = players;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
}
