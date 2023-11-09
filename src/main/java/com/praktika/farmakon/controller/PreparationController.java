package com.praktika.farmakon.controller;

import com.praktika.farmakon.dto.request.preparation.PreparationCreateRequest;
import com.praktika.farmakon.dto.request.preparation.PreparationUpdateRequest;
import com.praktika.farmakon.dto.response.preparation.PreparationResponse;
import com.praktika.farmakon.mapper.PreparationMapper;
import com.praktika.farmakon.service.PreparationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/preparation")
public class PreparationController {

    private final PreparationService preparationService;
    private final PreparationMapper preparationMapper;

    @GetMapping
    public ResponseEntity<List<PreparationResponse>> getAllPreparations(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size){
        return new ResponseEntity<>(preparationMapper.toDtos(preparationService.getAllPreparations(PageRequest.of(page, size))), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PreparationResponse> getPreparationById(@PathVariable Long id,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size){
        return new ResponseEntity<>(preparationMapper.toDto(preparationService.getPreparationById(id, PageRequest.of(page, size))), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PreparationResponse> createPreparation(@Valid @RequestBody PreparationCreateRequest preparationCreateRequest){
        return new ResponseEntity<>(preparationMapper.toDto(preparationService.createPreparation(preparationMapper.fromDto(preparationCreateRequest))), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PreparationResponse> updatePreparation(@Valid @RequestBody PreparationUpdateRequest preparationUpdateRequest){
        return new ResponseEntity<>(preparationMapper.toDto(preparationService.updatePreparation(preparationMapper.fromDto(preparationUpdateRequest))), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deletePreparation (@NotNull @PathVariable Long id){
        preparationService.deletePreparation(id);
    }
}
