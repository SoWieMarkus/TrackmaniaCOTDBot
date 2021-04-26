package api.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Round {

    @SerializedName("id")
    private long id;
    @SerializedName("name")
    private String name;

    @SerializedName("status")
    private String status;

    @SerializedName("matches")
    private List<Match> matches;

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isCompleted(){
        return status.equalsIgnoreCase("COMPLETED");
    }

}
