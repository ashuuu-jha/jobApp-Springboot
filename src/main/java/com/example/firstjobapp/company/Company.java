package com.example.firstjobapp.company;

import com.example.firstjobapp.job.Job;
import com.example.firstjobapp.job.JobRepository;
import com.example.firstjobapp.job.JobService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
public class Company {

      @jakarta.persistence.Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long Id;
      private String name;
      private String description;

      @JsonIgnore
      @OneToMany(mappedBy = "company")
      private List<Job> jobs;

      public Company() {
      }

      public Company(Long id, String name, String description, List<Job> jobs) {
            Id = id;
            this.name = name;
            this.description = description;
            this.jobs = jobs;
      }
}
