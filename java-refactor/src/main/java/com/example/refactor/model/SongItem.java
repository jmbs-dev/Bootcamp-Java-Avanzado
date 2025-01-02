package com.example.refactor.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SongItem {
    private Song track;
    @JsonProperty("added_by")
    private User addedBy;
}
