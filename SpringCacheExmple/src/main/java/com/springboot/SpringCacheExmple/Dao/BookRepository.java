package com.springboot.SpringCacheExmple.Dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.SpringCacheExmple.Vo.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	
	@Transactional
    @Modifying
    @Query(value=" UPDATE Book TS SET TS.name= :name WHERE TS.bookId = :bookId ", nativeQuery = true)
	public Book updateBookName(@Param("bookId") int bookId,@Param("name") String name );
	

}
