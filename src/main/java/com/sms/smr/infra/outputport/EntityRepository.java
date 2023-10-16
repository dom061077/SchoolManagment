package com.sms.smr.infra.outputport;

import java.util.List;

public interface EntityRepository {
    
    public <T> T save(T reg);

    public <T> T getById( Long id );

    public <T> List<T> getAll(  );    
}
