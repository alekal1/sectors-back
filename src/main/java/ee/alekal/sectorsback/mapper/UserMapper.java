package ee.alekal.sectorsback.mapper;

import ee.alekal.sectorsback.entities.UserEntity;
import ee.alekal.sectorsback.entities.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDto userEntityToDto(UserEntity entity);
    UserEntity userDtoToEntity(UserDto userDto);
}
