package com.praktika.farmakon.service;

import com.praktika.farmakon.entity.Category;
import com.praktika.farmakon.entity.Preparation;
import com.praktika.farmakon.exception.PreparationNotFoundException;
import com.praktika.farmakon.repository.PreparationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PreparationService {

    private final PreparationRepository preparationRepository;
    private final CategoryService categoryService;

    @Transactional(readOnly = true)
    public List<Preparation> getAllPreparations(PageRequest pageRequest){
        Page<Preparation> page = preparationRepository.findAll(pageRequest);
        return page.getContent();
    }

    @Transactional(readOnly = true)
    public Preparation getPreparationById(Long id, PageRequest pageRequest){
        return preparationRepository.findById(id, pageRequest).orElseThrow(()->new PreparationNotFoundException("Preparation not found"));
    }

    @Transactional
    public Preparation createPreparation(Preparation preparation){
        Category category = categoryService.findById(preparation.getCategoryId());
        preparation.setCategory(category);
        return preparationRepository.save(preparation);
    }

    @Transactional
    public Preparation updatePreparation(Preparation preparation){
        if (!preparationRepository.existsPreparationById(preparation.getId())){
            throw new PreparationNotFoundException("Preparation not found");
        }
        Category category = categoryService.findById(preparation.getCategoryId());
        preparation.setCategory(category);
        return preparationRepository.save(preparation);
    }

    @Transactional
    public void deletePreparation(Long id){
        if (preparationRepository.existsPreparationById(id)){
            preparationRepository.deleteById(id);
        }
        else{
            throw new PreparationNotFoundException("Preparation not found");
        }
    }
}
