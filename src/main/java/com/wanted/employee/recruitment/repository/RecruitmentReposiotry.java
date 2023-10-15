package com.wanted.employee.recruitment.repository;

import com.wanted.employee.recruitment.api.dto.RecruitmentQueryDto.RecruitmentIdProjectionDto;
import com.wanted.employee.recruitment.domain.Recruitment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecruitmentReposiotry extends JpaRepository<Recruitment, Long> {
    List<RecruitmentIdProjectionDto> findAllByCompanyId(Long companyId);
}
