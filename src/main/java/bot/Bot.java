package bot;

import api.TrackmaniaIOApi;
import api.models.Competition;
import api.models.cotd.COTD;
import api.models.dto.COTDDTO;
import api.models.player.Player;

import java.util.List;

public class Bot {

    public static void main(String[] args){
        TrackmaniaIOApi ioApi = new TrackmaniaIOApi();

        List<Competition> competitions = ioApi.getRecentCompetitions(10);
        int x = 0;

        COTD cotd = ioApi.getCotd(competitions.get(1).getId());
        List<Player> results = ioApi.getResultsOfCup(competitions.get(1).getId(), cotd.getRounds().get(0).getMatches().get(0).getId());
        int y = 0;

        COTDDTO cotddto = new COTDDTO(competitions.get(1), cotd, results);
        int z  = 0;

        /*Thread thread = new Thread(){

            @Override
            public void run() {
                super.run();
                for (int i = 0; i < competitions.size(); i++) {
                    COTD cotd = ioApi.getCotd(competitions.get(i).getId());
                    if (cotd.getRounds() == null || cotd.getRounds().isEmpty() || !cotd.getRounds().get(0).isCompleted()) continue;
                    List<Player> results = ioApi.getResultsOfCup(competitions.get(i).getId(), cotd.getRounds().get(0).getMatches().get(0).getId());
                    COTDDTO cotddto = new COTDDTO(competitions.get(i), cotd, results);
                    ioApi.sendDataToMyRestAPI(cotddto);
                    System.out.println(i);
                    try {
                        sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int x  =0;
            }


        };
        thread.start();*/


        //.sendDataToMyRestAPI(cotddto);
        //ioApi.sendDataToMyRestAPI(cotddto);
        x = 1;


    }

}
