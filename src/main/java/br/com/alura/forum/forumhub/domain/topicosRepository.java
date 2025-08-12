package br.com.alura.forum.forumhub.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;

public interface topicosRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findAll(Pageable paginacao);
}
