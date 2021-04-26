package api.models.cotd;

import api.models.Round;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class COTD {
    @SerializedName("name")
    private String name;

    @SerializedName(value = "startDate", alternate = {"startdate"})
    private long startDate;

    @SerializedName(value = "endDate", alternate = {"enddate"})
    private long endDate;

    @SerializedName("leaderboardid")
    private long leaderBoardId;

    @SerializedName("rounds")
    private List<Round> rounds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public long getLeaderBoardId() {
        return leaderBoardId;
    }

    public void setLeaderBoardId(long leaderBoardId) {
        this.leaderBoardId = leaderBoardId;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }
}
