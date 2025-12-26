package id.luannv.e_learning.mapper;

import id.luannv.e_learning.dto.request.UserCreationRequest;
import id.luannv.e_learning.dto.request.UserUpdateRequest;
import id.luannv.e_learning.dto.response.UserResponse;
import id.luannv.e_learning.entity.User;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "deleted", constant = "false")
    @Mapping(target = "avatarLink", ignore = true)
    User toEntity(UserCreationRequest userCreationRequest);

    UserResponse toResponse(User user);

    User updateUser(@MappingTarget User user, UserUpdateRequest userUpdateRequest);
}
