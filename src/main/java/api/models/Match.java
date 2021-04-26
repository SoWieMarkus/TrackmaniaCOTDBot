package api.models;

import com.google.gson.annotations.SerializedName;

public class Match {
    @SerializedName("id")
    private long id;

    @SerializedName("name")
    private String name;

    @SerializedName("completed")
    private boolean completed;

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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
