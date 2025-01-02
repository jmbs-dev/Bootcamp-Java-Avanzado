package com.example.refactor.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@Data
public class Album {
    @JsonProperty("album_type")
    private AlbumType type;
    private String href;
    private String id;
    private String name;
    @JsonProperty("release_date")
    private Date releaseDate;
    @JsonProperty("total_tracks")
    private int totalTracks;
    
    @Getter
    public enum AlbumType {
        ALBUM("album"),
        COMPILATION("compilation");

        private final String type;

        AlbumType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return type;
        }

        @JsonCreator
        public static AlbumType fromValue(String value) {
            for (AlbumType albumType : AlbumType.values()) {
                if (albumType.type.equals(value)) {
                    return albumType;
                }
            }
            throw new IllegalArgumentException("Unknown value: " + value);
        }
    }
}
