package ee.alekal.sectorsback.exceptions.sector;

import static ee.alekal.sectorsback.util.AppConstants.SECTOR_NOT_FOUND_EXCEPTION_MSG;

public class SectorNotFoundException extends RuntimeException {

    public SectorNotFoundException() {
        super(SECTOR_NOT_FOUND_EXCEPTION_MSG);
    }

    public SectorNotFoundException(String message) {
        super(message);
    }
}
