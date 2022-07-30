package ru.devmark.example.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.devmark.example.model.MyRecord;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

@Service
public class HighloadService {

    @Cacheable(cacheNames = "recordsCache", key = "#recordId")
    public MyRecord getOrCreateRecord(int recordId) {
        try {
            TimeUnit.SECONDS.sleep(3);
            // запись будет создана в кеше только 1 раз
            return new MyRecord(recordId, LocalTime.now());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @CachePut(cacheNames = "recordsCache", key = "#recordId")
    public MyRecord createOrUpdateRecord(int recordId) {
        // запись будет создаваться (обновляться) в кеше каждый раз
        return new MyRecord(recordId, LocalTime.now());
    }

    @CacheEvict(cacheNames = "recordsCache", key = "#recordId")
    public void deleteRecord(int recordId) {
        // запись будет удалена из кеша
    }
}
