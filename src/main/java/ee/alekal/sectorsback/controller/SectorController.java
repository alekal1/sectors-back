package ee.alekal.sectorsback.controller;

import ee.alekal.sectorsback.entities.SectorEntity;
import ee.alekal.sectorsback.service.SectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static ee.alekal.sectorsback.util.AppConstants.SECTOR_PATH;

@RestController
@RequestMapping(path = SECTOR_PATH)
@RequiredArgsConstructor
public class SectorController {

    private final SectorService sectorService;

    @GetMapping()
    public List<SectorEntity> getAllSectors() {
        return sectorService.getAllSectors();
    }

    @GetMapping("/{type}")
    public ResponseEntity<List<SectorEntity>> getSectorsByType(@PathVariable String type) {
        return sectorService.getSectorsByType(type);
    }

}
