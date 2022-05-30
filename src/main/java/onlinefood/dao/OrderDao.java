package onlinefood.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import onlinefood.model.OrderDetails;

public interface OrderDao extends JpaRepository<OrderDetails, Long> {

	public OrderDetails findByOrderId(long orderId);

}
