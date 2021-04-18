package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointTest {

  @Test
  @DisplayName("Point를 생성한다.")
  void create() {
    // given
    final boolean canCreate = true;

    // when
    final Point head = Point.head();
    final Point body1 = Point.body(head, canCreate);
    final Point body2 = Point.body(body1, canCreate);

    // then
    assertAll(
        () -> assertThat(head).isEqualTo(Point.head()),
        () -> assertThat(body1).isEqualTo(Point.body(head, canCreate)),
        () -> assertThat(body2).isEqualTo(Point.body(body1, canCreate)),
        () -> assertThat(body2).isNotEqualTo(Point.body(head, canCreate))
    );
  }

  @Test
  @DisplayName("true일 때, 가로선이 그려지고, false면 그려지지 않는다.")
  void draw() {
    // given
    final boolean canCreate = true;

    // when
    final Point cannotDraw = Point.head();
    final Point canDraw = Point.body(cannotDraw, canCreate);

    // then
    assertAll(
        () -> assertThat(canDraw.canDraw()).isEqualTo(Point.body(cannotDraw, canCreate).canDraw()),
        () -> assertThat(cannotDraw.canDraw()).isEqualTo(Point.head().canDraw())
    );
  }

  @Test
  @DisplayName("선이 있는지 없는지 반환한다.")
  void hasLine() {
    // given
    final boolean canCreate = true;

    // when
    final Point head = Point.head();
    final Point body = Point.body(head, canCreate);

    // then
    assertAll(
        () -> assertThat(head.hasLine()).isFalse(),
        () -> assertThat(body.hasLine()).isTrue()
    );
  }
}