package practice.querydsl.productOrderSystem.domain.review.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import practice.querydsl.productOrderSystem.domain.review.application.port.ReviewApplicationPort;
import practice.querydsl.productOrderSystem.domain.review.presentation.data.request.CreateReviewRequest;
import practice.querydsl.productOrderSystem.domain.review.presentation.data.response.GetReviewResponse;

import java.util.List;

@RequestMapping("/review")
@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewApplicationPort reviewApplicationPort;

    @PostMapping
    public void createReview(@RequestBody CreateReviewRequest request) {
        reviewApplicationPort.createReview(request.title(), request.content(), request.productId(), request.orderId());
    }

    @DeleteMapping("/{productId}")
    public void deleteReview(Long productId) {
        reviewApplicationPort.deleteReview(productId);
    }

    @GetMapping
    public List<GetReviewResponse> getReviews(
            @RequestParam(value = "productId", required = false) Long productId,
            @RequestParam(value = "userId", required = false) Long userId,
            @RequestParam(value = "orderId", required = false) Long orderId,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            @RequestParam(value = "page", defaultValue = "0", required = false) int page
    ) {
        PageRequest pageable = PageRequest.of(page, size);

        return reviewApplicationPort.searchReviews(productId, userId, orderId, pageable);
    }
}
