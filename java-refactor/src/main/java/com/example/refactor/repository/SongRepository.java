package com.example.refactor.repository;

import com.example.refactor.model.Song;

import java.util.List;

public interface SongRepository {
    List<Song> findAll();
}
