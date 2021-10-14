package api.models.dto;

import api.models.cotd.COTDPlayerResult;
import api.models.player.Player;
import com.google.gson.Gson;

public class PlayerResultDTO {

    private String accountId;
    private String accountName;
    private String zone;
    private int rank;

    public PlayerResultDTO(COTDPlayerResult cotdPlayerResult) {
        this.accountId = cotdPlayerResult.getPlayer().getId();
        this.accountName = cotdPlayerResult.getPlayer().getName();
        this.rank = cotdPlayerResult.getPosition();
        this.zone = new Gson().toJson(cotdPlayerResult.getPlayer().getZone());
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
