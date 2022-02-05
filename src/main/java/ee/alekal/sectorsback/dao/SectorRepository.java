package ee.alekal.sectorsback.dao;

import ee.alekal.sectorsback.entities.SectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectorRepository extends JpaRepository<SectorEntity, Long> {

    SectorEntity findByName(String name);

    List<SectorEntity> findAllByType(String type);

    List<SectorEntity> findByParentSectorId(Long id);
}
