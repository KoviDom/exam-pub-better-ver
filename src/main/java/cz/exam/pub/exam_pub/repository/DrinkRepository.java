package cz.exam.pub.exam_pub.repository;

import cz.exam.pub.exam_pub.entity.DrinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends JpaRepository<DrinkEntity, Long> {
}
