package api.models.dto;

import api.models.Competition;
import api.models.cotd.COTD;
import api.models.player.Player;

import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;
import java.util.List;

public class COTDDTO {

    private String name;

    private long id;

    private int year;
    private int month;
    private int day;

    private long startTime;
    private long endTime;
    private long leaderBoardId;
    private int players;

    private List<PlayerResultDTO> playerResultDTOS;

    public COTDDTO(Competition competition, COTD cotd, List<Player> players) {
        this.id = competition.getId();
        String date = cotd.getName().replace("Cup of the Day ", "");
        String[] dateParts = date.split("-");
        this.year = Integer.parseInt(dateParts[0]);
        this.month = Integer.parseInt(dateParts[1]);
        this.day = Integer.parseInt(dateParts[2]);
        this.startTime = competition.getStartTime();
        this.endTime = competition.getEndTime();
        this.leaderBoardId = cotd.getLeaderBoardId();
        this.players = competition.getPlayers();
        this.name = competition.getName();
        this.playerResultDTOS = new ArrayList<>();
        for (Player player :players) {
            playerResultDTOS.add(new PlayerResultDTO(player));
        }
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
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

    public long getLeaderBoardId() {
        return leaderBoardId;
    }

    public void setLeaderBoardId(long leaderBoardId) {
        this.leaderBoardId = leaderBoardId;
    }

    public int getPlayers() {
        return players;
    }

    public void setPlayers(int players) {
        this.players = players;
    }

    public List<PlayerResultDTO> getPlayerResultDTOS() {
        return playerResultDTOS;
    }

    public void setPlayerResultDTOS(List<PlayerResultDTO> playerResultDTOS) {
        this.playerResultDTOS = playerResultDTOS;
    }

}
