package com.mpt.journal.repository;

import com.mpt.journal.model.SubModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InMemorySubRepository {
    private List<SubModel> subs = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(1); // Генерация уникального ID

    public SubModel addSub(SubModel sub) {
        sub.setId(idCounter.getAndIncrement()); // Установка уникального ID
        subs.add(sub);
        return sub;
    }

    public SubModel updateSub(SubModel sub) {
        for (int i = 0; i < subs.size(); i++) {
            if (subs.get(i).getId() == sub.getId()) {
                subs.set(i, sub);
                return sub;
            }
        }
        return null; // Студент не найден
    }

    public void deleteSub(int id) {
        subs.removeIf(job -> job.getId() == id);
    }

    public List<SubModel> findAllSubs() {
        return new ArrayList<>(subs);
    }

    public SubModel findSubById(int id) {
        return subs.stream()
                .filter(job -> job.getId() == id)
                .findFirst()
                .orElse(null);
    }
}