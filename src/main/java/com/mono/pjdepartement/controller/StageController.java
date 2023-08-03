package com.mono.pjdepartement.controller;

import java.util.List;

import com.mono.pjdepartement.service.StageService;
import com.mono.pjdepartement.entity.app.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/Stage")
public class StageController {

	final
    StageService stageService;

    @Autowired
    public StageController(StageService stageService) {
        this.stageService = stageService;
    }

    @PostMapping(path = "/create/{idE}")
    public ResponseEntity<String> creatStage(@RequestBody Stage stage, @PathVariable Long idE){
        return stageService.create(stage, idE);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<String> updateStage(@RequestBody Stage stage, @PathVariable Long id){
        return stageService.update(stage, id);
    }

    @GetMapping(path = "/read")
    public List<Stage> readAllStage(){
        return stageService.getAll();
    }

    @GetMapping(path = "/read/{id}")
    public Stage readStage(@PathVariable Long id){
        return stageService.getStage(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteStage(@PathVariable Long id){
        return stageService.delete(id);
    }

    @GetMapping("/read/poste/{poste}")
    public List<Stage> getStageByPoste(@PathVariable String poste) {
        return stageService.getByPoste(poste);
    }

    @GetMapping("/read/desc/{desc}")
    public List<Stage> getStageByDescription(@PathVariable String desc) {
        return stageService.getByDescription(desc);
    }

    @GetMapping("/read/comp/{comp}")
    public List<Stage> getStageByCompetences(@PathVariable String comp) {
        return stageService.getByCompetences(comp);
    }

    @GetMapping("/read/period/{period}")
    public List<Stage> getStageByPeriode(@PathVariable String period) {
        return stageService.getByPeriode(period);
    }
}
