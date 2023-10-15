package com.wanted.employee.member_company.domain;


import com.wanted.employee.support.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Getter
@NoArgsConstructor
@Entity
public class MemberRecruitment extends BaseEntity {
    private Long memberId;
    private Long recruitmentId;
}
