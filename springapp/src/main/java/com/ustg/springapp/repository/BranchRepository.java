package com.ustg.springapp.repository;

import com.ustg.springapp.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BranchRepository extends JpaRepository<Branch,Long> {
    public Optional<Branch> findByBranchName(String branchName);
}

