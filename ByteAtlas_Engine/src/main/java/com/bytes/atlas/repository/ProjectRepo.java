package com.bytes.atlas.repository;

import com.bytes.atlas.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepo extends MongoRepository<Project, String> {

    //public List<Project> findByOrderByCreatedTimeAsc();
}
