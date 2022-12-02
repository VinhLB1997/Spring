package spring.springdata.repository.using_example;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import spring.springdata.entity.Branch;

public interface BranchExampleQuery extends CrudRepository<Branch, Long>, QueryByExampleExecutor<Branch> {
}
