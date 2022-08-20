package com.amboiko;

import java.time.LocalDateTime;

public class Record {
    private final int id;
    private final LocalDateTime date;

    public Record(int id) {
        this.id = id;
        date = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Record{" + "id=" + id + "}";
    }
}
