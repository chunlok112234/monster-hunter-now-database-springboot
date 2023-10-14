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
import com.lf8780.mhnowdb.model.Skill;
import com.lf8780.mhnowdb.repository.SkillRepository;

@RestController
@RequestMapping(path = "/api/skills")
public class SkillController {
    
    @Autowired
    private SkillRepository skillRepository;

    // @GetMapping(path = "")
    // public List<Skill> getAllASkills () {
    //     return skillRepository.findAll();
    // }

    @GetMapping(path = "/")
    public ListedJsonFormat getAllSkills () {
        List<Skill> data = skillRepository.findAll();
        ListedJsonFormat jsonBody = new ListedJsonFormat(data);
        return jsonBody;
        
    } 

    @GetMapping("/{id}")
    public ResponseEntity<?> getMember(@PathVariable Integer id) {
        Optional<Skill> skill = skillRepository.findById(id);
        return skill.map(response -> ResponseEntity.ok().body(new BasicJsonFormat(response))).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
