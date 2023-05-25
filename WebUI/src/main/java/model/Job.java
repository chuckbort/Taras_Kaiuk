package model;

import lombok.Data;

import java.util.Map;

@Data
public class Job {
    private String jobTitle;
    private String jobDescription;
    private String notes;

    public Job(Map<String, String> jobData){
        this.jobTitle = jobData.get("Job title");
        this.jobDescription = jobData.get("Job description");
        this.notes = jobData.get("Job notes");
    }
}
