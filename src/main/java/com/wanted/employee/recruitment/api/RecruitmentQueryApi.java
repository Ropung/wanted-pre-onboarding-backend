package com.wanted.employee.recruitment.api;


import com.wanted.employee.recruitment.api.dto.RecruitmentQueryDto.RecruitmentFindAllResDto;
import com.wanted.employee.recruitment.api.dto.RecruitmentQueryDto.RecruitmentFindDetailIdResDto;
import com.wanted.employee.recruitment.service.RecruitmentQueryUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recruitment")
public class RecruitmentQueryApi {

    private final RecruitmentQueryUsecase recruitmentQueryUsecase;

    @GetMapping("/list")
    public RecruitmentFindAllResDto findAll(){
        return recruitmentQueryUsecase.findAll();
    }

    @GetMapping("/{recruitmentId}")
    public RecruitmentFindDetailIdResDto findDetailId(
            @PathVariable Long recruitmentId
    ){
        return recruitmentQueryUsecase.findById(recruitmentId);
    }



}
