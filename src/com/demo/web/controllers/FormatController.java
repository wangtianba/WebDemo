//package com.demo.web.controllers;
//
//import java.math.RoundingMode;
//import java.util.Date;
//import java.util.Locale;
//
//import org.springframework.context.i18n.LocaleContextHolder;
//import org.springframework.format.datetime.DateFormatter;
//import org.springframework.format.number.CurrencyFormatter;
//import org.springframework.format.support.DefaultFormattingConversionService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.demo.web.models.FormatModel;
//
//@Controller
//@RequestMapping(value = "/format")
//public class FormatController {
//    
//	@RequestMapping(value = "/test", method = { RequestMethod.GET })
//	public String test(Model model) throws NoSuchFieldException,
//			SecurityException {
//
//		if (!model.containsAttribute("contentModel")) {
//
//			FormatModel formatModel = new FormatModel();
//
//			formatModel.setMoney(12345.678);
//			formatModel.setDate(new Date());
//
//			model.addAttribute("contentModel", formatModel);
//		}
//		return "formattest";
//	}
//
//}