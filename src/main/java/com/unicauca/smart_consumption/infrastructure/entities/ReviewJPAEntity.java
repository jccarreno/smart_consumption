package com.unicauca.smart_consumption.infrastructure.entities;
import com.unicauca.smart_consumption.domain.model.Product;
import com.unicauca.smart_consumption.domain.model.User;
import com.unicauca.smart_consumption.domain.model.valueObject.Rating;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "review")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class ReviewJPAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String comment;
    @NonNull
    private LocalDateTime datePublication;
    @Enumerated(EnumType.STRING)
    private Rating rating;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductJPAEntity product;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserJPAEntity user;
}
