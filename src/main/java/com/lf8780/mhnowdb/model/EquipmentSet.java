package com.lf8780.mhnowdb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "equipment_set_table")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class EquipmentSet {
    
    @Id
    @Column(name = "equipment_set_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "equipment_set_name", length = 32, nullable = false)
    @NonNull
    private String name;

}
