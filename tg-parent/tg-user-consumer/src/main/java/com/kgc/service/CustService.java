package com.kgc.service;

import com.kgc.pojo.user.Custodian;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface CustService {

    public Custodian getCustoById(@PathVariable("id") Integer id);

    public int update(@RequestBody Custodian custodian);

    public int add(@RequestBody Custodian custodian);

    public int delete(@PathVariable("id") Integer id);
}
