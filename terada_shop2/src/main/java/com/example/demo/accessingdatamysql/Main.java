package com.example.demo.accessingdatamysql;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.util.CollectionUtils;
//import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;

@Controller
public class Main {
	final static Logger logger = LoggerFactory.getLogger(Main.class);
	@Autowired
	private MAKER_MASTERRepository makerMasterRepository;

	@Autowired
	private PRODUCT_MASTERRepository productMasterRepository;

	@Autowired
	private PRODUCT_DETAIL_MASTERRepository productDetailMasterRepository;

	public @ResponseBody Iterable<MAKER_MASTER> getAllMakerMaster() {
		return makerMasterRepository.findAll();
	}

	public @ResponseBody Iterable<PRODUCT_MASTER> getAllProductMaster() {
		return productMasterRepository.findAll();
	}

	public @ResponseBody Iterable<PRODUCT_DETAIL_MASTER> getAllProductDetailMaster() {
		return productDetailMasterRepository.findAll();
	}

//	@Autowired(required = true)
//	private Map<String, String> getSelectMakers() {
//		Iterable<MAKER_MASTER> makerMasterList = getAllMakerMaster();
//		Map<String, String> selectMap = new LinkedHashMap<String, String>();
//		for (MAKER_MASTER makerMaster : makerMasterList) {
//			selectMap.put(makerMaster.getMakerCd(), makerMaster.getMakerName());
//		}
//		return selectMap;
//	}

	@Autowired(required = true)
	private List<MAKER_MASTER> getSelectMakers() {
		Iterable<MAKER_MASTER> makerMasterList = getAllMakerMaster();
		List<MAKER_MASTER> customers = new ArrayList<MAKER_MASTER>();
		for (MAKER_MASTER makerMaster : makerMasterList) {
		customers.add(makerMaster);
		}
		return customers;
	}


	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String helloWorld(Model model) {
		model.addAttribute("message");
		model.addAttribute("selectMakers", getSelectMakers());
		return "main";
	}

	//	 @RequestMapping(value = "/main/search", method = RequestMethod.GET)
	//	 public ModelAndView search(@RequestParam String keyword) {
	//		    logger.debug("PRODUCT_MASTER + search");
	//		    ModelAndView mv = new ModelAndView();
	//		    mv.setViewName("/main");
	//		    if (StringUtils.isEmpty(keyword)) {
	//		      List<PRODUCT_MASTER> list = PRODUCT_MASTERRepository.findSYOHINNAME(keyword);
	//		      if (CollectionUtils.isEmpty(list)) {
	//		        String productCd = productCd("productMaster.list.empty", null);
	//		        mv.addObject("emptyMessage", message);
	//		      }
	//		      mv.addObject("list", list);
	//		    }
	//		    return mv;
	//		  }

}
