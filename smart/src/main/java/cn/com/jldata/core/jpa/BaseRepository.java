package cn.com.jldata.core.jpa;

import cn.com.jldata.core.query.PropertyFilter;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
@NoRepositoryBean
public interface BaseRepository <T, ID extends Serializable>
		extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

    <S extends T> Page<S> findAll(List<PropertyFilter> propertyFilters, Pageable pageable);
}
