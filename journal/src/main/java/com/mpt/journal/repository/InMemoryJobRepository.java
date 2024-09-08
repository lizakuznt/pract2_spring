package com.mpt.journal.repository;

import com.mpt.journal.model.JobModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InMemoryJobRepository {
    private List<JobModel> jobs = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(1); // Генерация уникального ID

    public JobModel addJob(JobModel job) {
        job.setId(idCounter.getAndIncrement()); // Установка уникального ID
        jobs.add(job);
        return job;
    }

    public JobModel updateJob(JobModel job) {
        for (int i = 0; i < jobs.size(); i++) {
            if (jobs.get(i).getId() == job.getId()) {
                jobs.set(i, job);
                return job;
            }
        }
        return null; // Студент не найден
    }

    public void deleteJob(int id) {
        jobs.removeIf(job -> job.getId() == id);
    }

    public List<JobModel> findAllJobs() {
        return new ArrayList<>(jobs);
    }

    public JobModel findJobById(int id) {
        return jobs.stream()
                .filter(job -> job.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
