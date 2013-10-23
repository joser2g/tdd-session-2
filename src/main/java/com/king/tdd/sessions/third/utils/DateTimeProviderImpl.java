package com.king.tdd.sessions.third.utils;

import java.util.Date;

public class DateTimeProviderImpl implements DateTimeProvider {
    @Override
    public Date getTime() {
        return new Date();
    }
}
