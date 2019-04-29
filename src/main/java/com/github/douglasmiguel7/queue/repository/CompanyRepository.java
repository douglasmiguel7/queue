package com.github.douglasmiguel7.queue.repository;

import com.github.douglasmiguel7.queue.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
