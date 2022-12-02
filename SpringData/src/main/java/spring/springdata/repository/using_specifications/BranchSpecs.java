package spring.springdata.repository.using_specifications;

import org.springframework.data.jpa.domain.Specification;
import spring.springdata.entity.Branch;

public class BranchSpecs {

    public static Specification<Branch> isDeleteBranch(Boolean flag) {
        return (root, query, builder) -> {
            return builder.equal(root.get("deleteFlag"), flag);
        };
    }

}
