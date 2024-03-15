package com.music.padanisa.controller;

import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.music.padanisa.entity.Padanisa;
import com.music.padanisa.services.Padanisaservice;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;

import jakarta.servlet.http.HttpSession;

@Controller
public class PaymentController {
	@Autowired
	Padanisaservice padaserv;

	@PostMapping("/createOrder")
	@ResponseBody
	public String createOrder() {
	Order order = null;
	try {//key id , key secert
		RazorpayClient razorpay = new RazorpayClient("rzp_test_uJA1FGU3VY8YKd", "QU3qa11blFcLY9qDt1afZYER");

		JSONObject orderRequest = new JSONObject();
		orderRequest.put("amount",50000);
		orderRequest.put("currency","INR");
		orderRequest.put("receipt", "receipt#1");
		JSONObject notes = new JSONObject();
		notes.put("notes_key_1","Tea, Earl Grey, Hot");
		orderRequest.put("notes",notes);

		order = razorpay.orders.create(orderRequest);
	}
	catch(Exception e) {
		System.out.println("Exception while creating order");
	}
	return order.toString();
	}

	@PostMapping("/verify")
	@ResponseBody
	public boolean verifyPayment(@RequestParam String orderId,@RequestParam String paymentId,@RequestParam String signature) {
		try {
	        // Initialize Razorpay client with your API key and secret
	        RazorpayClient razorpayClient = new RazorpayClient("rzp_test_uJA1FGU3VY8YKd", "QU3qa11blFcLY9qDt1afZYER");
	        // Create a signature verification data string
	        String verificationData = orderId + "|" + paymentId;

	        // Use Razorpay's utility function to verify the signature
	        boolean isValidSignature = Utils.verifySignature(verificationData, signature, "QU3qa11blFcLY9qDt1afZYER");

	        return isValidSignature;
	    } 
	    catch (RazorpayException e) {
	    	e.printStackTrace();
	    	return false;
	    }
	}
		@GetMapping("payment-success")
		public String paymentsuccess(HttpSession session)
		{
			String email=(String) session.getAttribute("email");
			Padanisa pada= padaserv.getUser(email);
			pada.setPremium(true);
			padaserv.updateUser(pada);
			return "login";
		}
		@GetMapping("payment-failure")
		public String paymentFailure()
		{
			return "login";
		}
}