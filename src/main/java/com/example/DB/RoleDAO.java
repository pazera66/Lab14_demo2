package com.example.DB;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karol on 20.07.16.
 */
@Transactional
public interface RoleDAO extends CrudRepository<RoleDB, Long> {

    public RoleDB findByRole(String role);

}
