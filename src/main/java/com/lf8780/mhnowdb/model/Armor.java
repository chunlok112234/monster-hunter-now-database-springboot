package com.lf8780.mhnowdb.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "armor_table")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Armor implements Serializable{
    
    @Id
    @Column(name = "armor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "armor_name", length = 32, nullable = false)
    @NonNull
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "armor_type", nullable = false)
    private ArmorType armorType;

    @NonNull
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "equipment_set_id", nullable = false)
    private EquipmentSet equipmentSet;

    @OneToMany(mappedBy = "armor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ArmorSkill> armorSkills;

}
