package com.party.member.controller;

import com.party.exception.BusinessLogicException;
import com.party.exception.ExceptionCode;
import com.party.member.dto.MemberPostDto;
import com.party.member.entity.Member;
import com.party.member.mapper.MemberMapper;
import com.party.member.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Transactional
@Service
@RequiredArgsConstructor
@RestController
@RequestMapping(("/members"))
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper mapper;

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto memberPostDto) {
        Member member = memberService.createMember(mapper.memberPostDtoToMember(memberPostDto));
        member.setIntroduce("기본 소개글");
        return new ResponseEntity<>(mapper.memberToMemberResponseDto(member), HttpStatus.CREATED);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") long memberid) {
        Member member = memberService.findMember(memberid);
        return new ResponseEntity(mapper.memberToMemberResponseDto(member), HttpStatus.OK);
    }

    @GetMapping("/test")
    public String redirect() {
        return "redirect:https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=3900b85057673808b382401173a040e5&redirect_uri=https://www.naver.com";  // 원하는 주소로 리다이렉트합니다.
    }


//    @PatchMapping("/{member-id}")
//    public ResponseEntity patchMember(@PathVariable("member-id") long memberid) {
//        Long id = (Long) memberService.extractMemberInfo().get("id");
//        if(id != memberid) throw new BusinessLogicException(ExceptionCode.PERMISSION_NOT_EXIST);
//
//
//    }
}
