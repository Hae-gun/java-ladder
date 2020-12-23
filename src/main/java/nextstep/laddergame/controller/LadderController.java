package nextstep.laddergame.controller;

import nextstep.laddergame.domain.*;
import nextstep.laddergame.domain.dto.LadderDTO;
import nextstep.laddergame.domain.dto.ResultDTO;

import java.util.ArrayList;
import java.util.List;

public class LadderController {

    private Participants participants;
    private Ladder ladder;
    private Gifts gifts;


    public List<Person> initParticipants(String participants) {
        this.participants = Participants.create(participants);

        return this.participants.getParticipants();
    }

    public LadderDTO createLadder(int ladderHeight) {
        this.ladder = Ladder.of(participants.getParticipantCount(), ladderHeight);
        return LadderDTO.from(this.ladder);
    }

    public List<Gift> initGameGifts(String gameGifts) {
        this.gifts = Gifts.of(this.participants.getParticipantCount(), gameGifts);
        return this.gifts.getGifts();
    }

    public ResultDTO getResult(String name) {
        Person person = this.participants.findPerson(name);
        int resultIndex = this.ladder.runLadderByIndex(person.getSequence());
        Gift giftByIndex = gifts.findGiftByIndex(resultIndex);

        return ResultDTO.of(person, giftByIndex);
    }

    public List<ResultDTO> getAllResult() {
        List<ResultDTO> resultDTOS = new ArrayList<>();
        List<Person> allResult = this.participants.getParticipants();
        for (Person person : allResult) {
            resultDTOS.add(ResultDTO.of(person, gifts.findGiftByIndex(this.ladder.runLadderByIndex(person.getSequence()))));
        }

        return resultDTOS;
    }
}