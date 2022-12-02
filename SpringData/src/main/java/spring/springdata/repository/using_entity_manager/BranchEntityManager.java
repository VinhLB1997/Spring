package spring.springdata.repository.using_entity_manager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import spring.springdata.entity.Branch;

@Repository
public class BranchEntityManager {

    @PersistenceContext
    private EntityManager entityManager;

    public Branch findById(Long id){
        return entityManager.find(Branch.class, id);
    }
}
