package com.tailorapp.tailor.rates;
import com.tailorapp.common.constants.DatabaseConstants;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tailor_article_rate", schema = DatabaseConstants.TAILOR)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleRateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tailor_id", nullable = false)
    private Long tailorId;

    @Column(name = "article_id", nullable = false)
    private Long articleId;

    @Column(name = "stitching_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal stitchingPrice;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
