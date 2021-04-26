package api;

import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class PostRequest<T> {

    private final Gson gson;
    private final String url;
    private final T t;

    public PostRequest(String url, T t) {
        this.url = url;
        this.gson = new Gson();
        this.t = t;
    }

    public void execute(){
        try {
            URL uri = new URL(url);
            URLConnection con = uri.openConnection();
            HttpURLConnection http = (HttpURLConnection) con;
            http.setRequestMethod("POST"); // PUT is another valid option
            http.setDoOutput(true);
            byte[] out = gson.toJson(t).getBytes(StandardCharsets.UTF_8);
            int length = out.length;

            http.setFixedLengthStreamingMode(length);
            http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            http.connect();
            try(OutputStream os = http.getOutputStream()) {
                os.write(out);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
