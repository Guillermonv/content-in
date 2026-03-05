package com.n.in.service;

import com.n.in.model.Step;
import com.n.in.model.dto.ContentDto;
import com.n.in.model.mapper.NMapper;
import com.n.in.model.repository.ContentRepository;
import com.n.in.utils.ContentParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;

@Component
public class InternalOperationService {
    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private NMapper nMapper;

    public Object handleInternal(Long execution, Step step, String previousOutput)  {
        ContentDto contentDto = new ContentDto();

        ContentParser.parse(previousOutput, contentDto);
        contentDto.setExecutionId(execution);
        contentDto.setCreated(LocalDateTime.now());
        contentDto.setLastUpdated(LocalDateTime.now());
        contentDto.setCategory(step.getWorkflows().getCategory());
        contentDto.setSubCategory(step.getWorkflows().getSubCategory());
        contentRepository.save(nMapper.toEntity(contentDto));

        return Map.of(
                "step_prompt", step.getPrompt(),
                "previous_output", previousOutput,
                "combined", step.getPrompt() + " | " + previousOutput,
                "result", "Stored"
        );
    }
}


