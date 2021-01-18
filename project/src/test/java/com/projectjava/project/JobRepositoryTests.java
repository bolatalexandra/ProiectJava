package com.projectjava.project;

import com.projectjava.project.model.Job;
import com.projectjava.project.repository.JobRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class JobRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private JobRepository repo;

    @Test
    public void testCreateJob() {
        Job job = new Job();
        job.setName("Junior Tester");
        job.setDescription("Test Test Test");
        job.setRequirements("Never struggle to identify an element. Simply hover over any element within your mobile application, inspect the attributes and determine your locator strategy with ease.");
        job.setLocation("Bucharest");
        job.setPeriod("12 luni");
        job.setUsername("bolat.alexandra@gmail.com");

        Job savedUser = repo.save(job);

        Job existJob = entityManager.find(Job.class, savedUser.getId());

        assertThat(job.getName()).isEqualTo(existJob.getName());

    }
}
