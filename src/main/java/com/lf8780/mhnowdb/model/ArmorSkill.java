package com.lf8780.mhnowdb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "armor_skill_table")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ArmorSkill {
    
    @Id
    @Column(name = "armor_skill_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "armor_id", nullable = false)
    private Armor armor;

    @NonNull
    @Column(name = "armor_level", nullable = true)
    private Integer armorLevel;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "skill_id_1", referencedColumnName = "skill_id", nullable = true)
    private Skill skill1;

    @Column(name = "skill_point_1", nullable = false)
    private Integer skillPoint1;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "skill_id_2", referencedColumnName = "skill_id", nullable = true)
    private Skill skill2;

    @Column(name = "skill_point_2", nullable = true)
    private Integer skillPoint2;
}
