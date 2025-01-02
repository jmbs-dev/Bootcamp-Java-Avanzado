package com.example.refactor.service;

import com.example.refactor.model.Song;
import com.example.refactor.repository.SongRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SongProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(SongProcessor.class);
    private final SongRepository songRepository;

    public SongProcessor(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public void processAll() {
        songRepository.findAll().parallelStream().forEach(this::process);
    }

    private void process(Song song) {
        LOGGER.info(" - {} - {} - {} - {}", song.getId(), song.getName(),
                song.getArtists().toString(), song.getAlbum().getName());
    }
}
