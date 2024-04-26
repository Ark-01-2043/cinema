package com.jpn2018.thanhtoanservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpn2018.thanhtoanservice.dto.PaymentDto;
import com.jpn2018.thanhtoanservice.service.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Order;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

@RestController
@RequestMapping("/api/payment")
public class PaypalController {

	@Autowired
	private PaypalService service;

	public static final String SUCCESS_URL = "pay/success";
	public static final String CANCEL_URL = "pay/cancel";

	

	@PostMapping
	public String payment(@RequestBody PaymentDto paymentDto) {
		try {
			Payment payment = service.createPayment(paymentDto.getTotal(), paymentDto.getCurrency(), paymentDto.getMethod(), paymentDto.getIntent(), paymentDto.getDescription(), "http://localhost:8080/" + CANCEL_URL,
					"http://localhost:8080/" + SUCCESS_URL);
			for(Links link:payment.getLinks()) {
				if(link.getRel().equals("approval_url")) {
					System.out.println(link.getHref());
//					System.out.println(payment.toJSON());
					
					return payment.toJSON();
				}
			}
			
		} catch (PayPalRESTException e) {
		
			e.printStackTrace();
		}
		return "failed";
	}
	@PostMapping("/confirm")
	public String confirmPayment(@RequestParam("payerId") String payerId, @RequestParam("paymentId") String paymentId) {
		Payment payment;
		try {
			payment = service.executePayment(paymentId, payerId);
			if (payment.getState().equals("approved")) {
				System.out.println("approved");
			}
			return payment.toJSON();
		} catch (PayPalRESTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failed";
		}
		
	}
//	 @GetMapping(value = CANCEL_URL)
//	    public String cancelPay() {
//	        return "cancel";
//	    }
//
//	    @GetMapping(value = SUCCESS_URL)
//	    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
//	        try {
//	            Payment payment = service.executePayment(paymentId, payerId);
//	            System.out.println(payment.toJSON());
//	            if (payment.getState().equals("approved")) {
//	                return "success";
//	            }
//	        } catch (PayPalRESTException e) {
//	         System.out.println(e.getMessage());
//	        }
//	        return "redirect:/";
//	    }

}