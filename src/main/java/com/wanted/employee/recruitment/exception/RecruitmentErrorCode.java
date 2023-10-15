package com.wanted.employee.recruitment.exception;

import com.wanted.employee.support.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
@RequiredArgsConstructor
public enum RecruitmentErrorCode implements ErrorCode {
    PAGE_OUT_OF_RANGE("페이지 번호가 유효하지 않음.",HttpStatus.BAD_REQUEST),
    DEFAULT("채용 조회 오류", HttpStatus.INTERNAL_SERVER_ERROR),
    MISMATCHED("회원 정보가 일치하지 않습니다.", HttpStatus.NOT_FOUND),
    UNAUTHORIZED("인증 유저 정보가 존재하지 않습니다.", HttpStatus.UNAUTHORIZED),
    FORBIDDEN("올바르지 않은 권한입니다.", HttpStatus.FORBIDDEN),
    INVALID_TOKENS("올바르지 않은 인증 정보입니다.", HttpStatus.BAD_REQUEST),
    DEPRECATED("중복된 게시글 제목이거나 내용이 비었습니다.", HttpStatus.BAD_REQUEST),
    SIGN_FAIL("아이디 혹은 비밀번호가 일치하지 않습니다.",HttpStatus.BAD_REQUEST);


    public final String message;
    public final HttpStatus status;

    @Override
    public HttpStatus defaultHttpStatus() {
        return status;
    }

    @Override
    public String defaultMessage() {
        return message;
    }

    @Override
    public Recruitment defaultException() {
        return new Recruitment(this);
    }

    @Override
    public Recruitment defaultException(Throwable cause) {
        return new Recruitment(this, cause);
    }
}