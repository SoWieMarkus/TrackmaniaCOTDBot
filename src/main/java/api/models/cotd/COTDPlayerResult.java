package api.models.cotd;

import api.models.player.Player;
import com.google.gson.annotations.SerializedName;

public class COTDPlayerResult {

    @SerializedName("player")
    private Player player;

    private int position;
    private int score;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
