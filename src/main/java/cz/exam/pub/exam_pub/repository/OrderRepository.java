package cz.exam.pub.exam_pub.repository;

import cz.exam.pub.exam_pub.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {


    @Query(value = "select * from order_table ot where ot.user_id = :userId",nativeQuery = true)
    List<OrderEntity> findByUserId(Long userId);
}
