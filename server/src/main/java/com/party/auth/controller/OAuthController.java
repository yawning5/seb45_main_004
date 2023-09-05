package com.party.auth.controller;

import com.party.auth.dto.OAuth;
import com.party.auth.dto.Token;
import com.party.auth.service.OAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/oauth")
@RequiredArgsConstructor
public class OAuthController {
    private final OAuthService oAuthService;

    @PostMapping("/login")
    public ResponseEntity<Void> oauth(@RequestBody @Valid OAuth oAuth) {
        // 로그인한 정보를 바탕으로 해당 유저에 관련된 토큰을 반환해준다
        Token token = oAuthService.login(oAuth.getProvider(), oAuth.getCode());

        // 헤더에 담는 과정은 똑같음
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token.getAccessToken());
        headers.add("Refresh", "Bearer " + token.getRefreshToken());

        return ResponseEntity.ok().headers(headers).build();
    }
}
