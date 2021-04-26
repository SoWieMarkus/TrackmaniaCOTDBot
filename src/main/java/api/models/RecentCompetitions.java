package api.models;

import java.util.List;

public class RecentCompetitions {
    private List<Competition> competitions;

    public List<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<Competition> competitions) {
        this.competitions = competitions;
    }
}
