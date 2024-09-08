package com.mpt.journal.service;

import com.mpt.journal.model.JobModel;
import com.mpt.journal.entity.JobEntity;
import java.util.List;

public interface JobService {
    public List<JobModel> findAllJob();
    public JobModel findJobById(int id);
    public JobModel addJob(JobModel job);
    public JobModel updateJob(JobModel job);
    public void deleteJob(int id);
}
