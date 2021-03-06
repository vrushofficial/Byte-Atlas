package com.bytes.atlas.service;


import com.bytes.atlas.model.Analysis;
import com.bytes.atlas.model.Project;

import java.util.List;
import java.util.Optional;


public interface ProjectService {
	public Project save(Project project);

	public Optional<Project> getByKey(String projectKey);

	public List<Project> getAll();

	public List<Analysis> getHistoryByKey(String key);
}
