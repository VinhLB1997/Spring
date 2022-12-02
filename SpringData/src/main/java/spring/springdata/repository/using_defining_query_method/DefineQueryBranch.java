package spring.springdata.repository.using_defining_query_method;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;
import spring.springdata.entity.Branch;

import java.util.List;
import java.util.Optional;

public interface DefineQueryBranch extends JpaRepository<Branch, Long> {

    Optional<Branch> findByBranchCode(String branchCode);

    List<Branch> findByBranchCodeOrBranchNameAllIgnoreCase(String branchCode, String branchName, Sort sort);

    Page<Branch> queryFirst2ByDeleteFlag(Boolean deleteFlag, Pageable pageable);

    Streamable<Branch> findByBranchCodeLike(String branchCode);

    List<Branch> findAllBranchDelete(Boolean deleteFlag);

}
