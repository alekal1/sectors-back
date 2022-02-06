package ee.alekal.sectorsback.init;

import ee.alekal.sectorsback.dao.SectorRepository;
import ee.alekal.sectorsback.entities.SectorEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static ee.alekal.sectorsback.entities.enums.SectorType.LOW;
import static ee.alekal.sectorsback.entities.enums.SectorType.PRIMARY;
import static ee.alekal.sectorsback.util.AppConstants.LOW_LEVEL_SECTORS;
import static ee.alekal.sectorsback.util.AppConstants.MEDIUM_LEVEL_SECTORS;
import static ee.alekal.sectorsback.util.AppConstants.TOP_LEVEL_SECTORS;
import static ee.alekal.sectorsback.util.AppConstants.PRIMARY_SECTOR;
import static ee.alekal.sectorsback.entities.enums.SectorType.TOP;
import static ee.alekal.sectorsback.entities.enums.SectorType.MEDIUM;

@Configuration
public class SectorInit {


    @Bean
    public CommandLineRunner sectorCommandLineRunner(SectorRepository sectorRepository) {
        return args -> {
            PRIMARY_SECTOR.forEach(a -> {
                var sector = new SectorEntity();
                sector.setName(a);
                sector.setType(PRIMARY.getType());
                sectorRepository.saveAndFlush(
                        sector
                );
            });

            TOP_LEVEL_SECTORS.forEach((key, value) -> {
                value.forEach(top -> {
                    var sector = new SectorEntity();
                    sector.setName(top);
                    sector.setParentSector(sectorRepository.findByName(key));
                    sector.setType(TOP.getType());
                    sectorRepository.saveAndFlush(
                            sector
                    );
                });
            });

            MEDIUM_LEVEL_SECTORS.forEach((key, value) -> {
                value.forEach(med -> {
                    var sector = new SectorEntity();
                    sector.setName(med);
                    sector.setParentSector(sectorRepository.findByName(key));
                    sector.setType(MEDIUM.getType());
                    sectorRepository.saveAndFlush(
                            sector
                    );
                });
            });

            LOW_LEVEL_SECTORS.forEach((key, value) -> {
                value.forEach(low -> {
                    var sector = new SectorEntity();
                    sector.setName(low);
                    sector.setParentSector(sectorRepository.findByName(key));
                    sector.setType(LOW.getType());
                    sectorRepository.saveAndFlush(
                            sector
                    );
                });
            });
        };
    }
}
