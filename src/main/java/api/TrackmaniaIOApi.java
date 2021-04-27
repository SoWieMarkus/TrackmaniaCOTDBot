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
        PostRequest<COTDDTO> postRequest = new PostRequest<>("http://85.214.165.29:8080/cotd/update/" + cotddto.getYear() + "/" + cotddto.getMonth() + "/" + cotddto.getDay(), cotddto);
        postRequest.execute();
    }

    public void init(){
        Thread thread = new Thread(){

            @Override
            public void run() {
                super.run();
                List<Competition> competitions = getRecentCompetitions(11);
                for (int i = 0; i < competitions.size(); i++) {
                    COTD cotd = getCotd(competitions.get(i).getId());
                    if (cotd.getRounds() == null || cotd.getRounds().isEmpty() || !cotd.getRounds().get(0).isCompleted()) continue;
                    List<Player> results = getResultsOfCup(competitions.get(i).getId(), cotd.getRounds().get(0).getMatches().get(0).getId());
                    COTDDTO cotddto = new COTDDTO(competitions.get(i), cotd, results);
                    sendDataToMyRestAPI(cotddto);
                    System.out.println("COTD <"+i+"> : " + ((((double)(i*5000)/(competitions.size() * 5000))*100) + "%"));



                    try {
                        sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int x = 0;
            }


        };
        thread.start();
    }


}
