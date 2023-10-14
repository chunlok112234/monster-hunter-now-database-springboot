package com.lf8780.mhnowdb.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "skill_effect_table", uniqueConstraints={@UniqueConstraint(columnNames = {"skill_id", "skill_point"})})
@Getter
@Setter
@NoArgsConstructor
@ToString
public class SkillEffect implements Serializable{
    
    @Id
    @Column(name = "skill_effect_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    @NonNull
    @Column(name = "skill_point")
    private Integer skillPoint;

    @NonNull
    @Column(name = "skill_effect_description", length = 255)
    private String skillEffectDescription;

}
