package com.bank.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bank.model.Admin;
import com.bank.model.Profile;
import com.bank.service.AdminService;

/**
 * 
 * @author Bharat Maheshwari,Bhargavi Sharma <---@lntinfotech.com,
 *         ---@lntinfotech.com>
 *
 */

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;

	/**
	 * 
	 * @param model
	 *            model it a type of ModelAndView
	 * @param admin
	 *            it is POJO class to store admin credentials
	 * @param session
	 *            to remember the admin's login sessio
	 * @return Dashboard view if successsully authenticated else it redirects back
	 *         to the login page
	 */

	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
	public ModelAndView adminLogin(ModelAndView model, @ModelAttribute Admin admin, HttpSession session) {

		if (admin.getAdminId().equals("admin") && admin.getAdminPassword().equals("admin123")) {
			session.setAttribute("isAdminLoggedIn", true);

			model.setViewName("redirect:/display");
		} else {
			model.setViewName("Admin");
		}
		return model;

	}

	/**
	 * 
	 * @param model
	 *            It is of type ModelAndView
	 * @return fetches all the requests and displays it on admin dashboard
	 */
	@RequestMapping(value = "/display")
	public ModelAndView display(ModelAndView model) {

		List<Profile> accountOpeningRequests = adminService.displayRequests();

		model.addObject("requests", accountOpeningRequests);

		model.setViewName("AdminDashboard");

		return model;

	}

	@RequestMapping(value = "/show/{id}")
	public String show(@PathVariable int id, HttpSession session) {

		List<Profile> accountOpeningRequests = adminService.displayRequests();

		Profile user = new Profile();
		for (int i = 0; i < accountOpeningRequests.size(); i++) {
			if (accountOpeningRequests.get(i).getCustomer_id() == id) {
				user = accountOpeningRequests.get(i);
			}
		}

		session.setAttribute("userInfo", user);

		return "redirect:/accountdetailspage";
	}

	@RequestMapping(value = "/accountdetailspage")
	public ModelAndView printInfo(ModelAndView model, HttpSession session) {

		model.addObject(session.getAttribute("userInfo"));

		model.setViewName("printaccountdetails");
		return model;
	}

	/**
	 * 
	 * @param model
	 *            is of type ModelAndView
	 * @param session
	 *            is used to invalidate the admin's login ses
	 * @return to Bank Homepage aftr logout
	 */

	@RequestMapping(value = "/adminlogout")
	public ModelAndView adminLogout(ModelAndView model, HttpSession session) {

		session.removeAttribute("isAdminLoggedIn");
		session.invalidate();

		model.setViewName("index");

		return model;

	}

	/**
	 * 
	 * @param id
	 *            It is the customer Id that needs to be rejected
	 * @return It returns the name of the view i.e. the display view is returned
	 */
	@RequestMapping(value = "/reject/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		int i = adminService.reject(id);

		if (i > 0) {

		} else {
			return "ErrorPage";

		}

		return "redirect:/display";

	}

	/**
	 * 
	 * @param id
	 *            It is the customer Id that needs to be approved
	 * @return The display view is redirected after approval
	 */
	@RequestMapping(value = "/approve/{id}", method = RequestMethod.GET)
	public String approve(@PathVariable int id) {
		int i = adminService.approve(id);

		if (i > 0) {

		} else {
			return "ErrorPage";
		}

		return "redirect:/display";

	}

}
