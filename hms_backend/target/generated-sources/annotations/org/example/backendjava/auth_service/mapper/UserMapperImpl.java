package org.example.backendjava.auth_service.mapper;

import javax.annotation.processing.Generated;
import org.example.backendjava.auth_service.model.dto.UserRequestDto;
import org.example.backendjava.auth_service.model.dto.UserResponseDto;
import org.example.backendjava.auth_service.model.entity.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-17T01:11:42+0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.9 (Ubuntu)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponseDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setId( user.getId() );
        userResponseDto.setUsername( user.getUsername() );
        userResponseDto.setEmail( user.getEmail() );
        userResponseDto.setRole( user.getRole() );

        return userResponseDto;
    }

    @Override
    public User toEntity(UserRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( dto.getUsername() );
        user.setEmail( dto.getEmail() );
        user.setPassword( dto.getPassword() );
        user.setRole( dto.getRole() );

        return user;
    }
}
