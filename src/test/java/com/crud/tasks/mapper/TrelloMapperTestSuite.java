package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTestSuite {
    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void testMapToBoards() {
        //Given
        TrelloListDto trelloListDto = new TrelloListDto("1", "Test List Dto", true);
        List<TrelloListDto> trelloListsDto = new ArrayList<>();
        trelloListsDto.add(trelloListDto);

        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("1", "Test Board Dto", trelloListsDto);
        List<TrelloBoardDto> trelloBoardsDto = new ArrayList<>();
        trelloBoardsDto.add(trelloBoardDto);
        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardsDto);
        //Then
        assertEquals(1, trelloBoards.size());
    }

    @Test
    public void testMapToBoardsDto() {
        //Given
        TrelloList trelloList = new TrelloList("1", "Test List", true);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloList);

        TrelloBoard trelloBoard = new TrelloBoard("1", "Test Board", trelloLists);
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard);
        //When
        List<TrelloBoardDto> trelloBoardsDto = trelloMapper.mapToBoardsDto(trelloBoards);
        //Then
        assertEquals(1, trelloBoardsDto.size());
    }

    @Test
    public void testMapToLists() {
        //Given
        List<TrelloListDto> trelloListsDto = new ArrayList<>();
        trelloListsDto.add(new TrelloListDto("1", "Test List Dto", true));
        //When
        List<TrelloList> trelloLists = trelloMapper.mapToLists(trelloListsDto);
        //Then
        assertEquals(1, trelloLists.size());
    }

    @Test
    public void testMapToListsDto() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1", "Test List", true));
        //When
        List<TrelloListDto> trelloListsDto = trelloMapper.mapToListsDto(trelloLists);
        //Then
        assertEquals(1, trelloListsDto.size());
    }

    @Test
    public void testMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("Test Card", "Test Description", "Test Pos", "1");
        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        //Then
        assertEquals("Test Card", trelloCardDto.getName());
    }

    @Test
    public void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Test Card Dto", "Test Description", "Test Pos", "1");
        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        //Then
        assertEquals("Test Card Dto", trelloCard.getName());
    }
}
