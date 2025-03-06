package edu.meialua.kidsgrace.adapters.in.repositories;

import edu.meialua.kidsgrace.adapters.in.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ToyRepository extends JpaRepository<Toy, Long> {
    List<Toy> findAll();

    Optional<Toy> findById(Long id);

    Optional<Toy> findByName(String names);
    List<Toy> findAllByBrand(String brand);
    List<Toy> findAllByCategory(String category);

    @Override
    void deleteById(Long id);


}
