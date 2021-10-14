package api.models.cotd;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class COTDResults {

    @SerializedName("results")
    private List<COTDPlayerResult> players;

    public List<COTDPlayerResult> getPlayers() {
        return players;
    }

    public void setPlayers(List<COTDPlayerResult> players) {
        this.players = players;
    }
}
