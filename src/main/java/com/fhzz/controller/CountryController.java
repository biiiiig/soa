
package com.fhzz.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.fhzz.model.Country;
import com.fhzz.service.CountryService;
import com.github.pagehelper.PageInfo;



/**
 * 类的描述
 * @author 于起超
 * @Time 2016年10月24日
 *
 */
@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;
    


    @RequestMapping(method = RequestMethod.GET)
    public PageInfo<Country> getAll(@RequestParam(value="page", required=false, defaultValue="1") Integer page,
    						        @RequestParam(value="rows", required=false, defaultValue="20")Integer rows, 
    						        @RequestParam(value="name", required=false) String name,
    						        @RequestParam(value="code", required=false) String code, 
    						        Model model){ 
    	
        List<Country> countryList = countryService.getAll(page,rows,name,code);
        return new PageInfo<Country>(countryList);
    }

    @RequestMapping(value = "/add")
    public ModelAndView add() {
        ModelAndView result = new ModelAndView("view");
        result.addObject("country", new Country());
        return result;
    }

    @RequestMapping(value = "/view/{id}")
    @ResponseBody
    public Country view(@PathVariable Integer id) {
      
        Country country = countryService.getById(id);
        
        return country;
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable Integer id, RedirectAttributes ra) {
        ModelAndView result = new ModelAndView("redirect:/countries");
        countryService.deleteById(id);
        ra.addFlashAttribute("msg", "删除成功!");
        return result;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(Country country) {
        ModelAndView result = new ModelAndView("view");
        String msg = country.getId() == null ? "新增成功!" : "更新成功!";
        countryService.save(country);
        result.addObject("country", country);
        result.addObject("msg", msg);
        return result;
    }
}
