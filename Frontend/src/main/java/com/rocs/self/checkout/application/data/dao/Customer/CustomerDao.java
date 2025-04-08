package com.rocs.self.checkout.application.data.dao.Customer;

import com.rocs.self.checkout.application.data.model.Customer;

public interface CustomerDao {
    Customer findById(String id);
}
