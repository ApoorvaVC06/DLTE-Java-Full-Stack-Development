package hibernate.dltepayee.services;

import hibernate.dltepayee.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hibernate.dltepayee.remote.PaymentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    //CRUD operations
    public Payment implementationOfSave(Payment payment){
        return paymentRepository.save(payment);
    }
    public List<Payment> implementationOfFindAll(){ return (List<Payment>) paymentRepository.findAll();}
    public Optional<Payment> implentationOfFindbyId(int payeeId){ return paymentRepository.findById(payeeId);}

    public String implementationOfDeletebyId(int payeeId){
        Payment payment=paymentRepository.findById(payeeId).get();
        paymentRepository.deleteById(payeeId);
        String ack=payment.getPayeeName()+" has been removed from the table records";
        return ack;
    }
}
