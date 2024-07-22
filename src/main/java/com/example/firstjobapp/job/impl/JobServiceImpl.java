package com.example.firstjobapp.job.impl;

import com.example.firstjobapp.job.Job;
import com.example.firstjobapp.job.JobRepository;
import com.example.firstjobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

//    private List<Job> jobRepository = new ArrayList<>();
    JobRepository jobRepository;
    private Long nextId  = 1L;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }


    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
      jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try{
         jobRepository.deleteById(id);
         return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        if(jobRepository.findById(id).isPresent()){
            Job job = jobRepository.findById(id).get();
                job.setTitle(updatedJob.getTitle());
                job.setDescription((updatedJob.getDescription()));
                job.setSalary(updatedJob.getSalary());
                jobRepository.save(job);
                return true;
        }
        return false;
    }


}
