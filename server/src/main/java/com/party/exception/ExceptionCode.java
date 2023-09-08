package com.party.exception;

import lombok.Getter;

public enum ExceptionCode {
    MEMBER_EXIST(409, "Member exists"),
    MEMBER_NOT_FOUND(404, "Member not found"),
    BOARD_NOT_FOUND(405, "board not found"),
    NOT_ALLOW_PARTICIPATE(405, "unable to participate"),
    PERMISSION_NOT_EXIST(409, "You don't have permission to access this resource."),
    COMMENT_EXISTS(400,"comment exists"),
    INVALID_MEMBER_ID(400,"Invalid memberId format"),
    OWN_MEMBER(400,"You can't follow your own account"),
    ALREADY_FOLLOWING(400,"You already follow this account"),
    UNAUTHORIZED_FOLLOW(400,"You don't have permission"),
    FOLLOW_NOT_FOUND(400,"Follow not found");


    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}
