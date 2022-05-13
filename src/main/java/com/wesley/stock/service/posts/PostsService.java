package com.wesley.stock.service.posts;

import com.wesley.stock.domain.posts.Posts;
import com.wesley.stock.domain.posts.PostsRepository;
import com.wesley.stock.web.dto.PostsResponseDto;
import com.wesley.stock.web.dto.PostsSaveRequestDto;
import com.wesley.stock.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 주식 종목이 없습니다. id=" + id));

        posts.update(requestDto.getStockName(),
                requestDto.getSector(),
                requestDto.getCurrentPrice(),
                requestDto.getAllTimeHighPrice(),
                requestDto.getAllTimeLowPrice(),
                requestDto.getPER(),
                requestDto.getEstimatePER(),
                requestDto.getPBR(),
                requestDto.getDividendRate());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 주식 종목이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

}
