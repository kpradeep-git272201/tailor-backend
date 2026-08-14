package com.tailorapp.tailor.tailor.entity;

import com.tailorapp.catalog.article.entity.ArticleEntity;
import com.tailorapp.common.constants.DatabaseConstants;
import com.tailorapp.tailornew.tailor.entity.TailorEntity;
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
    private TailorEntityOld tailor;

    @ManyToOne
    @JoinColumn(name="article_id")
    private ArticleEntity article;

    @Column(name="stitching_price")
    private Double stitchingPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TailorEntityOld getTailor() {
        return tailor;
    }

    public void setTailor(TailorEntityOld tailor) {
        this.tailor = tailor;
    }

    public ArticleEntity getArticle() {
        return article;
    }

    public void setArticle(ArticleEntity article) {
        this.article = article;
    }

    public Double getStitchingPrice() {
        return stitchingPrice;
    }

    public void setStitchingPrice(Double stitchingPrice) {
        this.stitchingPrice = stitchingPrice;
    }
}
