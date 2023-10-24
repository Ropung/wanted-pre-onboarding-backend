package com.wanted.employee.recruitment.service;

import com.wanted.employee.recruitment.api.dto.RecruitmentCommandDto.RecruitCreateReqDto;
import com.wanted.employee.recruitment.api.dto.RecruitmentCommandDto.RecruitCreateResDto;
import com.wanted.employee.recruitment.api.dto.RecruitmentCommandDto.RecruitDeleteResDto;
import com.wanted.employee.recruitment.api.dto.RecruitmentCommandDto.RecruitUpdateReqDto;
import com.wanted.employee.recruitment.api.dto.RecruitmentCommandDto.RecruitUpdateResDto;
import com.wanted.employee.recruitment.domain.Recruitment;
import com.wanted.employee.recruitment.exception.RecruitmentErrorCode;
import com.wanted.employee.recruitment.repository.RecruitmentReposiotry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class RecruitmentCommandService implements RecruitmentCommandUsecase{

    private final RecruitmentReposiotry recruitmentReposiotry;

    @Override
    public RecruitCreateResDto create(RecruitCreateReqDto dto) {

        //TODO 예외처리 작업

        Recruitment recruitment = Recruitment.builder()
                .companyId(dto.companyId())
                .companyName(dto.companyName())
                .country(dto.country())
                .region(dto.region())
                .position(dto.position())
                .compensation(dto.compensation())
                .technology(dto.technology())
                .contents(dto.contents())
                .build();

        recruitmentReposiotry.save(recruitment);

        return RecruitCreateResDto.builder()
                .companyId(recruitment.getCompanyId())
                .companyName(recruitment.getCompanyName())
                .country(recruitment.getCountry())
                .region(recruitment.getRegion())
                .position(recruitment.getPosition())
                .compensation(recruitment.getCompensation())
                .technology(recruitment.getTechnology())
                .contents(recruitment.getContents())
                .build();
    }

    @Override
    @Transactional
    public RecruitUpdateResDto update(Long recruitmentId, RecruitUpdateReqDto dto) {

        Recruitment recruitmentEntity = recruitmentReposiotry.findById(recruitmentId)
                .orElseThrow(RecruitmentErrorCode.DEFAULT::defaultException);

        recruitmentEntity.changePosition(dto.position());
        recruitmentEntity.changeCompensation(dto.compensation());
        recruitmentEntity.changeTechnology(dto.technology());
        recruitmentEntity.changeContents(dto.contents());

        return RecruitUpdateResDto.builder()
                .position(recruitmentEntity.getPosition())
                .compensation(recruitmentEntity.getCompensation())
                .technology(recruitmentEntity.getTechnology())
                .contents(recruitmentEntity.getContents())
                .build();
    }

    @Override
    public RecruitDeleteResDto delete(Long recruitmentId) {

        Recruitment recruitmentEntity = recruitmentReposiotry.findById(recruitmentId)
                .orElseThrow(RecruitmentErrorCode.DEFAULT::defaultException);

        recruitmentReposiotry.delete(recruitmentEntity);

        return RecruitDeleteResDto.builder()
                .success(true)
                .build();
    }
}
