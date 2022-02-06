package ee.alekal.sectorsback.dao;

import ee.alekal.sectorsback.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByIdAndUsername(Long id, String name);
}
