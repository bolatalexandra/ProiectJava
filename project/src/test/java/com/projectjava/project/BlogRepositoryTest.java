package com.projectjava.project;

import com.projectjava.project.model.Blog;
import com.projectjava.project.repository.BlogRepository;
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
public class BlogRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BlogRepository repo;

//    @Test
//    public void testCreateBlog() {
//        Blog blog = new Blog();
//        blog.setName("Junior Tester");
//        blog.setDescription("Test Test Test");
//        blog.setUsername("bolat.alexandra@gmail.com");
//
//        Blog savedBlog = repo.save(blog);
//
//        Blog existBlog = entityManager.find(Blog.class, savedBlog.getId());
//
//        assertThat(blog.getName()).isEqualTo(existBlog.getName());
//
//
//    }
}
