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

    @Test
    @DisplayName("목록?searchKeyword=영광")
    void t5() {
        Rq rq = new Rq("목록?searchKeyword=영광");
        String searchKeyword = rq.getParam("searchKeyword", ""); // "영광"

        assertThat(searchKeyword).isEqualTo("영광");
    }

    @Test
    @DisplayName("목록")
    void t6() {
        Rq rq = new Rq("목록");
        String searchKeyword = rq.getParam("searchKeyword", "");

        assertThat(searchKeyword).isEqualTo("");
    }

    @Test
    @DisplayName("목록?searchKeyword=")
    void t7() {
        Rq rq = new Rq("목록?searchKeyword=");
        String searchKeyword = rq.getParam("searchKeyword", "");

        assertThat(searchKeyword).isEqualTo("");
    }

    @Test
    @DisplayName("목록?page=5&searchKeyword=영광")
    void t8() {
        Rq rq = new Rq("목록?page=5&searchKeyword=영광");
        int page = rq.getParamAsInt("page", -1); // 5
        String searchKeyword = rq.getParam("searchKeyword", ""); // "영광"

        assertThat(page).isEqualTo(5);
        assertThat(searchKeyword).isEqualTo("영광");
    }
}