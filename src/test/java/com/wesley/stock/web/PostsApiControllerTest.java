package com.wesley.stock.web;

import com.wesley.stock.domain.posts.Posts;
import com.wesley.stock.domain.posts.PostsRepository;
import com.wesley.stock.web.dto.PostsSaveRequestDto;
import com.wesley.stock.web.dto.PostsUpdateRequestDto;
import org.apache.coyote.Response;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void tearDown() throws Exception {
        postsRepository.deleteAll();
    }

    @Test
    public void PostsInsert() throws Exception {
        // given
        String stockName = "테스트 종목";
        String sector = "테스트 섹터";
        int currentPrice = 180000;
        int allTimeHighPrice = 249000;
        int allTimeLowPrice = 162000;
        double PER = 10.11;
        double estimatePER = 7.44;
        double PBR = 0.62;
        double dividendRate = 2.77;

        PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
                .stockName(stockName)
                .sector(sector)
                .currentPrice(currentPrice)
                .allTimeHighPrice(allTimeHighPrice)
                .allTimeLowPrice(allTimeLowPrice)
                .PER(PER)
                .estimatePER(estimatePER)
                .PBR(PBR)
                .dividendRate(dividendRate)
                .build();

        String url = "http://localhost:" + port + "/api/v1/posts";

        // when
        // ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        // then
        // assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        // assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getStockName()).isEqualTo(stockName);
        assertThat(all.get(0).getSector()).isEqualTo(sector);
        assertThat(all.get(0).getCurrentPrice()).isEqualTo(currentPrice);
        assertThat(all.get(0).getAllTimeHighPrice()).isEqualTo(allTimeHighPrice);
        assertThat(all.get(0).getAllTimeLowPrice()).isEqualTo(allTimeLowPrice);
        assertThat(all.get(0).getPER()).isEqualTo(PER);
        assertThat(all.get(0).getEstimatePER()).isEqualTo(estimatePER);
        assertThat(all.get(0).getPBR()).isEqualTo(PBR);
        assertThat(all.get(0).getDividendRate()).isEqualTo(dividendRate);
    }

    @Test
    public void PostsUpdate() throws Exception {
        // given
        Posts savedPosts = postsRepository.save(Posts.builder()
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

        Long updateId = savedPosts.getId();
        String expectedStockName = "테스트 종목2";
        String expectedSector = "테스트 섹터2";
        int expectedCurrentPrice = 190000;
        int expectedAllTimeHighPrice = 259000;
        int expectedAllTimeLowPrice = 172000;
        double expectedPER = 11.11;
        double expectedEstimatedPER = 8.44;
        double expectedPBR = 1.62;
        double expectedDividendRate = 3.77;

        PostsUpdateRequestDto requestDto = PostsUpdateRequestDto.builder()
                .stockName(expectedStockName)
                .sector(expectedSector)
                .currentPrice(expectedCurrentPrice)
                .allTimeHighPrice(expectedAllTimeHighPrice)
                .allTimeLowPrice(expectedAllTimeLowPrice)
                .PER(expectedPER)
                .estimatePER(expectedEstimatedPER)
                .PBR(expectedPBR)
                .dividendRate(expectedDividendRate)
                .build();

        String url = "http://localhost:" + port + "/api/v1/posts/" + updateId;

        HttpEntity<PostsUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        // when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);
        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getStockName()).isEqualTo(expectedStockName);
        assertThat(all.get(0).getSector()).isEqualTo(expectedSector);
        assertThat(all.get(0).getCurrentPrice()).isEqualTo(expectedCurrentPrice);
        assertThat(all.get(0).getAllTimeHighPrice()).isEqualTo(expectedAllTimeHighPrice);
        assertThat(all.get(0).getAllTimeLowPrice()).isEqualTo(expectedAllTimeLowPrice);
        assertThat(all.get(0).getPER()).isEqualTo(expectedPER);
        assertThat(all.get(0).getEstimatePER()).isEqualTo(expectedEstimatedPER);
        assertThat(all.get(0).getPBR()).isEqualTo(expectedPBR);
        assertThat(all.get(0).getDividendRate()).isEqualTo(expectedDividendRate);
    }

}
