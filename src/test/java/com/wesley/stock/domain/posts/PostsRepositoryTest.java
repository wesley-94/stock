package com.wesley.stock.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanUp() {
        postsRepository.deleteAll();
    }

    @Test
    public void selectStockTest() {
        // given
        String stockName = "테스트 종목";
        String sector = "테스트 섹터";

        postsRepository.save(Posts.builder()
                        .stockName(stockName)
                        .sector(sector)
                        .currentPrice(180000)
                        .build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);
        assertThat(posts.getStockName()).isEqualTo(stockName);
        assertThat(posts.getSector()).isEqualTo(sector);
    }

    @Test
    public void registerBaseTimeEntity() {
        // given
        LocalDateTime now = LocalDateTime.of(2022, 5, 13, 0, 0, 0);
        postsRepository.save(Posts.builder()
                .stockName("테스트 종목")
                .sector("테스트 섹터")
                .currentPrice(180000)
                .allTimeHighPrice(249000)
                .allTimeLowPrice(162000)
                .PER(10.11)
                .estimatePER(7.44)
                .PBR(0.62)
                .dividendRate(2.77)
                .build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>> createDate=" + posts.getCreatedDate() + ", modifiedDate=" + posts.getModifiedDate());
        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }

}
