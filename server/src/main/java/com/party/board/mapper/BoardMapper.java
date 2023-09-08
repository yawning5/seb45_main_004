package com.party.board.mapper;

import com.party.board.dto.BoardDto;
import com.party.board.dto.BoardResponseDto;
import com.party.board.entity.Board;

import org.mapstruct.Mapper;
import java.util.List;
@Mapper(componentModel = "spring")
public interface BoardMapper {
    Board BoardPostDtoToBoard(BoardDto.Post postDto);

    default BoardResponseDto boardToBoardResponse(Board board) {
        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setMemberId(board.getMember().getId());
        boardResponseDto.setMemberNickname(board.getMember().getNickname());
        boardResponseDto.setBoardId(board.getId());
        boardResponseDto.setTitle(board.getTitle());
        boardResponseDto.setDate(board.getDate());
        boardResponseDto.setBody(board.getBody());
        boardResponseDto.setCategory(String.valueOf(board.getCategory()));
        boardResponseDto.setTotalNum(board.getTotalNum());
        boardResponseDto.setCurrentNum(board.getCurrentNum());
        boardResponseDto.setMoney(board.getMoney());
        boardResponseDto.setBoardStatus(board.getStatus());
        boardResponseDto.setBoardLikesCount(board.getBoardLikesCount());
        boardResponseDto.setAddress(board.getAddress());
        boardResponseDto.setLatitude(board.getLatitude());
        boardResponseDto.setLongitude(board.getLongitude());
        boardResponseDto.setImageUrl(board.getImageUrl());
        boardResponseDto.setMemberImageUrl(board.getMember().getImageUrl());
        return boardResponseDto;
    }
    List<BoardResponseDto> boardsToBoardResponse(List<Board> boards);
}