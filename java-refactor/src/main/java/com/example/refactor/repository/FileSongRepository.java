package com.example.refactor.repository;

import com.example.refactor.model.Song;
import com.example.refactor.model.SongItem;
import com.example.refactor.config.PropertyFactory;
import com.example.refactor.utils.ExampleFileUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileSongRepository implements SongRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileSongRepository.class);
    private static final String playlistFileName = PropertyFactory.getProperties().getProperty("refactorpractice.playlist.filename");

    private final ObjectMapper objectMapper;

    public FileSongRepository() {
        ObjectMapper objectMapper = new ObjectMapper();
        this.objectMapper = objectMapper;
    }

    @Override
    public List<Song> findAll() {
        try {
            final File inputSource = ExampleFileUtils.getFileFromResources(playlistFileName);
            JSONObject json = ExampleFileUtils.getJsonFromFile(inputSource);
            return objectMapper.readValue(json.get("items").toString(), new TypeReference<List<SongItem>>(){})
                    .stream().map(s -> s.getTrack()).collect(Collectors.toList());
        } catch(Exception e) {
            LOGGER.error("Error while deserializing Song from source", e);
            return Collections.emptyList();
        }
    }
}
