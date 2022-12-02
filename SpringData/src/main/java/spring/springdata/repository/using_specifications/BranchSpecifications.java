package spring.springdata.repository.using_specifications;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import spring.springdata.entity.Branch;

public interface BranchSpecifications extends CrudRepository<Branch, Long>, JpaSpecificationExecutor<Branch> {
}
