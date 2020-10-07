package ru.devmark.example.model;

import java.time.LocalTime;

public class Record {

    private final int id;
    private final LocalTime creationTime;

    public Record(int id, LocalTime creationTime) {
        this.id = id;
        this.creationTime = creationTime;
    }

    public int getId() {
        return id;
    }

    public LocalTime getCreationTime() {
        return creationTime;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", creationTime=" + creationTime +
                '}';
    }
}
