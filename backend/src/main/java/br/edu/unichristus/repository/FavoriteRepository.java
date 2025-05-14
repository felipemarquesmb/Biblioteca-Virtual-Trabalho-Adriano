package br.edu.unichristus.repository;

import br.edu.unichristus.domain.model.Book;
import br.edu.unichristus.domain.model.Favorite;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    @Query("SELECT f.book FROM Favorite f GROUP BY f.book ORDER BY COUNT(f.book) DESC")
    List<Book> findMostFavoritedBooks(Pageable pageable);
}
