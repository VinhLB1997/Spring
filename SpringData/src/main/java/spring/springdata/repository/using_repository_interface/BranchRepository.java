package spring.springdata.repository.using_repository_interface;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import spring.springdata.entity.Branch;

public interface BranchRepository extends CrudRepository<Branch,Long>, PagingAndSortingRepository<Branch,Long>{
}
