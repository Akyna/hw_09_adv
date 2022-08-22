package com.amboiko;

public class Record {
    private final int id;

    public Record(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Record{" + "id=" + id + "}";
    }
}
