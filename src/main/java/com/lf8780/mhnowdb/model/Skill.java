package com.lf8780.mhnowdb.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "skill_table")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Skill implements Serializable{
    
    @Id
    @Column(name = "skill_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "skill_name", length = 32)
    @NonNull
    private String name;

    @Column(name = "skill_max_point")
    @NonNull
    private Integer maxPoint;

    @Column(name = "skill_description", length = 255)
    @NonNull
    private String description;

    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SkillEffect> skillEffects;
}
