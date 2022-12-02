package spring.springdata.repository.using_example;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import spring.springdata.entity.Branch;

public class BranchExample {

    public static Example createExampleFindCode() {
        Branch branch = new Branch();
        branch.setBranchCode("BRANCH008");
        return Example.of(branch);
    }
}
