package com.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Isaac Maria <isaac.maria@lntinfotech.com>
 *
 */
@Controller
public class MapperController {

	/**
	 * 
	 * @param model
	 * @return returns the name of the view that is to be displayed, It is useful to
	 *         avoid 404 error if the views are stored in the pages directory of
	 *         WEB-INF folder
	 */
	@RequestMapping("/addPayeePage")
	public ModelAndView addPayeeMap(ModelAndView model) {

		model.addObject("AddPayeeView", "not empty");
		model.setViewName("Dashboard");

		return model;

	}

	@RequestMapping("/deletePayeePage")
	public ModelAndView deletePayeeMap(ModelAndView model) {

		model.addObject("DeletePayeeView", "not empty");
		model.setViewName("Dashboard");

		return model;

	}

	@RequestMapping("/changeIdPage")
	public ModelAndView changeIdPage(ModelAndView model) {

		model.addObject("ChangeIdView", "not empty");
		model.setViewName("Dashboard");

		return model;

	}

	@RequestMapping("/changePasswordPage")
	public ModelAndView changePassword(ModelAndView model) {

		model.addObject("ChangePasswordView", "not empty");
		model.setViewName("Dashboard");

		return model;

	}

	@RequestMapping("/changeTransactionPasswordPage")
	public ModelAndView changeTransactionPassword(ModelAndView model) {

		model.addObject("ChangeTransactionPasswordView", "not empty");
		model.setViewName("Dashboard");

		return model;

	}

	@RequestMapping("/accountStatementPage")
	public ModelAndView accountStatement(ModelAndView model) {

		model.addObject("AccountStatementView", "not empty");
		model.setViewName("Dashboard");

		return model;

	}

}
