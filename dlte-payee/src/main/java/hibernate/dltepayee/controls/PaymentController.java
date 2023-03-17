package hibernate.dltepayee.controls;

import hibernate.dltepayee.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import hibernate.dltepayee.services.PaymentService;

import java.util.List;
import java.util.Optional;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/insert")
    public Payment callingSave(@RequestBody Payment payment){
        return paymentService.implementationOfSave(payment);
    }

    @GetMapping("/view")
    public List<Payment> callingFindAll(){
        return paymentService.implementationOfFindAll();
    }

    @GetMapping("/details/{payeeId}")
    public Optional<Payment> callingFindbyId(@PathVariable ("payeeId") int payeeId){
        return paymentService.implentationOfFindbyId(payeeId);
    }

    @PutMapping("/modify/{payeeId}")
    public Payment callingUpdate(@RequestBody Payment payment){
        return paymentService.implementationOfSave(payment);
    }

    @DeleteMapping("/delete")
    public String callingDeletebyId(@PathVariable("payeeId") int payeeId){
        return paymentService.implementationOfDeletebyId(payeeId);
    }
}

