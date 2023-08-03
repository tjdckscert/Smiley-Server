package com.smiley.smileybackend.domain;

import com.smiley.smileybackend.dto.user.ExpJsonDto;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@TypeDef(name = "json", typeClass = JsonType.class)
public class TotalExpStastics {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer totalExp;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private List<ExpJsonDto> totalExpStastics;

    @Column(unique =true)
    private String userTier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_user_number", foreignKey = @ForeignKey(name = "fk_totalexpstastics_user"))
    private User user;

    @Builder
    public TotalExpStastics(Integer id, Integer totalExp, List<ExpJsonDto> totalExpStastics, String userTier, User user) {
        this.id = id;
        this.totalExp = totalExp;
        this.totalExpStastics = totalExpStastics;
        this.userTier = userTier;
        this.user = user;
    }
}
