package ee.alekal.sectorsback.users;


import ee.alekal.sectorsback.BaseSpringBootTest;
import ee.alekal.sectorsback.entities.dto.UserDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.util.List;

import static ee.alekal.sectorsback.util.AppConstants.USER_PATH;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class UserServiceTest extends BaseSpringBootTest {

    private static UserDto initialDto;

    @BeforeAll
    public static void init() {
        initialDto = new UserDto();
        initialDto.setId(1L);
        initialDto.setUsername("test");
        initialDto.setSectorsIds(List.of(19L, 3L));
        initialDto.setAgreeToTerms(true);
    }

    @Order(1)
    @Test
    public void verifyCanAddUser() {
        try {
            mvc.perform(post(USER_PATH.concat("/add"))
                    .content(asJson(initialDto))
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Order(2)
    @Test
    public void verifyCanGetUser() {
        try {
            mvc.perform(get(USER_PATH.concat("/" + initialDto.getId()))
            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

}
