package ee.alekal.sectorsback.entities.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String username;
    private boolean agreeToTerms;
    private List<Long> sectorsIds;
}
