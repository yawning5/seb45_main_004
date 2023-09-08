package com.party.chatting.entity;

import com.party.board.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Chatting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int chattingUnread;

    @OneToOne(mappedBy = "chatting")
    private Board board;
}
