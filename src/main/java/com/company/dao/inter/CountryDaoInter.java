package com.company.dao.inter;

import com.company.entity.Country;
import java.util.List;
public interface CountryDaoInter {
    public List<Country> getAllCountry();
    public Country getCountryById(int id);
    public boolean addCountry(Country u);
    public boolean updateCountry(Country u);
    public boolean removeCountry(int id);

}
