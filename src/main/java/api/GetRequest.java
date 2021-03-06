package api;

import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetRequest<T>{

    private final Gson gson;
    private final String url;
    private final Class<T> type;

    public GetRequest(Class<T> type, String url) {
        this.url = url;
        this.gson = new Gson();
        this.type = type;
    }

    public T execute(){
        try {
            URL uri = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
            connection.addRequestProperty("User-Agent","trackmania-leaderboard-harvest-bot by SoWieMarkus (Markus#2348) https://github.com/SoWieMarkus/TrackmaniaCOTDBot");
            String result = parseResult(connection);
            return parse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private T parse(String json) {
        return gson.fromJson(json, type);
    }

    private String parseResult(HttpURLConnection connection) throws IOException {
        StringBuilder responseString = new StringBuilder();
        InputStream inputStream = new BufferedInputStream(connection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String responseLine;
        while ((responseLine = bufferedReader.readLine()) != null) {
            responseString.append(responseLine);
        }
        return responseString.toString();
    }


}
