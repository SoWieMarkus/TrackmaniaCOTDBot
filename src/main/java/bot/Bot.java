package bot;

import api.TrackmaniaIOApi;
import api.models.Competition;
import api.models.cotd.COTD;
import api.models.dto.COTDDTO;
import api.models.player.Player;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Bot {

    public static void main(String[] args) {
        TrackmaniaIOApi ioApi = new TrackmaniaIOApi();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    System.out.println(new Date().toString() + ": Searching ..." );
                    List<Competition> competitions = ioApi.getRecentCompetitions(1);
                    COTD cotd = ioApi.getCotd(competitions.get(0).getId());
                    if (cotd.getRounds() == null || cotd.getRounds().isEmpty() || !cotd.getRounds().get(0).isCompleted())
                        return;
                    List<Player> results = ioApi.getResultsOfCup(competitions.get(0).getId(), cotd.getRounds().get(0).getMatches().get(0).getId());
                    COTDDTO cotddto = new COTDDTO(competitions.get(0), cotd, results);
                    ioApi.sendDataToMyRestAPI(cotddto);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 10 * 60 * 1000L);
    }


}
