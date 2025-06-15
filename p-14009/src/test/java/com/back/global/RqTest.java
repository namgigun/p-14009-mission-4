package com.back.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RqTest {
    @Test
    @DisplayName("삭제?id=1")
    void t1() {
        Rq rq = new Rq("삭제?id=1");
        int id = rq.getParamAsInt("id", -1);

        assertThat(id).isEqualTo(1);
    }

    @Test
    @DisplayName("삭제")
    void t2() {
        Rq rq = new Rq("삭제");
        int id = rq.getParamAsInt("id", -1);

        assertThat(id).isEqualTo(-1);
    }

    @Test
    @DisplayName("삭제?id=")
    void t3() {
        Rq rq = new Rq("삭제?id=");
        int id = rq.getParamAsInt("id", -1);

        assertThat(id).isEqualTo(-1);
    }

    @Test
    @DisplayName("삭제?id=일번")
    void t4() {
        Rq rq = new Rq("삭제?id=일번");
        int id = rq.getParamAsInt("id", -1);

        assertThat(id).isEqualTo(-1);
    }
}