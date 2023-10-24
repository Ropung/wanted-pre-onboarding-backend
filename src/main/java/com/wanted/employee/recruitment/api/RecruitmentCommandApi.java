package com.wanted.employee.recruitment.api;


import com.wanted.employee.recruitment.api.dto.RecruitmentCommandDto.RecruitDeleteResDto;
import com.wanted.employee.recruitment.api.dto.RecruitmentCommandDto.RecruitUpdateReqDto;
import com.wanted.employee.recruitment.api.dto.RecruitmentCommandDto.RecruitCreateReqDto;
import com.wanted.employee.recruitment.api.dto.RecruitmentCommandDto.RecruitCreateResDto;
import com.wanted.employee.recruitment.api.dto.RecruitmentCommandDto.RecruitUpdateResDto;
import com.wanted.employee.recruitment.service.RecruitmentCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recruitment")
public class RecruitmentCommandApi {

    private final RecruitmentCommandService recruitmentCommandService;

    @PostMapping()
    public RecruitCreateResDto create(
            @RequestBody @Valid RecruitCreateReqDto dto
            ){
        return recruitmentCommandService.create(dto);
    }

    @PutMapping("/{recruitmentId}")
    public RecruitUpdateResDto update(
            @RequestBody @Valid RecruitUpdateReqDto dto,
            @PathVariable Long recruitmentId
            ){
        return recruitmentCommandService.update(recruitmentId,dto);
    }

    @DeleteMapping("/{recruitmentId}")
    public RecruitDeleteResDto delete(
            @PathVariable Long recruitmentId
    ){
        return recruitmentCommandService.delete(recruitmentId);
    }

}
