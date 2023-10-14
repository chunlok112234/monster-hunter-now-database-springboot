package com.lf8780.mhnowdb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lf8780.mhnowdb.jsonformat.BasicJsonFormat;
import com.lf8780.mhnowdb.jsonformat.ListedJsonFormat;
import com.lf8780.mhnowdb.model.Armor;
import com.lf8780.mhnowdb.repository.ArmorRepository;

@RestController
@RequestMapping(path = "/api/armors")
public class ArmorController {
    
    @Autowired
    private ArmorRepository armorRepository;

    // @GetMapping(path = "")
    // public List<Skill> getAllASkills () {
    //     return skillRepository.findAll();
    // }

    @GetMapping(path = "/")
    public ListedJsonFormat getAllSkills () {
        List<Armor> data = armorRepository.findAll();
        ListedJsonFormat jsonBody = new ListedJsonFormat(data);
        return jsonBody;
        
    } 

    @GetMapping("/{id}")
    public ResponseEntity<?> getMember(@PathVariable Integer id) {
        Optional<Armor> armor = armorRepository.findById(id);
        return armor.map(response -> ResponseEntity.ok().body(new BasicJsonFormat(response))).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}