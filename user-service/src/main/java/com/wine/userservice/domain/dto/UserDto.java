package com.wine.userservice.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.Instant;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(exclude = {"city"})
@ToString(exclude = {"city"})
@Accessors(chain = true)
public class UserDto implements AbstractDto<Long> {
    private Long id;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;

    @JsonDeserialize(using = InstantDeserializer.class)
    @JsonSerialize(using = InstantSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private Instant createDate;

    private String name;
    private String phoneNumber;
    private CityDto city;
    private Boolean isActivated;
    private Long authId;
}
