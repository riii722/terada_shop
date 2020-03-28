package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.maker_master.MAKER_MASTER;
import com.example.demo.maker_master.MAKER_MASTERRepository;
import com.example.demo.product_detail_master.PRODUCT_DETAIL_MASTER;
import com.example.demo.product_detail_master.PRODUCT_DETAIL_MASTERRepository;
import com.example.demo.product_master.PRODUCT_MASTER;
import com.example.demo.product_master.PRODUCT_MASTERRepository;
import com.example.demo.product_master.ProductService;

@ComponentScan
@Controller
@RequestMapping("/main")
public class Main {
	private static final String VIEW = "/main";
	final static Logger logger = LoggerFactory.getLogger(Main.class);

	@Autowired
	public ProductService productService;

	@Autowired		//newしてくれる
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

//	@InitBinder
//	  public void initBinder(WebDataBinder binder) {
//	    binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
//	  }


	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String index(Model model) {
		List<PRODUCT_MASTER> listProducts = (List<PRODUCT_MASTER>) productMasterRepository.findAll();
		model.addAttribute("listProducts", listProducts);
		Form form = new Form();
		model.addAttribute("PRODUCT_MASTER", form);
		model.addAttribute("selectMakers", getSelectMakers());
		model.addAttribute("results", getResults());
		return VIEW;
	}

//データリスト
	@Autowired(required = true)
	private List<MAKER_MASTER> getSelectMakers() {
		Iterable<MAKER_MASTER> makerMasterList = getAllMakerMaster();
		List<MAKER_MASTER> customers = new ArrayList<MAKER_MASTER>();
		for (MAKER_MASTER makerMaster : makerMasterList) {
			customers.add(makerMaster);
		}
		return customers;
	}

//リスト表示　別バージョン
//	@Autowired(required = true)
//	private Map<String, String> getSelectMakers() {
//		Iterable<MAKER_MASTER> makerMasterList = getAllMakerMaster();
//		Map<String, String> selectMap = new LinkedHashMap<String, String>();
//		for (MAKER_MASTER makerMaster : makerMasterList) {
//			selectMap.put(makerMaster.getMakerCd(), makerMaster.getMakerName());
//		}
//		return selectMap;
//	}

//検索POST
	@RequestMapping(value="main", method = RequestMethod.POST)
	public ModelAndView login(ModelAndView mav,
			@RequestParam("productcd") String PRODUCTCD,
			@RequestParam("syohinName") String SYOHINNAME
//			,@RequestParam("MAKER_MASTER.makercd") String MAKERCD
			) {
		mav.setViewName(VIEW);
//		List<String> id = new ArrayList<String>();
//		id.add(PRODUCTCD);
//		Iterable<KeyId> ids = id;
//		Iterable<PRODUCT_MASTER> resultid = productMasterRepository.findAllById(ids);
//		mav.addObject("result", resultid);
//
//		List<String> sn = new ArrayList<String>();
//		sn.add(SYOHINNAME);
//		Iterable<KeyId> sns = sn;
//		Iterable<PRODUCT_DETAIL_MASTER> resultsn = productDetailMasterRepository.findAllById(sns);
//		mav.addObject("result", resultsn);

//		List<String> mc = new ArrayList<String>();
//		mc.add(MAKERCD);
//		Iterable<KeyId> mcs = mc;
//		Iterable<MAKER_MASTER> resultmc = makerMasterRepository.findAllById(mcs);
//		mav.addObject("result", resultmc);

		mav.addObject("productCd", PRODUCTCD);
		mav.addObject("syohinName", SYOHINNAME);
//		mav.addObject("makerCd", MAKERCD);
		Iterable<PRODUCT_MASTER> result = productService.search(PRODUCTCD, SYOHINNAME);
		mav.addObject("result", result);
		return mav;
	}

//検索結果
	@PostMapping(value="main")
	List<PRODUCT_MASTER> getResults(){
		Iterable<PRODUCT_MASTER> resultList = getAllProductMaster();
		List<PRODUCT_MASTER> results = new ArrayList<PRODUCT_MASTER>();
		for (PRODUCT_MASTER productMaster : resultList) {
			results.add(productMaster);
	}
	return results;
	}

//更新
	public void save(PRODUCT_MASTER productMaster, PRODUCT_DETAIL_MASTER productDetailMaster, MAKER_MASTER makerMaster) {
		productMasterRepository.save(productMaster);
		productDetailMasterRepository.save(productDetailMaster);
		makerMasterRepository.save(makerMaster);
	}

	public PRODUCT_MASTER getProductCd(String productcd) {
		return productMasterRepository.findById(productcd).get();
	}
	public PRODUCT_MASTER getSyohinName(String syohinname) {
		return productMasterRepository.findById(syohinname).get();
	}
	public MAKER_MASTER getMakerCd(String makercd) {
		return makerMasterRepository.findById(makercd).get();
	}

//削除
	public void deleteProductCd(String productcd) {
		productMasterRepository.deleteById(productcd);
	}
	public void deleteSyohinName(String syohinname) {
		productMasterRepository.deleteById(syohinname);
	}
	public void delete(String makercd) {
		makerMasterRepository.deleteById(makercd);
	}

}
