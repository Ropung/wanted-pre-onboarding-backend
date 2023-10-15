package com.wanted.employee.recruitment.service;

import com.wanted.employee.recruitment.api.dto.RecruitmentQueryDto.RecruitmentFindAllResDto;
import com.wanted.employee.recruitment.api.dto.RecruitmentQueryDto.RecruitmentFindDetailIdResDto;
import com.wanted.employee.recruitment.api.dto.RecruitmentQueryDto.RecruitmentFindListByOneResDto;
import com.wanted.employee.recruitment.api.dto.RecruitmentQueryDto.RecruitmentIdProjectionDto;
import com.wanted.employee.recruitment.domain.Recruitment;
import com.wanted.employee.recruitment.exception.RecruitmentErrorCode;
import com.wanted.employee.recruitment.repository.RecruitmentReposiotry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecruitmentQueryService implements RecruitmentQueryUsecase{

    private final RecruitmentReposiotry recruitmentReposiotry;



    @Override
    public RecruitmentFindAllResDto findAll() {

        List<Recruitment> recruitmentList = recruitmentReposiotry.findAll();

        List<RecruitmentFindListByOneResDto> recruitmentDtoList = recruitmentList.stream()
                .map((e)-> RecruitmentFindListByOneResDto.builder()
                    .id(e.getId())
                    .companyName(e.getCompanyName())
                    .country(e.getCountry())
                    .region(e.getRegion())
                    .position(e.getPosition())
                    .compensation(e.getCompensation())
                    .technology(e.getTechnology())
                    .build())
                .collect(Collectors.toList());

        return RecruitmentFindAllResDto.builder()
                .RecruitmentList(recruitmentDtoList)
                .build();
    }

    @Override
    public RecruitmentFindDetailIdResDto findById(Long recruitmentId) {

        Recruitment recruitment = recruitmentReposiotry.findById(recruitmentId)
                .orElseThrow(RecruitmentErrorCode.DEFAULT::defaultException);

        List<RecruitmentIdProjectionDto> recruitmentIdList = recruitmentReposiotry.findAllByCompanyId(recruitment.getCompanyId());

        return RecruitmentFindDetailIdResDto.builder()
                .id(recruitment.getId())
                .companyName(recruitment.getCompanyName())
                .country(recruitment.getCountry())
                .region(recruitment.getRegion())
                .position(recruitment.getPosition())
                .compensation(recruitment.getCompensation())
                .technology(recruitment.getTechnology())
                .contents(recruitment.getContents())
                .otherRecruitmentIdList(recruitmentIdList.stream()
                        .filter((e)-> e.id() != recruitmentId).toList())
                .createdAt(recruitment.getCreatedAt())
                .updatedAt(recruitment.getUpdatedAt())
                .build();
    }
}
