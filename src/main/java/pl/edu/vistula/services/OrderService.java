package pl.edu.vistula.services;

import lombok.AllArgsConstructor;
import pl.edu.vistula.Exception.RecordNotFound;
import pl.edu.vistula.dao.ClientRepository;
import pl.edu.vistula.dao.MedicineRepository;
import pl.edu.vistula.dao.OrderRepository;
import pl.edu.vistula.data.MedicineData;
import pl.edu.vistula.data.OrderData;
import pl.edu.vistula.data.OrderStatus;
import pl.edu.vistula.data.SuccessResponse;
import pl.edu.vistula.models.Client;
import pl.edu.vistula.models.Medicine;
import pl.edu.vistula.models.Order;
@AllArgsConstructor
public class OrderService {
    private OrderRepository orderRepository;
    private ClientRepository clientRepository;
    private MedicineRepository medicineRepository;

    public SuccessResponse purchase(OrderData orderData){
        Order order = new Order();
        //Find client, we assume the client is logged in
        //So we throw error when he is not found in db
        Client client = clientRepository.findById(orderData.getClientId()).get();           //.orElseThrow(() -> new RecordNotFound("No Client"));
        order.setClient(client);

        //Validate and Modify each medicine in the order, eg count
        for (MedicineData medicineData: orderData.getMedicine()) {
            //Find the medicine in the database as we don't trust clients
            Medicine medicine = medicineRepository.findById(medicineData.getId()).get();     //.orElseThrow(() -> new RecordNotFound("No Med"));

            //Reduce the medicament, throw exception if count is less than 0
            int count = medicine.getCount() - medicineData.getCount();
            if(count < 0) throw new RecordNotFound("Medicine in the store is less than ordered medicine");
            medicine.setCount(count);

            /** ↓↓↓↓ MANY MORE CONDITIONS: such as doctor prescription,ExpDates... ↓↓↓↓*/

            order.getMedicine().add(medicine);
        }

        order.setOrderStatus(OrderStatus.COMPLETED);
        orderRepository.save(order);
        return new SuccessResponse("{" +
                    "\"message\":\"Order was placed successfully\"," +
                    "\"trackingNumber\":\""+order.getTrackingNumber()+"\""+
                "}");
    }
}
