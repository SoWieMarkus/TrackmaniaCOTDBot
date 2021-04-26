package api;

import api.models.Competition;
import api.models.RecentCompetitions;
import api.models.cotd.COTD;
import api.models.cotd.COTDResults;
import api.models.dto.COTDDTO;
import api.models.player.Player;

import java.util.ArrayList;
import java.util.List;

public class TrackmaniaIOApi {

    private static final String BASE_URL = "https://trackmania.io/api/";

    private static final String COTD = "cotd/";
    private static final String COMP = "comp/";

    public List<Competition> getRecentCompetitions(int amount) {
        List<Competition> competitions = new ArrayList<>();
        String url = BASE_URL + COTD + "/";

        for (int i = 0; i < amount; i++) {
            String partUrl = url + i;
            competitions.addAll(new GetRequest<>(RecentCompetitions.class, partUrl).execute().getCompetitions());
        }
        return competitions;
    }

    public List<Player> getResultsOfCup(long competitionId, long matchId) {
        List<Player> cotdResults = new ArrayList<>();
        String url = BASE_URL + COMP + "/" + competitionId + "/results/" + matchId + "/";
        for (int i = 0; i < 4; i++) {
            String partUrl = url + i;
            cotdResults.addAll(new GetRequest<>(COTDResults.class, partUrl).execute().getPlayers());
        }
        return cotdResults;
    }

    public COTD getCotd(long competitionId) {
        String url = BASE_URL + COMP + "/" + competitionId;
        return new GetRequest<>(COTD.class, url).execute();
    }

    public void sendDataToMyRestAPI(COTDDTO cotddto) {
        PostRequest<COTDDTO> postRequest = new PostRequest<>("http://localhost:8080/cotd/update/" + cotddto.getYear() + "/" + cotddto.getMonth() + "/" + cotddto.getDay(), cotddto);
        postRequest.execute();
    }


}
