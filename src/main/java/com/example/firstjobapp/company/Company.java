package com.example.firstjobapp.company;

import com.example.firstjobapp.job.Job;
import com.example.firstjobapp.job.JobRepository;
import com.example.firstjobapp.job.JobService;
import com.example.firstjobapp.review.Review;
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

      @OneToMany(mappedBy = "company")
      private List<Review> reviews;

      public Long getId() {
            return Id;
      }

      public void setId(Long id) {
            Id = id;
      }

      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
      }

      public String getDescription() {
            return description;
      }

      public void setDescription(String description) {
            this.description = description;
      }

      public List<Job> getJobs() {
            return jobs;
      }

      public void setJobs(List<Job> jobs) {
            this.jobs = jobs;
      }

      public List<Review> getReviews() {
            return reviews;
      }

      public void setReviews(List<Review> reviews) {
            this.reviews = reviews;
      }

      public Company() {
      }

      public Company(Long id, String name, String description, List<Job> jobs) {
            Id = id;
            this.name = name;
            this.description = description;
            this.jobs = jobs;
      }
}
