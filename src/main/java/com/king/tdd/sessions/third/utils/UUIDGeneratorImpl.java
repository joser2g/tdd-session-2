package com.king.tdd.sessions.third.utils;

import java.util.UUID;

public class UUIDGeneratorImpl implements UUIDGenerator {
    @Override
    public String generateUUID() {
        return UUID.randomUUID().toString();
    }
}
