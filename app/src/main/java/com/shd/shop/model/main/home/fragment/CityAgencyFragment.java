package com.shd.shop.model.main.home.fragment;



import com.shd.shop.model.main.home.AgencyBaseFragment;
import com.shd.shop.utils.ToastUtils;

public class CityAgencyFragment extends AgencyBaseFragment {

    @Override
    protected void doDoes() {
        super.doDoes();
        supplier_adapter.setOnItemClickListener((adapter, view, position) -> {
            switch (position) {
                case 0:
                    ToastUtils.showToast("33333333");
                    break;
                case 1:
                    break;
                case 2:
                    break;
            }
        });

    }
}
