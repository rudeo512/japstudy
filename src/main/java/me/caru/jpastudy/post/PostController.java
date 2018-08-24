package me.caru.jpastudy.post;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * PostController
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 23.
 */

@RestController
@RequiredArgsConstructor
@Slf4j
public class PostController {
	final private PostRepository postRepository;

	@GetMapping("/posts/{id}")
	public String getPost(@PathVariable("id") Post post) {
		return post.getTitle();
	}

	@GetMapping(value = "/posts", produces = MediaType.APPLICATION_JSON_VALUE)
	public PagedResources<Resource<Post>> getPosts(Pageable pageable, PagedResourcesAssembler<Post> pagedResourcesAssembler) {
		return pagedResourcesAssembler.toResource(postRepository.findAll(pageable));
	}
}
