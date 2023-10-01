package com.example.noteappsharedpreference;
import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

public class Note implements Parcelable {
    private String title;
    private String description;

    public Note(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    protected Note(Parcel in) {
        title = in.readString();
        description = in.readString();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
    }

    // Convert a Note object to a JSONObject
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("title", title);
            json.put("description", description);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    // Create a Note object from a JSONObject
    public static Note fromJson(JSONObject json) {
        try {
            String title = json.getString("title");
            String description = json.getString("description");
            return new Note(title, description);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null; // Return null on failure
    }
}
