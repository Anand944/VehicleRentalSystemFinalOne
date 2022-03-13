package com.cg.vrs.controller;
import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.vrs.entities.Payment;
import com.cg.vrs.entities.Vehicle;
import com.cg.vrs.exception.RecordNotFoundException;
import com.cg.vrs.service.IPaymentService;
import com.cg.vrs.utility.GlobalResources;

@RestController
@RequestMapping("/vrs-payment")
public class PaymentController {
	
	@Autowired
	IPaymentService iPaymentService;
	private Logger logger = GlobalResources.getLogger(PaymentController.class);
	
	@PostMapping("/addpayment")
	public String addPayment(@Valid@RequestBody Payment payment) throws RecordNotFoundException{
		String methodName = "addPayment()";
		logger.info(methodName + "Called");
		return iPaymentService.addPayment(payment);
	}
	
	@DeleteMapping("/cancelpayment")
	public String cancelPayment(@RequestBody Payment p) throws RecordNotFoundException{
		String methodName = "cancelPayment()";
		logger.info(methodName + "Called");
		return iPaymentService.cancelPayment(p);
	}
	
	@GetMapping("/getpayment/{id}")
	public Payment viewPayment(@PathVariable("id") int p) throws RecordNotFoundException{
		String methodName = "viewPayment()";
		logger.info(methodName + "Called");
		return iPaymentService.viewPayment(p);
	}
	
	@GetMapping("/getallpaymentbyvehicle")
	public List<Payment> viewAllPayments(@RequestBody Vehicle vehicle) throws RecordNotFoundException{
		String methodName = "viewAllPayments)";
		logger.info(methodName + "Called");
		return iPaymentService.viewAllPayments(vehicle);
	}
	
	@GetMapping("/getpaymentrevenue/{d1}/{d2}")
	public double calculateMonthlyRevenue(@RequestParam("localDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate d1,
			@RequestParam("localDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate d2) throws RecordNotFoundException{
		String methodName = "calculateMonthlyRevenuecalculateMonthlyRevenue()";
		logger.info(methodName + "Called");
		return iPaymentService.calculateMonthlyRevenue(d1, d2);
	}
	
	@GetMapping("/getpaymentrevenuebyvehicle")
	public double calculateTotalPayment(@RequestBody Vehicle v) throws RecordNotFoundException{
		String methodName = "calculateTotalPayment()";
		logger.info(methodName + "Called");
		return iPaymentService.calculateTotalPayment(v);
	}

}
