package org.example.asterixapi.service;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@RequiredArgsConstructor

public class IdService {
    public String randomId() {
        return UUID.randomUUID().toString();
    }
}
