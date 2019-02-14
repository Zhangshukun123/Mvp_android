package com.shd.shop.model.models.home.factory;

import android.support.v4.app.Fragment;
import android.widget.Switch;

import com.shd.shop.api.Agency;
import com.shd.shop.model.main.home.fragment.CityAgencyFragment;
import com.shd.shop.model.main.home.fragment.ComAgencyFragemnt;
import com.shd.shop.model.main.home.fragment.ProvinecAgencyFragment;
import com.shd.shop.model.main.home.fragment.ShopAgencyFragment;
import com.shd.shop.model.main.home.fragment.SupplerFragemnt;
import com.shd.shop.server.DataServer;

import java.util.HashMap;

public class AgencyFragmentFactory {
    private DataServer agency;

    private HashMap<Agency, Fragment> fragments;


    public AgencyFragmentFactory(DataServer agency) {
        this.agency = agency;
        if (fragments == null) {
            fragments = new HashMap<>();
        }
    }


    public Fragment getAgencyFragemt() {
        return proAgencyFragment(agency.getAgency());
    }

    private Fragment proAgencyFragment(Agency agency) {
        Fragment fragment = fragments.get(agency);
        if (fragment == null) {
            switch (agency) {
                case SUPPLER_AGENCY:
                    fragment = new SupplerFragemnt();
                    break;
                case COM_AGENCY:
                    fragment = new ComAgencyFragemnt();
                    break;
                case CITY_AGENCY:
                    fragment = new CityAgencyFragment();
                    break;
                case PROVINEC_AGENCY:
                    fragment = new ProvinecAgencyFragment();
                    break;
                case SHOP_AGENCY:
                    fragment = new ShopAgencyFragment();
                    break;
            }
            fragments.put(agency, fragment);
            return fragment;
        }
        return fragment;
    }


}
