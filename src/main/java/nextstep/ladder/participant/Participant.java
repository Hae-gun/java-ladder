package nextstep.ladder.participant;

import nextstep.ladder.Position;

public class Participant {
    private static final int NAME_MAX_LENGTH = 5;

    private String name;
    private Position position;

    public Participant(String name) {
        if (!validation(name)) {
            throw new IllegalArgumentException("이름은 최대 5글자까지만 사용가능합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private boolean validation(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            return false; //Error
        }
        return true;
    }

    public void setStartPosition(int position, int MAX_POSITION) {
        this.position = new Position(position, MAX_POSITION);
    }

    public String position() {
        return this.position.toString();
    }

    public void movePosition(int nextPosition) {
        this.position.move(nextPosition);
    }

    public Position getPosition() {
        return this.position;
    }
}
