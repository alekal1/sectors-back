package ee.alekal.sectorsback.sectors;

import ee.alekal.sectorsback.BaseSpringBootTest;
import ee.alekal.sectorsback.exceptions.sector.SectorNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.web.util.NestedServletException;

import static ee.alekal.sectorsback.util.AppConstants.SECTOR_PATH;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SectorsServiceTest extends BaseSpringBootTest {

    @Test
    public void verifyCanGetAllSectors() {
        try {
            mvc.perform(get(SECTOR_PATH))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void verifyCanGetSectorByValidType() {
        try {
            mvc.perform(get(SECTOR_PATH.concat("/low")))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void verifyCannotGetSectorByInvalidType() {
        assertThatThrownBy(() -> mvc.perform(get(SECTOR_PATH.concat("/test")))).hasCause(
                new SectorNotFoundException("Sector with given type was not founded")
        );
    }
}
