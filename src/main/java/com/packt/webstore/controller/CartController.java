package com.packt.webstore.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Cart controller.
 * 
 * @author hector
 *
 */
@Controller
@RequestMapping(value = "/cart")
public class CartController {

	/**
	 * It redirects and appends the session's ID.
	 * 
	 * @param request http servlet request
	 * @return view name
	 */
	@RequestMapping
	public String get(HttpServletRequest request) {
		return "redirect:/cart/" + request.getSession(true).getId();
	}

	/**
	 * It retrieves a cart with the given Id.
	 * 
	 * @param cartId cart's id
	 * @param model spring's view model
	 * @return view name
	 */
	@RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
	public String getCart(@PathVariable(value = "cartId") String cartId,
			Model model) {
		model.addAttribute("cartId", cartId);
		return "cart";
	}
}