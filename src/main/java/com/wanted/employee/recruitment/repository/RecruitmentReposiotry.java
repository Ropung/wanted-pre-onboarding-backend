package com.wanted.employee.recruitment.repository;


import com.wanted.employee.recruitment.api.dto.RecruitmentQueryDto.RecruitmentIdProjectionDto;
import com.wanted.employee.recruitment.domain.Recruitment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecruitmentReposiotry extends JpaRepository<Recruitment, Long> {

    List<RecruitmentIdProjectionDto> findAllByCompanyId(Long companyId);

    @Query(
            value ="select * " +
                    "from wanted7th.recruitment r " +
                    "where r.company_name like %:search% " +
                    "   or r.position like %:search% " +
                    "   or r.technology like %:search%" +
                    "   or r.contents like %:search%",
            nativeQuery = true
    )
    List<Recruitment> findAllBySearch(@Param("search") String search);

}
