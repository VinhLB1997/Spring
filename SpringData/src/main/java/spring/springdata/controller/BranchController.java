package spring.springdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.springdata.entity.Branch;
import spring.springdata.repository.using_defining_query_method.DefineQueryBranch;
import spring.springdata.repository.using_entity_manager.BranchEntityManager;
import spring.springdata.repository.using_example.BranchExample;
import spring.springdata.repository.using_example.BranchExampleQuery;
import spring.springdata.repository.using_repository_interface.BranchRepository;
import spring.springdata.repository.using_specifications.BranchSpecifications;
import spring.springdata.repository.using_specifications.BranchSpecs;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/branchs")
public class BranchController {
    @Autowired
    private BranchRepository repository;
    @Autowired
    private DefineQueryBranch queryBranchRepository;
    @Autowired
    private BranchEntityManager branchEntityManager;
    @Autowired
    private BranchSpecifications branchSpecifications;

    @Autowired
    BranchExampleQuery branchExampleQuery;

    /************** Using Repository  **************/

    @GetMapping("/all")
    public Iterable<Branch> getAllBranch() {
        PageRequest page = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "id"));
        return repository.findAll(page);
    }

    /************** Using Repository QueryDSL Extention  **************/

    @GetMapping("/querydsl/all")
    public Iterable<Branch> findAllBranchQuerydsl(@Autowired Branch branch) {
        return null;
    }

    /************** Using Define Method in interface Repository  **************/

    @GetMapping("/branch-code/{branchCode}")
    public Optional<Branch> getBranchByCode(@PathVariable("branchCode") String branchCode) {
        return queryBranchRepository.findByBranchCode(branchCode);
    }

    @GetMapping("/branchCode-and-branchName/{branchCode}/{branchName}")
    public List<Branch> getBranchByCodeAndName(@PathVariable("branchCode") String branchCode, @PathVariable("branchName") String branchName) {
        Sort.TypedSort<Branch> branch = Sort.sort(Branch.class);
        Sort sort = branch.by(Branch::getBranchCode).descending()
                .and(branch.by(Branch::getBranchName).ascending());
        return queryBranchRepository.findByBranchCodeOrBranchNameAllIgnoreCase(branchCode, branchName, sort);
    }

    @GetMapping("/pagination")
    public Page<Branch> paginationBranchByDeleteFlag() {
        return queryBranchRepository.queryFirst2ByDeleteFlag(false, null);
    }

    @GetMapping("/returnStreamableType")
    public List<Branch> returnStreamableType() {
        return queryBranchRepository.findByBranchCodeLike("%BRANCH001%").stream().toList();
    }

    @GetMapping("/named-query/findAllDelete/{flag}")
    public List<Branch> findAllBranchDelete(@PathVariable("flag") Boolean flag) {
        return queryBranchRepository.findAllBranchDelete(flag);
    }

    /************** Using operations EntityManager  **************/
    @GetMapping("/{branchId}")
    public Branch findByIdOperations(@PathVariable("branchId") Long branchId) {
        return branchEntityManager.findById(branchId);
    }

    /************** Using Specifications  **************/
    @GetMapping("/specification/delete")
    public List<Branch> findBySpecification() {
        return branchSpecifications.findAll(BranchSpecs.isDeleteBranch(true));
    }
    /************** Using Example  **************/
    @GetMapping("/example")
    public Iterable<Branch> findByExample() {
        return branchExampleQuery.findAll(BranchExample.createExampleFindCode());
    }


}
