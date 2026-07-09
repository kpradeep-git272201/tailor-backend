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

    public Long getId() {
        return id;
    }

    public TailorEntity getTailor() {
        return tailor;
    }

    public ArticleEntity getArticle() {
        return article;
    }

    public Double getStitchingPrice() {
        return stitchingPrice;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTailor(TailorEntity tailor) {
        this.tailor = tailor;
    }

    public void setArticle(ArticleEntity article) {
        this.article = article;
    }

    public void setStitchingPrice(Double stitchingPrice) {
        this.stitchingPrice = stitchingPrice;
    }
}
