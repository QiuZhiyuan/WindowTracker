package com.qiu.window.tracker.entry;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TrackEntry {

    @NonNull
    private final List<TrackActionEntry> mActionEntryList = new ArrayList<>();
    @NonNull
    private final String mTrackName;

    public TrackEntry(@NonNull String trackName) {
        mTrackName = trackName;
    }

    public void addAction(@NonNull TrackActionEntry entry) {
        mActionEntryList.add(entry);
    }



    public void saveTrack() {

    }

    @Nullable
    public static TrackEntry fromJson(@NonNull JSONObject jsonObject) {
        return null;
    }
}
