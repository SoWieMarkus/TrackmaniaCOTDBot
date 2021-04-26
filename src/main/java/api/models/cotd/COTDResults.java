package api.models.cotd;

import api.models.player.Player;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class COTDResults {

    @SerializedName("results")
    private List<Player> players;

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
