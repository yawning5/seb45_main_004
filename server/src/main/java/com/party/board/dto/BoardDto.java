package com.party.board.dto;

import com.party.board.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class BoardDto {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Post{

        @NotBlank
        private String title;

        @NotNull
        private LocalDate date;

        @NotBlank
        private String body;

        @NotBlank
        private String category;

        private String latitude;

        private String longitude;

        private String address;

        @NotNull
        private int totalNum;

        private int money;

        @NotBlank //카드 이미지 선택 안하면 글 생성 안되게하기 위해
        private String imageUrl;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class ResponsePost extends Post {
        private long boardId;
        private String address;
        private String latitude;
        private String longitude;

        public ResponsePost(Board createdBoard) {
            super();
            this.boardId = createdBoard.getId();
            this.address = createdBoard.getAddress();
            this.latitude = createdBoard.getLatitude();
            this.longitude = createdBoard.getLongitude();
        }
    }
}
