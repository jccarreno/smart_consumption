package com.unicauca.smart_consumption.infrastructure.pattern.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Domain to manage cen integration config.
 *
 * @author jcardenass@unicauca.edu.co
 * @version 1.0
 * @since 2024-09-14
 */

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {
    private UserDto user;
    private ProductMongoDto product;
    private int ratingValue;
    private String comment;
    private LocalDateTime date;
}
