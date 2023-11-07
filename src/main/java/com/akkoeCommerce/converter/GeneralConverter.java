package com.akkoeCommerce.converter;

public interface GeneralConverter<Entity, RequestDto, ResponseDto> {
    ResponseDto entityToResponseDto(Entity source);
    Entity requestDtoToEntity(RequestDto source);
}
