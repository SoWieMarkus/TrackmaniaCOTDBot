package api.models.dto;

import api.models.player.Player;
import com.google.gson.Gson;

public class PlayerResultDTO {

    private String accountId;
    private String accountName;
    private String zone;
    private int rank;

    public PlayerResultDTO(Player player) {
        this.accountId = player.getAccountId();
        this.accountName = player.getDisplayName();
        this.rank = player.getPosition();
        this.zone = new Gson().toJson(player.getZone());
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

}
