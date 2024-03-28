package com.bookworm.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookworm.entities.BeneficiaryMaster;
import com.bookworm.entities.MyShelf;
import com.bookworm.entities.Product;
import com.bookworm.entities.ProductBenMaster;
import com.bookworm.entities.RoyaltyCalculation;
import com.bookworm.services.BeneficiaryManager;
import com.bookworm.services.IProductService;
import com.bookworm.services.MyShelfManager;
import com.bookworm.services.ProductBenService;
import com.bookworm.services.RoyaltyCalculationService;

@RestController
@CrossOrigin("*")
public class MyShelfController {

	@Autowired
	MyShelfManager myShelfManager;
	@Autowired
	ProductBenService probenService;
	@Autowired
	IProductService prodService;
	@Autowired
	RoyaltyCalculationService royalCalService;
	@Autowired
	BeneficiaryManager benService;
	
	
	@GetMapping("/getall")
	public List<MyShelf> getById() {
		return myShelfManager.findallby();
	}

	@GetMapping("/getByCustomerId/{id}")
	public List<MyShelf> getByCustomerId(@PathVariable long id) {
		return myShelfManager.getByCustomerId(id);
	}
    
	@PostMapping("/addToShelf")
	public Long addToShelf(@RequestBody MyShelf shelf) {
		
		List<ProductBenMaster> proBenList = probenService.getByProduct((long)shelf.getBuyId());
		Product product = prodService.getProductById((long)shelf.getBuyId());
		double amount = 0;
		double totalEarning = 0;
		for(ProductBenMaster proben : proBenList) {
			RoyaltyCalculation royalCal = new RoyaltyCalculation();
			royalCal.setBeneficiary_id(proben.getProdBen_ben_id().getBenId());
			royalCal.setBase_price(product.getProduct_baseprice());
			royalCal.setTransaction_type(shelf.getTranType());
			royalCal.setProduct_id((long)shelf.getBuyId());
			royalCal.setRoyalty_calculation_date(LocalDate.now());
			royalCal.setSale_price(product.getProduct_sp_cost());
			if(shelf.getPriceAmount() != 0) {
				 amount = product.getProduct_baseprice() * (proben.getProdBen_percentage()/100);
			}
			else {
				 amount = shelf.getTotalAmount() * (proben.getProdBen_percentage()/100);
			}
			royalCal.setRoyalty_on_base_price(amount);
			royalCalService.addRoyality(royalCal);
			BeneficiaryMaster ben = benService.getByBeneficiaryId(royalCal.getBeneficiary_id());
			totalEarning = ben.getTotalEarning() + amount;
			ben.setTotalEarning(totalEarning);
			benService.updateBeneficiary(ben.getBenId(), ben);
			//benService.getByBeneficiaryId(ben.getBenId());
		}
		return myShelfManager.addToShelf(shelf).getShelfId();
	}
	@GetMapping("/getted/{tranType}")
    public List<MyShelf> gettranType(@PathVariable String tranType) {
        List<MyShelf> la= myShelfManager.geTransType(tranType);
        return la;
    }
	@DeleteMapping("/deleteProduct/{id}")
	public List<MyShelf> deleteproductbyid(@PathVariable long id) {
		List<MyShelf> myshelf= myShelfManager.deleteProduct(id);
		return myshelf;
	}
}
