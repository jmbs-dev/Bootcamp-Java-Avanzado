package com.example.refactor.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
@Data
public class Artist {
    @JsonProperty("external_urls")
    private Map<String, String> externalUrls;
    private String href;
    private String id;
    private String name;
    private String type;
    private String uri;
}
