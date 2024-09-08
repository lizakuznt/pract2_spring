package com.mpt.journal.service;

import com.mpt.journal.model.JobModel;
import com.mpt.journal.repository.InMemoryJobRepository;
import org.springframework.stereotype.Service;
import com.mpt.journal.entity.JobEntity;
import java.util.List;

@Service
public class InMemoryJobServiceImpl implements JobService {

    private final InMemoryJobRepository jobRepository;

    public InMemoryJobServiceImpl(InMemoryJobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<JobModel> findAllJob() {
        return jobRepository.findAllJobs();
    }

    @Override
    public JobModel findJobById(int id) {
        return jobRepository.findJobById(id);
    }

    @Override
    public JobModel addJob(JobModel job) {
        return jobRepository.addJob(job);
    }

    @Override
    public JobModel updateJob(JobModel job) {
        return jobRepository.updateJob(job);
    }

    @Override
    public void deleteJob(int id) {
        jobRepository.deleteJob(id);
    }
}
