package com.party.member.dto;

import com.party.board.dto.ApplicantResponseDto;
import com.party.board.entity.Applicant;
import com.party.bookmark.entity.Bookmark;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
public class MemberResponseDto {
    // 추가해야 되는거 팔로우 목록
    private long memberId;
    private long applicantId;
    private String nickname;
    private String email;
    private String gender;
    private String introduce;
    private String imageUrl;
    private List<ApplicantResponseDto> applicants = new ArrayList<>();
}
