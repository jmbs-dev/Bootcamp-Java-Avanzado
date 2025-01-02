package com.example.refactor;

import com.example.refactor.repository.FileSongRepository;
import com.example.refactor.service.SongProcessor;

public class Solution {
    public static void main(String... args) {
        SongProcessor songProcessor = new SongProcessor(new FileSongRepository());
        songProcessor.processAll();
    }
}
