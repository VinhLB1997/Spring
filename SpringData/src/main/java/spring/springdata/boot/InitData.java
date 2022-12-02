package spring.springdata.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import spring.springdata.entity.Branch;
import spring.springdata.repository.using_repository_interface.BranchRepository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

//@Component
public class InitData implements CommandLineRunner {
    @Autowired
    BranchRepository repository;

    @Override
    public void run(String... args) throws Exception {
        String brancodePrefix = "BRANCH00";
        String brannamePrefix = "Branch ";
        String deviceCodePrefix = "branch38578ndsjs ";
        List<Branch> list = new ArrayList<>();
        for (int i = 1; i <=100; i++){
            Branch branch = new Branch();
            branch.setBranchCode(brancodePrefix + i);
            branch.setBranchName(brannamePrefix+ i);
            branch.setDeviceRegisterCode(deviceCodePrefix + i);
            branch.setCreateDate(Instant.now());
            branch.setUpdateDate(Instant.now());
            list.add(branch);
        }
        repository.saveAll(list);
    }
}
