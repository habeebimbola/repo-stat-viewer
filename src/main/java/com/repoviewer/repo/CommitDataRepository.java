package com.repoviewer.repo;

import com.repoviewer.domain.CommitData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommitDataRepository extends JpaRepository<CommitData, Integer> {
}
