package com.tailorapp.tailor.tailor.entity;

import com.tailorapp.catalog.article.entity.ArticleEntity;
import com.tailorapp.common.constants.DatabaseConstants;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
        name="tailor_article_rate",
        schema = DatabaseConstants.TAILOR,
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"tailor_id","article_id"}
                )
        }
)
@Getter
@Setter
public class TailorArticleRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="tailor_id")
    private TailorEntity tailor;

    @ManyToOne
    @JoinColumn(name="article_id")
    private ArticleEntity article;

    @Column(name="stitching_price")
    private Double stitchingPrice;
}
