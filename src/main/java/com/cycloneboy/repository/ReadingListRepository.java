package com.cycloneboy.repository;

import com.cycloneboy.domain.Book;
import com.cycloneboy.domain.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/6/27.
 */
public interface ReadingListRepository extends JpaRepository<Book,Long>{

    List<Book> findByReader(String reader);


}
