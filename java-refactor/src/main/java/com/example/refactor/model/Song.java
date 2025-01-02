package com.example.refactor.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
public class Song {

    private String id;
    private String name;
    private Boolean explicit;
    @JsonProperty("is_playable")
    private Boolean playable;
    private int popularity;
    @JsonProperty("album")
    private Album album;
    private List<Artist> artists;

}
