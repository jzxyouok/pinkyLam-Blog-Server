package com.pinkyLam.blog.dao;

import com.pinkyLam.blog.entity.Attach;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Pinky Lam 908716835@qq.com
 * @date 2017年7月22日 下午2:51:48
 */

@Repository
public interface AttachDao extends JpaRepository<Attach, Long> {

	Page<Attach> findAttachByAuthorId(Long authorId, Pageable pageable);

	@Query(nativeQuery = true, value = "SELECT COUNT(1) FROM ATTACH WHERE AUTHOR_ID=:userId")
	public int getAttachByAuthorIdCnt(@Param("userId") Long userId);
}
