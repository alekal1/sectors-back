package ee.alekal.sectorsback.entities.enums;

import lombok.Getter;

public enum SectorType {

    PRIMARY("primary"),
    TOP("top"),
    MEDIUM("medium"),
    LOW("low");

    @Getter
    String type;

    SectorType(String type) {
        this.type = type;
    }
}
